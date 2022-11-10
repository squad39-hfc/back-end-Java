package br.com.fcamara.dpbes39.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class NewUsers {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(nullable = false, unique = true)
	Long id;
	String nome;
	String email;
	
	@ManyToMany(mappedBy = "users", cascade = CascadeType.PERSIST)
	private List<Type_user> Type_user = new ArrayList<Type_user>();
	
	@ManyToMany(mappedBy = "users", cascade = CascadeType.PERSIST)
	private List<Trilhas> Trilhas = new ArrayList<Trilhas>();
	
	public NewUsers(String nome) {
		super();
		this.nome = nome;
	}
	

	public NewUsers(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}


	public NewUsers(String nome, List<Type_user> type_user,
			List<Trilhas> trilhas) {
		super();
		this.nome = nome;
		Type_user = type_user;
		Trilhas = trilhas;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Type_user> getType_user() {
		return Type_user;
	}


	public void setType_user(List<Type_user> type_user) {
		Type_user = type_user;
	}


	public List<Trilhas> getTrilhas() {
		return Trilhas;
	}


	public void setTrilhas(List<Trilhas> trilhas) {
		Trilhas = trilhas;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	

}
