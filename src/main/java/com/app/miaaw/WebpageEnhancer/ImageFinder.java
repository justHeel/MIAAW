package com.app.miaaw.WebpageEnhancer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImageFinder {			
	
	public static List<String> getImagesFromPage(Document page) throws IOException {
		//Document link = SoupChef.makeSoup("https://www.amazon.de/gp/switch-language/homepage.html?ie=UTF8&tag=googdeaen-21&ref=pd_sl_17puwuo972_e&hvadid=163602155469&hvpos=1t1&hvexid=&hvnetw=g&hvrand=15699322301001308934&hvpone=&hvptwo=&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9065291&hvtargid=kwd-10573980&language=nl_NL");
		String s = "";
		Elements images = page.select("img");
		List<String> list = new ArrayList<String>();
		
		for (Element img : images) {
			s = img.attr("abs:src");
			if(!"".equals(s)) {
				list.add(s);
			}
		}
		return list;
	}
}
