package br.com.fcamara.dpbes39.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Builder;

@Entity
@Builder
public class Conteudos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;

	private String descricao;

	private boolean finalizado;

	@ManyToMany(mappedBy = "conteudos", cascade = CascadeType.PERSIST)
	private List<Medias> medias = new ArrayList<Medias>();

	@ManyToMany
	private List<NewUsers> idUsers = new ArrayList<NewUsers>();

	@ManyToMany(mappedBy = "conteudos", cascade = CascadeType.PERSIST)
	private List<Trilhas> idTrilhas = new ArrayList<Trilhas>();

	public Conteudos() {
		super();
	}

	public Conteudos(boolean finalizado) {
		super();
		this.finalizado = finalizado;
	}

	public Conteudos(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	/*
	 * public Conteudos(List<NewUsers> idUsers, List<Trilhas> idTrilhas) { super();
	 * this.idUsers = idUsers; this.idTrilhas = idTrilhas; }
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/*
	 public List<Medias> getMedias() { 
		 return medias; }
	 
	public void setMedias(List<Medias> medias) { 
		this.medias = medias; }
	 
	 * public List<NewUsers> getIdUsers() { return idUsers; }
	 * 
	 * public void setIdUsers(List<NewUsers> idUsers) { this.idUsers = idUsers; }
	 * 
	 * public List<Trilhas> getIdTrilhas() { return idTrilhas; }
	 * 
	 * public void setIdTrilhas(List<Trilhas> idTrilhas) { this.idTrilhas =
	 * idTrilhas; }
	 * 
	 */

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
		this.finalizado = false;
	}

}
