package com.nt.cmns;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

//@Component("comp")
@Setter
@ToString
public class Company {
    @Value("${org.nit.name}")
	private String name;
    @Value("${org.nit.city}")
    private String location;
    
    @Value("${org.nit.pincode}")
    private int pinCode;
    
    @Value("${nit.samosa}+${nit.poha}")
    private int total;
}
