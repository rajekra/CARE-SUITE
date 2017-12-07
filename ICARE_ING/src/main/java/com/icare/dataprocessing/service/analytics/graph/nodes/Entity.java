package com.icare.dataprocessing.service.analytics.graph.nodes;

import java.math.BigDecimal;

public abstract class Entity {

	private String id;
	private String entityType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Entity(String id, String entityType) {
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
