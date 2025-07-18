package controller.Stadium;

import connect.DBConnection;
import dao.ReportDAO;
import model.Report;
import model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SubmitReportServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("📨 [SubmitReportServlet] Processing report submission");

        // Set response configuration
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        Connection conn = null;
        
        try {
            // Step 1: Validate user session
            User currentUser = validateUserSession(request);
            if (currentUser == null) {
                sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, 
                                "Please login to submit a report.");
                return;
            }

            System.out.println("✅ User authenticated: " + currentUser.getFullName());

            // Step 2: Extract and validate parameters
            ReportParameters params = extractParameters(request);
            if (params == null) {
                sendErrorResponse(response, HttpServletResponse.SC_BAD_REQUEST, 
                                "Missing required report information.");
                return;
            }

            System.out.println("✅ Parameters validated: Stadium ID " + params.stadiumId);

            // Step 3: Create report object
            Report report = createReport(currentUser, params);
            
            // Step 4: Save to database
            conn = DBConnection.getConnection();
            if (conn == null) {
                sendErrorResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 
                                "Database connection failed.");
                return;
            }

            ReportDAO reportDAO = new ReportDAO(conn);
            boolean success = reportDAO.createReport(report);
            
            if (success) {
                System.out.println("✅ Report saved successfully");
                sendSuccessResponse(response, "Report submitted successfully. Thank you for your feedback!");
            } else {
                System.out.println("❌ Failed to save report");
                sendErrorResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 
                                "Failed to submit report. Please try again.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
            e.printStackTrace();
            sendErrorResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 
                            "Database error occurred. Please try again.");
        } catch (Exception e) {
            System.out.println("❌ System error: " + e.getMessage());
            e.printStackTrace();
            sendErrorResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 
                            "System error occurred. Please try again.");
        } finally {
            closeConnection(conn);
        }
    }

    /**
     * Validate user session and return current user
     */
    private User validateUserSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            System.out.println("❌ No session found");
            return null;
        }

        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            System.out.println("❌ No user in session");
            return null;
        }

        return currentUser;
    }

    /**
     * Extract and validate request parameters
     */
    private ReportParameters extractParameters(HttpServletRequest request) {
        String stadiumIdParam = request.getParameter("stadiumId");
        String reason = request.getParameter("reason");
        String description = request.getParameter("description");

        System.out.println("📥 Parameters: stadiumId='" + stadiumIdParam + 
                          "', reason='" + reason + "', description length=" + 
                          (description != null ? description.length() : "null"));

        // Validate stadium ID
        if (stadiumIdParam == null || stadiumIdParam.trim().isEmpty()) {
            System.out.println("❌ Stadium ID missing");
            return null;
        }

        int stadiumId;
        try {
            stadiumId = Integer.parseInt(stadiumIdParam.trim());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid stadium ID format");
            return null;
        }

        // Validate reason
        if (reason == null || reason.trim().isEmpty()) {
            System.out.println("❌ Reason missing");
            return null;
        }

        // Validate description
        if (description == null || description.trim().isEmpty()) {
            System.out.println("❌ Description missing");
            return null;
        }

        return new ReportParameters(stadiumId, reason.trim(), description.trim());
    }

    /**
     * Create report object with clean format
     */
    private Report createReport(User user, ReportParameters params) {
        Report report = new Report();
        report.setUserID(user.getUserID());
        report.setRelatedStadiumID(params.stadiumId);
        
        // ✅ Clean format - no duplication
        report.setTitle(params.reason);
        report.setDescription(params.description);
        
        report.setStatus("Pending");

        System.out.println("📝 Report created: '" + report.getTitle() + 
                          "' for stadium " + report.getRelatedStadiumID());

        return report;
    }

    /**
     * Send success response
     */
    private void sendSuccessResponse(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        String jsonResponse = "{\"success\": true, \"message\": \"" + escapeJson(message) + "\"}";
        response.getWriter().write(jsonResponse);
    }

    /**
     * Send error response
     */
    private void sendErrorResponse(HttpServletResponse response, int statusCode, String message) throws IOException {
        response.setStatus(statusCode);
        String jsonResponse = "{\"success\": false, \"message\": \"" + escapeJson(message) + "\"}";
        response.getWriter().write(jsonResponse);
    }

    /**
     * Escape JSON special characters
     */
    private String escapeJson(String text) {
        if (text == null) return "";
        return text.replace("\\", "\\\\")
                  .replace("\"", "\\\"")
                  .replace("\r", "\\r")
                  .replace("\n", "\\n")
                  .replace("\t", "\\t");
    }

    /**
     * Close database connection safely
     */
    private void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("✅ Database connection closed");
            } catch (SQLException e) {
                System.out.println("⚠️ Error closing connection: " + e.getMessage());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sendErrorResponse(response, HttpServletResponse.SC_METHOD_NOT_ALLOWED, 
                         "GET method not allowed. Use POST.");
    }

    /**
     * Helper class to hold validated parameters
     */
    private static class ReportParameters {
        final int stadiumId;
        final String reason;
        final String description;

        ReportParameters(int stadiumId, String reason, String description) {
            this.stadiumId = stadiumId;
            this.reason = reason;
            this.description = description;
        }
    }
}