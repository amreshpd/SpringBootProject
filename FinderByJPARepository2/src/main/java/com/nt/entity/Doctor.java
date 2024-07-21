package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "JPA_DOCTOR1")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Doctor {
    @Column(name = "doct_id") 
	@Id 	
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@SequenceGenerator(name = "gen1",sequenceName = "SEQ_PR1",initialValue = 1000,allocationSize = 1)
    //@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer docId;
	@Column(name="DOC_NAME",length = 100)
    private String docName;
	@Column(name = "SPECIALIZATION",length = 100)
	private String specialization;
	@Column(name = "DOC_PERCANTAGE")
	@NonNull
	private Double percantage;
	@Column(name = "mobile")
	@NonNull
	private Long mobile;
	@Column(name ="INCOME",length = 12)
//	@Transient
	private Double income;
	
}
