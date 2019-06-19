package com.app.miaaw.Domain;

import javax.persistence.Column;
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
@Table(name = "form_opties")
public class FormOpties {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name="form_id")
	private long formId;
	
	@Column(name="ContrastCode", columnDefinition = "VARCHAR(MAX)")
	private String FormContrastCode;
	
	@Column(name="OtherCode", columnDefinition = "VARCHAR(MAX)")
	private String OtherFormCode;
	
	@Column(name="ttsCode", columnDefinition = "VARCHAR(MAX)")
	private String ttsCode;

	public String getTtsCode() {
		return ttsCode;
	}

	public void setTtsCode(String ttsCode) {
		this.ttsCode = ttsCode;
	}

	public long getFormId() {
		return formId;
	}

	public void setFormId(long formId) {
		this.formId = formId;
	}

	public String getFormContrastCode() {
		return FormContrastCode;
	}

	public void setFormContrastCode(String formContrastCode) {
		FormContrastCode = formContrastCode;
	}

	public String getOtherFormCode() {
		return OtherFormCode;
	}

	public void setOtherFormCode(String otherFormCode) {
		OtherFormCode = otherFormCode;
	}

}
