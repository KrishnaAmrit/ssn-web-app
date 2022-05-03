package com.agamiit.usermanagement.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "USER_DTLS")
@Data
public class UserAccountEntity {
	@Id
	@Column(name = "USER_iD")
	@GeneratedValue
	private int userId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName; 
	
	@Column(name = "USER_EMAIL")
	private String userEmail;
	
	@Column(name = "USER_PWD")
	private String userPwd;
	
	@Column(name = "USER_MOBILE")
	private String userMobile;
	
	@Column(name = "DOB")
	private String dob;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "CITY_ID")
	private Integer cityId;
	
	@Column(name = "STATE_ID")
	private Integer stateId;
	
	@Column(name = "COUNTRY_ID")
	private Integer countryId;
	
	@Column(name = "ACC_STATUS")
	private String accStatus;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;


}
