package com.agamiit.usermanagement.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STATE_MASTER")
public class StateMasterEntity {
	
	@Id
	@Column(name = "STATE_ID")
	@GeneratedValue
	private int stateId;
	@Column(name = "STATE_NAME")
	private String stateName;
	@Column(name = "COUNTRY_ID")
	private Integer countryId;

}
