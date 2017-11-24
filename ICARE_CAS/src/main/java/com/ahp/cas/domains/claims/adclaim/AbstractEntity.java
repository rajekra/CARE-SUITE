package com.ahp.cas.domains.claims.adclaim;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class AbstractEntity {

	@Column(name = "CREATED_BY")
	@JsonIgnore
	protected BigDecimal createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	@JsonIgnore
	protected Date createdDate;

	@Column(name = "MODIFIED_BY")
	@JsonIgnore
	protected BigDecimal modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIED_DATE")
	@JsonIgnore
	protected Date modifiedDate;

	@PrePersist
	protected void onCreate() {
		createdDate = modifiedDate = new Date();
		createdBy = new BigDecimal(24);
		modifiedBy = new BigDecimal(24);
	}

	@PreUpdate
	protected void onUpdate() {
		modifiedDate = new Date();
		modifiedBy = new BigDecimal(24);
		if(null==createdDate)
		{
			createdDate = modifiedDate = new Date();
		}
		if(null==createdBy)
		{
			createdBy = new BigDecimal(24);
		}
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public BigDecimal getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(BigDecimal modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
