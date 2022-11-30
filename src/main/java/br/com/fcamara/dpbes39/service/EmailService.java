package br.com.fcamara.dpbes39.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.fcamara.dpbes39.entities.EmailEntity;
import br.com.fcamara.dpbes39.enums.StatusEmail;
import br.com.fcamara.dpbes39.repositories.EmailRepository;

@Service
public class EmailService {

	@Autowired
	EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender emailSender;
	
	//Metodo para salvar e enviar email
	public EmailEntity sendEmail(EmailEntity emailEntity) {
		
       emailEntity.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailEntity.getEmailFrom());
            message.setTo(emailEntity.getEmailTo());
            message.setSubject(emailEntity.getSubject());
            message.setText(emailEntity.getText());
            emailSender.send(message);

           emailEntity.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e){
           emailEntity.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return emailRepository.save(emailEntity);
        }	
	
	}
	
}
