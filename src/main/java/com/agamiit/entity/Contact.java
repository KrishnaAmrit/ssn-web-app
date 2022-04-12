package com.agamiit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACT_DTLS")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTACT_Id")
	private Integer contactId;
	
	@Column(name = "CONTACT_NUMBER")
	private long contactNumber;
	
	@Column(name = "CONTACT_NAME")
	private String contactName;
	
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name = "CREATE_DATE",updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	@Column(name = "UPDATE_DATE",insertable = false)
	
	@UpdateTimestamp
	private LocalDate updateDate;
	@Column(name = "ACTIVISW")
	private String activieSW;

}
