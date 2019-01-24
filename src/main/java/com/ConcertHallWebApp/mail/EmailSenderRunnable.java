package com.ConcertHallWebApp.mail;

import com.ConcertHallWebApp.operations.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderRunnable implements Runnable{

    public EmailServiceImpl emailService;

    private String userEmail;

    @Autowired
    public EmailSenderRunnable(EmailServiceImpl emailService, @Qualifier("p")String userEmail){
        this.emailService = emailService;
        this.userEmail = userEmail;
    }
    public void run() {
        emailService.sendMessageWithAttachment(userEmail, "Bilet na koncert", "Witaj. Dziękujemy za dokonanie mądrego wyboru. Bilet w załaczniku.", "ticket.pdf");
        PDFGenerator.DeleteFile("ticket.pdf");
    }
}
