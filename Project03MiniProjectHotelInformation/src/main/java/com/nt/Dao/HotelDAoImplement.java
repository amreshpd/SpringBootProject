package com.nt.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.HotelBean;

@Repository("hDao")
public class HotelDAoImplement implements IHotelDao{
	 private static final String GET_HOTEL_INFO="SELECT CITY,HOTELNAME,HOTELRENT,HOTELADDRESS from HOTEL_INFO WHERE CITY IN(?,?,?) ORDER BY CITY";
	 List<HotelBean> list=null;
	 @Autowired
	 private DataSource ds;
	 @Override
	public List<HotelBean> getHotelDetails(String cty1, String cty2, String cty3) throws Exception {
		try(Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(GET_HOTEL_INFO)){
			ps.setString(1, cty1);
			ps.setString(2, cty2);
			ps.setString(3, cty3);
			list=new ArrayList<HotelBean>();
			try(ResultSet rs=ps.executeQuery()){
				while(rs.next()) {
					HotelBean hb=new HotelBean();
					hb.setCity(rs.getString(1));
					hb.setHotelName(rs.getString(2));
					hb.setHotelRent(rs.getDouble(3));
					hb.setHotelAddress(rs.getString(4));
					list.add(hb);
				}//while end
			}//end try2			
		}//end try1
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		    
		return list;
	}

}
/*
 create table hotel_info(city varchar2(35),hotelName varchar2(150),
 hotelRent number(10,3),hotelAddress varchar2(150));


*/