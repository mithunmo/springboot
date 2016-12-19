package com.f9g4.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class F9G4Hashing {
	
	
	public static String getHashValue(String plaintext){
		 StringBuffer hexString = new StringBuffer();
	try {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		 md.update(plaintext.getBytes());
		 
	        byte byteData[] = md.digest();
		
	    	for (int i=0;i<byteData.length;i++) {
	    		String hex=Integer.toHexString(0xff & byteData[i]);
	   	     	if(hex.length()==1) hexString.append('0');
	   	     	hexString.append(hex);
	    	}
//	    	System.out.println(hexString.toString());
		
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return hexString.toString();
	}
	

}
