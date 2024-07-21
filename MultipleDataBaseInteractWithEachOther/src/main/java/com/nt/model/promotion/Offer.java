package com.nt.model.promotion;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "MDS_OFFERS")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer offerId;
	@NonNull
	@Column(length = 30)
	private String offerName;
	@Column(length = 35)
	@NonNull
	private String offerCode;
	@NonNull
	private Double discountPercantage;
	@NonNull
	private LocalDateTime expiryTime;
}
