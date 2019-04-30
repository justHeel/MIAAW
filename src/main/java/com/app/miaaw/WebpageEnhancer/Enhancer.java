package com.app.miaaw.WebpageEnhancer;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.app.miaaw.Domain.CodeTemplate;

public class Enhancer {
	public static Document enhanceDocumentLink(String link, CodeTemplate codeTemplate) throws IOException {
		Document htmlDocument = SoupChef.makeLinkSoup(link);

		/*-------------Form Enhance-------------*/
		if (codeTemplate.getFormOpties() != null) {
			htmlDocument.append("<p>" + codeTemplate.getFormOpties().getCode() + "</p>");
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

	public static Document enhanceDocumentFile(String file, CodeTemplate codeTemplate) throws IOException {
		Document htmlDocumentFile = SoupChef.makeLinkSoup(file);

		/*
		 * Elements paragraphs = htmlDocument.select("p"); for (Element p : paragraphs)
		 * { p.addClass("MIAAW_Resizeable"); }
		 * htmlDocument.append("<style>.MIAAW_Resizeable {color:red;}</style>");
		 */
		if (codeTemplate.getFormOpties() != null) {
			htmlDocumentFile.append("<p>" + codeTemplate.getFormOpties().getCode() + "</p>");
		}
		if (codeTemplate.getBasicBar() != null) {
			htmlDocumentFile.append("<p>" + codeTemplate.getBasicBar().getBasicBarCode() + "</p>");
			htmlDocumentFile.append("<p>" + codeTemplate.getBasicBar().getContrastOptiesCode() + "</p>");
			htmlDocumentFile.append("<p>" + codeTemplate.getBasicBar().getFontOptiesCode() + "</p>");
		}
		if (codeTemplate.getTextToSpeech() != null) {
			htmlDocumentFile.append("<p>" + codeTemplate.getTextToSpeech().getCode() + "</p>");
		}
		if (codeTemplate.getVideoOpties() != null) {
			htmlDocumentFile.append("<p>" + codeTemplate.getVideoOpties().getCode() + "</p>");
		}

		return htmlDocumentFile;
	}
}
