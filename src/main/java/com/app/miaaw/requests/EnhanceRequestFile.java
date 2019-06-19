package com.app.miaaw.requests;

public class EnhanceRequestFile {
	String file;
	boolean formOpties;
	boolean imgOpties;
	boolean textToSpeech;
	boolean basicBar;
	boolean basicBarContrast;
	boolean basicBarFont;
	
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
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
