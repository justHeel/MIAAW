package com.app.miaaw.WebpageEnhancer;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.app.miaaw.Domain.CodeTemplate;

public class Enhancer {
	public static Document enhanceDocument(Document htmlDocument, CodeTemplate codeTemplate) throws IOException {
		/*-------------Form Enhance-------------*/
		if (codeTemplate.getFormOpties() != null) {
			Elements forms = htmlDocument.select("form");
			for (Element f : forms) {
				f.attr("id", "MIAAW_form");

				Elements formInputs = htmlDocument.select("#MIAAW_form input");

				f.append("<div class='MIAAW_form_speech'></div>");
				Elements newDivs = htmlDocument.select(".MIAAW_form_speec");
				for (Element div : newDivs) {
					for (Element fI : formInputs) {
						div.append(fI.toString());
					}
				}
			}
			Elements body = htmlDocument.select("body");
			for (Element b : body) {
				b.append(codeTemplate.getFormOpties().getCode());
			}
		}
		/*-------------Basic Bar-------------*/
		if (codeTemplate.getBasicBar() != null) {
			htmlDocument.append("<p>" + codeTemplate.getBasicBar().getBasicBarCode() + "</p>");
			htmlDocument.append("<p>" + codeTemplate.getBasicBar().getContrastOptiesCode() + "</p>");
			htmlDocument.append("<p>" + codeTemplate.getBasicBar().getFontOptiesCode() + "</p>");
		}
		/*-------------TTS-------------*/
		if (codeTemplate.getTextToSpeech() != null) {
			htmlDocument.append("<p>" + codeTemplate.getTextToSpeech().getCode() + "</p>");
		}
		/*-------------Video Enhance-------------*/
		if (codeTemplate.getVideoOpties() != null) {
			htmlDocument.append("<p>" + codeTemplate.getVideoOpties().getCode() + "</p>");
		}

		return htmlDocument;
	}
}
