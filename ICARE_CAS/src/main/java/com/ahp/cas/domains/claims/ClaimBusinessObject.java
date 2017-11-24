package com.ahp.cas.domains.claims;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "ClaimBusinessObject")
public class ClaimBusinessObject {
	
	@JsonProperty("ClaimTarget")
	private String claimTarget;

	@JsonProperty("ClaimInformation")
	private ClaimHeader claimHeader;

	public String getClaimTarget() {
		return claimTarget;
	}

	public void setClaimTarget(String claimTarget) {
		this.claimTarget = claimTarget;
	}

	public ClaimHeader getClaimHeader() {
		return claimHeader;
	}

	public void setClaimHeader(ClaimHeader claimHeader) {
		this.claimHeader = claimHeader;
	}

}
