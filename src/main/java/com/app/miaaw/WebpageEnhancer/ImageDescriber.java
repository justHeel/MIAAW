package com.app.miaaw.WebpageEnhancer;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.jsoup.nodes.Document;

public class ImageDescriber {
	    // **********************************************
	    // *** Update or verify the following values. ***
	    // **********************************************
		
	    // Replace <Subscription Key> with your valid subscription key.
	    private static final String subscriptionKey = "7d868b20a97948c7af4ec3f9011170c2";

	    // You must use the same Azure region in your REST API method as you used to
	    // get your subscription keys. For example, if you got your subscription keys
	    // from the West US region, replace "westcentralus" in the URL
	    // below with "westus".
	    //
	    // Free trial subscription keys are generated in the "westus" region.
	    // If you use a free trial subscription key, you shouldn't need to change
	    // this region.
	    private static final String uriBase =
	            "https://northeurope.api.cognitive.microsoft.com//vision/v2.0/analyze";

	    /*private static final String imageToAnalyze = "https://images-eu.ssl-images-amazon.com/images/G/03/gno/sprites/nav-sprite-global_bluebeacon-V3-1x_optimized._CB454020359_.png";*/


	    public static String getDescription(String url) {
	    	String returnVal = "";
	    	System.out.println("DESCRIBING");
	        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

	        try {
	            URIBuilder builder = new URIBuilder(uriBase);

	            // Request parameters. All of them are optional.
	            builder.setParameter("visualFeatures", "Categories,Description,Color");
	            builder.setParameter("language", "en");

	            // Prepare the URI for the REST API method.
	            URI uri = builder.build();
	            HttpPost request = new HttpPost(uri);

	            // Request headers.
	            request.setHeader("Content-Type", "application/json");
	            request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

	            // Request body.
	            
	            StringEntity requestEntity =
	                    new StringEntity("{\"url\":\"" + url + "\"}");
	            request.setEntity(requestEntity);

	            // Call the REST API method and get the response entity.
	            HttpResponse response = httpClient.execute(request);
	            HttpEntity entity = response.getEntity();

	            if (entity != null) {
	                // Format and display the JSON response.
	                String jsonString = EntityUtils.toString(entity);
	                JSONObject json = new JSONObject(jsonString);
	                returnVal = json.toString(2);
	            }
	            
	            TimeUnit.MILLISECONDS.sleep(250);
	        } catch (Exception e) {
	            // Display error message.
	            System.out.println(e.getMessage());
	        }
	        
			return returnVal;
	    }
	    public static List<String> getAllDescription(Document page) throws IOException {	    	
	    	List<String> imageLinks = ImageFinder.getImagesFromPage(page);    	
	    	List<String> imageDescriptions = new ArrayList<String>();
	    	
	    	for (String link : imageLinks) {
	    		imageDescriptions.add(ImageDescriber.getDescription(link));
	    	}
	    	return imageDescriptions;
	    }
	}
