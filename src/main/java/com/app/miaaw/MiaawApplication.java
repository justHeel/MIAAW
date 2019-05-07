package com.app.miaaw;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.miaaw.WebpageEnhancer.Enhancer;
import com.app.miaaw.WebpageEnhancer.ImageDescriber;
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

	public static void main(String[] args) {
		SpringApplication.run(MiaawApplication.class, args);

//		try {
//			System.out.println(SoupChef.makeFileSoup("<html>\r\n" + 
//					"	<head>\r\n" + 
//					"		<title>Gitaarles en Optredens Houten - Ludwig Rond&oacute;n</title>\r\n" + 
//					"		<link rel=\"canonical\" href=\"https://www.ludwigrondon.nl/\">\r\n" + 
//					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"artStyle.css\">\r\n" + 
//					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n" + 
//					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"formstyle.css\">\r\n" + 
//					"		<link rel=\"icon\" href=\"icon.png\">\r\n" + 
//					"		<link rel=\"icon\" sizes=\"980x980\" href=\"icon.png\">\r\n" + 
//					"\r\n" + 
//					"		<meta name=\"google-site-verification\" content=\"PxZxCe8zCiH4et-DFjghAMNHDOOTaWXkt1lKI44j1R8\">\r\n" + 
//					"		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0 maximum-scale=1.0, user-scalable=no\">\r\n" + 
//					"		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
//					"\r\n" + 
//					"		<meta name=\"description\" content=\"Gitarist Ludwig Rond&oacute;n geeft gitaarles en ensembletraining in Houten. Ook geeft hij recitals en optredens. Zijn specialiteiten zijn: klassieke muziek, hedendaagse Latijnsamerikaanse muziek, gitaarklassiekers en Antilliaanse volksmuziek.\">\r\n" + 
//					"		<meta name=\"keywords\" content=\"gitaarlessen,gitaarles,muzieklessen,optredens,recitals,klassieke muziek,muziek,bruiloft,muziekale omlijsting,lessen,Houten,houtens muziek collectief, gitaarlessen Houten,gitaarles Houten, muzieklessen Houten,concert,proefles,Ludwig Rond&oacute;n,antilliaanse muziek, antilliaanse volks muziek, antilliaan, antilliaanse gitaar muziek, klassiek antilliaanse muziek, gitarist\">\r\n" + 
//					"		<meta name=\"author\" content=\"Ludwig Rondon\">\r\n" + 
//					"\r\n" + 
//					"		<meta name=\"theme-color\" content=\"#00063d\">\r\n" + 
//					"\r\n" + 
//					"		<script type=\"text/javascript\" src=\"https://cdn.emailjs.com/sdk/2.2.4/email.min.js\"></script>\r\n" + 
//					"		<script type=\"text/javascript\">\r\n" + 
//					"		   (function(){\r\n" + 
//					"		      emailjs.init(\"user_L6RQmVllqCvj8Zp1NhV7E\");\r\n" + 
//					"		   })();\r\n" + 
//					"		</script>\r\n" + 
//					"	</head>\r\n" + 
//					"\r\n" + 
//					"	<body>\r\n" + 
//					"	<div id=\"toolbar\">\r\n" + 
//					"		<button onclick=\"smoothScroll(document.getElementById('info'))\">INFORMATIE</button>\r\n" + 
//					"		<button onclick=\"smoothScroll(document.getElementById('contact'))\">CONTACT</button>\r\n" + 
//					"		<button onclick=\"smoothScroll(document.getElementById('media'))\">MEDIA</button>\r\n" + 
//					"	</div>\r\n" + 
//					"\r\n" + 
//					"\r\n" + 
//					"\r\n" + 
//					"\r\n" + 
//					"	<div id=\"divBody\">\r\n" + 
//					"		<div id=\"background\">\r\n" + 
//					"			<div id=\"canvas\">\r\n" + 
//					"				\r\n" + 
//					"			</div>\r\n" + 
//					"		</div>\r\n" + 
//					"		<div id=\"title\">\r\n" + 
//					"			<h2>Ludwig Rond&oacute;n</h2>\r\n" + 
//					"		</div>\r\n" + 
//					"		<div id=\"title2\">\r\n" + 
//					"			<h1>Gitaarles en Optredens</h1>\r\n" + 
//					"		</div>\r\n" + 
//					"	</div>\r\n" + 
//					"\r\n" + 
//					"		<div class=\"textArea\" id=\"topArea\">\r\n" + 
//					"			<div>\r\n" + 
//					"				<h3 id=\"info\">INFORMATIE</h3>\r\n" + 
//					"				<p>Ludwig Rond&oacute;n is een gitarist uit Houten. Ludwig geeft recitals en optredens. Ook geef hij gitaarles in Houten. Hij is aangesloten bij het Houtens Muziek Collectief. Op deze website vindt u alle informatie over zijn muzieklessen in Houten. Ook kunt u zich aanmelden voor gitaarles en contact opnemen voor eventuele vragen of boekingen voor recitals of optredens.\r\n" + 
//					"				</p>\r\n" + 
//					"				<button id=\"lesButton\" onclick=\"lesTekst()\">Lessen</button>\r\n" + 
//					"				<button id=\"recitalsButton\" onclick=\"recitalsTekst()\">Recitals</button>\r\n" + 
//					"				<button id=\"biografieButton\"onclick=\"biografieTekst()\">Biografie</button>\r\n" + 
//					"				<div id=\"changeableText\"></div>\r\n" + 
//					"			</div>\r\n" + 
//					"		</div>\r\n" + 
//					"\r\n" + 
//					"		<div class=\"textArea\">\r\n" + 
//					"			<div>\r\n" + 
//					"				<h3 id=\"contact\">CONTACT</h3>\r\n" + 
//					"\r\n" + 
//					"				<form id=\"mailForm\">\r\n" + 
//					"				    <label for=\"naam\">Name*</label>\r\n" + 
//					"				    <input 	type=\"text\" id=\"naam\" name=\"naam\" required \r\n" + 
//					"				    		oninvalid=\"this.style.borderBottom = '2px solid red'\"\r\n" + 
//					"				    		placeholder= \"Name...\">\r\n" + 
//					"\r\n" + 
//					"				    <label for=\"lname\">E-Mail*</label>\r\n" + 
//					"				    <input 	type=\"text\" id=\"mail\" name=\"mail\" required \r\n" + 
//					"				    		oninvalid=\"this.style.borderBottom = '2px solid red'\"\r\n" + 
//					"				    		placeholder=\"example@example.com\">\r\n" + 
//					"\r\n" + 
//					"				    <label for=\"lname\">Message*</label>\r\n" + 
//					"				    <textarea rows=\"4\" cols=\"50\" id=\"bericht\" name=\"bericht\" form=\"mailForm\" required \r\n" + 
//					"				    oninvalid=\"this.style.borderBottom = '2px solid red'\"\r\n" + 
//					"				    placeholder=\"Message...\"></textarea>\r\n" + 
//					"				  </form>\r\n" + 
//					"				  <button id=\"sendMailBtn\" onclick=\"sendmail()\">Send!</button>\r\n" + 
//					"				  \r\n" + 
//					"\r\n" + 
//					"				<form id=\"aanmeldenForm\">\r\n" + 
//					"					<h3>AANMELDEN</h3>\r\n" + 
//					"					<p id=\"verplicht\">* verplicht veld</p>\r\n" + 
//					"				    <label for=\"naam\">Naam*</label>\r\n" + 
//					"				    <input 	type=\"text\" id=\"naamAan\" name=\"naam\" required\r\n" + 
//					"						    oninvalid=\"this.style.borderBottom = '2px solid red'\"\r\n" + 
//					"						    placeholder=\"Naam...\">\r\n" + 
//					"\r\n" + 
//					"				    <label for=\"gbdatum\">Geboortedatum*</label>\r\n" + 
//					"				    <input 	type=\"date\" id=\"gbdatum\" name=\"gbdatum\" required\r\n" + 
//					"				    		oninvalid=\"this.style.borderBottom = '2px solid red'\">\r\n" + 
//					"\r\n" + 
//					"				   	<label for=\"adres\">Adres*</label>\r\n" + 
//					"				    <input 	type=\"text\" id=\"adres\" name=\"adres\" required\r\n" + 
//					"						    oninvalid=\"this.style.borderBottom = '2px solid red'\"\r\n" + 
//					"						    placeholder=\"Adres...\">\r\n" + 
//					"\r\n" + 
//					"				    <label for=\"postcode\">Postcode*</label>\r\n" + 
//					"				    <input 	type=\"text\" id=\"postcode\" name=\"postcode\" required\r\n" + 
//					"						    oninvalid=\"this.style.borderBottom = '2px solid red'\"\r\n" + 
//					"						    placeholder=\"8080AA\">\r\n" + 
//					"\r\n" + 
//					"				    <label for=\"plaats\">Plaats*</label>\r\n" + 
//					"				    <input 	type=\"text\" id=\"plaats\" name=\"plaats\" required\r\n" + 
//					"						    oninvalid=\"this.style.borderBottom = '2px solid red'\"\r\n" + 
//					"						    placeholder=\"Plaats...\">\r\n" + 
//					"\r\n" + 
//					"				  	<label for=\"tel\">Telefoon*</label>\r\n" + 
//					"				    <input 	type=\"tel\" id=\"telefoonAan\" name=\"tel\" required\r\n" + 
//					"						    oninvalid=\"this.style.borderBottom = '2px solid red'\"\r\n" + 
//					"						    placeholder=\"Telefoon...\">\r\n" + 
//					"\r\n" + 
//					"				    <label for=\"lname\">E-Mail*</label>\r\n" + 
//					"				    <input 	type=\"email\" id=\"mailAan\" name=\"mail\" required\r\n" + 
//					"						    oninvalid=\"this.style.borderBottom = '2px solid red'\"\r\n" + 
//					"						    placeholder=\"Jouw e-mailadres...\">\r\n" + 
//					"\r\n" + 
//					"				    <label for=\"lesvorm\">Lesvorm*</label>\r\n" + 
//					"				    <select id=\"lesvorm\" name=\"lesvorm\" required\r\n" + 
//					"				    		oninvalid=\"this.style.borderBottom = '2px solid red'\">\r\n" + 
//					"						<option value=\"\" selected disabled hidden>Lesvorm</option>\r\n" + 
//					"					    <option value=\"gratis proefles\">Gratis proefles</option>\r\n" + 
//					"					    <option value=\"eenkeer per week\">1 keer per week</option>\r\n" + 
//					"					    <option value=\"eenkeer per twee weken\">1 keer per twee weken</option>\r\n" + 
//					"						<option value=\"strip 10\">Strippenkaart 10 lessen</option>\r\n" + 
//					"				    </select>\r\n" + 
//					"\r\n" + 
//					"				    <label for=\"lname\">Hoe heeft u mij gevonden?</label>\r\n" + 
//					"				    <textarea rows=\"4\" cols=\"50\" name=\"bericht1\" form=\"mailForm\" placeholder=\"Hoe heeft u mij gevonden?\" id=\"gevonden\"></textarea>\r\n" + 
//					"\r\n" + 
//					"				    <label for=\"lname\">Andere opmerkingen</label>\r\n" + 
//					"				    <textarea rows=\"4\" cols=\"50\" name=\"bericht2\" form=\"mailForm\" placeholder=\"Opmerking...\" id=\"opmerking\"></textarea>\r\n" + 
//					"				     <button id=\"sendAanBtn\" onclick=\"sendaan()\">Meld mij aan!</button>\r\n" + 
//					"				  </form>\r\n" + 
//					"				 \r\n" + 
//					"\r\n" + 
//					"				  	<div>\r\n" + 
//					"					  <button onclick=\"aanmelden();smoothScroll(document.getElementById('contact'));\" id=\"aanmeldenButton\">Of meld je direct aan!\r\n" + 
//					"					  </button>\r\n" + 
//					"\r\n" + 
//					"					  <button onclick=\"tochMail();smoothScroll(document.getElementById('contact'));\" id=\"tochMailButton\">Terug naar mail\r\n" + 
//					"					  </button>\r\n" + 
//					"					</div>\r\n" + 
//					"				<p id=\"contact\">\r\n" + 
//					"					<strong>Contact informatie:</strong><br>	\r\n" + 
//					"					Notengaarde 37, 3992 JR  Houten<br>\r\n" + 
//					"					Telefoon: 06-304 390 92 <br>\r\n" + 
//					"					Email: GitaarProm [at] hotmail.com\r\n" + 
//					"				</p>\r\n" + 
//					"			</div>\r\n" + 
//					"		</div>\r\n" + 
//					"		\r\n" + 
//					"		<div id=\"messagePlace\"></div>\r\n" + 
//					"\r\n" + 
//					"\r\n" + 
//					"		<div class=\"textArea\" id=\"mediaArea\">\r\n" + 
//					"			<h3 id=\"media\">MEDIA</h3>\r\n" + 
//					"			<div id=\"videos\">\r\n" + 
//					"				<div class=\"vid\"> \r\n" + 
//					"					<iframe height='315' src='https://www.youtube-nocookie.com/embed/YaMdHTTlFrY?rel=0&amp;showinfo=0' frameborder='0' allow='autoplay; encrypted-media' allowfullscreen></iframe>\r\n" + 
//					"				</div>\r\n" + 
//					"				<div class=\"vid\"> \r\n" + 
//					"					<iframe height='315' src='https://www.youtube-nocookie.com/embed/hOXNYtoCdCc?rel=0&amp;showinfo=0' frameborder='0' allow='autoplay; encrypted-media' allowfullscreen></iframe>\r\n" + 
//					"				</div>\r\n" + 
//					"				<div class=\"vid\">\r\n" + 
//					"					<iframe height=\"315\" src=\"https://www.youtube-nocookie.com/embed/1mSue8hICjk?rel=0&amp;&amp;showinfo=1\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>\r\n" + 
//					"				</div>\r\n" + 
//					"				<div class=\"vid\">\r\n" + 
//					"					<iframe height=\"315\" src=\"https://www.youtube-nocookie.com/embed/UD05RqtcNck?rel=0&amp;&amp;showinfo=1\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>\r\n" + 
//					"				</div>\r\n" + 
//					"				<div class=\"vid\">\r\n" + 
//					"					<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/YvtEO5J8tKc\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>\r\n" + 
//					"				</div>\r\n" + 
//					"				<div class=\"vid\"> \r\n" + 
//					"					<iframe height=\"315\" src=\"https://www.youtube-nocookie.com/embed/tDTCdWB5Hg8?rel=0&amp;&amp;showinfo=1\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>\r\n" + 
//					"				</div>\r\n" + 
//					"				<div class=\"vid\"> \r\n" + 
//					"					<iframe height=\"315\" src=\"https://www.youtube-nocookie.com/embed/jtvbc-sYu1A?rel=0&amp;&amp;showinfo=1\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>\r\n" + 
//					"				</div>\r\n" + 
//					"				<div class=\"vid\"> \r\n" + 
//					"					<iframe height=\"315\" src=\"https://www.youtube-nocookie.com/embed/qsbnTbzHRFw?rel=0&amp;&amp;showinfo=1\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>\r\n" + 
//					"				</div>\r\n" + 
//					"\r\n" + 
//					"			</div>\r\n" + 
//					"			<h3 id=\"scrollInst\"><--scroll--></h3>\r\n" + 
//					"		</div>\r\n" + 
//					"\r\n" + 
//					"	</body>\r\n" + 
//					"\r\n" + 
//					"	<script src=\"script.js\"></script>\r\n" + 
//					"	<script src=\"scrollTo.js\"></script>\r\n" + 
//					"	<script src=\"textChange.js\"></script>\r\n" + 
//					"	<script src=\"sendMail.js\"></script>\r\n" + 
//					"</html>"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
