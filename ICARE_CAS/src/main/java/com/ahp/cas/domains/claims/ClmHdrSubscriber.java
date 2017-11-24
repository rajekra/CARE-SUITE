package com.ahp.cas.domains.claims;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ClmHdrSubscriber.
 */
public class ClmHdrSubscriber implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The clm hdr subscriber sid. */
	private long clmHdrSubscriberSid;

	/** The birth date. */
	@JsonProperty("SubscriberBirthDate")
	private Date birthDate;

	/** The death date. */
	@JsonProperty("SubscriberDeathDate")
	private Date deathDate;

	/** The first name. */
	@JsonProperty("SubscriberFirstName")
	private String firstName;

	/** The gender. */
	@JsonProperty("SubscriberGender")
	private String gender;

	/** The idntfr type cid. */
	@JsonProperty("SubscriberPrimaryIDQualifier")
	private BigDecimal idntfrTypeCid;

	/** The last name. */
	@JsonProperty("SubscriberLastName")
	private String lastName;

	/** The mbr identifier. */
	@JsonProperty("SubscriberPrimaryID")
	private String mbrIdentifier;

	/** The middle name. */
	@JsonProperty("SubscriberMiddleName")
	private String middleName;

	/** The relationship lkpcd. */
	@JsonProperty("SubscriberRelationshipCode")
	private String relationshipLkpcd;

	/** The subscriber group nmbr. */
	@JsonProperty("SubscriberGroupOrPolicyNo")
	private String subscriberGroupNmbr;

	/** The suffix lkpcd. */
	@JsonProperty("SubscriberSuffix")
	private String suffixLkpcd;
	
	private BigDecimal mbrSid;

	/** The claim header. */
	@JsonBackReference
	private ClaimHeader claimHeader;

	/**
	 * Instantiates a new clm hdr subscriber.
	 */
	public ClmHdrSubscriber() {
	}

	/**
	 * Gets the clm hdr subscriber sid.
	 *
	 * @return the clm hdr subscriber sid
	 */
	public long getClmHdrSubscriberSid() {
		return clmHdrSubscriberSid;
	}

	/**
	 * Sets the clm hdr subscriber sid.
	 *
	 * @param clmHdrSubscriberSid the new clm hdr subscriber sid
	 */
	public void setClmHdrSubscriberSid(long clmHdrSubscriberSid) {
		this.clmHdrSubscriberSid = clmHdrSubscriberSid;
	}

	/**
	 * Gets the birth date.
	 *
	 * @return the birth date
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the birth date.
	 *
	 * @param birthDate the new birth date
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Gets the death date.
	 *
	 * @return the death date
	 */
	public Date getDeathDate() {
		return deathDate;
	}

	/**
	 * Sets the death date.
	 *
	 * @param deathDate the new death date
	 */
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the idntfr type cid.
	 *
	 * @return the idntfr type cid
	 */
	public BigDecimal getIdntfrTypeCid() {
		return idntfrTypeCid;
	}

	/**
	 * Sets the idntfr type cid.
	 *
	 * @param idntfrTypeCid the new idntfr type cid
	 */
	public void setIdntfrTypeCid(BigDecimal idntfrTypeCid) {
		this.idntfrTypeCid = idntfrTypeCid;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the mbr identifier.
	 *
	 * @return the mbr identifier
	 */
	public String getMbrIdentifier() {
		return mbrIdentifier;
	}

	/**
	 * Sets the mbr identifier.
	 *
	 * @param mbrIdentifier the new mbr identifier
	 */
	public void setMbrIdentifier(String mbrIdentifier) {
		this.mbrIdentifier = mbrIdentifier;
	}

	/**
	 * Gets the middle name.
	 *
	 * @return the middle name
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Sets the middle name.
	 *
	 * @param middleName the new middle name
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Gets the relationship lkpcd.
	 *
	 * @return the relationship lkpcd
	 */
	public String getRelationshipLkpcd() {
		return relationshipLkpcd;
	}

	/**
	 * Sets the relationship lkpcd.
	 *
	 * @param relationshipLkpcd the new relationship lkpcd
	 */
	public void setRelationshipLkpcd(String relationshipLkpcd) {
		this.relationshipLkpcd = relationshipLkpcd;
	}

	/**
	 * Gets the subscriber group nmbr.
	 *
	 * @return the subscriber group nmbr
	 */
	public String getSubscriberGroupNmbr() {
		return subscriberGroupNmbr;
	}

	/**
	 * Sets the subscriber group nmbr.
	 *
	 * @param subscriberGroupNmbr the new subscriber group nmbr
	 */
	public void setSubscriberGroupNmbr(String subscriberGroupNmbr) {
		this.subscriberGroupNmbr = subscriberGroupNmbr;
	}

	/**
	 * Gets the suffix lkpcd.
	 *
	 * @return the suffix lkpcd
	 */
	public String getSuffixLkpcd() {
		return suffixLkpcd;
	}

	/**
	 * Sets the suffix lkpcd.
	 *
	 * @param suffixLkpcd the new suffix lkpcd
	 */
	public void setSuffixLkpcd(String suffixLkpcd) {
		this.suffixLkpcd = suffixLkpcd;
	}

	public BigDecimal getMbrSid() {
		return mbrSid;
	}

	public void setMbrSid(BigDecimal mbrSid) {
		this.mbrSid = mbrSid;
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