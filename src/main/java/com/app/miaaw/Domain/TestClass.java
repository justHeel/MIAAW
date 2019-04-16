package com.app.miaaw.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class TestClass {
	@Id
	private long id;
	private String litness;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLitness() {
		return litness;
	}
	public void setLitness(String litness) {
		this.litness = litness;
	}
}
