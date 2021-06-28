package com.example.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class user {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="ide")
private int ide;
private String username;
private String password;
private String role;
public int getIde() {
	return ide;
}
public void setIde(int ide) {
	this.ide = ide;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public user(int ide, String username, String password, String role) {
	super();
	this.ide = ide;
	this.username = username;
	this.password = password;
	this.role = role;
}
public user() {
	super();
	// TODO Auto-generated constructor stub
}

}
