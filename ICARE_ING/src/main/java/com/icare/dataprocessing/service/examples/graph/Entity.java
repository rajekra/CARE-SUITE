package com.icare.dataprocessing.service.examples.graph;

import java.math.BigDecimal;

public abstract class Entity {

	private BigDecimal id;
	private String entityType;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Entity(BigDecimal id, String entityType) {
		super();
		this.id = id;
		this.entityType= entityType;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

}
