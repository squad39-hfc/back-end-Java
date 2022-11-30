package br.com.fcamara.dpbes39.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.fcamara.dpbes39.enums.StatusEmail;
import lombok.Data;

//@Data
@Entity
@Table(name = "EMAIL")
public class EmailEntity implements Serializable{	
	private static final long serialVersionUID = 1l;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmail;
	
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;
	public EmailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailEntity(String ownerRef, String emailFrom, String emailTo, String subject, String text,
			LocalDateTime sendDateEmail, StatusEmail statusEmail) {
		super();
		this.ownerRef = ownerRef;
		this.emailFrom = emailFrom;
		this.emailTo = emailTo;
		this.subject = subject;
		this.text = text;
		this.sendDateEmail = sendDateEmail;
		this.statusEmail = statusEmail;
	}

	
	
	public Long getIdEmail() {
		return idEmail;
	}
	public void setIdEmail(Long idEmail) {
		this.idEmail = idEmail;
	}
	public String getOwnerRef() {
		return ownerRef;
	}
	public void setOwnerRef(String ownerRef) {
		this.ownerRef = ownerRef;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	public String getEmailTo() {
		return emailTo;
	}
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDateTime getSendDateEmail() {
		return sendDateEmail;
	}
	public void setSendDateEmail(LocalDateTime sendDateEmail) {
		this.sendDateEmail = sendDateEmail;
	}
	public StatusEmail getStatusEmail() {
		return statusEmail;
	}
	public void setStatusEmail(StatusEmail statusEmail) {
		this.statusEmail = statusEmail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    

}
