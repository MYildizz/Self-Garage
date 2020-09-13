package com.yildizmurat.api;

import com.yildizmurat.service.email.EmailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping("/mail")
public class EmailApi {

    EmailService emailService;

    @RequestMapping(value = "/sendEmail")
    public String sendEmail(String name, String phone, String email, String message){

        if(name==null || phone ==null || email==null || message==null){
            return "empty information";
        }
        emailService=new EmailService();

        try {
            emailService.sendmail(name,phone,email,message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Email sent successfully";
    }

    @RequestMapping(value = "/sendComplaint")
    public String sendComplaint(String name, String message){

        if(name==null  || message==null){
            return "empty information";
        }
        emailService=new EmailService();

        try {
            emailService.sendComplaint(name,message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Email sent successfully";
    }


}
