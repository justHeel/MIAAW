package com.app.miaaw.WebpageEnhancer;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.app.miaaw.Domain.CodeTemplate;

public class Enhancer {
	public static Document enhanceDocumentLink(String link, CodeTemplate codeTemplate) throws IOException {
		Document htmlDocumentLink = SoupChef.makeLinkSoup(link);
		
		
/*		Elements paragraphs = htmlDocument.select("p");
        for (Element p : paragraphs) {
            p.addClass("MIAAW_Resizeable");
        }
        htmlDocument.append("<style>.MIAAW_Resizeable {color:red;}</style>");*/
		if (codeTemplate.getFormOpties() != null) {
			htmlDocumentLink.append("<p>" + codeTemplate.getFormOpties().getCode() + "</p>");
		}
		if (codeTemplate.getBasicBar() != null) {
			htmlDocumentLink.append("<p>" + codeTemplate.getBasicBar().getBasicBarCode() + "</p>");
			htmlDocumentLink.append("<p>" + codeTemplate.getBasicBar().getContrastOptiesCode() + "</p>");
			htmlDocumentLink.append("<p>" + codeTemplate.getBasicBar().getFontOptiesCode() + "</p>");
		}
		if (codeTemplate.getTextToSpeech() != null) {
			htmlDocumentLink.append("<p>" + codeTemplate.getTextToSpeech().getCode() + "</p>");
		}
		if (codeTemplate.getVideoOpties() != null) {
			htmlDocumentLink.append("<p>" + codeTemplate.getVideoOpties().getCode() + "</p>");
		}
		
        
        return htmlDocumentLink;
	}
	
	public static Document enhanceDocumentFile(String file, CodeTemplate codeTemplate) throws IOException {
		Document htmlDocumentFile = SoupChef.makeLinkSoup(file);
		
		
/*		Elements paragraphs = htmlDocument.select("p");
        for (Element p : paragraphs) {
            p.addClass("MIAAW_Resizeable");
        }
        htmlDocument.append("<style>.MIAAW_Resizeable {color:red;}</style>");*/
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
