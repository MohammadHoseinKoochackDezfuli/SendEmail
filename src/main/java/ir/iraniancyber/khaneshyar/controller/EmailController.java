package ir.iraniancyber.khaneshyar.controller;

import ir.iraniancyber.khaneshyar.email.EmailSender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendEmail")
public class EmailController {
    private final EmailSender emailSender;

    public EmailController(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @GetMapping
    public ResponseEntity<?> sendEmail(@RequestParam String to,@RequestParam String subject,@RequestParam String text)
    {
        emailSender.sendEmail(to,text,subject);
        return ResponseEntity.ok().build();
    }
}
