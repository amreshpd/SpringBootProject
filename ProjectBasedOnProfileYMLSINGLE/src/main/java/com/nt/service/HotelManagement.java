package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Dao.IHotelDao;
import com.nt.Dao.MySQLDao;
import com.nt.model.HotelBean;

@Service("hMan")
public class HotelManagement implements IHotelManag {
	@Autowired
	private IHotelDao htm;
	@Override
	public List<HotelBean> fetchHotelData(String cty1, String cty2, String cty3) throws Exception {
		List<HotelBean> list=htm.getHotelDetails(cty1, cty2, cty3);
		return list;
	}

}
