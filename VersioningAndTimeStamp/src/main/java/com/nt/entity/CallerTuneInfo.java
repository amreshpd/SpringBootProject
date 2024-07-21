package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="CALLER_TUNE_INFO")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CallerTuneInfo {
	@Id
	@Column(name = "TUNE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer TuneId;
	
	@Column(name = "MOVIE_NAME",length = 30)
	@NonNull
    private String movieName;
	
	@Column(name = "TUNE_NAME",length = 40)
	@NonNull
	private String tuneName;
	@Column(name = "UPDATE_COUNT")
	@Version
	private Integer updateCounter;
	
	@Column(name = "CREATED_LOCAL_TIME",updatable = false)  // we can not created manually because updatable=false
	@CreationTimestamp
	private LocalDateTime createdLocalTime;
	
	@Column(name = "UPDATED_LOCAL_TIME",updatable = true)   // we can update time manually because updatable=true
	@UpdateTimestamp
	private LocalDateTime updateLocalTime;
}
