package br.com.fcamara.dpbes39.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fcamara.dpbes39.dto.EmailDto;
import br.com.fcamara.dpbes39.entities.EmailEntity;
import br.com.fcamara.dpbes39.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	EmailService emailService;

	@PostMapping("/sending-email")
	public ResponseEntity<EmailEntity> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
		EmailEntity emailEntity = new EmailEntity();
		// Convert DTO -> Entity ( Model )
		BeanUtils.copyProperties(emailDto, emailEntity);
		// Sending - (criar metodo)
		emailService.sendEmail(emailEntity);
		// retornar para o cliente o email salvo e o status
		return new ResponseEntity<>(emailEntity, HttpStatus.CREATED);
	}


}
