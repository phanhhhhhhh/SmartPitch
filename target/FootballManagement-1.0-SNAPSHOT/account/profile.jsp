<%-- 
    Document   : profile
    Created on : May 26, 2025, 1:09:07 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Football Profile Manager</title>
    <link rel="stylesheet" href="../css/profile.css"/>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>
                <div class="football-icon">⚽</div>
                Quản Lý Hồ Sơ Bóng Đá
            </h1>
            <p>Quản lý hồ sơ và tuỳ chọn bóng đá của bạn</p>
        </div>

        <div class="profile-container">
            <div class="profile-sidebar">
                <div class="profile-avatar">
                    <%
                        String avatar = (String) session.getAttribute("avatar"); // hoặc lấy từ DB
                        if (avatar == null || avatar.isEmpty()) {
                    %>
                        <div class="avatar-circle">👤</div>
                    <%
                        } else {
                    %>
                        <div class="avatar-circle" style="background-image: url('<%= request.getContextPath() + "/" + avatar %>'); background-size: cover;"></div>
                    <%
                        }
                    %>
                    <form action="${pageContext.request.contextPath}/uploadAvatar" method="post" enctype="multipart/form-data" style="margin-top: 10px;">
                        <input type="file" name="avatar" accept="image/*" required>
                        <button type="submit" class="upload-btn">Tải Ảnh Đại Diện</button>
                    </form>
                </div>
                
                <ul class="nav-menu">
                    <li class="nav-item">
                        <button class="nav-link active" onclick="showSection('personal-info')">
                            👤 Thông Tin Cá Nhân
                        </button>
                    </li>
                    <li class="nav-item">
                        <button class="nav-link" onclick="showSection('football-profile')">
                            ⚽ Hồ Sơ Bóng Đá
                        </button>
                    </li>
                    <li class="nav-item">
                        <button class="nav-link" onclick="showSection('security')">
                            🔒 Bảo Mật
                        </button>
                    </li>
                    <li class="nav-item">
                        <button class="nav-link" onclick="showSection('preferences')">
                            ⚙️ Tuỳ Chọn
                        </button>
                    </li>
                    <li class="nav-item">
                        <button class="nav-link" onclick="showSection('stats')">
                            📊 Thống Kê
                        </button>
                    </li>
                </ul>
            </div>

            <div class="main-content">
                <div id="notification" class="notification"></div>

                <!-- Personal Information Section -->
                <div id="personal-info" class="section active">
                    <h2 class="section-title">Thông Tin Cá Nhân</h2>
                    <form id="personalInfoForm">
                        <div class="form-row">
                            <div class="form-group">
                                <label for="firstName">Họ</label>
                                <input type="text" id="firstName" name="firstName" value="John" required>
                            </div>
                            <div class="form-group">
                                <label for="lastName">Tên</label>
                                <input type="text" id="lastName" name="lastName" value="Smith" required>
                            </div>
                        </div>
                        
                        <div class="form-row">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" id="email" name="email" value="john.smith@email.com" required>
                            </div>
                            <div class="form-group">
                                <label for="phone">Số Điện Thoại</label>
                                <input type="tel" id="phone" name="phone" value="+1 (555) 123-4567">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group">
                                <label for="birthdate">Ngày Sinh</label>
                                <input type="date" id="birthdate" name="birthdate" value="1990-05-15">
                            </div>
                            <div class="form-group">
                                <label for="nationality">Quốc Tịch</label>
                                <select id="nationality" name="nationality">
                                    <option value="usa">Hoa Kỳ</option>
                                    <option value="uk">Anh</option>
                                    <option value="canada">Canada</option>
                                    <option value="australia">Úc</option>
                                    <option value="other">Khác</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="address">Địa Chỉ</label>
                            <textarea id="address" name="address" rows="3">123 Đường Bóng Đá, Thành Phố Bóng Đá, FC 12345</textarea>
                        </div>

                        <button type="submit" class="btn btn-primary">Cập Nhật Thông Tin</button>
                    </form>
                </div>

                <!-- Football Profile Section -->
                <div id="football-profile" class="section">
                    <h2 class="section-title">Hồ Sơ Bóng Đá</h2>
                    <form id="footballProfileForm">
                        <div class="form-row">
                            <div class="form-group">
                                <label for="position">Vị Trí Ưa Thích</label>
                                <select id="position" name="position">
                                    <option value="goalkeeper">Thủ Môn</option>
                                    <option value="defender">Hậu Vệ</option>
                                    <option value="midfielder" selected>Tiền Vệ</option>
                                    <option value="forward">Tiền Đạo</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="skillLevel">Trình Độ</label>
                                <select id="skillLevel" name="skillLevel">
                                    <option value="beginner">Mới Bắt Đầu</option>
                                    <option value="intermediate" selected>Trung Bình</option>
                                    <option value="advanced">Nâng Cao</option>
                                    <option value="professional">Chuyên Nghiệp</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group">
                                <label for="favoriteTeam">Đội Bóng Yêu Thích</label>
                                <input type="text" id="favoriteTeam" name="favoriteTeam" value="Manchester United">
                            </div>
                            <div class="form-group">
                                <label for="favoritePlayer">Cầu Thủ Yêu Thích</label>
                                <input type="text" id="favoritePlayer" name="favoritePlayer" value="Cristiano Ronaldo">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group">
                                <label for="yearsPlaying">Số Năm Chơi</label>
                                <input type="number" id="yearsPlaying" name="yearsPlaying" value="8" min="0">
                            </div>
                            <div class="form-group">
                                <label for="currentClub">Câu Lạc Bộ Hiện Tại</label>
                                <input type="text" id="currentClub" name="currentClub" value="City Football Club">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="footballBio">Tiểu Sử Bóng Đá</label>
                            <textarea id="footballBio" name="footballBio" rows="4">Tiền vệ đam mê với 8 năm kinh nghiệm. Yêu thích kiến tạo và hỗ trợ cả phòng ngự lẫn tấn công.</textarea>
                        </div>

                        <button type="submit" class="btn btn-primary">Cập Nhật Hồ Sơ</button>
                    </form>
                </div>

                <!-- Security Settings Section -->
                <div id="security" class="section">
                    <h2 class="section-title">Bảo Mật</h2>
                    
                    <div style="margin-bottom: 30px;">
                        <h3>Đổi Mật Khẩu</h3>
                        <form id="passwordForm">
                            <div class="form-group">
                                <label for="currentPassword">Mật Khẩu Hiện Tại</label>
                                <input type="password" id="currentPassword" name="currentPassword" required>
                            </div>
                            <div class="form-group">
                                <label for="newPassword">Mật Khẩu Mới</label>
                                <input type="password" id="newPassword" name="newPassword" required>
                            </div>
                            <div class="form-group">
                                <label for="confirmPassword">Xác Nhận Mật Khẩu Mới</label>
                                <input type="password" id="confirmPassword" name="confirmPassword" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Đổi Mật Khẩu</button>
                        </form>
                    </div>

                    <div style="margin-bottom: 30px;">
                        <h3>Xác Thực Hai Lớp</h3>
                        <p>Thêm lớp bảo mật cho tài khoản của bạn</p>
                        <button class="btn btn-success" onclick="enable2FA()">Bật 2FA</button>
                    </div>

                    <div>
                        <h3>Phiên Đăng Nhập</h3>
                        <p>Quản lý các phiên đăng nhập hiện tại</p>
                        <button class="btn btn-danger" onclick="logoutAllSessions()">Đăng Xuất Tất Cả Phiên Khác</button>
                    </div>
                </div>

                <!-- Preferences Section -->
                <div id="preferences" class="section">
                    <h2 class="section-title">Tuỳ Chọn</h2>
                    <form id="preferencesForm">
                        <div class="form-group">
                            <label for="language">Ngôn Ngữ</label>
                            <select id="language" name="language">
                                <option value="en" selected>Tiếng Anh</option>
                                <option value="es">Tiếng Tây Ban Nha</option>
                                <option value="fr">Tiếng Pháp</option>
                                <option value="de">Tiếng Đức</option>
                                <option value="it">Tiếng Ý</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="timezone">Múi Giờ</label>
                            <select id="timezone" name="timezone">
                                <option value="utc-5" selected>Giờ Miền Đông (UTC-5)</option>
                                <option value="utc-6">Giờ Miền Trung (UTC-6)</option>
                                <option value="utc-7">Giờ Miền Núi (UTC-7)</option>
                                <option value="utc-8">Giờ Miền Tây (UTC-8)</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <h3>Tuỳ Chọn Thông Báo</h3>
                            <div style="margin: 10px 0;">
                                <input type="checkbox" id="emailNotifications" name="emailNotifications" checked>
                                <label for="emailNotifications" style="display: inline; margin-left: 8px;">Nhận Email Thông Báo</label>
                            </div>
                            <div style="margin: 10px 0;">
                                <input type="checkbox" id="matchReminders" name="matchReminders" checked>
                                <label for="matchReminders" style="display: inline; margin-left: 8px;">Nhắc Nhở Trận Đấu</label>
                            </div>
                            <div style="margin: 10px 0;">
                                <input type="checkbox" id="teamUpdates" name="teamUpdates" checked>
                                <label for="teamUpdates" style="display: inline; margin-left: 8px;">Cập Nhật Đội Bóng</label>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary">Lưu Tuỳ Chọn</button>
                    </form>
                </div>

                <!-- Statistics Section -->
                <div id="stats" class="section">
                    <h2 class="section-title">Thống Kê Bóng Đá Của Bạn</h2>
                    <div class="stats-grid">
                        <div class="stat-card">
                            <div class="stat-number">142</div>
                            <div>Số Trận Đã Đá</div>
                        </div>
                        <div class="stat-card">
                            <div class="stat-number">23</div>
                            <div>Bàn Thắng</div>
                        </div>
                        <div class="stat-card">
                            <div class="stat-number">35</div>
                            <div>Kiến Tạo</div>
                        </div>
                        <div class="stat-card">
                            <div class="stat-number">8.5</div>
                            <div>Điểm Trung Bình</div>
                        </div>
                    </div>

                    <div style="margin-top: 30px;">
                        <h3>Phong Độ Gần Đây</h3>
                        <div style="background: #f8f9fa; padding: 20px; border-radius: 10px; margin: 15px 0;">
                            <p><strong>Trận Gần Nhất:</strong> City FC vs United FC - Thắng 2-1</p>
                            <p><strong>Phong Độ Của Bạn:</strong> 1 Bàn, 1 Kiến Tạo, Điểm: 9.2</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        function showSection(sectionId) {
            // Hide all sections
            const sections = document.querySelectorAll('.section');
            sections.forEach(section => section.classList.remove('active'));
            
            // Remove active class from all nav links
            const navLinks = document.querySelectorAll('.nav-link');
            navLinks.forEach(link => link.classList.remove('active'));
            
            // Show selected section
            document.getElementById(sectionId).classList.add('active');
            
            // Add active class to clicked nav link
            event.target.classList.add('active');
        }

        function showNotification(message, type = 'success') {
            const notification = document.getElementById('notification');
            notification.textContent = message;
            notification.className = `notification ${type}`;
            notification.style.display = 'block';
            
            setTimeout(() => {
                notification.style.display = 'none';
            }, 3000);
        }

        function uploadPhoto() {
            const input = document.createElement('input');
            input.type = 'file';
            input.accept = 'image/*';
            input.onchange = function(e) {
                const file = e.target.files[0];
                if (file) {
                    const reader = new FileReader();
                    reader.onload = function(e) {
                        const avatar = document.getElementById('avatarCircle');
                        avatar.style.backgroundImage = `url(${e.target.result})`;
                        avatar.style.backgroundSize = 'cover';
                        avatar.textContent = '';
                    };
                    reader.readAsDataURL(file);
                    showNotification('Profile photo updated successfully!');
                }
            };
            input.click();
        }

        function enable2FA() {
            showNotification('Two-Factor Authentication has been enabled!');
        }

        function logoutAllSessions() {
            showNotification('All other sessions have been logged out!');
        }

        // Form submission handlers
        document.getElementById('personalInfoForm').addEventListener('submit', function(e) {
            e.preventDefault();
            showNotification('Personal information updated successfully!');
        });

        document.getElementById('footballProfileForm').addEventListener('submit', function(e) {
            e.preventDefault();
            showNotification('Football profile updated successfully!');
        });

        document.getElementById('passwordForm').addEventListener('submit', function(e) {
            e.preventDefault();
            const newPassword = document.getElementById('newPassword').value;
            const confirmPassword = document.getElementById('confirmPassword').value;
            
            if (newPassword !== confirmPassword) {
                showNotification('Passwords do not match!', 'error');
                return;
            }
            
            showNotification('Password changed successfully!');
            this.reset();
        });

        document.getElementById('preferencesForm').addEventListener('submit', function(e) {
            e.preventDefault();
            showNotification('Preferences saved successfully!');
        });
    </script>
</body>
</html>