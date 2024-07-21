package com.nt.service;

import java.util.List;

import com.nt.model.HotelBean;

public interface IHotelManag {
	public List<HotelBean> fetchHotelData(String cty1,String cty2,String cty3) throws Exception;
}
