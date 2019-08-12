package com.fusionhawk.model.res;

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
public class DemandTableDbRes {
	
	@Id
	@Column(name = "CALENDARYEAR")
	private int calenderYear;
	
	@Column(name = "TOTALSALESVOLUME")
	private int totalSalesVolume;

	@Column(name = "APO")
	private int apo;
	
	@Column(name = "TEMPERTURE")
	private int temperature;
	
	@Column(name = "PREDICTIONS")
	private int predictions;

}
