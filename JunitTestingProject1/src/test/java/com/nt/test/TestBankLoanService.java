package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

import com.nt.service.BankLoanService;

@DisplayName("TestingBankLoanService class")
//@TestMethodOrder(value = OrderAnnotation.class)//best and @order are combined
//@TestMethodOrder(value = MethodName.class)  //based on method name size
//@TestMethodOrder(value = MethodOrderer.DisplayName.class)  // based on ASCII value
@TestMethodOrder(value =MethodOrderer.Random.class) //default 

public class TestBankLoanService {
	private static BankLoanService service;
	private static float actual=0;

	@BeforeEach
	@Disabled
	//@Order(1)
	public void setUp() {
		System.out.println("TestBankLoanService.setUp()");
     service=new BankLoanService();
     actual=service.calSimpleInterestAmount(100000, 2, 12);
	}
	
	
	@BeforeAll
	public static void setUpOnce() {
		service=new BankLoanService();
		actual=service.calSimpleInterestAmount(100000, 2, 12);
	}
	
	@Test
	@DisplayName("with small letter")
	//@Order(2)
	@Tag("uat")
	public void testcalSimpleInterestAmountWithNUmber(TestInfo info) {
		System.out.println(info.getClass()+":"+info.getTags()+": "+info.getDisplayName()+": "+info.getTestMethod().get().getName()+":"+info.getTestClass().get().getName());
		float expected=24000.12f;
	//	Assertions.assertEquals(expected, actual,"results are not matched");
	    Assertions.assertEquals(expected, actual,0.5,"results are not matched");//0.5 is the delta value is allowed to closer value are passed
	}
	
	@Test
	@DisplayName("with Big letter")
	//@Order(5)
	@Tag("test")
	public void testcalSimpleInterestAmountWithBigNUmber() {
	//	BankLoanService service=new BankLoanService();
		float actual=service.calSimpleInterestAmount(10000000, 2, 12);
		float expected=2400000.0f;
	    Assertions.assertEquals(expected, actual);
	}
	@Test
	@DisplayName("whith Invalid input")
	//@Order(-10)
	@Tag("dev")
	public void testcalSimpleInterestAmountWithInvalidNUmber() {
	//	BankLoanService service=new BankLoanService();
		assertThrows(IllegalArgumentException.class, ()->{
			service.calSimpleInterestAmount(0, 0, 0);
			
		});
		
	}
	
	@Test
	@Disabled
	@DisplayName("whith Timer letter")
	//@Order(2)
	
	@Tag("dev") 
	@Tag("uat")
	public void testcalSimpleInterestAmountWithTimer() {
		BankLoanService service=new BankLoanService();
		assertTimeout(Duration.ofMillis(200000), ()->{
			service.calSimpleInterestAmount(1000000, 2, 12);
		});		
	}
	

	@Test
	@DisplayName("whith does not invalid")
	//@Order(12)
	@Tag("dev")
	public void testcalSimpleInterestAmountWithNoException() {
	//	BankLoanService service=new BankLoanService();
		assertDoesNotThrow(()->{
			service.calSimpleInterestAmount(1000, 2, 12);
		});	
	}
	
	
	
	
	
	@AfterEach
	@Disabled
	public void clear() {
		System.out.println("TestBankLoanService.clear()");
		service=null;
	}
	@AfterAll
	public static void clearOnce() {
		System.out.println("TestBankLoanService.clearOnce()");
		service=null;
	}
	
	
	
}
