package com.fuatkara.map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Government", catalog = "newDatabase")
public class Government {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Government_Id", unique = true ,nullable = false)
	private Integer governmentId;

	@Column(name = "Government_Service", length = 50)
	private String governmentService;
	
	@Column(name = "Government_Name", length = 50)
	private String governmentName;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "government", cascade = CascadeType.ALL) //mapped by: GovernmentInfo icinde tanimlanan degiskenle ayni 									
																						 //olmasi lazim : private Government goverment;
	private GovernmentInfo governmentInfo;
	
	public Government() {
		
	}

	public Government(Integer governmentId, String governmentService, String governmentName,
			GovernmentInfo governmentInfo) {
		super();
		this.governmentId = governmentId;
		this.governmentService = governmentService;
		this.governmentName = governmentName;
		this.governmentInfo = governmentInfo;
	}

	public Integer getGovernmentId() {
		return governmentId;
	}

	public void setGovernmentId(Integer governmentId) {
		this.governmentId = governmentId;
	}

	public String getGovernmentService() {
		return governmentService;
	}

	public void setGovernmentService(String governmentService) {
		this.governmentService = governmentService;
	}

	public String getGovernmentName() {
		return governmentName;
	}

	public void setGovernmentName(String governmentName) {
		this.governmentName = governmentName;
	}

	public GovernmentInfo getGovernmentInfo() {
		return governmentInfo;
	}

	public void setGovernmentInfo(GovernmentInfo governmentInfo) {
		this.governmentInfo = governmentInfo;
	}

	@Override
	public String toString() {
		return "Government [governmentId=" + governmentId + ", governmentService=" + governmentService
				+ ", governmentName=" + governmentName + ", governmentInfo=" + governmentInfo + "]";
	}

	
}
