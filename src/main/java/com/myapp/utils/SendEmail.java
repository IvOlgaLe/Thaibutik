package com.myapp.utils;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

    public String execute(String to, String messageHeader, String messageText) {
        // Recipient's email ID needs to be mentioned.
    //    String to = "abcd@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "thaibutik.irk@gmail.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
    //    properties.setProperty("mail.smtp.host", "10.101.3.229");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(messageHeader);

            // Now set the actual message
            message.setText(messageText);

            // Send message
            Transport.send(message);

        } catch (MessagingException mex) {
            mex.printStackTrace();
            return mex.getMessage();
        }
        return "Sent message successfully";
    }
}
