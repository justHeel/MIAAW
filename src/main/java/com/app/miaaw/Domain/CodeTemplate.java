package com.app.miaaw.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Id;

@Entity
@Table(name = "code_template")
public class CodeTemplate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name="code_template_id")
	private long codeTemplateId;
	
    @ManyToOne
    @JoinColumn(name = "admin_id")
	private Admin admin;
    
    @OneToOne
    private BasicBar basicBar;
    
	@OneToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private TextToSpeech textToSpeech;
	
	@OneToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private FormOpties formOpties;
	
	@OneToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private VideoOpties videoOpties;
	
	public VideoOpties getVideoOpties() {
		return videoOpties;
	}

	public void setVideoOpties(VideoOpties videoOpties) {
		this.videoOpties = videoOpties;
	}

	public FormOpties getFormOpties() {
		return formOpties;
	}

	public void setFormOpties(FormOpties formOpties) {
		this.formOpties = formOpties;
	}

	public TextToSpeech getTextToSpeech() {
		return textToSpeech;
	}

	public void setTextToSpeech(TextToSpeech textToSpeech) {
		this.textToSpeech = textToSpeech;
	}

	public long getCodeTemplateId() {
		return codeTemplateId;
	}

	public void setCodeTemplateId(long codeTemplateId) {
		this.codeTemplateId = codeTemplateId;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public BasicBar getBasicBar() {
		return basicBar;
	}

	public void setBasicBar(BasicBar basicBar) {
		this.basicBar = basicBar;
	}

    
}
