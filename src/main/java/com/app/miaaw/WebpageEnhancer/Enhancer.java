package com.app.miaaw.WebpageEnhancer;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.app.miaaw.Domain.BasicBar;
import com.app.miaaw.Domain.CodeTemplate;
import com.app.miaaw.Domain.TextToSpeech;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Enhancer {
	
	public static Document enhanceDocument(Document htmlDocument, CodeTemplate codeTemplate, boolean describeImage) throws IOException, JSONException {
		/*------------All text string builder and hidden tts creator------------*/
		TextToSpeech tts = codeTemplate.getTextToSpeech()
		if (tts != null) {
			String giantSuperExtremeBigString = "";
			Elements ptjes = htmlDocument.select("p");
			for (Element ptje : ptjes) {
				giantSuperExtremeBigString += ptje.text();
			}
			ArrayList<String> array = devideString(giantSuperExtremeBigString, 100);
			
			htmlDocument.append("<div id='MIAAW_Hidden_TTS_Div'></div>");
			Elements hiddentts = htmlDocument.select("#MIAAW_Hidden_TTS_Div");
			for (Element e : hiddentts) {
				for (String textItem : array) {
					e.append("<p style='display:none;' class='MIAAW_TTS_Text_Group'>" + textItem + "</p>");
				}
			}
		}
		/*-------------Basic Bar-------------*/
		BasicBar basicBar = codeTemplate.getBasicBar();
		Elements body = htmlDocument.select("body");
		Elements divs = htmlDocument.select("p");
		for (Element div : divs) {
			div.addClass("MIAAW_speech");
		}
		Elements forms = htmlDocument.select("form");
		
		for (Element b : body) {
			if (basicBar != null) {
				b.append(basicBar.getBasicBarCode());
			}	
		}

		/*-------------TTS-------------*/
		if (tts != null) {
			Elements popup = htmlDocument.select("#MIAAW_Popup");
			for (Element p : popup) {
				popup.append(tts.getCode());
			}
		}
		/*-------------Form Enhance-------------*/
		boolean therIsAForm = false;
		if (codeTemplate.getFormOpties() != null) {
			Elements formss = htmlDocument.select("form");
			for (Element f : formss) {
				therIsAForm = true;
				f.attr("id", "MIAAW_form");

				Elements formInputs = htmlDocument.select("#MIAAW_form input");

				f.append("<div class='MIAAW_form_speech'></div>");
				Elements newDivs = htmlDocument.select(".MIAAW_form_speech");
				for (Element div : newDivs) {
					for (Element fI : formInputs) {
						div.append(fI.toString());
					}
				}
			}
			if (therIsAForm) {
				Elements popup = htmlDocument.select("#MIAAW_Popup");
				for (Element p : popup) {
					popup.append(codeTemplate.getFormOpties().getTtsCode());
				}
				
				Elements contrastCont = htmlDocument.select("#MIAAW_ContrastOption_Container");
				for (Element p : contrastCont) {
					contrastCont.append(codeTemplate.getFormOpties().getFormContrastCode());
				}
				
				
/*				for (Element b : body) {
					b.append(codeTemplate.getFormOpties().getOtherFormCode());
				}*/
			}

		}
		/*-------------Video Enhance-------------*/
		if (codeTemplate.getVideoOpties() != null) {
			htmlDocument.append(codeTemplate.getVideoOpties().getCode());
		}
		
		/*--------------------Add Image Description-------------------*/
		if (describeImage) {
			ArrayList<String> imageDescriptions = new ArrayList<String>();
			for (String l : ImageDescriber.getAllDescription(htmlDocument)) {
				JSONObject json = new JSONObject(l);
				
				try {
					for (int i = 0; i < json.getJSONObject("description").getJSONArray("captions").length(); i++) {
						
						if (Double.parseDouble(json.getJSONObject("description").getJSONArray("captions").getJSONObject(i).get("confidence").toString()) > 0.1) {
							imageDescriptions.add(json.getJSONObject("description").getJSONArray("captions").getJSONObject(i).get("text").toString());
						}
					}
				} catch(Exception e) {
					imageDescriptions.add("");
				}
			}
			Elements images = htmlDocument.select("img");
			
			int loopIndex = 0;
			for (Element img : images) {
				if (loopIndex < imageDescriptions.toArray().length) {
					img.attr("alt", imageDescriptions.get(loopIndex));
					
				}
				loopIndex++;
			}
		}
		
		return htmlDocument;
	}

	public static ArrayList<String> devideString(String string, int devideOn) {		
		ArrayList<String> stringetjes = new ArrayList<String>();
		String subStr = "";
		String subStr2 = "";
		int i = 0;
		Boolean done= false;
		if (string.length() > devideOn) {
			while (i < string.length()) {
				if (i + devideOn > string.length()) {
					stringetjes.add(string.substring(i, string.length()));
					i += string.length() - i;
				} else {
					subStr = string.substring(i, i + devideOn);
					
					for (int iSub = 100 -1; iSub > 0; iSub--) {
						if (subStr.charAt(iSub) == ' ') {
							subStr2 = string.substring(i, (i + iSub + 1));
							stringetjes.add(subStr2);
							i += iSub + 1;
							done = true;
							break;
						}
					}
					if (done == false) {
						stringetjes.add(string.substring(i, string.length()));
						i += string.length() - i;
					}
					done = false;
				}
			}
		} else {
			stringetjes.add(string);
		}
		return stringetjes;
	}
}
