package br.com.fcamara.dpbes39.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Builder;

@Entity
@Builder
public class Trilhas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTrilha;

	private String nome;

	private int progresso;

	@ManyToMany
	@JoinTable(name = "Users_Trilhas", joinColumns = {
			@JoinColumn(name = "idTrilha", referencedColumnName = "idTrilha") }, inverseJoinColumns = {
					@JoinColumn(name = "idUser", referencedColumnName = "id") })
	private List<NewUsers> users = new ArrayList<NewUsers>();

	@ManyToMany
	@JoinTable(name = "Conteudos_Trilhas", joinColumns = @JoinColumn(name = "idTrilha", referencedColumnName = "idTrilha"), inverseJoinColumns = @JoinColumn(name = "idConteudo", referencedColumnName = "id"))
	private List<Conteudos> conteudos = new ArrayList<Conteudos>();

	public Trilhas() {
		super();
	}

	public Trilhas(String nome) {
		super();
		this.nome = nome;
	}

	public Trilhas(int progresso) {
		super();
		this.progresso = progresso;
	}

	public Trilhas(String nome, List<NewUsers> users, List<Conteudos> conteudos) {
		super();
		this.nome = nome;
		this.users = users;
		this.conteudos = conteudos;
	}

	public int getIdTrilha() {
		return idTrilha;
	}

	public void setIdTrilha(int idTrilha) {
		this.idTrilha = idTrilha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<NewUsers> getUsers() {
		return users;
	}

	public void setUsers(List<NewUsers> users) {
		this.users = users;
	}

	public List<Conteudos> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<Conteudos> conteudos) {
		this.conteudos = conteudos;
	}

	public int getProgresso() {
		return progresso;
	}

	public void setProgresso(int progresso) {
		this.progresso = progresso;
	}
	
	

}
