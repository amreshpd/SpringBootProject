package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.nt.service.CensusService;

public class CensusServiceTest {
  
	@RepeatedTest(value = 10,name = "execution of {displayName}-{currentRepetition}/{totalRepeatition}")
	@DisplayName("testExport")
	public void testexportData() {
		
		System.out.println("repeated test cases is: ");
		CensusService service=new CensusService();
		Assertions.assertEquals("data exported", service.exportData());

	}
	
	@ParameterizedTest
	@ValueSource(ints= {10,20,30,56,11,78})
	public void testisOdd(int n) {
		System.out.println("test object isOdd() method is invoked");
		CensusService service=new CensusService();
		assertTrue(service.isOdd(n));
	}
	
	@ParameterizedTest
	@ValueSource(strings= {"Ak","Devu"})
	//@EmptySource
	public void testsayHello(String str) {
		System.out.println("test object isOdd() method is invoked");
		CensusService service=new CensusService();
		Assertions.assertEquals("hello"+str,service.sayHello(str));
	}
	
	@ParameterizedTest
//	@ValueSource(strings= {""," ","k"})
//	@EmptySource
//	@NullSource	
	@NullAndEmptySource
	public void testisEmpty(String str) {
		System.out.println("test object isOdd() method is invoked");
		CensusService service=new CensusService();
		Assertions.assertTrue(service.isEmpty(str));
	}
	
}
