package com.ahp.cas.domains.claims;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
// TODO: Auto-generated Javadoc

/**
 * The Class ClmHdrAmbulanceDtl.
 */
public class ClmHdrAmbulanceDtl implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm hdr amblnc dtl sid. */
	private long clmHdrAmblncDtlSid;
	
	/** The amblnc trnsprtn rsn lkpcd. */
	@JsonProperty("PatientTransportReasonCode")
	private String amblncTrnsprtnRsnLkpcd;
	
	/** The patient weight. */
	@JsonProperty("PatientWeight")
	private BigDecimal patientWeight;
	
	/** The patient weight uom code. */
	@JsonProperty("PatientWeightMeasurementCode")
	private String patientWeightUomCode;
	
	/** The round trip prps desc. */
	@JsonProperty("RoundTripPurposeDesc")
	private String roundTripPrpsDesc;
	
	/** The strtchr prps desc. */
	@JsonProperty("StretcherPurposeDesc")
	private String strtchrPrpsDesc;
	
	/** The trnsprtn distance. */
	@JsonProperty("TransportDistance")
	private BigDecimal trnsprtnDistance;
	
	/** The trnsprtn distance uom code. */
	@JsonProperty("TransportDistanceMeasurementCode")
	private String trnsprtnDistanceUomCode;
	
	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr ambulance dtl.
	 */
	public ClmHdrAmbulanceDtl() {
	}


	/**
	 * Gets the amblnc trnsprtn rsn lkpcd.
	 *
	 * @return the amblnc trnsprtn rsn lkpcd
	 */
	public String getAmblncTrnsprtnRsnLkpcd() {
		return amblncTrnsprtnRsnLkpcd;
	}

	/**
	 * Sets the amblnc trnsprtn rsn lkpcd.
	 *
	 * @param amblncTrnsprtnRsnLkpcd the new amblnc trnsprtn rsn lkpcd
	 */
	public void setAmblncTrnsprtnRsnLkpcd(String amblncTrnsprtnRsnLkpcd) {
		this.amblncTrnsprtnRsnLkpcd = amblncTrnsprtnRsnLkpcd;
	}


	/**
	 * Gets the patient weight.
	 *
	 * @return the patient weight
	 */
	public BigDecimal getPatientWeight() {
		return patientWeight;
	}

	/**
	 * Sets the patient weight.
	 *
	 * @param patientWeight the new patient weight
	 */
	public void setPatientWeight(BigDecimal patientWeight) {
		this.patientWeight = patientWeight;
	}

	/**
	 * Gets the patient weight uom code.
	 *
	 * @return the patient weight uom code
	 */
	public String getPatientWeightUomCode() {
		return patientWeightUomCode;
	}

	/**
	 * Sets the patient weight uom code.
	 *
	 * @param patientWeightUomCode the new patient weight uom code
	 */
	public void setPatientWeightUomCode(String patientWeightUomCode) {
		this.patientWeightUomCode = patientWeightUomCode;
	}

	/**
	 * Gets the round trip prps desc.
	 *
	 * @return the round trip prps desc
	 */
	public String getRoundTripPrpsDesc() {
		return roundTripPrpsDesc;
	}

	/**
	 * Sets the round trip prps desc.
	 *
	 * @param roundTripPrpsDesc the new round trip prps desc
	 */
	public void setRoundTripPrpsDesc(String roundTripPrpsDesc) {
		this.roundTripPrpsDesc = roundTripPrpsDesc;
	}

	/**
	 * Gets the strtchr prps desc.
	 *
	 * @return the strtchr prps desc
	 */
	public String getStrtchrPrpsDesc() {
		return strtchrPrpsDesc;
	}

	/**
	 * Sets the strtchr prps desc.
	 *
	 * @param strtchrPrpsDesc the new strtchr prps desc
	 */
	public void setStrtchrPrpsDesc(String strtchrPrpsDesc) {
		this.strtchrPrpsDesc = strtchrPrpsDesc;
	}

	/**
	 * Gets the trnsprtn distance.
	 *
	 * @return the trnsprtn distance
	 */
	public BigDecimal getTrnsprtnDistance() {
		return trnsprtnDistance;
	}

	/**
	 * Sets the trnsprtn distance.
	 *
	 * @param trnsprtnDistance the new trnsprtn distance
	 */
	public void setTrnsprtnDistance(BigDecimal trnsprtnDistance) {
		this.trnsprtnDistance = trnsprtnDistance;
	}

	/**
	 * Gets the trnsprtn distance uom code.
	 *
	 * @return the trnsprtn distance uom code
	 */
	public String getTrnsprtnDistanceUomCode() {
		return trnsprtnDistanceUomCode;
	}

	/**
	 * Sets the trnsprtn distance uom code.
	 *
	 * @param trnsprtnDistanceUomCode the new trnsprtn distance uom code
	 */
	public void setTrnsprtnDistanceUomCode(String trnsprtnDistanceUomCode) {
		this.trnsprtnDistanceUomCode = trnsprtnDistanceUomCode;
	}

	/**
	 * Gets the claim header.
	 *
	 * @return the claim header
	 */
	public ClaimHeader getClaimHeader() {
		return claimHeader;
	}

	/**
	 * Sets the claim header.
	 *
	 * @param claimHeader the new claim header
	 */
	public void setClaimHeader(ClaimHeader claimHeader) {
		this.claimHeader = claimHeader;
	}


	/**
	 * Gets the clm hdr amblnc dtl sid.
	 *
	 * @return the clm hdr amblnc dtl sid
	 */
	public long getClmHdrAmblncDtlSid() {
		return clmHdrAmblncDtlSid;
	}


	/**
	 * Sets the clm hdr amblnc dtl sid.
	 *
	 * @param clmHdrAmblncDtlSid the new clm hdr amblnc dtl sid
	 */
	public void setClmHdrAmblncDtlSid(long clmHdrAmblncDtlSid) {
		this.clmHdrAmblncDtlSid = clmHdrAmblncDtlSid;
	}


}