package com.app.miaaw.requests;

public class EnhanceRequestLink {
	String link;
	long formOpties;
	long videoOpties;
	long textToSpeech;
	long basicBar;
	long basicBarContrast;
	long basicBarFont;
	

	public long getFormOpties() {
		return formOpties;
	}

	public void setFormOpties(long formOpties) {
		this.formOpties = formOpties;
	}

	public long getVideoOpties() {
		return videoOpties;
	}

	public void setVideoOpties(long videoOpties) {
		this.videoOpties = videoOpties;
	}

	public long getTextToSpeech() {
		return textToSpeech;
	}

	public void setTextToSpeech(long textToSpeech) {
		this.textToSpeech = textToSpeech;
	}

	public long getBasicBar() {
		return basicBar;
	}

	public void setBasicBar(long basicBar) {
		this.basicBar = basicBar;
	}

	public long getBasicBarContrast() {
		return basicBarContrast;
	}

	public void setBasicBarContrast(long basicBarContrast) {
		this.basicBarContrast = basicBarContrast;
	}

	public long getBasicBarFont() {
		return basicBarFont;
	}

	public void setBasicBarFont(long basicBarFont) {
		this.basicBarFont = basicBarFont;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
