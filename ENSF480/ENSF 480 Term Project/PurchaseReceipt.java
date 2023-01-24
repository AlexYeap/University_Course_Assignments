import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class PurchaseReceipt implements Receipt{
    public void ReceiptType() {

    }
    
    public static void createReceipt(String ticketID, String email) {

        final String username = "";//set login email here
        final String password = "";//set gmail password here. if 2FA on have to create app password

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ex@gmail.com"));//set from email in quotations
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("Purchase Receipt for Order: " + ticketID);
            message.setText("Your order #" + ticketID + " has been processed succesfully."
            + "\nYou may refund your ticket until 72 hours before the showtime."
            + "\n\nThank you for your purchase!");

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
