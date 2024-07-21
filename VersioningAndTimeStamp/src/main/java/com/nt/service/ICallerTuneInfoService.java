package com.nt.service;

import com.nt.entity.CallerTuneInfo;

public interface ICallerTuneInfoService {
	  public String saveCallerInfo(CallerTuneInfo caller);
	  public String updateCallerInfo(Integer Id,String tuneName,String movieName);
	  public CallerTuneInfo showAllDataById(Integer id);
}
