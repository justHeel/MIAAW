package com.app.miaaw.Domain;

import javax.persistence.Column;
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
	
	@Column(name="code", columnDefinition = "VARCHAR(MAX)")
	private String basicBarCode;
	private String fontOptiesCode, contrastOptiesCode;
	
	public String getBasicBarCode() {
		return basicBarCode;
	}
	public void setBasicBarCode(String basicBarCode) {
		this.basicBarCode = basicBarCode;
	}
	public String getFontOptiesCode() {
		return fontOptiesCode;
	}
	public void setFontOptiesCode(String fontOptiesCode) {
		this.fontOptiesCode = fontOptiesCode;
	}
	public String getContrastOptiesCode() {
		return contrastOptiesCode;
	}
	public void setContrastOptiesCode(String contrastOptiesCode) {
		this.contrastOptiesCode = contrastOptiesCode;
	}
	public long getBasicBarId() {
		return basicBarId;
	}
	public void setBasicBarId(long basicBarId) {
		this.basicBarId = basicBarId;
	}
}
