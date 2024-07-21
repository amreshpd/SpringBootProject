package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CallerTuneInfo;
import com.nt.repositry.ICallerTuneInfoRepo;

@Service("CallerTuneService")
public class CallerTuneInfoServiceImpl implements ICallerTuneInfoService {
	@Autowired
	private ICallerTuneInfoRepo repo;
	@Override
	public String saveCallerInfo(CallerTuneInfo caller) {
		Integer id = repo.save(caller).getTuneId();
		return "Caller Tune is saved:: "+id;
	}
	@Override
	public String updateCallerInfo(Integer Id, String tuneName, String movieName) {
		Optional<CallerTuneInfo> find = repo.findById(Id);
		if(find.isPresent()) {
			CallerTuneInfo caller = find.get();
			caller.setTuneName(tuneName);
			caller.setMovieName(movieName);
			CallerTuneInfo tune=repo.save(caller);
			return "Object is updated for "+tune.getUpdateCounter()+" times... last modified on"+tune.getUpdateLocalTime()
			+" .... created on"+tune.getCreatedLocalTime();
			
		}else
		return "Object is not found";
	}
	@Override
	public CallerTuneInfo showAllDataById(Integer id) {
		
		return repo.findById(id).orElseThrow(()->new IllegalArgumentException("Caller id not found"));
	}

}
