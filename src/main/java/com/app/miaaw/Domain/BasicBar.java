package com.app.miaaw.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "basic_bar")
public class BasicBar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name="basicbar_id")
	private long basicBarId;
	
	private String code;
	
	public long getBasicBarId() {
		return basicBarId;
	}
	public void setBasicBarId(long basicBarId) {
		this.basicBarId = basicBarId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
