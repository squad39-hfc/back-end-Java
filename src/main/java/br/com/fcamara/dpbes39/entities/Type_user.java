package br.com.fcamara.dpbes39.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "typeUsers")
public class Type_user {
		  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idType;
	
	//@ManyToMany(mappedBy = "users")
	@ManyToMany
	@JoinTable(name="typeUsers_users",
    joinColumns= @JoinColumn(name="idType",referencedColumnName = "idType"),
    inverseJoinColumns= @JoinColumn(name="idUser",referencedColumnName = "id")) 
	private List<NewUsers> users = new ArrayList<>();

	public Type_user() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	public Type_user(List<NewUsers> users) {
		super();
		this.users = users;
	}
    */
	public Long getIdType() {
		return idType;
	}

	public void setIdType(Long idType) {
		this.idType = idType;
	}

	public List<NewUsers> getUsers() {
		return users;
	}

	public void setUsers(List<NewUsers> users) {
		this.users = users;
	}

	

}
