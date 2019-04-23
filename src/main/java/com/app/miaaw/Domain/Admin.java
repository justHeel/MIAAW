package com.app.miaaw.Domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "admin_id")
	private long adminId;
	private String name,email;
	
	@OneToMany
	private List<CodeTemplate> codetemplates;

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CodeTemplate> getCodetemplates() {
		return codetemplates;
	}

	public void setCodetemplates(List<CodeTemplate> codetemplates) {
		this.codetemplates = codetemplates;
	}
	
	
	
}
