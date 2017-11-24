package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnAmbulancePtntCndtn.
 */
public class ClmLnAmbulancePtntCndtn implements Serializable {

	/** The clm ln amblnc ptnt cndtn sid. */
	private long clmLnAmblncPtntCndtnSid;

	/** The patient condition code. */
	@JsonProperty("PatientConditionCode")
	private String patientConditionCode;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The claim line. */
	@JsonBackReference
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln ambulance ptnt cndtn.
	 */
	public ClmLnAmbulancePtntCndtn() {
	}

	/**
	 * Gets the claim line.
	 *
	 * @return the claim line
	 */
	public ClaimLine getClaimLine() {
		return claimLine;
	}

	/**
	 * Sets the claim line.
	 *
	 * @param claimLine the new claim line
	 */
	public void setClaimLine(ClaimLine claimLine) {
		this.claimLine = claimLine;
	}

	/**
	 * Gets the patient condition code.
	 *
	 * @return the patient condition code
	 */
	public String getPatientConditionCode() {
		return patientConditionCode;
	}

	/**
	 * Sets the patient condition code.
	 *
	 * @param patientConditionCode the new patient condition code
	 */
	public void setPatientConditionCode(String patientConditionCode) {
		this.patientConditionCode = patientConditionCode;
	}

	/**
	 * Gets the clm ln amblnc ptnt cndtn sid.
	 *
	 * @return the clm ln amblnc ptnt cndtn sid
	 */
	public long getClmLnAmblncPtntCndtnSid() {
		return clmLnAmblncPtntCndtnSid;
	}

	/**
	 * Sets the clm ln amblnc ptnt cndtn sid.
	 *
	 * @param clmLnAmblncPtntCndtnSid the new clm ln amblnc ptnt cndtn sid
	 */
	public void setClmLnAmblncPtntCndtnSid(long clmLnAmblncPtntCndtnSid) {
		this.clmLnAmblncPtntCndtnSid = clmLnAmblncPtntCndtnSid;
	}

}