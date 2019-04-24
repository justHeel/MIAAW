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
@Table(name = "contrast_opties")
public class ContrastOpties {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "contrast_id")
	private long contrastId;
	
	@OneToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private BasicBar basicBar;
	
	private String code;

	public long getContrastId() {
		return contrastId;
	}

	public void setContrastId(long contrastId) {
		this.contrastId = contrastId;
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
