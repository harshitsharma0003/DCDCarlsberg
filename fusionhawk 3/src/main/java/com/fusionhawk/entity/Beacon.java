package com.fusionhawk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "beacon")
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Beacon {
	
	@Id
	@Column(name = "CALENDARYEAR")
	private String calenderYear;
	
	@Column(name = "LEADSKU")
	private String leadSku;

	@Column(name = "TOTALSALESVOLUME")
	private String totalSalesVolume;

	@Column(name = "APO")
	private String apo;
	
	@Column(name = "TEMPERTURE")
	private String temperature;
	
	@Column(name = "PREDICTIONS")
	private String predictions;
	
	@Column(name = "LEADSKUNAME")
	private String leadSkuName;
	
	@Column(name = "BRANDNAME")
	private String brandName;

}
