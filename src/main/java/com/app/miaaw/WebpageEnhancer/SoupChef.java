package com.app.miaaw.WebpageEnhancer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import java.io.File;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SoupChef {
	public static Document makeLinkSoup(String link) throws IOException {
        String url = link;
        Connection conn = Jsoup.connect(url);
        conn.timeout(999999);
        
        Document document = conn.get();
        return document;
	}
	
	public static Document makeFileSoup(String file) throws IOException{
	    Document documentFile = Jsoup.parse(file, "utf-8");
	    return documentFile;
	}
}
