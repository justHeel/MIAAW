package com.app.miaaw.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import javax.persistence.Id;

@Entity
@Table(name = "font_opties")
public class FontOpties {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "font_id")
	private long fontId;
	
	@OneToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private BasicBar basicBar;
	
	private String code;

	public long getFontId() {
		return fontId;
	}

	public void setFontId(long fontId) {
		this.fontId = fontId;
	}

	public BasicBar getBasicBar() {
		return basicBar;
	}

	public void setBasicBar(BasicBar basicBar) {
		this.basicBar = basicBar;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
