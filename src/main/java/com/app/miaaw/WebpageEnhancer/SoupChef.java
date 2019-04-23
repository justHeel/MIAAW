package com.app.miaaw.WebpageEnhancer;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SoupChef {
	public static void makeSoup(String link) throws IOException {
        String url = link;
        Document document = Jsoup.connect(url).get();

        Elements paragraphs = document.select("p");
        for (Element p : paragraphs) {
            System.out.println(p.text());
            p.addClass("MIAAW_Resizeable");
        }
        document.append("<style>.MIAAW_Resizeable {color:red;}</style>");
        System.out.println(document);
	}
}
