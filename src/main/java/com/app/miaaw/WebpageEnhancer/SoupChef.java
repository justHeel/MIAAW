package com.app.miaaw.WebpageEnhancer;

import java.io.IOException;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SoupChef {
	public static Document makeLinkSoup(String link) throws IOException {
        String url = link;
        Document document = Jsoup.connect(url).get();
        return document;
        
	}
	
	public static Document makeFileSoup(String file) throws IOException{
		String fileName = file;
	    Document documentFile = Jsoup.parse(new File(fileName), "utf-8");
	    return documentFile;
	}
}
