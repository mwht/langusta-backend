package ovh.spajste.langusta.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MailService {

    @Value("${langusta.mail.host}")
    private String langustaMailHost;

    @Value("${langusta.mail.from}")
    private String langustaMailFrom;

    @Value("${langusta.mail.login}")
    private String langustaMailLogin;

    @Value("${langusta.mail.pass}")
    private String langustaMailPass;

    public void sendMail(String to, String subject, String message) {
        Properties props = new Properties();
        props.put("mail.smtp.host", langustaMailHost);
        Session session = Session.getInstance(props, null);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(langustaMailFrom);
            msg.setRecipients(Message.RecipientType.TO,
                    to);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(message);
            Transport.send(msg, langustaMailLogin, langustaMailPass);
            Logger.getGlobal().log(Level.INFO, "MailService: Sent mail to "+to);
        } catch (MessagingException mex) {
            Logger.getGlobal().log(Level.WARNING, "can't send mail to "+to+": "+mex);
        }
    }

}
