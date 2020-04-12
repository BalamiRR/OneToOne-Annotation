package com.fuatkara.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "GovernmentInfo", catalog = "newDatabase")
public class GovernmentInfo {
	
	@GenericGenerator(name = "generator", strategy = "foreign",
			parameters= @Parameter(name = "property", value = "government")
		)
	@Id
	@GeneratedValue(generator ="generator")
	@Column(name = "Government_Id", unique = true ,nullable = false)
	private Integer governmentId;
	
	@Column(name="Government_Address", length = 50)
	private String governmentAddress;
	
	@Column(name="Government_Parties", length = 50)
	private String governmentParties;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Government government;
	
	
	public GovernmentInfo() {
		
	}

	public GovernmentInfo(int governmentId, String governmentAddress, String governmentParties, Government government) {
		this.governmentId = governmentId;
		this.governmentAddress = governmentAddress;
		this.governmentParties = governmentParties;
		this.government = government;
	}

	public int getGovernmentId() {
		return governmentId;
	}

	public void setGovernmentId(int governmentId) {
		this.governmentId = governmentId;
	}

	public String getGovernmentAddress() {
		return governmentAddress;
	}

	public void setGovernmentAddress(String governmentAddress) {
		this.governmentAddress = governmentAddress;
	}

	public String getGovernmentParties() {
		return governmentParties;
	}

	public void setGovernmentParties(String governmentParties) {
		this.governmentParties = governmentParties;
	}

	public Government getGovernment() {
		return government;
	}

	public void setGovernment(Government government) {
		this.government = government;
	}

	@Override
	public String toString() {
		return "GovernmentInfo [governmentId=" + governmentId + ", governmentAddress=" + governmentAddress
				+ ", governmentParties=" + governmentParties + ", government=" + government + "]";
	}
	
}
