package com.app.miaaw.WebpageEnhancer;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SoupChef {
	public static Document makeSoup(String link) throws IOException {
        String url = link;
        Document document = Jsoup.connect(url).get();
        return document;
	}
}
