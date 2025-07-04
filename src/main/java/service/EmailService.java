package service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    public static final String EMAIL_SENDER = "nguyenphananh49@gmail.com";
    public static final String EMAIL_PASSWORD = "***REMOVED_GMAIL_APP_PASSWORD***";
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 587;

    private void validateCredentials() {
        if (EMAIL_SENDER == null || EMAIL_PASSWORD == null) {
            System.out.println("⚠️ Vui lòng cấu hình biến môi trường SENDER_EMAIL và SENDER_PASSWORD.");
            throw new IllegalStateException("Chưa cấu hình thông tin email.");
        }
        System.out.println("✅ SENDER_EMAIL: " + EMAIL_SENDER);
        System.out.println("✅ SENDER_PASSWORD: " + (EMAIL_PASSWORD != null ? "********" : "NULL"));
    }

    private Session createSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.debug", "true");

        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_SENDER, EMAIL_PASSWORD);
            }
        });
    }

    public void sendOTPEmail(String recipientEmail, String resetCode, String subject) {
        validateCredentials();
        Session session = createSession();

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_SENDER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setContent(
                "<h1>Yêu cầu xác thực OTP</h1>"
                + "<p>Xin chào,</p>"
                + "<p>Chúng tôi đã nhận được một yêu cầu cho tài khoản của bạn.</p>"
                + "<p>Mã xác thực của bạn là: <strong>" + resetCode + "</strong></p>"
                + "<p>Mã này có hiệu lực trong vòng 5 phút. Vui lòng nhập mã để tiếp tục quá trình đặt lại mật khẩu.</p>"
                + "<p>Nếu bạn không yêu cầu, hãy bỏ qua email này.</p>"
                + "<p>Trân trọng,</p>"
                + "<p>Đội ngũ Ứng dụng</p>",
                "text/html; charset=UTF-8"
            );

            Transport.send(message);
            System.out.println("✅ Đã gửi email OTP đến: " + recipientEmail);

        } catch (MessagingException e) {
            System.err.println("❌ Gửi email thất bại: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendManualSignupEmail(String recipientEmail, String username) {
        validateCredentials();
        Session session = createSession();

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_SENDER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Chào mừng bạn đến với Ứng dụng của chúng tôi!");
            message.setContent(
                "<h1>Đăng ký thành công</h1>"
                + "<p>Xin chào " + username + ",</p>"
                + "<p>Chúc mừng! Bạn đã đăng ký tài khoản thành công.</p>"
                + "<p>Thông tin tài khoản:</p>"
                + "<ul>"
                + "<li>Tên người dùng: " + username + "</li>"
                + "<li>Email: " + recipientEmail + "</li>"
                + "</ul>"
                + "<p>Bạn có thể đăng nhập và bắt đầu sử dụng các dịch vụ của chúng tôi.</p>"
                + "<p>Trân trọng,</p>"
                + "<p>Đội ngũ Ứng dụng</p>",
                "text/html; charset=UTF-8"
            );

            Transport.send(message);
            System.out.println("✅ Đã gửi email đăng ký thủ công đến: " + recipientEmail);

        } catch (MessagingException e) {
            System.err.println("❌ Gửi email thất bại: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendGoogleSignupEmail(String recipientEmail, String username) {
        validateCredentials();
        Session session = createSession();

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_SENDER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Chào mừng bạn - Đăng ký bằng Google");
            message.setContent(
                "<h1>Đăng ký bằng Google thành công</h1>"
                + "<p>Xin chào " + username + ",</p>"
                + "<p>Bạn đã đăng ký tài khoản thành công bằng Google.</p>"
                + "<p>Thông tin tài khoản:</p>"
                + "<ul>"
                + "<li>Tên người dùng: " + username + "</li>"
                + "<li>Email: " + recipientEmail + "</li>"
                + "</ul>"
                + "<p>Bạn có thể đăng nhập bất cứ lúc nào bằng tài khoản Google.</p>"
                + "<p>Trân trọng,</p>"
                + "<p>Đội ngũ Ứng dụng</p>",
                "text/html; charset=UTF-8"
            );

            Transport.send(message);
            System.out.println("✅ Đã gửi email đăng ký bằng Google đến: " + recipientEmail);

        } catch (MessagingException e) {
            System.err.println("❌ Gửi email thất bại: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendConfirmationEmail(String recipientEmail, String orderDetails) {
        validateCredentials();
        Session session = createSession();

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_SENDER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Xác nhận đơn hàng");
            message.setContent(
                "<h1>Cảm ơn bạn đã đặt hàng!</h1>"
                + "<p>Chi tiết đơn hàng:</p>"
                + "<pre>" + orderDetails + "</pre>"
                + "<p><strong>Lưu ý:</strong> Đơn hàng sẽ được giao trong vòng 2-3 ngày.</p>",
                "text/html; charset=UTF-8"
            );

            Transport.send(message);
            System.out.println("✅ Đã gửi email xác nhận đơn hàng đến: " + recipientEmail);

        } catch (MessagingException e) {
            System.err.println("❌ Gửi email thất bại: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void sendEmail(String recipientEmail, String subject, String messageText) throws MessagingException {
        System.out.println("📨 [DEBUG] - Bắt đầu gửi email...");
        System.out.println("📨 [DEBUG] - Gửi tới: " + recipientEmail);

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.debug", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_SENDER, EMAIL_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_SENDER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(messageText);

            System.out.println("📨 [INFO] - Đang gửi email...");
            Transport.send(message);
            System.out.println("✅ Email đã gửi thành công!");

        } catch (MessagingException e) {
            System.err.println("❌ Gửi email thất bại: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
