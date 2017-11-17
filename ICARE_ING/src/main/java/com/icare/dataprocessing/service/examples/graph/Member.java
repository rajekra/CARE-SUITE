package com.icare.dataprocessing.service.examples.graph;

import java.math.BigDecimal;

public class Member extends Entity{
	
private String memberName;


public Member(BigDecimal id, String memberName) {
	super(id,"Member");
	this.memberName = memberName;
}

public String getMemberName() {
	return memberName;
}

public void setMemberName(String memberName) {
	this.memberName = memberName;
}

}
