package com.agamiit.usermanagement.binding;

import java.util.Date;

import lombok.Data;

@Data
public class UserRegForm {
	private int userId;
	private String firstName;
	private String lastName;
	private String userEmail;
	private String userPassword;
	private String userMobile;
	private String dob;
	private String gender;
	private Integer cityId;
	private Integer stateId;
	private Integer countryId;
	private String accStatus;
	private Date createdDate;
	private Date updatedDate;

}
