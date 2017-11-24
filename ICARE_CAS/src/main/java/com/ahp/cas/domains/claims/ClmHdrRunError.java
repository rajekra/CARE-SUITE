package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrRunError.
 */
public class ClmHdrRunError implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm hdr run error sid. */
	private long clmHdrRunErrorSid;
	
	/** The clm adjustment reason sid. */
	private BigDecimal clmAdjustmentReasonSid;
	
	/** The clm error sid. */
	private BigDecimal clmErrorSid;
	
	/** The clm remittance advice rmrk sid. */
	private BigDecimal clmRemittanceAdviceRmrkSid;
	
	/** The created by. */
	private BigDecimal createdBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The current recycle nmbr. */
	private BigDecimal currentRecycleNmbr;
	
	/** The disposition lkpcd. */
	private String dispositionLkpcd;
	
	/** The erroneous data type qlfr. */
	private String erroneousDataTypeQlfr;
	
	/** The erroneous data value. */
	private String erroneousDataValue;
	
	/** The error action lkpcd. */
	private String errorActionLkpcd;
	
	/** The error count. */
	private BigDecimal errorCount;
	
	/** The error qlfr. */
	private String errorQlfr;
	
	/** The error recycle count. */
	private BigDecimal errorRecycleCount;
	
	/** The error rsltn date. */
	private Date errorRsltnDate;
	
	/** The modified by. */
	private BigDecimal modifiedBy;
	
	/** The modified date. */
	private Date modifiedDate;
	
	/** The order sqnc nmbr. */
	private BigDecimal orderSqncNmbr;
	
	/** The rsltn comment. */
	private String rsltnComment;
	
	/** The rsltn user acct sid. */
	private BigDecimal rsltnUserAcctSid;
	
	/** The run nmbr. */
	private BigDecimal runNmbr;

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr run error.
	 */
	public ClmHdrRunError() {
	}

	/**
	 * Gets the clm hdr run error sid.
	 *
	 * @return the clm hdr run error sid
	 */
	public long getClmHdrRunErrorSid() {
		return clmHdrRunErrorSid;
	}

	/**
	 * Sets the clm hdr run error sid.
	 *
	 * @param clmHdrRunErrorSid the new clm hdr run error sid
	 */
	public void setClmHdrRunErrorSid(long clmHdrRunErrorSid) {
		this.clmHdrRunErrorSid = clmHdrRunErrorSid;
	}

	/**
	 * Gets the clm adjustment reason sid.
	 *
	 * @return the clm adjustment reason sid
	 */
	public BigDecimal getClmAdjustmentReasonSid() {
		return clmAdjustmentReasonSid;
	}

	/**
	 * Sets the clm adjustment reason sid.
	 *
	 * @param clmAdjustmentReasonSid the new clm adjustment reason sid
	 */
	public void setClmAdjustmentReasonSid(BigDecimal clmAdjustmentReasonSid) {
		this.clmAdjustmentReasonSid = clmAdjustmentReasonSid;
	}

	/**
	 * Gets the clm error sid.
	 *
	 * @return the clm error sid
	 */
	public BigDecimal getClmErrorSid() {
		return clmErrorSid;
	}

	/**
	 * Sets the clm error sid.
	 *
	 * @param clmErrorSid the new clm error sid
	 */
	public void setClmErrorSid(BigDecimal clmErrorSid) {
		this.clmErrorSid = clmErrorSid;
	}

	/**
	 * Gets the clm remittance advice rmrk sid.
	 *
	 * @return the clm remittance advice rmrk sid
	 */
	public BigDecimal getClmRemittanceAdviceRmrkSid() {
		return clmRemittanceAdviceRmrkSid;
	}

	/**
	 * Sets the clm remittance advice rmrk sid.
	 *
	 * @param clmRemittanceAdviceRmrkSid the new clm remittance advice rmrk sid
	 */
	public void setClmRemittanceAdviceRmrkSid(
			BigDecimal clmRemittanceAdviceRmrkSid) {
		this.clmRemittanceAdviceRmrkSid = clmRemittanceAdviceRmrkSid;
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
	 * Gets the current recycle nmbr.
	 *
	 * @return the current recycle nmbr
	 */
	public BigDecimal getCurrentRecycleNmbr() {
		return currentRecycleNmbr;
	}

	/**
	 * Sets the current recycle nmbr.
	 *
	 * @param currentRecycleNmbr the new current recycle nmbr
	 */
	public void setCurrentRecycleNmbr(BigDecimal currentRecycleNmbr) {
		this.currentRecycleNmbr = currentRecycleNmbr;
	}

	/**
	 * Gets the disposition lkpcd.
	 *
	 * @return the disposition lkpcd
	 */
	public String getDispositionLkpcd() {
		return dispositionLkpcd;
	}

	/**
	 * Sets the disposition lkpcd.
	 *
	 * @param dispositionLkpcd the new disposition lkpcd
	 */
	public void setDispositionLkpcd(String dispositionLkpcd) {
		this.dispositionLkpcd = dispositionLkpcd;
	}

	/**
	 * Gets the erroneous data type qlfr.
	 *
	 * @return the erroneous data type qlfr
	 */
	public String getErroneousDataTypeQlfr() {
		return erroneousDataTypeQlfr;
	}

	/**
	 * Sets the erroneous data type qlfr.
	 *
	 * @param erroneousDataTypeQlfr the new erroneous data type qlfr
	 */
	public void setErroneousDataTypeQlfr(String erroneousDataTypeQlfr) {
		this.erroneousDataTypeQlfr = erroneousDataTypeQlfr;
	}

	/**
	 * Gets the erroneous data value.
	 *
	 * @return the erroneous data value
	 */
	public String getErroneousDataValue() {
		return erroneousDataValue;
	}

	/**
	 * Sets the erroneous data value.
	 *
	 * @param erroneousDataValue the new erroneous data value
	 */
	public void setErroneousDataValue(String erroneousDataValue) {
		this.erroneousDataValue = erroneousDataValue;
	}

	/**
	 * Gets the error action lkpcd.
	 *
	 * @return the error action lkpcd
	 */
	public String getErrorActionLkpcd() {
		return errorActionLkpcd;
	}

	/**
	 * Sets the error action lkpcd.
	 *
	 * @param errorActionLkpcd the new error action lkpcd
	 */
	public void setErrorActionLkpcd(String errorActionLkpcd) {
		this.errorActionLkpcd = errorActionLkpcd;
	}

	/**
	 * Gets the error count.
	 *
	 * @return the error count
	 */
	public BigDecimal getErrorCount() {
		return errorCount;
	}

	/**
	 * Sets the error count.
	 *
	 * @param errorCount the new error count
	 */
	public void setErrorCount(BigDecimal errorCount) {
		this.errorCount = errorCount;
	}

	/**
	 * Gets the error qlfr.
	 *
	 * @return the error qlfr
	 */
	public String getErrorQlfr() {
		return errorQlfr;
	}

	/**
	 * Sets the error qlfr.
	 *
	 * @param errorQlfr the new error qlfr
	 */
	public void setErrorQlfr(String errorQlfr) {
		this.errorQlfr = errorQlfr;
	}

	/**
	 * Gets the error recycle count.
	 *
	 * @return the error recycle count
	 */
	public BigDecimal getErrorRecycleCount() {
		return errorRecycleCount;
	}

	/**
	 * Sets the error recycle count.
	 *
	 * @param errorRecycleCount the new error recycle count
	 */
	public void setErrorRecycleCount(BigDecimal errorRecycleCount) {
		this.errorRecycleCount = errorRecycleCount;
	}

	/**
	 * Gets the error rsltn date.
	 *
	 * @return the error rsltn date
	 */
	public Date getErrorRsltnDate() {
		return errorRsltnDate;
	}

	/**
	 * Sets the error rsltn date.
	 *
	 * @param errorRsltnDate the new error rsltn date
	 */
	public void setErrorRsltnDate(Date errorRsltnDate) {
		this.errorRsltnDate = errorRsltnDate;
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
	 * Gets the order sqnc nmbr.
	 *
	 * @return the order sqnc nmbr
	 */
	public BigDecimal getOrderSqncNmbr() {
		return orderSqncNmbr;
	}

	/**
	 * Sets the order sqnc nmbr.
	 *
	 * @param orderSqncNmbr the new order sqnc nmbr
	 */
	public void setOrderSqncNmbr(BigDecimal orderSqncNmbr) {
		this.orderSqncNmbr = orderSqncNmbr;
	}

	/**
	 * Gets the rsltn comment.
	 *
	 * @return the rsltn comment
	 */
	public String getRsltnComment() {
		return rsltnComment;
	}

	/**
	 * Sets the rsltn comment.
	 *
	 * @param rsltnComment the new rsltn comment
	 */
	public void setRsltnComment(String rsltnComment) {
		this.rsltnComment = rsltnComment;
	}

	/**
	 * Gets the rsltn user acct sid.
	 *
	 * @return the rsltn user acct sid
	 */
	public BigDecimal getRsltnUserAcctSid() {
		return rsltnUserAcctSid;
	}

	/**
	 * Sets the rsltn user acct sid.
	 *
	 * @param rsltnUserAcctSid the new rsltn user acct sid
	 */
	public void setRsltnUserAcctSid(BigDecimal rsltnUserAcctSid) {
		this.rsltnUserAcctSid = rsltnUserAcctSid;
	}

	/**
	 * Gets the run nmbr.
	 *
	 * @return the run nmbr
	 */
	public BigDecimal getRunNmbr() {
		return runNmbr;
	}

	/**
	 * Sets the run nmbr.
	 *
	 * @param runNmbr the new run nmbr
	 */
	public void setRunNmbr(BigDecimal runNmbr) {
		this.runNmbr = runNmbr;
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

}