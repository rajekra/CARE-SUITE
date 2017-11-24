package com.ahp.cas.domains.claims;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrAttachment.
 */
public class ClmHdrAttachment implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm hdr attachment sid. */
	private long clmHdrAttachmentSid;
	
	/** The atchmnt cntrl nmbr. */
	private String atchmntCntrlNmbr;
	
	/** The created by. */
	private BigDecimal createdBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The data source lkpcd. */
	private String dataSourceLkpcd;
	
	/** The file image. */
	private byte[] fileImage;
	
	/** The file mime type. */
	private String fileMimeType;
	
	/** The file name. */
	private String fileName;
	
	/** The file path. */
	private String filePath;
	
	/** The file size. */
	private BigDecimal fileSize;
	
	/** The modified by. */
	private BigDecimal modifiedBy;
	
	/** The modified date. */
	private Date modifiedDate;
	
	/** The report trnsmsn code lkpcd. */
	private String reportTrnsmsnCodeLkpcd;
	
	/** The report type code lkpcd. */
	private String reportTypeCodeLkpcd;
	
	/** The upload date. */
	private Date uploadDate;
	
	/** The uploaded by. */
	private BigDecimal uploadedBy;
	
	/** The claim header. */
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr attachment.
	 */
	public ClmHdrAttachment() {
	}

	/**
	 * Gets the clm hdr attachment sid.
	 *
	 * @return the clm hdr attachment sid
	 */
	public long getClmHdrAttachmentSid() {
		return clmHdrAttachmentSid;
	}

	/**
	 * Sets the clm hdr attachment sid.
	 *
	 * @param clmHdrAttachmentSid the new clm hdr attachment sid
	 */
	public void setClmHdrAttachmentSid(long clmHdrAttachmentSid) {
		this.clmHdrAttachmentSid = clmHdrAttachmentSid;
	}

	/**
	 * Gets the atchmnt cntrl nmbr.
	 *
	 * @return the atchmnt cntrl nmbr
	 */
	public String getAtchmntCntrlNmbr() {
		return atchmntCntrlNmbr;
	}

	/**
	 * Sets the atchmnt cntrl nmbr.
	 *
	 * @param atchmntCntrlNmbr the new atchmnt cntrl nmbr
	 */
	public void setAtchmntCntrlNmbr(String atchmntCntrlNmbr) {
		this.atchmntCntrlNmbr = atchmntCntrlNmbr;
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
	 * Gets the data source lkpcd.
	 *
	 * @return the data source lkpcd
	 */
	public String getDataSourceLkpcd() {
		return dataSourceLkpcd;
	}

	/**
	 * Sets the data source lkpcd.
	 *
	 * @param dataSourceLkpcd the new data source lkpcd
	 */
	public void setDataSourceLkpcd(String dataSourceLkpcd) {
		this.dataSourceLkpcd = dataSourceLkpcd;
	}

	/**
	 * Gets the file image.
	 *
	 * @return the file image
	 */
	public byte[] getFileImage() {
		return fileImage;
	}

	/**
	 * Sets the file image.
	 *
	 * @param fileImage the new file image
	 */
	public void setFileImage(byte[] fileImage) {
		this.fileImage = fileImage;
	}

	/**
	 * Gets the file mime type.
	 *
	 * @return the file mime type
	 */
	public String getFileMimeType() {
		return fileMimeType;
	}

	/**
	 * Sets the file mime type.
	 *
	 * @param fileMimeType the new file mime type
	 */
	public void setFileMimeType(String fileMimeType) {
		this.fileMimeType = fileMimeType;
	}

	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name.
	 *
	 * @param fileName the new file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Gets the file path.
	 *
	 * @return the file path
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * Sets the file path.
	 *
	 * @param filePath the new file path
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Gets the file size.
	 *
	 * @return the file size
	 */
	public BigDecimal getFileSize() {
		return fileSize;
	}

	/**
	 * Sets the file size.
	 *
	 * @param fileSize the new file size
	 */
	public void setFileSize(BigDecimal fileSize) {
		this.fileSize = fileSize;
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
	 * Gets the report trnsmsn code lkpcd.
	 *
	 * @return the report trnsmsn code lkpcd
	 */
	public String getReportTrnsmsnCodeLkpcd() {
		return reportTrnsmsnCodeLkpcd;
	}

	/**
	 * Sets the report trnsmsn code lkpcd.
	 *
	 * @param reportTrnsmsnCodeLkpcd the new report trnsmsn code lkpcd
	 */
	public void setReportTrnsmsnCodeLkpcd(String reportTrnsmsnCodeLkpcd) {
		this.reportTrnsmsnCodeLkpcd = reportTrnsmsnCodeLkpcd;
	}

	/**
	 * Gets the report type code lkpcd.
	 *
	 * @return the report type code lkpcd
	 */
	public String getReportTypeCodeLkpcd() {
		return reportTypeCodeLkpcd;
	}

	/**
	 * Sets the report type code lkpcd.
	 *
	 * @param reportTypeCodeLkpcd the new report type code lkpcd
	 */
	public void setReportTypeCodeLkpcd(String reportTypeCodeLkpcd) {
		this.reportTypeCodeLkpcd = reportTypeCodeLkpcd;
	}

	/**
	 * Gets the upload date.
	 *
	 * @return the upload date
	 */
	public Date getUploadDate() {
		return uploadDate;
	}

	/**
	 * Sets the upload date.
	 *
	 * @param uploadDate the new upload date
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	/**
	 * Gets the uploaded by.
	 *
	 * @return the uploaded by
	 */
	public BigDecimal getUploadedBy() {
		return uploadedBy;
	}

	/**
	 * Sets the uploaded by.
	 *
	 * @param uploadedBy the new uploaded by
	 */
	public void setUploadedBy(BigDecimal uploadedBy) {
		this.uploadedBy = uploadedBy;
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