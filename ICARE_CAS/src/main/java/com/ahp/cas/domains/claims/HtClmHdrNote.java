package com.ahp.cas.domains.claims;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the HT_CLM_HDR_NOTE database table.
 * 
 */
public class HtClmHdrNote implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The clm hdr note sid. */
	private long clmHdrNoteSid;

	/** The note type code. */
	// Start: No DB fields from CEM which we use to derive LKPCDs and IIDs
	@JsonProperty("NoteTypeCode")
	private String noteTypeCode;

	/**
	 * Gets the note type code.
	 *
	 * @return the note type code
	 */
	public String getNoteTypeCode() {
		return noteTypeCode;
	}

	/**
	 * Sets the note type code.
	 *
	 * @param noteTypeCode the new note type code
	 */
	public void setNoteTypeCode(String noteTypeCode) {
		this.noteTypeCode = noteTypeCode;
	}

	/** The clm comment. */
	@Column(name = "CLM_COMMENT")
	@JsonProperty("Note")
	private String clmComment;

	/** The clm note type lkpcd. */
	@JsonProperty("NoteTypeLkpCode")
	@Column(name = "CLM_NOTE_TYPE_LKPCD")
	private String clmNoteTypeLkpcd;

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;

	// public BigDecimal getClaimHeaderSid() {
	// return this.claimHeaderSid;
	// }
	//
	// public void setClaimHeaderSid(BigDecimal claimHeaderSid) {
	// this.claimHeaderSid = claimHeaderSid;
	// }

	/**
	 * Gets the clm comment.
	 *
	 * @return the clm comment
	 */
	public String getClmComment() {
		return this.clmComment;
	}

	/**
	 * Sets the clm comment.
	 *
	 * @param clmComment the new clm comment
	 */
	public void setClmComment(String clmComment) {
		this.clmComment = clmComment;
	}

	/**
	 * Gets the clm note type lkpcd.
	 *
	 * @return the clm note type lkpcd
	 */
	public String getClmNoteTypeLkpcd() {
		return this.clmNoteTypeLkpcd;
	}

	/**
	 * Sets the clm note type lkpcd.
	 *
	 * @param clmNoteTypeLkpcd the new clm note type lkpcd
	 */
	public void setClmNoteTypeLkpcd(String clmNoteTypeLkpcd) {
		this.clmNoteTypeLkpcd = clmNoteTypeLkpcd;
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
	 * Gets the clm hdr note sid.
	 *
	 * @return the clm hdr note sid
	 */
	public long getClmHdrNoteSid() {
		return clmHdrNoteSid;
	}

	/**
	 * Sets the clm hdr note sid.
	 *
	 * @param clmHdrNoteSid the new clm hdr note sid
	 */
	public void setClmHdrNoteSid(long clmHdrNoteSid) {
		this.clmHdrNoteSid = clmHdrNoteSid;
	}

}