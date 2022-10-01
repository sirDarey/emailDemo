package emaildemo;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class eMailDemo {

    public static void main(String[] args) {
        
        final String username = "your_email_address";
        final String password = "your_password";
        
        Properties props = new Properties ();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props, 
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication () {
                        return new PasswordAuthentication (username, password);
                    }
                });
        
        try {
            
            Message message = new MimeMessage (session);
            message.setFrom(new InternetAddress (username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("recipient_email_address"));
            message.setSubject("eMail Test");
            message.setText("Just testing this email something");
            Transport.send(message);
            System.out.println("Sent Successfully");
            
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        
        
        
    }
}

