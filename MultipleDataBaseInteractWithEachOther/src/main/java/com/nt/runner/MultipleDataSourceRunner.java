package com.nt.runner;


import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.prod.Product;
import com.nt.model.promotion.Offer;
import com.nt.repo.prod.IProductRepo;
import com.nt.repo.promotion.IOffersRepo;

@Component
public class MultipleDataSourceRunner implements CommandLineRunner {
	@Autowired
	private IProductRepo productRepo;
	@Autowired
	private IOffersRepo offerRepo;
	@Override
	public void run(String... args) throws Exception {
		//save object
		productRepo.saveAll(Arrays.asList(new Product("Mouse", 45.0,47458.0)
				,new Product("Chair", 50.0, 45612.32)
				,new Product("Table", 100.0, 32030.25)));
		System.out.println("Product are saved");

		System.out.println("====================================");
		offerRepo.saveAll(Arrays.asList(new Offer("Buy-1 Get-1","B1G1",10.0,LocalDateTime.of(2024,6,16,12,10))
				,new Offer("Buy-1 Get-1","B1G2",12.0,LocalDateTime.of(2024,6,16,12,45))
				,new Offer("Buy-1 Get-1","B1G3",14.0,LocalDateTime.of(2024,6,16,11,27))));
	System.out.println("Offers are saved.........");
	System.out.println("display the recors(product)......");
	productRepo.findAll().forEach(System.out::println);
	System.out.println("display the record(Offers).....");
	offerRepo.findAll().forEach(System.out::println);
	}

}
