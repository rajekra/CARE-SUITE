package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmLnDentalDetail.
 */
public class ClmLnDentalDetail implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm ln dental detail sid. */
	private long clmLnDentalDetailSid;
	
	/** The created by. */
	private BigDecimal createdBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The modified by. */
	private BigDecimal modifiedBy;
	
	/** The modified date. */
	private Date modifiedDate;
	
	/** The surface 1 cid. */
	private BigDecimal surface1Cid;
	
	/** The surface 2 cid. */
	private BigDecimal surface2Cid;
	
	/** The surface 3 cid. */
	private BigDecimal surface3Cid;
	
	/** The surface 4 cid. */
	private BigDecimal surface4Cid;
	
	/** The surface 5 cid. */
	private BigDecimal surface5Cid;
	
	/** The tooth cid. */
	private BigDecimal toothCid;
	
	/** The claim line. */
	private ClaimLine claimLine;

	/**
	 * Instantiates a new clm ln dental detail.
	 */
	public ClmLnDentalDetail() {
	}

	/**
	 * Gets the clm ln dental detail sid.
	 *
	 * @return the clm ln dental detail sid
	 */
	public long getClmLnDentalDetailSid() {
		return clmLnDentalDetailSid;
	}

	/**
	 * Sets the clm ln dental detail sid.
	 *
	 * @param clmLnDentalDetailSid the new clm ln dental detail sid
	 */
	public void setClmLnDentalDetailSid(long clmLnDentalDetailSid) {
		this.clmLnDentalDetailSid = clmLnDentalDetailSid;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the modified by.
	 *
	 * @return the modified by
	 */
	public BigDecimal getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Sets the modified by.
	 *
	 * @param modifiedBy the new modified by
	 */
	public void setModifiedBy(BigDecimal modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * Gets the modified date.
	 *
	 * @return the modified date
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * Sets the modified date.
	 *
	 * @param modifiedDate the new modified date
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * Gets the surface 1 cid.
	 *
	 * @return the surface 1 cid
	 */
	public BigDecimal getSurface1Cid() {
		return surface1Cid;
	}

	/**
	 * Sets the surface 1 cid.
	 *
	 * @param surface1Cid the new surface 1 cid
	 */
	public void setSurface1Cid(BigDecimal surface1Cid) {
		this.surface1Cid = surface1Cid;
	}

	/**
	 * Gets the surface 2 cid.
	 *
	 * @return the surface 2 cid
	 */
	public BigDecimal getSurface2Cid() {
		return surface2Cid;
	}

	/**
	 * Sets the surface 2 cid.
	 *
	 * @param surface2Cid the new surface 2 cid
	 */
	public void setSurface2Cid(BigDecimal surface2Cid) {
		this.surface2Cid = surface2Cid;
	}

	/**
	 * Gets the surface 3 cid.
	 *
	 * @return the surface 3 cid
	 */
	public BigDecimal getSurface3Cid() {
		return surface3Cid;
	}

	/**
	 * Sets the surface 3 cid.
	 *
	 * @param surface3Cid the new surface 3 cid
	 */
	public void setSurface3Cid(BigDecimal surface3Cid) {
		this.surface3Cid = surface3Cid;
	}

	/**
	 * Gets the surface 4 cid.
	 *
	 * @return the surface 4 cid
	 */
	public BigDecimal getSurface4Cid() {
		return surface4Cid;
	}

	/**
	 * Sets the surface 4 cid.
	 *
	 * @param surface4Cid the new surface 4 cid
	 */
	public void setSurface4Cid(BigDecimal surface4Cid) {
		this.surface4Cid = surface4Cid;
	}

	/**
	 * Gets the surface 5 cid.
	 *
	 * @return the surface 5 cid
	 */
	public BigDecimal getSurface5Cid() {
		return surface5Cid;
	}

	/**
	 * Sets the surface 5 cid.
	 *
	 * @param surface5Cid the new surface 5 cid
	 */
	public void setSurface5Cid(BigDecimal surface5Cid) {
		this.surface5Cid = surface5Cid;
	}

	/**
	 * Gets the tooth cid.
	 *
	 * @return the tooth cid
	 */
	public BigDecimal getToothCid() {
		return toothCid;
	}

	/**
	 * Sets the tooth cid.
	 *
	 * @param toothCid the new tooth cid
	 */
	public void setToothCid(BigDecimal toothCid) {
		this.toothCid = toothCid;
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

}