package com.nit.html;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component("htm")
@ToString
@Setter
@Getter
public class Hotel {
	@Value("12345")
	private Integer hotelId;
	@Value("${hotel.name}")
	private String hotelName;
	@Value("${hotel.addrs}")
	private String address;
	
	//customer details
	@Value("${cust.name}")
	private String customerName;
	
	
	//menu
	@Value("${menu.dosarate}")
	private int dosaRate;
	@Value("#{${menu.samosa} + ${menu.bada}}")
	private float totalBillAmt;
	
}
