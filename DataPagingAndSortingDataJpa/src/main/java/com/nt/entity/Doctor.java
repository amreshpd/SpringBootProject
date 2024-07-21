package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "JPA_DOCTOR")
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
	
	
	
	@Column(name ="INCOME",length = 12)
//	@Transient
	private Float income;
	
}
