<%@ page import="model.User" %>

<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" 
          rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"> 
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/header.css">

    <!-- Nhúng Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
</head>
<body>
<header class="header-bg">
    <div class="header-row row-top">
        <div class="container">
            <div class="row header-top">
                <div class="col-sm-6">
                    <div class="logo">
                        <a href="home.jsp">
                            <img src="<%= request.getContextPath() %>/images/logo.png" alt="logo"/>
                        </a>
                    </div>
                </div>
                <div class="col-sm-6 header-booking">
                    <a href="#">Đặt lịch dùng thử</a> 
                </div>
            </div>
        </div>
    </div>


    <div class="header-row row-bottom">
        <div class="container">
            <div class="row header-menu">
                <div class="col-8 menu-wrapper">
                    <div class="item"><a href="<%= request.getContextPath() %>home.jsp"><i class="fa-solid fa-house"></i></a></div>
                    <div class="item"><a href="<%= request.getContextPath() %>/home.jsp">Trang chủ</a></div>
                    <div class="item"><a href="<%= request.getContextPath() %>/stadiums">Danh sách sân bóng</a></div>
                    <div class="item"><a href="<%= request.getContextPath() %>/user/tournaments">Giải đấu</a></div>

                    <%-- Kiểm tra nếu người dùng đăng nhập --%>
                    <%
                        model.User currentUser = (model.User) session.getAttribute("currentUser");
                        if (currentUser != null) {
                            boolean isOwner = currentUser.isFieldOwner();
                            if (isOwner) {
                    %>
                                <div class="item">
                                    <a href="${pageContext.request.contextPath}/dashboard">Dành cho chủ sân</a>
                                </div>
                    <%
                            } else {
                    %>
                                <div class="item">
                                    <a href="#" onclick="requestOwner(event)">Dành cho chủ sân</a>
                                </div>
                    <%
                            }
                        } else {
                    %>
                            <div class="item">
                                <a href="#" onclick="requestOwnerGuest(event)">Dành cho chủ sân</a>
                            </div>
                    <%
                        }
                    %>

                    <div class="item"><a href="#">Liên hệ</a></div>
                    <div class="item"><a href="#">Chính sách</a></div>

                </div>

                <div class="col-4 box-account d-flex justify-content-end align-items-center">
                    <%
                        // currentUser đã được khai báo ở trên, không cần khai báo lại
                        if (currentUser != null) {
                    %>
                        <div class="dropdown">
                            <a href="#" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown"
                               aria-expanded="false">
                                <i class="fa-solid fa-user"></i>
                                <%= currentUser.getFullName() != null ? currentUser.getFullName() : currentUser.getEmail() %>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-end">
                                <li><a class="dropdown-item" href="<%= request.getContextPath() %>/account/profile.jsp">Hồ sơ</a></li>
                                <li><a class="dropdown-item" href="<%= request.getContextPath() %>/booking-history">Lịch sử đặt hàng</a></li>
                                <li><a class="dropdown-item" href="<%= request.getContextPath() %>/logout">Đăng xuất</a></li>
                            </ul>
                        </div>
                    <%
                        } else {
                    %>
                        <div class="account item">
                            <a class="register me-2" href="<%= request.getContextPath() %>/account/register.jsp">Đăng ký</a>
                            <a href="<%= request.getContextPath() %>/account/login.jsp">Đăng nhập</a>
                        </div>
                    <%
                        }
                    %>

                    <div class="search-header item ms-3">
                        <a href="#">
                            <span>Tìm kiếm</span>
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<script>
    function requestOwner(event) {
        event.preventDefault(); // Prevent the default link behavior
        const confirmRequest = confirm("Bạn hiện tại không phải chủ sân. Bạn có muốn đăng ký làm chủ sân không?");
        if (confirmRequest) {
            window.location.href = "<%= request.getContextPath() %>/become-owner-request.jsp";
        }
        // If user clicks Cancel, nothing happens and they stay on the current page
    }

    function requestOwnerGuest(event) {
        event.preventDefault(); // Prevent the default link behavior
        const confirmRequest = confirm("Bạn cần đăng nhập trước khi gửi yêu cầu làm chủ sân.");
        if (confirmRequest) {
            window.location.href = "<%= request.getContextPath() %>/account/login.jsp";
        }
        // If user clicks Cancel, nothing happens and they stay on the current page
    }
</script>

</body>
</html> 
</html>
