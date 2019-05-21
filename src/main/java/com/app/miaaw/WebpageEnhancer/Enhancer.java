package com.app.miaaw.WebpageEnhancer;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.app.miaaw.Domain.CodeTemplate;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Enhancer {
	static String basicBarCode =  "	<style type=\"text/css\">	\r\n" + 
			"		body {\r\n" + 
			"			margin-top:50px !important;\r\n" + 
			"		}	\r\n" + 
			"		#MIAAW_Popup {\r\n" + 
			"			position: fixed !important;\r\n" + 
			"			right:0 !important;\r\n" + 
			"			top:50px !important;\r\n" + 
			"			display: none;\r\n" + 
			"			background: #efefef !important;\r\n" + 
			"			border: 1px solid black !important;\r\n" + 
			"			width: 30% !important;\r\n" + 
			"			height: 300px !important;\r\n" + 
			"			float: right;\r\n" + 
			"			z-index:99999999999 !important;\r\n" + 
			"		}\r\n" + 
			"		\r\n" + 
			"		#MIAAW_Access_editor {\r\n" + 
			"			position:fixed !important;\r\n" + 
			"			z-index:9999999999 !important;\r\n" + 
			"			margin-bottom: 20px !important;\r\n" + 
			"			display: inline-block !important;\r\n" + 
			"			right:0 !important;\r\n" + 
			"			top:0 !important;\r\n" + 
			"			width:30% !important;\r\n" + 
			"			margin-left:10% !important;\r\n" + 
			"			font-size:40px;\r\n" + 
			"			\r\n" + 
			"			background-color: #00ba00 !important;\r\n" + 
			"			border: none !important;\r\n" + 
			"			color: white !important;\r\n" + 
			"			padding: 15px 32px !important;\r\n" + 
			"			text-align: center !important;\r\n" + 
			"			text-decoration: none !important;\r\n" + 
			"			display: inline-block !important;\r\n" + 
			"			font-size: 15px;\r\n" + 
			"			cursor:pointer;\r\n" + 
			"		}\r\n" + 
			"		\r\n" + 
			"		#MIAAW_Access_editor:hover {\r\n" + 
			"			font-size:40px !important;\r\n" + 
			"		}\r\n" + 
			"		\r\n" + 
			"		.exit {\r\n" + 
			"			float: right !important;\r\n" + 
			"			display: inline-block !important;\r\n" + 
			"		}\r\n" + 
			"		\r\n" + 
			"		.MIAAW_speech {\r\n" + 
			"			font-size: 20px;\r\n" + 
			"		}\r\n" + 
			"		\r\n" + 
			"		.font-button {\r\n" + 
			"			height: 20px;\r\n" + 
			"			width: 20px;\r\n" + 
			"			display: inline-block;\r\n" + 
			"			text-align: center;\r\n" + 
			"			line-height: 50px;\r\n" + 
			"			font-size: 25pt;\r\n" + 
			"			cursor: pointer;\r\n" + 
			"		}\r\n" + 
			"		\r\n" + 
			"		.fontsize p {\r\n" + 
			"			display: inline !important;\r\n" + 
			"			margin-left: 20px !important;\r\n" + 
			"			margin-right: 20px !important;\r\n" + 
			"			font-size:35px !important;\r\n" + 
			"		}\r\n" + 
			"		\r\n" + 
			"		.tts, .tts_form {\r\n" + 
			"			margin-left: 5px;\r\n" + 
			"			font-weight: 900 !important;\r\n" + 
			"		}\r\n" + 
			"		.tts p, .tts_form p {\r\n" + 
			"			font-size: 22px !important;\r\n" + 
			"		}\r\n" + 
			"		\r\n" + 
			"		.MIAAW_form_play, .MIAAW_play {\r\n" + 
			"			height: 30px;\r\n" + 
			"			width: 60px;\r\n" + 
			"			display: inline-block;\r\n" + 
			"			font-size: 18px;\r\n" + 
			"			font-weight: 900;\r\n" + 
			"			color: black;\r\n" + 
			"			border: 2px solid #555555;\r\n" + 
			"		}\r\n" + 
			"		\r\n" + 
			"		input {\r\n" + 
			"			width: 400px !important;\r\n" + 
			"			height: 25px !important;\r\n" + 
			"		}\r\n" + 
			"		\r\n" + 
			"		input[type=\"text\"] {\r\n" + 
			"			font-size: 24px !important;\r\n" + 
			"		}\r\n" + 
			"		\r\n" + 
			"		.tekst {\r\n" + 
			"			font-size: 16px !important;\r\n" + 
			"		}\r\n" + 
			"		\r\n" + 
			"		form {\r\n" + 
			"			zoom: 100%;\r\n" + 
			"		}\r\n" + 
			"	</style>\r\n" + 
			"	<button id=\"MIAAW_Access_editor\">Accessibility</button>\r\n" + 
			"	<div id=\"MIAAW_Popup\">\r\n" + 
			"	    <div class=\"fontsize\">\r\n" + 
			"        	<a class=\"font-button plus\">+</a> \r\n" + 
			"                <p>Font size</p>\r\n" + 
			"            <a class=\"font-button minus\">-</a>\r\n" + 
			"        </div>\r\n" + 
			"		<div class=\"tts\">\r\n" + 
			"			<p>Text-to-Speech</p>\r\n" + 
			"			<button class=\"MIAAW_play\">Play</button>\r\n" + 
			"		</div>\r\n" + 
			"		<br>\r\n" + 
			"		<div class=\"tts_form\">\r\n" + 
			"			<p>Text-to-Speech Form</p>\r\n" + 
			"			<button class=\"MIAAW_form_play\">Play</button>\r\n" + 
			"		</div>\r\n" + 
			"		<br>\r\n" + 
			"		<audio src=\"\" class=\"MIAAW_form_speech\" ></audio>\r\n" + 
			"	</div>" + 
			"<script type=\"text/javascript\"\r\n" + 
			"	src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js\"></script>\r\n" + 
			"<script type=\"text/javascript\">\r\n" + 
			"    $(function () {\r\n" + 
			"        $(\".font-button\").bind(\"click\", function () {\r\n" + 
			"            var size = parseInt($('body').css(\"font-size\"));\r\n" + 
			"                if ($(this).hasClass(\"plus\")) {\r\n" + 
			"                    size = size + 2;\r\n" + 
			"                } else {\r\n" + 
			"                    size = size - 2;\r\n" + 
			"                    if (size <= 10) {\r\n" + 
			"                        size = 10;\r\n" + 
			"                    }\r\n" + 
			"                }\r\n" + 
			"         		$('body').css('font-size', size); \r\n" + 
			"         		$('p').css('font-size',size); \r\n" + 
			" /*            $('body').css(\"font-size\", size); */\r\n" + 
			"            console.log(size);\r\n" + 
			"        });\r\n" + 
			"    });\r\n" + 
			"    \r\n" + 
			"    function addNewStyle(newStyle) {\r\n" + 
			"        var styleElement = document.getElementById('styles_js');\r\n" + 
			"        if (!styleElement) {\r\n" + 
			"            styleElement = document.createElement('style');\r\n" + 
			"            styleElement.type = 'text/css';\r\n" + 
			"            styleElement.id = 'styles_js';\r\n" + 
			"            document.getElementsByTagName('head')[0].appendChild(styleElement);\r\n" + 
			"        }\r\n" + 
			"        styleElement.appendChild(document.createTextNode(newStyle));\r\n" + 
			"    }\r\n" + 
			"</script>\r\n" + 
			"<script>\r\n" + 
			"document.getElementById('MIAAW_Popup').style.display = 'none';\r\n" + 
			"document.getElementById('MIAAW_Access_editor').addEventListener('click',function() {\r\n" + 
			"	console.log(document.getElementById('MIAAW_Popup').style.display);\r\n" + 
			"	if (document.getElementById('MIAAW_Popup').style.display == 'none') {\r\n" + 
			"		document.getElementById('MIAAW_Popup').style.display='block';\r\n" + 
			"	}else if (document.getElementById('MIAAW_Popup').style.display == 'block') {\r\n" + 
			"		document.getElementById('MIAAW_Popup').style.display= 'none';\r\n" + 
			"	}\r\n" + 
			"});\r\n" + 
			"</script>\r\n" + 
			"<script>\r\n" + 
			"	function startDictation() {\r\n" + 
			"		var target = [];\r\n" + 
			"		document\r\n" + 
			"				.getElementById(\"MIAAW_form\")\r\n" + 
			"				.addEventListener(\r\n" + 
			"						\"click\",\r\n" + 
			"						function(e) {\r\n" + 
			"							if (e.target && e.target.nodeName == \"INPUT\") {\r\n" + 
			"								console.log(\"List item \", e.target.id.replace(\r\n" + 
			"										\"post-\", \"\"), \" was clicked!\");\r\n" + 
			"								iets = e.target.id.replace(\"post-\", \"\")\r\n" + 
			"								target.push(iets);\r\n" + 
			"\r\n" + 
			"								var arrayLength = target.length;\r\n" + 
			"								for (var i = 0; i < arrayLength; i++) {\r\n" + 
			"\r\n" + 
			"									if (window\r\n" + 
			"											.hasOwnProperty('webkitSpeechRecognition')) {\r\n" + 
			"\r\n" + 
			"										var recognition = new webkitSpeechRecognition();\r\n" + 
			"										recognition.continuous = false;\r\n" + 
			"										recognition.interimResults = false;\r\n" + 
			"\r\n" + 
			"										recognition.lang = \"nl-NL\";\r\n" + 
			"										recognition.start();\r\n" + 
			"\r\n" + 
			"										recognition.onresult = function(e) {\r\n" + 
			"											document.getElementById(iets).value = e.results[0][0].transcript;\r\n" + 
			"											recognition.stop();\r\n" + 
			"										};\r\n" + 
			"\r\n" + 
			"										recognition.onerror = function(e) {\r\n" + 
			"											recognition.stop();\r\n" + 
			"										}\r\n" + 
			"\r\n" + 
			"									}\r\n" + 
			"								}\r\n" + 
			"\r\n" + 
			"								target.pop();\r\n" + 
			"							}\r\n" + 
			"						})\r\n" + 
			"	};\r\n" + 
			"	startDictation();\r\n" + 
			"</script>\r\n" + 
			"<script>\r\n" + 
			"	var tts_classes = document.getElementsByClassName(\"MIAAW_TTS_Text_Group\");\r\n" + 
			"	$('button.MIAAW_play')\r\n" + 
			"			.on(\r\n" + 
			"					'click',\r\n" + 
			"					function(e) {\r\n" + 
			"						var i = 0;\r\n" + 
			"						var next = false;\r\n" + 
			"						$(function() {\r\n" + 
			"							e.preventDefault();\r\n" + 
			"							var text = tts_classes[i].innerHTML;\r\n" + 
			"							text = encodeURIComponent(text);\r\n" + 
			"							var url = \"https://translate.google.com/translate_tts?tl=nl&q=\"\r\n" + 
			"									+ text + \"&client=tw-ob\";\r\n" + 
			"							$('audio').attr('src', url).get(0).play();\r\n" + 
			"							$(\"audio\")\r\n" + 
			"									.bind(\r\n" + 
			"											'ended',\r\n" + 
			"											function() {\r\n" + 
			"												i++;\r\n" + 
			"												text = tts_classes[i].innerHTML;\r\n" + 
			"												text = encodeURIComponent(text);\r\n" + 
			"												var url = \"https://translate.google.com/translate_tts?tl=nl&q=\"\r\n" + 
			"														+ text\r\n" + 
			"														+ \"&client=tw-ob\";\r\n" + 
			"												$('audio').attr('src', url)\r\n" + 
			"														.get(0).play();\r\n" + 
			"											});\r\n" + 
			"						});\r\n" + 
			"					});\r\n" + 
			"</script>\r\n" + 
			"<script>\r\n" + 
			"	$(function() {\r\n" + 
			"		$('button.MIAAW_form_play')\r\n" + 
			"				.on(\r\n" + 
			"						'click',\r\n" + 
			"						function(e) {\r\n" + 
			"							var arrText = new Array();\r\n" + 
			"							$('input[type=text]').each(function() {\r\n" + 
			"								arrText.push($(this).val());\r\n" + 
			"							})\r\n" + 
			"							e.preventDefault();\r\n" + 
			"							var text = arrText;\r\n" + 
			"							text = encodeURIComponent(text);\r\n" + 
			"							console.log(text);\r\n" + 
			"							var url = \"https://translate.google.com/translate_tts?tl=nl&q=\"\r\n" + 
			"									+ text + \"&client=tw-ob\";\r\n" + 
			"							$('audio').attr('src', url).get(0).play();\r\n" + 
			"						});\r\n" + 
			"	});\r\n" + 
			"</script>\r\n" + 
			"<script type=\"text/javascript\">\r\n" + 
			"	onload = function() {\r\n" + 
			"		document.querySelector('form').style.zoom = \"250%\";\r\n" + 
			"	}\r\n" + 
			"</script>";

	public static Document enhanceDocument(Document htmlDocument, CodeTemplate codeTemplate) throws IOException, JSONException {
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
				e.append("<p style='display:none;' class='MIAAW_TTS_Text_Group'>" + textItem + "</p>");
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
			form.attr("id", "MIAAW_form");
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
		
		/*--------------------Add Image Description-------------------*/
		ArrayList<String> imageDescriptions = new ArrayList<String>();
		for (String l : ImageDescriber.getAllDescription(htmlDocument)) {
			JSONObject json = new JSONObject(l);
			
			try {
				for (int i = 0; i < json.getJSONObject("description").getJSONArray("captions").length(); i++) {
					
					if (Double.parseDouble(json.getJSONObject("description").getJSONArray("captions").getJSONObject(i).get("confidence").toString()) > 0.1) {
						imageDescriptions.add(json.getJSONObject("description").getJSONArray("captions").getJSONObject(i).get("text").toString());
					}
				}
			} catch(Exception e) {
				imageDescriptions.add("");
			}
		}
		Elements images = htmlDocument.select("img");
		
		int loopIndex = 0;
		for (Element img : images) {
			if (loopIndex < imageDescriptions.toArray().length) {
				img.before("<p class='MIAAW_Picture_Description'><i> picture: " + imageDescriptions.get(loopIndex) + "</i></p>");
				
			}
			loopIndex++;
		}
		
		return htmlDocument;
	}

	public static ArrayList<String> devideString(String string, int devideOn) {		
		ArrayList<String> stringetjes = new ArrayList<String>();
		String subStr = "";
		String subStr2 = "";
		int i = 0;
		Boolean done= false;
		if (string.length() > devideOn) {
			while (i < string.length()) {
				if (i + devideOn > string.length()) {
					stringetjes.add(string.substring(i, string.length()));
					i += string.length() - i;
				} else {
					subStr = string.substring(i, i + devideOn);
					
					for (int iSub = 100 -1; iSub > 0; iSub--) {
						if (subStr.charAt(iSub) == ' ') {
							subStr2 = string.substring(i, (i + iSub + 1));
							stringetjes.add(subStr2);
							i += iSub + 1;
							done = true;
							break;
						}
					}
					if (done == false) {
						stringetjes.add(string.substring(i, string.length()));
						i += string.length() - i;
					}
					done = false;
				}
			}
		} else {
			stringetjes.add(string);
		}
		return stringetjes;
	}
}
