package com.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_tc6 {
	

	@Test
	void Proj() {
	//Step 1 Specify End point /Base URL 		 	
		RestAssured.baseURI="https://swapi.dev/api/"; 		
		
		//Step 2 create request object for type of request 		 		
		RequestSpecification httprequest=RestAssured.given(); 		 
		
		//Step 3 Create response object 		 		
		Response httpresponse=httprequest.request(Method.GET,"people/4/"); 		 	
		String response=httpresponse.getBody().asString(); 		
		System.out.println(response); 		 	
		
		//Validate Status code 	
		int Code=httpresponse.getStatusCode(); //200 	
		System.out.println(Code); 	
		
		//Insert asserts 		
		Assert.assertEquals(Code, 200);
		
		//statusline:fetching status
		String statusline=httpresponse.statusLine();
		System.out.println(statusline);
		
		//validate statusline
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
	}


}
