package com.example.demo.model;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
@Table(name="materiel")
public class materiel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private int id;
private String nom;
private String reference;
private int quantite;
private Date date_fab;
private Date date_exp;
private String type;
private Date date_ajout;
private String ncategorie;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getReference() {
	return reference;
}
public void setReference(String reference) {
	this.reference = reference;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public Date getDate_fab() {
	return date_fab;
}
public void setDate_fab(Date date_fab) {
	this.date_fab = date_fab;
}
public Date getDate_exp() {
	return date_exp;
}
public void setDate_exp(Date date_exp) {
	this.date_exp = date_exp;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getNcategorie() {
	return ncategorie;
}
public void setNcategorie(String ncategorie) {
	this.ncategorie = ncategorie;
}
public Date getDate_ajout() {
	return date_ajout;
}
public void setDate_ajout(Date date_ajout) {
	this.date_ajout = date_ajout;
}

public materiel(int id, String nom, String reference, int quantite, Date date_fab, Date date_exp, String type,
		Date date_ajout, String ncategorie) {
	super();
	this.id = id;
	this.nom = nom;
	this.reference = reference;
	this.quantite = quantite;
	this.date_fab = date_fab;
	this.date_exp = date_exp;
	this.type = type;
	this.date_ajout = date_ajout;
	this.ncategorie = ncategorie;
}
public materiel() {
	super();
	// TODO Auto-generated constructor stub
}


}
