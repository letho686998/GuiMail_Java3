/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guimail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author LENOVO
 */
public class EmailSender {

    private static String NGUOI_GUI = "tholtph30084@fpt.edu.vn";
    private static String MAT_KHAU = "zcgboorpflqwqcwk";

    public static void send(String ngNhan, String tieuDe, String noiDung) {

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(NGUOI_GUI, MAT_KHAU);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(NGUOI_GUI));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(ngNhan)
            );
            message.setSubject(tieuDe);
            message.setText(noiDung);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        EmailSender.send("quangtnph30071@fpt.edu.vn", "Tho nhai", "Xinh gái");
    }
}
