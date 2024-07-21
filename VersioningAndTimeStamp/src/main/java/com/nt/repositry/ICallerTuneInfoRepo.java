package com.nt.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CallerTuneInfo;

public interface ICallerTuneInfoRepo extends JpaRepository<CallerTuneInfo,Integer>{

}
