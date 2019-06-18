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
	static String basicBarCode = "<style type=\"text/css\">\r\n" + 
			"#MIAAW_ContrastOption_Container {\r\n" + 
			"	display:block;\r\n" + 
			"	width:100%;\r\n" + 
			"}\r\n" + 
			"#MIAAW_ContrastOption_Container label {\r\n" + 
			"	width:100px;\r\n" + 
			"	overflow:hidden;\r\n" + 
			"	font-size:20px !important;\r\n" + 
			"}\r\n" + 
			"#MIAAW_Popup button {\r\n" + 
			"	margin:0px !important;\r\n" + 
			"	padding:0px !important;\r\n" + 
			"	background-color:white;\r\n" + 
			"}\r\n" + 
			"    #MIAAW_Popup {\r\n" + 
			"    		line-height:18px !important;\r\n" + 
			"            position: fixed !important;\r\n" + 
			"            right:0 !important;\r\n" + 
			"            top:50px !important;\r\n" + 
			"            display: none;\r\n" + 
			"            background: #efefef !important;\r\n" + 
			"            border: 1px solid black !important;\r\n" + 
			"            width: 35% !important;\r\n" + 
			"            height: 100% !important;\r\n" + 
			"            float: right;\r\n" + 
			"            z-index:99999999999 !important;\r\n" + 
			"            overflow: hidden;\r\n" + 
			"        }\r\n" + 
			"        \r\n" + 
			"        #MIAAW_Access_editor {\r\n" + 
			"            position:fixed !important;\r\n" + 
			"            z-index:9999999999 !important;\r\n" + 
			"            margin-bottom: 20px !important;\r\n" + 
			"            display: inline-block !important;\r\n" + 
			"            right:0 !important;\r\n" + 
			"            top:0 !important;\r\n" + 
			"            width:30% !important;\r\n" + 
			"            margin-left:10% !important;\r\n" + 
			"            font-size:40px;\r\n" + 
			"            \r\n" + 
			"            background-color: #ffff00 !important;\r\n" + 
			"            border: none !important;\r\n" + 
			"            color: black !important;\r\n" + 
			"            padding: 15px 32px !important;\r\n" + 
			"            text-align: center !important;\r\n" + 
			"            text-decoration: none !important;\r\n" + 
			"            display: inline-block !important;\r\n" + 
			"            font-size: 24px;\r\n" + 
			"            cursor:pointer;\r\n" + 
			"        }\r\n" + 
			"        \r\n" + 
			"        #MIAAW_Access_editor:hover {\r\n" + 
			"            font-size:40px !important;\r\n" + 
			"        }\r\n" + 
			"\r\n" + 
			".MIAAW_ResizeableText{\r\n" + 
			"    font-family: Arial;\r\n" + 
			"    font-size: 16px;\r\n" + 
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
			".fontsize{\r\n" + 
			"    margin-left: 5px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".fontsize p{\r\n" + 
			"    display: inline;\r\n" + 
			"    margin-left: 20px;\r\n" + 
			"    margin-right: 20px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".exit{\r\n" + 
			"    float: right;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".tts, .tts_form, .fontsize, .tts_popup {\r\n" + 
			"    margin-left: 5px;\r\n" + 
			"    font-weight: 900 !important;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".tts{\r\n" + 
			"    margin-top: 20px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".tts p, .tts_form p, .fontsize p, .tts_popup p {\r\n" + 
			"    font-size: 20px !important;\r\n" + 
			"    margin:2px !important;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"input{\r\n" + 
			"    width: 400px;\r\n" + 
			"    height: 25px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".tekst{\r\n" + 
			"    font-size: 16px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".speech img{\r\n" + 
			"    width: 20px;\r\n" + 
			"    height: 20px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".MIAAW_ResizeableText{\r\n" + 
			"    font-size: 20px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".tts_popup{\r\n" + 
			"    margin-top: 25px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"		.MIAAW_contrastOption1 {\r\n" + 
			"			width: 50px;\r\n" + 
			"			height: 50px;\r\n" + 
			"			background-color: blue !important;\r\n" + 
			"			color:white !important;\r\n" + 
			"			text-shadow: none !important;\r\n" + 
			"		}\r\n" + 
			"		.MIAAW_contrastOption2 {\r\n" + 
			"			width: 50px;\r\n" + 
			"			height: 50px;\r\n" + 
			"			background-color: black !important;\r\n" + 
			"			color:white !important;\r\n" + 
			"			text-shadow: none !important;\r\n" + 
			"		}\r\n" + 
			"		.MIAAW_contrastOption3 {\r\n" + 
			"			width: 50px;\r\n" + 
			"			height: 50px;\r\n" + 
			"			background-color: white !important;\r\n" + 
			"			color:black !important;\r\n" + 
			"			text-shadow: none !important;\r\n" + 
			"		}\r\n" + 
			"		.MIAAW_undocontrast, .MIAAW_undooutline,.MIAAW_undoinputborder {\r\n" + 
			"			width: 50px;\r\n" + 
			"			height: 50px;\r\n" + 
			"		}\r\n" + 
			"		.MIAAW_textoutline1 {\r\n" + 
			"			width: 50px;\r\n" + 
			"			height: 50px;\r\n" + 
			"			text-shadow: -1px -1px 0 black, 1px -1px 0 black, -1px 1px 0 black, 1px 1px 0 black !important;\r\n" + 
			"			color:white !important;\r\n" + 
			"			background-color:white !important;\r\n" + 
			"		}\r\n" + 
			"		.MIAAW_textoutline2 {\r\n" + 
			"			width: 50px;\r\n" + 
			"			height: 50px;\r\n" + 
			"			text-shadow: -1px -1px 0 blue, 1px -1px 0 blue, -1px 1px 0 blue, 1px 1px 0 blue !important;\r\n" + 
			"			color:white !important;\r\n" + 
			"			background-color:white !important;\r\n" + 
			"		}\r\n" + 
			"		.MIAAW_textoutline3 {\r\n" + 
			"			width: 50px;\r\n" + 
			"			height: 50px;\r\n" + 
			"			text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white, 1px 1px 0 white !important;\r\n" + 
			"			color:black !important;\r\n" + 
			"			background-color:black !important;\r\n" + 
			"		}\r\n" + 
			"		.MIAAW_inputborder1 {\r\n" + 
			"			width: 50px;\r\n" + 
			"			height: 50px;\r\n" + 
			"			background-color:#ffff00 !important;\r\n" + 
			"		}\r\n" + 
			"		.MIAAW_inputborder2 {\r\n" + 
			"			width: 50px;\r\n" + 
			"			height: 50px;\r\n" + 
			"			background-color:blue !important;\r\n" + 
			"		} \r\n" + 
			"		.MIAAW_inputborder3 {\r\n" + 
			"			width: 50px;\r\n" + 
			"			height: 50px;\r\n" + 
			"			background-color:black !important;\r\n" + 
			"		}\r\n" + 
			"\r\n" + 
			"</style>" +
			"	<button id=\"MIAAW_Access_editor\">Accessibility</button>\r\n" + 
			"    <div id=\"MIAAW_Popup\">\r\n" + 
			"        <div class=\"fontsize\">\r\n" + 
			"            <a class=\"font-button plus\">+</a> \r\n" + 
			"                <p>Font size</p>\r\n" + 
			"            <a class=\"font-button minus\">-</a>\r\n" + 
			"        </div>\r\n" + 
			"        <div class=\"tts\">\r\n" + 
			"            <p>Text-to-Speech</p>\r\n" + 
			"            <button id=\"play\" class=\"MIAAW_play\"><img class=\\\"MIAAW_play\\\" style=\"height: 40px; width: 40px;\" src=\"../fotos/play.png\"></button>\r\n" + 
			"            <button id=\"pause\" class=\"MIAAW_play\"><img style=\"height: 40px; width: 40px;\" src=\"../fotos/pause.png\"></button>\r\n" + 
			"            <button id=\"stop\" class=\"MIAAW_play\"><img style=\"height: 40px; width: 40px;\" src=\"../fotos/stop.png\"></button>\r\n" + 
			"        </div>\r\n" + 
			"        <br>\r\n" + 
			"        <div class=\"tts_form\">\r\n" + 
			"            <p>Text-to-Speech Form</p>\r\n" + 
			"            <button class=\"MIAAW_form_play\"><img style=\"height: 40px; width: 40px;\" src=\"../fotos/play.png\"></button>\r\n" + 
			"        </div>\r\n" + 
			"        <div class=\"tts_popup\">\r\n" + 
			"            <p>Text-to-Speech Popup</p>\r\n" + 
			"            <button id=\"playpp\" class=\"MIAAW_form_play\"><img style=\"height: 40px; width: 40px;\" src=\"../fotos/play.png\"></button>\r\n" + 
			"        </div>\r\n" + 
			"        <br>\r\n" + 
			"        <div id=\"MIAAW_ContrastOption_Container\">\r\n" + 
			"        	<label>Text Contrast:</label><br>\r\n" + 
			"	       <button class=\"MIAAW_contrastOption1\">Abc</button>\r\n" + 
			"		   <button class=\"MIAAW_contrastOption2\">Abc</button>\r\n" + 
			"		   <button class=\"MIAAW_contrastOption3\">Abc</button>\r\n" + 
			"		   <button class=\"MIAAW_undocontrast\">X</button>\r\n" + 
			"		   <br>\r\n" + 
			"		   <label>Letter Contrast::</label><br>\r\n" + 
			"		   <button class=\"MIAAW_textoutline1\">Abc</button>\r\n" + 
			"		   <button class=\"MIAAW_textoutline2\">Abc</button>\r\n" + 
			"		   <button class=\"MIAAW_textoutline3\">Abc</button>\r\n" + 
			"		   <button class=\"MIAAW_undooutline\">X</button>\r\n" + 
			"		   <br>\r\n" + 
			"		   <label>Form Contrast:</label><br>\r\n" + 
			"		   <button class=\"MIAAW_inputborder1\"></button>\r\n" + 
			"		   <button class=\"MIAAW_inputborder2\"></button>\r\n" + 
			"		   <button class=\"MIAAW_inputborder3\"></button>\r\n" + 
			"		   <button class=\"MIAAW_undoinputborder\">X</button>\r\n" + 
			"	   </div>\r\n" + 
			"        <audio src=\"\" class=\"MIAAW_form_speech\" ></audio>\r\n" + 
			"    </div>" +
			"<script>\r\n" + 
			"onload = function() {\r\n" + 
			"    if ('speechSynthesis' in window) with(speechSynthesis) {\r\n" + 
			"\r\n" + 
			"        var playEle = document.querySelector('#play');\r\n" + 
			"        var pauseEle = document.querySelector('#pause');\r\n" + 
			"        var stopEle = document.querySelector('#stop');\r\n" + 
			"        var flag = false;\r\n" + 
			"\r\n" + 
			"        playEle.addEventListener('click', onClickPlay);\r\n" + 
			"        pauseEle.addEventListener('click', onClickPause);\r\n" + 
			"        stopEle.addEventListener('click', onClickStop);\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"        var myTimeout;\r\n" + 
			"        function myTimer() {\r\n" + 
			"        window.speechSynthesis.pause();\r\n" + 
			"        window.speechSynthesis.resume();\r\n" + 
			"        myTimeout = setTimeout(myTimer, 10000);\r\n" + 
			"        }\r\n" + 
			"\r\n" + 
			"         window.speechSynthesis.cancel();\r\n" + 
			"        myTimeout = setTimeout(myTimer, 10000);\r\n" + 
			"\r\n" + 
			"        function onClickPlay() {\r\n" + 
			"            if(!flag){\r\n" + 
			"                flag = true;\r\n" + 
			"                utterance = new SpeechSynthesisUtterance(document.querySelector('.MIAAW_speech').textContent);\r\n" + 
			"\r\n" + 
			"                utterance.lang = 'nl-NL';\r\n" + 
			"                utterance.rate = 0.7;\r\n" + 
			"                utterance.onend = function(){\r\n" + 
			"                    flag = false; playEle.className = pauseEle.className = ''; stopEle.className = 'stopped';\r\n" + 
			"                };\r\n" + 
			"                playEle.className = 'played';\r\n" + 
			"                stopEle.className = '';\r\n" + 
			"                speak(utterance);\r\n" + 
			"            }\r\n" + 
			"             if (paused) { \r\n" + 
			"                playEle.className = 'played';\r\n" + 
			"                pauseEle.className = '';\r\n" + 
			"                resume();\r\n" + 
			"            } \r\n" + 
			"        }\r\n" + 
			"\r\n" + 
			"        function onClickPause() {\r\n" + 
			"            if(speaking && !paused){ \r\n" + 
			"                pauseEle.className = 'paused';\r\n" + 
			"                playEle.className = '';\r\n" + 
			"                pause();\r\n" + 
			"            }\r\n" + 
			"        }\r\n" + 
			"\r\n" + 
			"        function onClickStop() {\r\n" + 
			"            if(speaking){\r\n" + 
			"                stopEle.className = 'stopped';\r\n" + 
			"                playEle.className = pauseEle.className = '';\r\n" + 
			"                flag = false;\r\n" + 
			"                cancel();\r\n" + 
			"\r\n" + 
			"            }\r\n" + 
			"        }\r\n" + 
			"\r\n" + 
			"    }\r\n" + 
			"\r\n" + 
			"    else { /* speech synthesis not supported */\r\n" + 
			"        msg = document.createElement('h5');\r\n" + 
			"        msg.textContent = \"Detected no support for Speech Synthesis\";\r\n" + 
			"        msg.style.textAlign = 'center';\r\n" + 
			"        msg.style.backgroundColor = 'red';\r\n" + 
			"        msg.style.color = 'white';\r\n" + 
			"        msg.style.marginTop = msg.style.marginBottom = 0;\r\n" + 
			"        document.body.insertBefore(msg, document.querySelector('div'));\r\n" + 
			"    }\r\n" + 
			"\r\n" + 
			"}\r\n" + 
			"</script>\r\n" + 
			"<script>\r\n" + 
			"onload = function() {\r\n" + 
			"    if ('speechSynthesis' in window) with(speechSynthesis) {\r\n" + 
			"\r\n" + 
			"        var playEle = document.querySelector('#playpp');\r\n" + 
			"\r\n" + 
			"        var flag = false;\r\n" + 
			"\r\n" + 
			"        playEle.addEventListener('click', onClickPlay);\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"        var myTimeout;\r\n" + 
			"        function myTimer() {\r\n" + 
			"        window.speechSynthesis.pause();\r\n" + 
			"        window.speechSynthesis.resume();\r\n" + 
			"        myTimeout = setTimeout(myTimer, 10000);\r\n" + 
			"        }\r\n" + 
			"\r\n" + 
			"         window.speechSynthesis.cancel();\r\n" + 
			"        myTimeout = setTimeout(myTimer, 10000);\r\n" + 
			"\r\n" + 
			"        function onClickPlay() {\r\n" + 
			"            if(!flag){\r\n" + 
			"                flag = true;\r\n" + 
			"                utterance = new SpeechSynthesisUtterance(document.querySelector('#MIAAW_Popup').textContent);\r\n" + 
			"\r\n" + 
			"                utterance.lang = 'nl-NL';\r\n" + 
			"                utterance.rate = 0.7;\r\n" + 
			"                speak(utterance);\r\n" + 
			"            }\r\n" + 
			"        }\r\n" + 
			"\r\n" + 
			"    }\r\n" + 
			"\r\n" + 
			"    else { /* speech synthesis not supported */\r\n" + 
			"        msg = document.createElement('h5');\r\n" + 
			"        msg.textContent = \"Detected no support for Speech Synthesis\";\r\n" + 
			"        msg.style.textAlign = 'center';\r\n" + 
			"        msg.style.backgroundColor = 'red';\r\n" + 
			"        msg.style.color = 'white';\r\n" + 
			"        msg.style.marginTop = msg.style.marginBottom = 0;\r\n" + 
			"        document.body.insertBefore(msg, document.querySelector('div'));\r\n" + 
			"    }\r\n" + 
			"\r\n" + 
			"}\r\n" + 
			"</script>\r\n" + 
			"<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js\"></script>\r\n" + 
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
			"            $('body').css(\"font-size\", size);\r\n" + 
			"            console.log(size);\r\n" + 
			"        });\r\n" + 
			"    });\r\n" + 
			"</script>\r\n" + 
			"<script>\r\n" + 
			"document.getElementById('MIAAW_Popup').style.display = 'none';\r\n" + 
			"document.getElementById('MIAAW_Access_editor').addEventListener('click',function() {\r\n" + 
			"    console.log(document.getElementById('MIAAW_Popup').style.display);\r\n" + 
			"    if (document.getElementById('MIAAW_Popup').style.display == 'none') {\r\n" + 
			"        document.getElementById('MIAAW_Popup').style.display='block';\r\n" + 
			"    }else if (document.getElementById('MIAAW_Popup').style.display == 'block') {\r\n" + 
			"        document.getElementById('MIAAW_Popup').style.display= 'none';\r\n" + 
			"    }\r\n" + 
			"});\r\n" + 
			"</script>\r\n" + 
			"<script>\r\n" + 
			"	var elems = document.querySelectorAll(\"p,h1,h2,h3,button,a,label\");\r\n" + 
			"	$('button.MIAAW_contrastOption1').on('click', function() {\r\n" + 
			"	    var index = 0, length = elems.length;\r\n" + 
			"	    for ( ; index < length; index++) {\r\n" + 
			"	        elems[index].style.backgroundColor = \"blue\";\r\n" + 
			"	        elems[index].style.color = \"white\";\r\n" + 
			"	    }\r\n" + 
			"	});\r\n" + 
			"	$('button.MIAAW_contrastOption2').on('click', function() {\r\n" + 
			"	    var index = 0, length = elems.length;\r\n" + 
			"	    for ( ; index < length; index++) {\r\n" + 
			"	        elems[index].style.backgroundColor = \"black\";\r\n" + 
			"	        elems[index].style.color = \"white\";\r\n" + 
			"	    }\r\n" + 
			"	});\r\n" + 
			"	$('button.MIAAW_contrastOption3').on('click', function() {\r\n" + 
			"	    var index = 0, length = elems.length;\r\n" + 
			"	    for ( ; index < length; index++) {\r\n" + 
			"	        elems[index].style.backgroundColor = \"white\";\r\n" + 
			"	        elems[index].style.color = \"black\";\r\n" + 
			"	    }\r\n" + 
			"	});\r\n" + 
			"	$('button.MIAAW_undocontrast').on('click', function() {\r\n" + 
			"	    var index = 0, length = elems.length;\r\n" + 
			"	    for ( ; index < length; index++) {\r\n" + 
			"	        elems[index].style.backgroundColor = \"\";\r\n" + 
			"	        elems[index].style.color = \"\";\r\n" + 
			"	    }\r\n" + 
			"	});\r\n" + 
			"\r\n" + 
			"	$('button.MIAAW_textoutline1').on('click', function(){\r\n" + 
			"	    var index = 0, length = elems.length;\r\n" + 
			"	    for ( ; index < length; index++) {\r\n" + 
			"	        elems[index].style.textShadow = \"-1px -1px 0 black, 1px -1px 0 black, -1px 1px 0 black, 1px 1px 0 black\";\r\n" + 
			"	        elems[index].style.color = \"white\";\r\n" + 
			"	    }\r\n" + 
			"	});\r\n" + 
			"	$('button.MIAAW_textoutline2').on('click', function(){\r\n" + 
			"	    var index = 0, length = elems.length;\r\n" + 
			"	    for ( ; index < length; index++) {\r\n" + 
			"	        elems[index].style.textShadow = \"-1px -1px 0 blue, 1px -1px 0 blue, -1px 1px 0 blue, 1px 1px 0 blue\";\r\n" + 
			"	        elems[index].style.color = \"white\";\r\n" + 
			"	    }\r\n" + 
			"	});\r\n" + 
			"	$('button.MIAAW_textoutline3').on('click', function(){\r\n" + 
			"	    var index = 0, length = elems.length;\r\n" + 
			"	    for ( ; index < length; index++) {\r\n" + 
			"	        elems[index].style.textShadow = \"-1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white, 1px 1px 0 white\";\r\n" + 
			"	        elems[index].style.color = \"black\";\r\n" + 
			"	    }\r\n" + 
			"	});\r\n" + 
			"	$('button.MIAAW_undooutline').on('click', function(){\r\n" + 
			"	    var index = 0, length = elems.length;\r\n" + 
			"	    for ( ; index < length; index++) {\r\n" + 
			"	        elems[index].style.textShadow = \"\";\r\n" + 
			"	        elems[index].style.color = \"\";\r\n" + 
			"	    }\r\n" + 
			"	});\r\n" + 
			"	var borderelems = document.querySelectorAll(\"input,textarea\");\r\n" + 
			"	$('button.MIAAW_inputborder1').on('click', function(){\r\n" + 
			"	    var index = 0, length = elems.length;\r\n" + 
			"	    for ( ; index < length; index++) {\r\n" + 
			"	        borderelems[index].style.border = '4px solid #ffff00'\r\n" + 
			"	    }\r\n" + 
			"	});\r\n" + 
			"	$('button.MIAAW_inputborder2').on('click', function(){\r\n" + 
			"	    var index = 0, length = elems.length;\r\n" + 
			"	    for ( ; index < length; index++) {\r\n" + 
			"	        borderelems[index].style.border = '4px solid blue'\r\n" + 
			"	    }\r\n" + 
			"	});\r\n" + 
			"	$('button.MIAAW_inputborder3').on('click', function(){\r\n" + 
			"	    var index = 0, length = elems.length;\r\n" + 
			"	    for ( ; index < length; index++) {\r\n" + 
			"	        borderelems[index].style.border = '4px solid black'\r\n" + 
			"	    }\r\n" + 
			"	});\r\n" + 
			"	$('button.MIAAW_undoinputborder').on('click', function(){\r\n" + 
			"	    var index = 0, length = elems.length;\r\n" + 
			"	    for ( ; index < length; index++) {\r\n" + 
			"	        borderelems[index].style.border = \"\";\r\n" + 
			"	    }\r\n" + 
			"	});\r\n" + 
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
			htmlDocument.append(codeTemplate.getBasicBar().getBasicBarCode());
			htmlDocument.append(codeTemplate.getBasicBar().getContrastOptiesCode());
			htmlDocument.append(codeTemplate.getBasicBar().getFontOptiesCode());
		}
		/*-------------TTS-------------*/
		if (codeTemplate.getTextToSpeech() != null) {
			htmlDocument.append(codeTemplate.getTextToSpeech().getCode());
		}
		/*-------------Video Enhance-------------*/
		if (codeTemplate.getVideoOpties() != null) {
			htmlDocument.append(codeTemplate.getVideoOpties().getCode());
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
				img.attr("alt", imageDescriptions.get(loopIndex));
				
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
