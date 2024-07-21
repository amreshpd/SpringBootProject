package com.nt.Dao;

import java.util.List;

import com.nt.model.HotelBean;

public interface IHotelDao {
	public List<HotelBean> getHotelDetails(String cty1,String cty2,String cty3) throws Exception;
   
    
}
