package org.monstercraft.info.plugin;

import java.util.Calendar;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Emailer {

    public boolean sendEmail(final String to, final String subject,
            final String body, final String port, final String host,
            final String username, final String password) {
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new MailAuthenticator(
                username, password));
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(username));
            message.setSender(new InternetAddress(username));
            message.setReplyTo(new InternetAddress[] { new InternetAddress(
                    username) });
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    to));
            message.setHeader("Content-Type", "text/plain");
            message.setSubject(subject);
            message.setText(body);
            message.setSentDate(Calendar.getInstance().getTime());
            Transport transport = session.getTransport("smtp");
            transport.connect(host, username, password);
            Transport.send(message);
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private class MailAuthenticator extends Authenticator {
        String user;
        String pw;

        public MailAuthenticator(String username, String password) {
            super();
            this.user = username;
            this.pw = password;
        }

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, pw);
        }
    }

}
