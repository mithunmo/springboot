package com.f9g4.common.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class F9G4HashingTest {

	@Test
	public void testGetHashValue() {
		String p1=F9G4Hashing.getHashValue("password");
		String p2=F9G4Hashing.getHashValue("password");
		String p3=F9G4Hashing.getHashValue("password1");
		String p4=F9G4Hashing.getHashValue("password1");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		assertEquals("Hello",p1.toString(), p2.toString());
		assertEquals("Hello",p3.toString(), p4.toString());
		
		
	}

}
