package com.nt.cmns;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component("cmp")
@Setter
@Getter
@ToString
@ConfigurationProperties(prefix = "org.nit")
public class Company1 {
    private String name;
    private int pincode;
}
