package com.icare.dataprocessing.service.analytics.graph.nodes;

import java.math.BigDecimal;

public class Provider  extends Entity{
private String providerName;


public Provider( String id, String providerName) {
	super(id,"Provider");
	this.providerName = providerName;
}


public String getProviderName() {
	return providerName;
}

public void setProviderName(String providerName) {
	this.providerName = providerName;
}
}
