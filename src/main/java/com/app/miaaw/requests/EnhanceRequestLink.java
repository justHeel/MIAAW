package com.app.miaaw.requests;

public class EnhanceRequestLink {
	String link;
	boolean formOpties;
	boolean imgOpties;
	boolean textToSpeech;
	boolean basicBar;
	boolean basicBarContrast;
	boolean basicBarFont;
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public boolean isFormOpties() {
		return formOpties;
	}
	public void setFormOpties(boolean formOpties) {
		this.formOpties = formOpties;
	}
	public boolean isImgOpties() {
		return imgOpties;
	}
	public void setImgOpties(boolean imgOpties) {
		this.imgOpties = imgOpties;
	}
	public boolean isTextToSpeech() {
		return textToSpeech;
	}
	public void setTextToSpeech(boolean textToSpeech) {
		this.textToSpeech = textToSpeech;
	}
	public boolean isBasicBar() {
		return basicBar;
	}
	public void setBasicBar(boolean basicBar) {
		this.basicBar = basicBar;
	}
	public boolean isBasicBarContrast() {
		return basicBarContrast;
	}
	public void setBasicBarContrast(boolean basicBarContrast) {
		this.basicBarContrast = basicBarContrast;
	}
	public boolean isBasicBarFont() {
		return basicBarFont;
	}
	public void setBasicBarFont(boolean basicBarFont) {
		this.basicBarFont = basicBarFont;
	}
}
