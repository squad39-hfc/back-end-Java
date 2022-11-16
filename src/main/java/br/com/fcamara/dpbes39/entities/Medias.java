package br.com.fcamara.dpbes39.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Builder;

import javax.persistence.JoinColumn;


@Entity
@Builder
public class Medias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedias;	
	private String type;
	private String link;
	private String duration;
	
	
	@ManyToMany
	@JoinTable(name="Conteudos_Medias",
    joinColumns= @JoinColumn(name="idMedias",referencedColumnName = "idMedias"),
    inverseJoinColumns= @JoinColumn(name="idConteudo",referencedColumnName = "id")) 	
	private List<Conteudos> conteudos = new ArrayList<Conteudos>();
	

	public Medias() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Medias(String type, String link, String duration) {
		super();
		this.type = type;
		this.link = link;
		this.duration = duration;
	}
    
	public int getIdMedias() {
		return idMedias;
	}

	public void setIdMedias(int idMedias) {
		this.idMedias = idMedias;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	
	
	
	
	
	

}
