package com.icare.ing.service.descriptive;

public class MDCTestClaim {
	private String src;
	private String dst;
	private int relationship;

	public MDCTestClaim() {

	}

	public MDCTestClaim(String src, String dst, int relationship) {
		super();
		this.src = src;
		this.dst = dst;
		this.relationship = relationship;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getDst() {
		return dst;
	}

	public void setDst(String dst) {
		this.dst = dst;
	}

	public int getRelationship() {
		return relationship;
	}

	public void setRelationship(int relationship) {
		this.relationship = relationship;
	}
}
