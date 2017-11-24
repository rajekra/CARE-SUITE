package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnDrugIdentification.
 */
public class ClmLnDrugIdentification implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clm ln drug identification sid. */
	private long clmLnDrugIdentificationSid;

	/** The drug code. */
	@JsonProperty("NationalDrugCode")
	private String drugCode;

	/** The drug product identifier. */
	@JsonProperty("DrugProductQualifier")
	private String drugProductIdentifier;

	/** The prescription date. */
	@JsonProperty("PrescriptionDate")
	private Date prescriptionDate;

	/** The prescription number. */
	@JsonProperty("PrescriptionNumber")
	private String prescriptionNumber;

	/** The prescription number qlfr. */
	@JsonProperty("PrescriptionNumberQualifier")
	private String prescriptionNumberQlfr;

	/** The quantity amount. */
	@JsonProperty("NationalDrugUnitCount")
	private String quantityAmount;

	/** The uom code. */
	@JsonProperty("DrugUnitOfMeasurementQualifier")
	private String uomCode;

	/** The claim line. */
	@JsonBackReference
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln drug identification.
	 */
	public ClmLnDrugIdentification() {
	}

	/**
	 * Gets the drug code.
	 *
	 * @return the drug code
	 */
	public String getDrugCode() {
		return drugCode;
	}

	/**
	 * Sets the drug code.
	 *
	 * @param drugCode the new drug code
	 */
	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}

	/**
	 * Gets the drug product identifier.
	 *
	 * @return the drug product identifier
	 */
	public String getDrugProductIdentifier() {
		return drugProductIdentifier;
	}

	/**
	 * Sets the drug product identifier.
	 *
	 * @param drugProductIdentifier the new drug product identifier
	 */
	public void setDrugProductIdentifier(String drugProductIdentifier) {
		this.drugProductIdentifier = drugProductIdentifier;
	}

	/**
	 * Gets the prescription date.
	 *
	 * @return the prescription date
	 */
	public Date getPrescriptionDate() {
		return prescriptionDate;
	}

	/**
	 * Sets the prescription date.
	 *
	 * @param prescriptionDate the new prescription date
	 */
	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	/**
	 * Gets the prescription number.
	 *
	 * @return the prescription number
	 */
	public String getPrescriptionNumber() {
		return prescriptionNumber;
	}

	/**
	 * Sets the prescription number.
	 *
	 * @param prescriptionNumber the new prescription number
	 */
	public void setPrescriptionNumber(String prescriptionNumber) {
		this.prescriptionNumber = prescriptionNumber;
	}

	/**
	 * Gets the prescription number qlfr.
	 *
	 * @return the prescription number qlfr
	 */
	public String getPrescriptionNumberQlfr() {
		return prescriptionNumberQlfr;
	}

	/**
	 * Sets the prescription number qlfr.
	 *
	 * @param prescriptionNumberQlfr the new prescription number qlfr
	 */
	public void setPrescriptionNumberQlfr(String prescriptionNumberQlfr) {
		this.prescriptionNumberQlfr = prescriptionNumberQlfr;
	}

	/**
	 * Gets the quantity amount.
	 *
	 * @return the quantity amount
	 */
	public String getQuantityAmount() {
		return quantityAmount;
	}

	/**
	 * Sets the quantity amount.
	 *
	 * @param quantityAmount the new quantity amount
	 */
	public void setQuantityAmount(String quantityAmount) {
		this.quantityAmount = quantityAmount;
	}

	/**
	 * Gets the uom code.
	 *
	 * @return the uom code
	 */
	public String getUomCode() {
		return uomCode;
	}

	/**
	 * Sets the uom code.
	 *
	 * @param uomCode the new uom code
	 */
	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
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
	 * Gets the clm ln drug identification sid.
	 *
	 * @return the clm ln drug identification sid
	 */
	public long getClmLnDrugIdentificationSid() {
		return clmLnDrugIdentificationSid;
	}

	/**
	 * Sets the clm ln drug identification sid.
	 *
	 * @param clmLnDrugIdentificationSid the new clm ln drug identification sid
	 */
	public void setClmLnDrugIdentificationSid(long clmLnDrugIdentificationSid) {
		this.clmLnDrugIdentificationSid = clmLnDrugIdentificationSid;
	}

}