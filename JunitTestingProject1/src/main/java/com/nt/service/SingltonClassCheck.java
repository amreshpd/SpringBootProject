package com.nt.service;

public class SingltonClassCheck {
	private static SingltonClassCheck INSTANCE=new SingltonClassCheck();
	private SingltonClassCheck() {
		
	}
	public static SingltonClassCheck getInstance() {
		return INSTANCE;
	}
}
