package com.cni.api.model;
import javax.persistence.*;

@Entity
@Table(name = "utilisateur")
public class User {
    
	@Id
	@Column(name = "mat")
	private Long mat;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "role")
	private String role;
	@Column(name = "coddep")
	private String coddep;
	@Column(name = "codreg")
	private String codreg;
	@Column(name = "active")
	private int active;
	@Column(name = "mot_de_passe")
	private String motDePasse;
	@Column(name = "date_modif")
	private String dateModif;
	
	public User() {

	}
	public User(Long mat, String nom, String prenom, String role, String coddep, String codreg, int active,
			String motDePasse, String dateModif) {
		super();
		this.mat = mat;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.coddep = coddep;
		this.codreg = codreg;
		this.active = active;
		this.motDePasse = motDePasse;
		this.dateModif = dateModif;
	}
	public Long getMat() {
		return mat;
	}
	public void setMat(Long mat) {
		this.mat = mat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCoddep() {
		return coddep;
	}
	public void setCoddep(String coddep) {
		this.coddep = coddep;
	}
	public String getCodreg() {
		return codreg;
	}
	public void setCodreg(String codreg) {
		this.codreg = codreg;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getDateModif() {
		return dateModif;
	}
	public void setDateModif(String dateModif) {
		this.dateModif = dateModif;
	}
	public boolean isActive() {
		return active==1?true:false;
	}

}
