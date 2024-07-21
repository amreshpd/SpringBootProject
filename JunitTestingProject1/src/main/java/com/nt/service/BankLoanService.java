package com.nt.service;

public class BankLoanService {
	
	
       public float calSimpleInterestAmount(float pAmt,float rate,float time) {
    	  System.out.println("BankLoanService.calSimpleInterestAmount(.,.):: object is created");
    	   
    	  if(pAmt<=0 || rate<=0 || time<=0) {
    		  throw new IllegalArgumentException("Invalid Input");
    	  }
    	  try {
    		  Thread.sleep(30000);
    	  }catch (Exception e) {
			e.printStackTrace();
		}
    	  return pAmt*rate*time/100.0f;
       }
}
