import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.net.PasswordAuthentication;
import java.util.Properties;

public class RefundReceipt implements Receipt{
    public void ReceiptType() {

    }
    
    @Override
    public  void createReciept(String orderNumber, String email)
    {
        final String username = "";// set login email here
        final String password = "";// set gmail password here. if 2FA on have to create app password

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(""));// set from email in quotations
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("Refund Receipt for Order: " + orderNumber );
            message.setText("Your order #" + orderNumber + " has been refunded.");

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    }
