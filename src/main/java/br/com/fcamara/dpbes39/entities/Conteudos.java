package br.com.fcamara.dpbes39.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Conteudos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany
	private List<NewUsers> idUsers = new ArrayList<NewUsers>();

	
	@ManyToMany
	private List<Trilhas> idTrilhas = new ArrayList<Trilhas>();
	
	
	
	public Conteudos() {
		super();
	}



	public Conteudos(List<NewUsers> idUsers, List<Trilhas> idTrilhas) {
		super();
		this.idUsers = idUsers;
		this.idTrilhas = idTrilhas;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public List<NewUsers> getIdUsers() {
		return idUsers;
	}



	public void setIdUsers(List<NewUsers> idUsers) {
		this.idUsers = idUsers;
	}



	public List<Trilhas> getIdTrilhas() {
		return idTrilhas;
	}



	public void setIdTrilhas(List<Trilhas> idTrilhas) {
		this.idTrilhas = idTrilhas;
	}

	

	

}
