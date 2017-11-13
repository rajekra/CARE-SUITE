package com.icare.dataprocessing.service.examples.graph;

import java.math.BigDecimal;

public abstract class Entity {

	private BigDecimal id;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Entity(BigDecimal id) {
		super();
		this.id = id;
	}

}
