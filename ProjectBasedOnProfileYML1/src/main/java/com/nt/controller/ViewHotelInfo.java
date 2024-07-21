package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.HotelBean;
import com.nt.service.HotelManagement;

@Controller("view")
public class ViewHotelInfo {
   @Autowired
	private HotelManagement hm;
   
   public List<HotelBean> viewInfo(String cty1,String cty2,String cty3) throws Exception{
	   List<HotelBean> list=hm.fetchHotelData(cty1, cty2, cty3);
	   return list;
   }
}
