package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.User;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String path = req.getRequestURI().substring(req.getContextPath().length());

        User currentUser = (session != null) ? (User) session.getAttribute("currentUser") : null;

        if (path.equals("/") && currentUser != null && currentUser.isAdmin()) {
            res.sendRedirect(req.getContextPath() + "/admin/adminPage.jsp");
            return;
        }

        if (path.equals("/about")) {
            chain.doFilter(request, response);
            return;
        }

        if (path.startsWith("/admin")) {
            if (currentUser == null || !currentUser.isAdmin()) {
                res.sendRedirect(req.getContextPath() + "/unauthorized.jsp");
                return;
            }
        }

        if (path.startsWith("/fieldOwner")) {
            if (currentUser == null || !currentUser.isFieldOwner()) {
                res.sendRedirect(req.getContextPath() + "/unauthorized.jsp");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
