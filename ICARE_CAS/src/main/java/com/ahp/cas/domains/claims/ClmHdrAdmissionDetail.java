package com.ahp.cas.domains.claims;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;



public class ClmHdrAdmissionDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long clmHdrAdmissionDetailSid;
	
	@JsonProperty("PatientAdmissionSourceCode")
	private String admissionSourceLkpcd;

	@JsonProperty("PatientAdmissionTypeCode")
	private String admissionTypeLkpcd;
	
	@JsonProperty("PatientStatusCode")
	private String patientStatusLkpcd;
	
	@JsonBackReference
	private ClaimHeader claimHeader;

	public ClmHdrAdmissionDetail() {
	}


	public String getAdmissionSourceLkpcd() {
		return admissionSourceLkpcd;
	}

	public void setAdmissionSourceLkpcd(String admissionSourceLkpcd) {
		this.admissionSourceLkpcd = admissionSourceLkpcd;
	}

	public String getAdmissionTypeLkpcd() {
		return admissionTypeLkpcd;
	}

	public void setAdmissionTypeLkpcd(String admissionTypeLkpcd) {
		this.admissionTypeLkpcd = admissionTypeLkpcd;
	}


	public String getPatientStatusLkpcd() {
		return patientStatusLkpcd;
	}

	public void setPatientStatusLkpcd(String patientStatusLkpcd) {
		this.patientStatusLkpcd = patientStatusLkpcd;
	}

	public ClaimHeader getClaimHeader() {
		return claimHeader;
	}

	public void setClaimHeader(ClaimHeader claimHeader) {
		this.claimHeader = claimHeader;
	}


	public long getClmHdrAdmissionDetailSid() {
		return clmHdrAdmissionDetailSid;
	}


	public void setClmHdrAdmissionDetailSid(long clmHdrAdmissionDetailSid) {
		this.clmHdrAdmissionDetailSid = clmHdrAdmissionDetailSid;
	}

}