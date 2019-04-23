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
@Table(name = "text_to_speech")
public class TextToSpeech {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name="text_to_speech_id")
	private long textToSpeechId;
	
	@OneToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private CodeTemplate codeTemplate;
	
	private String code;

	public long getTextToSpeechId() {
		return textToSpeechId;
	}

	public void setTextToSpeechId(long textToSpeechId) {
		this.textToSpeechId = textToSpeechId;
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
