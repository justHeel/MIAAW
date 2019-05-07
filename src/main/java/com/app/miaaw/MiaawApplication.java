package com.app.miaaw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.miaaw.WebpageEnhancer.ImageDescriber;
import com.app.miaaw.WebpageEnhancer.ImageDescriberFinal;
import com.app.miaaw.WebpageEnhancer.SoupChef;
import com.cmeza.sdgenerator.annotation.SDGenerator;
@SDGenerator(
        entityPackage = "com.app.miaaw.Domain",
        repositoryPackage = "com.app.miaaw.repos",
        managerPackage = "com.app.miaaw.managers",
        repositoryPostfix = "Repository",
        managerPostfix = "Manager",
        onlyAnnotations = false,
        debug = false,
        overwrite = false
)
@SpringBootApplication
public class MiaawApplication {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(MiaawApplication.class, args);
		//System.out.println(ImageDescriber.getDescription());
		
		//System.out.println(ImageDescriber.getAllDescription());
		//List<String> urls = ImageDescriber.getAllDescription();
		//System.out.println(ImageDescriber.getAllDescription());
		//System.out.println(ImageDescriberFinal.getDescription());
		
		List<String> urlOfImages = ImageDescriber.getAllDescription();
		Map<String, String> descriptions = new HashMap<>();
		
		for(String url : urlOfImages) {
			String description = ImageDescriber.getDescription(url);
			descriptions.put(url, description);
		}
		
		descriptions.entrySet().stream().forEach(entry -> {
			System.out.println(">>>>>> Nieuwe plaatje");
			System.out.println("url: " + entry.getKey());
			System.out.println("image details: " + entry.getValue());
		});
		
		
		/*Document link = SoupChef.makeSoup("https://www.amazon.de/gp/switch-language/homepage.html?ie=UTF8&tag=googdeaen-21&ref=pd_sl_17puwuo972_e&hvadid=163602155469&hvpos=1t1&hvexid=&hvnetw=g&hvrand=15699322301001308934&hvpone=&hvptwo=&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9065291&hvtargid=kwd-10573980&language=nl_NL");
		String s;
		Elements images = link.select("img");		
		List<String> list = new ArrayList<String>();
		
		for (Element img : images) {
			s = img.attr("abs:src");
			list.add(s);
			System.out.println(list);
		}*/	
	}
}
