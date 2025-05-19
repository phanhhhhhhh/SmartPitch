<%-- 
    Document   : header
    Created on : May 15, 2025, 7:45:23 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/header.css"/>
    </head>
    <body>
        <header class="header-bg">
            <div class="header-row row-top">
                <div class="container">
                    <div class="row header-top">
                        <div class="col-sm-6">
                            <div class="logo">
                                <a href="url">
                                    <img src="./images/logo.png" alt="alt"/>
                                </a>
                            </div>
                        </div>
                        <div class="col-sm-6 header-booking">
                            <a href="url">Đặt lịch dùng thử</a>
                        </div>
                    </div>
                </div>
            </div> 
            
            <div class="header-row row-bottom">
                <div class="container">
                    <div class="row header-menu">
                        <div class="col-8 menu-wrapper">
                            <div class="item">
                                <a href="url"><i class="fa-solid fa-house"></i></a>
                            </div>
                            <div class="item">
                                <a href="url">Trang chủ</a>
                            </div>
                            <div class="item">
                                <a href="url">Danh sách sân bóng</a>
                            </div>
                            <div class="item">
                                <a href="url">Đồ ăn</a>
                            </div>
                            <div class="item">
                                <a href="url">Giới thiệu</a>
                            </div>
                            <div class="item">
                                <a href="url">Dành cho chủ sân</a>
                            </div>
                            <div class="item">
                                <a href="url">Liên hệ</a>
                            </div>
                            <div class="item">
                                <a href="url">Chính sách</a>
                            </div>
                        </div>
                        
                        <div class="col-4 box-account">
                            <div class="account item">
                                <a class="register" href="./account/register.jsp">Đăng ký</a>
                                <a href="./account/login.jsp">Đăng nhập</a>
                            </div>
                            
                            <div class="search-header item">
                                <a href="url">
                                    <span>Tìm kiếm</span>
                                    <i class="fa-solid fa-magnifying-glass"></i>
                                </a>
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
    </body>
</html>
