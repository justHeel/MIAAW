package com.app.miaaw.WebpageEnhancer;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.app.miaaw.Domain.CodeTemplate;

public class Enhancer {
	public static Document enhanceDocument(String link, CodeTemplate codeTemplate) throws IOException {
		Document htmlDocument = SoupChef.makeSoup(link);
		
		Elements paragraphs = htmlDocument.select("p");
        for (Element p : paragraphs) {
            p.addClass("MIAAW_Resizeable");
        }
        htmlDocument.append("<style>.MIAAW_Resizeable {color:red;}</style>");
        return htmlDocument;
	}
}
