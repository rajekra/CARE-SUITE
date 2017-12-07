package com.icare.dataprocessing.service.analytics.graph.nodes;

import java.math.BigDecimal;

public class Member extends Entity{
	
private String memberName;


public Member(String id, String memberName) {
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
