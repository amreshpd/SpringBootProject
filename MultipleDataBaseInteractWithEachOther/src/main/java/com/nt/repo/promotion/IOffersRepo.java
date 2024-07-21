package com.nt.repo.promotion;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.promotion.Offer;

public interface IOffersRepo extends JpaRepository<Offer,Integer>{

}
