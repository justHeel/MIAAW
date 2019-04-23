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
@Table(name = "form_opties")
public class FormOpties {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name="form_id")
	private long formId;
	
	@OneToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private CodeTemplate codeTemplate;
	
	private String code;

	public long getFormId() {
		return formId;
	}

	public void setFormId(long formId) {
		this.formId = formId;
	}

	public CodeTemplate getCodeTemplate() {
		return codeTemplate;
	}

	public void setCodeTemplate(CodeTemplate codeTemplate) {
		this.codeTemplate = codeTemplate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
