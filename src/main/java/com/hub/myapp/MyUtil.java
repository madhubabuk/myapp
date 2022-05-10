package com.hub.myapp;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;

public class MyUtil {

	public static void main(String[] args) {
		System.out.println("here 1");
		// TODO Auto-generated method stub
		 String adminuserCredentials = "user:passwd";
	        String encodedCredentials =
	                new String(Base64.encodeBase64(adminuserCredentials.getBytes(Charset.forName("US-ASCII"))));
	        System.out.println(encodedCredentials);
			/*
			 * HttpHeaders httpHeaders = new HttpHeaders(); httpHeaders.add("Authorization",
			 * "Basic " + encodedCredentials);
			 * httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); return
			 * httpHeaders;
			 */
	}

}
