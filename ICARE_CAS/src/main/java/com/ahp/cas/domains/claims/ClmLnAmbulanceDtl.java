package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnAmbulanceDtl.
 */
public class ClmLnAmbulanceDtl implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clm ln amblnc dtl sid. */
	private long clmLnAmblncDtlSid;

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

	/** The claim line. */
	@JsonBackReference
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln ambulance dtl.
	 */
	public ClmLnAmbulanceDtl() {
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
	 * Gets the clm ln amblnc dtl sid.
	 *
	 * @return the clm ln amblnc dtl sid
	 */
	public long getClmLnAmblncDtlSid() {
		return clmLnAmblncDtlSid;
	}

	/**
	 * Sets the clm ln amblnc dtl sid.
	 *
	 * @param clmLnAmblncDtlSid the new clm ln amblnc dtl sid
	 */
	public void setClmLnAmblncDtlSid(long clmLnAmblncDtlSid) {
		this.clmLnAmblncDtlSid = clmLnAmblncDtlSid;
	}

}