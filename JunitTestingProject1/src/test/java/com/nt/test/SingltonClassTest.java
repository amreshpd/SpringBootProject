package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.nt.service.SingltonClassCheck;

public class SingltonClassTest {
	  
	@Test
	public void testSingloton() {
		SingltonClassCheck s1=SingltonClassCheck.getInstance();
		SingltonClassCheck s2=SingltonClassCheck.getInstance();
       // assertNotNull(s1);
    //    assertNotNull(s2);
		if(s1==null || s2==null)
			fail("s, s2 are must not be null");
		assertSame(s1, s2);
	
	
	}
}
