package com.app.miaaw.WebpageEnhancer;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.app.miaaw.Domain.CodeTemplate;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Enhancer {
	static String basicBarCode = "<audio src=\"\" class=\"MIAAW_form_speech\" hidden></audio>"
			+ "	<button id=\"editor\" onclick=\"document.getElementById('popup').style.display='block'\">Editor</button>\r\n" + 
			"    <div id=\"popup\"> \r\n" + 
			"        <div class=\"tts\">\r\n" + 
			"            <p>Text-to-Speech</p>\r\n" + 
			"            <button class=\"MIAAW_play\">Play</button>\r\n" + 
			"        </div>\r\n" + 
			"        <br>\r\n" + 
			"        <div class=\"tts_form\">\r\n" + 
			"            <p>Text-to-Speech Form</p>\r\n" + 
			"            <button class=\"MIAAW_form_play\">Play</button>\r\n" + 
			"        </div>\r\n" + 
			"        <br>\r\n" + 
			"            <button class=\"exit\" onclick=\"document.getElementById('popup').style.display='none'\">Exit</button>\r\n" + 
			"    </div>"
			+ "<script>\r\n" + 
			"function startDictation() {\r\n" + 
			"    var target = [];\r\n" + 
			"    document.getElementById(\"MIAAW_form\").addEventListener(\"click\", function(e) {\r\n" + 
			"        if(e.target && e.target.nodeName == \"INPUT\") {\r\n" + 
			"            console.log(\"List item \", e.target.id.replace(\"post-\", \"\"), \" was clicked!\");\r\n" + 
			"            iets = e.target.id.replace(\"post-\", \"\")\r\n" + 
			"            target.push(iets);\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"            var arrayLength = target.length;\r\n" + 
			"            for (var i = 0; i < arrayLength; i++) {\r\n" + 
			"        \r\n" + 
			"                if (window.hasOwnProperty('webkitSpeechRecognition')) {\r\n" + 
			"\r\n" + 
			"                        var recognition = new webkitSpeechRecognition();\r\n" + 
			"                        recognition.continuous = false;\r\n" + 
			"                        recognition.interimResults = false;\r\n" + 
			"\r\n" + 
			"                        recognition.lang = \"nl-NL\";\r\n" + 
			"                        recognition.start();\r\n" + 
			"\r\n" + 
			"                        recognition.onresult = function(e) {\r\n" + 
			"                            document.getElementById(iets).value = e.results[0][0].transcript;\r\n" + 
			"                            recognition.stop();\r\n" + 
			"                        };\r\n" + 
			"\r\n" + 
			"                        recognition.onerror = function(e) {\r\n" + 
			"                            recognition.stop();\r\n" + 
			"                        }\r\n" + 
			"\r\n" + 
			"                    }\r\n" + 
			"                }\r\n" + 
			"\r\n" + 
			"        target.pop();\r\n" + 
			"    }\r\n" + 
			"})\r\n" + 
			"};\r\n" + 
			"startDictation();\r\n" + 
			"</script>\r\n" + 
			"<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js\"></script>\r\n" + 
			"<script>\r\n"
			+ "	var tts_classes = document.getElementsByClassName(\"MIAAW_TTS_Text_Group\");\r\n" + 
			"	$('button.MIAAW_play').on('click',function(e){\r\n" + 
			"		var i = 0;\r\n" + 
			"		var next = false;\r\n" + 
			"		    $(function() {\r\n" + 
			"		            e.preventDefault();\r\n" + 
			"		            var text= tts_classes[i].innerHTML;\r\n" + 
			"		            text = encodeURIComponent(text);\r\n" + 
			"		            var url = \"https://translate.google.com/translate_tts?tl=nl&q=\" + text + \"&client=tw-ob\";\r\n" + 
			"		            $('audio').attr('src', url).get(0).play();\r\n" + 
			"		           	$(\"audio\").bind('ended', function(){\r\n" + 
			"		           		i++;\r\n" + 
			"			            text= tts_classes[i].innerHTML;\r\n" + 
			"			            text = encodeURIComponent(text);\r\n" + 
			"			           	var url = \"https://translate.google.com/translate_tts?tl=nl&q=\" + text + \"&client=tw-ob\";\r\n" + 
			"			            $('audio').attr('src', url).get(0).play();\r\n" + 
			"					});\r\n" + 
			"		        });\r\n" + 
			"	});" +
			"</script>\r\n" + 
			"<script>\r\n" + 
			"    $(function() {\r\n" + 
			"        $('button.MIAAW_form_play').on('click',function(e){\r\n" + 
			"            var arrText= new Array();\r\n" + 
			"            $('input[type=text]').each(function(){\r\n" + 
			"                arrText.push($(this).val());\r\n" + 
			"\r\n" + 
			"            })\r\n" + 
			"            e.preventDefault();\r\n" + 
			"            var text= arrText;\r\n" + 
			"            text = encodeURIComponent(text);\r\n" + 
			"            console.log(text);\r\n" + 
			"            var url = \"http://translate.google.com/translate_tts?tl=nl&q=\" + text + \"&client=tw-ob\";\r\n" + 
			"            $('audio').attr('src', url).get(0).play();\r\n" + 
			"        });\r\n" + 
			"});\r\n" + 
			"</script>\r\n" + 
			"<script type=\"text/javascript\">\r\n" + 
			"	onload = function() {\r\n" + 
			"        document.querySelector('form').style.zoom = \"250%\";\r\n" + 
			"    }\r\n" + 
			"</script>\r\n" + 
			"<style type=\"text/css\">\r\n" + 
			"#popup{\r\n" + 
			"    display:none; \r\n" + 
			"    background:#efefef; \r\n" + 
			"    border:1px solid black; \r\n" + 
			"    width:30%; \r\n" + 
			"    height:300px;\r\n" + 
			"    float: right\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"#editor{\r\n" + 
			"    float: right;\r\n" + 
			"    margin-bottom: 20px;\r\n" + 
			"    display: inline-block;\r\n" + 
			"    margin-left: 100%;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"body{\r\n" + 
			"    font-family: Arial;\r\n" + 
			"    font-size: 16px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".exit{\r\n" + 
			"    float: right;\r\n" + 
			"    display: inline-block;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".MIAAW_speech{\r\n" + 
			"    font-size: 20px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".font-button{\r\n" + 
			"    height: 20px;\r\n" + 
			"    width: 20px;\r\n" + 
			"    display: inline-block;\r\n" + 
			"    text-align: center;\r\n" + 
			"    line-height: 50px;\r\n" + 
			"    font-size: 25pt;\r\n" + 
			"    cursor: pointer;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".fontsize p{\r\n" + 
			"    display: inline;\r\n" + 
			"    margin-left: 20px;\r\n" + 
			"    margin-right: 20px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".tts, .tts_form{\r\n" + 
			"    margin-left: 5px;\r\n" + 
			"    font-size: 22px;\r\n" + 
			"    font-weight: 900;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".MIAAW_form_play, .MIAAW_play{\r\n" + 
			"    height: 30px;\r\n" + 
			"    width: 60px;\r\n" + 
			"    display: inline-block;\r\n" + 
			"    font-size: 18px;\r\n" + 
			"    font-weight: 900;\r\n" + 
			"    color: black;\r\n" + 
			"    border: 2px solid #555555;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"input{\r\n" + 
			"    width: 400px;\r\n" + 
			"    height: 25px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"input[type=\"text\"]\r\n" + 
			"{\r\n" + 
			"    font-size:24px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".tekst{\r\n" + 
			"    font-size: 16px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"form{\r\n" + 
			"    zoom: 100%;\r\n" + 
			"}\r\n" + 
			"</style>";
			
	public static Document enhanceDocument(Document htmlDocument, CodeTemplate codeTemplate) throws IOException {
		/*------------All text string builder and hidden tts creator------------*/
		String giantSuperExtremeBigString = "";
		Elements ptjes = htmlDocument.select("p");
		for (Element ptje : ptjes) {
			giantSuperExtremeBigString += ptje.text();
		}
		ArrayList<String> array = devideString(giantSuperExtremeBigString, 100);
		htmlDocument.append("<div id='MIAAW_Hidden_TTS_Div'></div>");
		Elements hiddentts = htmlDocument.select("#MIAAW_Hidden_TTS_Div");
		for (Element e : hiddentts) {
			for (String textItem : array) {
				e.append("<p style='display:none;' class='MIAAW_TTS_Text_Group'>"+textItem+"</p>");
			}
		}

		
		/*-------------Form Enhance-------------*/
		if (codeTemplate.getFormOpties() != null) {
			Elements forms = htmlDocument.select("form");
			for (Element f : forms) {
				f.attr("id", "MIAAW_form");
				
				Elements formInputs = htmlDocument.select("#MIAAW_form input");

				f.append("<div class='MIAAW_form_speech'></div>");
				Elements newDivs = htmlDocument.select(".MIAAW_form_speech");
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
		Elements body = htmlDocument.select("body");
		Elements divs = htmlDocument.select("p");
		for (Element div : divs) {
			div.addClass("MIAAW_speech");
		}
		Elements forms = htmlDocument.select("form");
		for (Element form : forms) {
			form.attr("id","MIAAW_form");
		}
		for (Element b : body) {
			b.append(basicBarCode);
		}
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
	
	public static ArrayList<String> devideString(String string, int devideOn) {
		ArrayList<String> stringetjes = new ArrayList<String>();
		
		int i =0;
		if (string.length() > devideOn) {
			while (i < string.length()) {
				if (i+devideOn > string.length()) {
					stringetjes.add(string.substring(i, string.length()));
					i+= string.length() - i;
				} else {
					stringetjes.add(string.substring(i, i+devideOn));
					i+= devideOn;
				}
			}
		} else {
			stringetjes.add(string);
		}
		return stringetjes;
	}
	
}
