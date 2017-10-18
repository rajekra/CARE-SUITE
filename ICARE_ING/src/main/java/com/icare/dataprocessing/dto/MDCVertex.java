package com.icare.dataprocessing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MDCVertex {

	private String MDC_ID;
	
	private String MDC_DESCRIPTION;
	
	private int MDC_START;
	
	private int MDC_END;

	public String getMDC_ID() {
		return MDC_ID;
	}

	public void setMDC_ID(String mDC_ID) {
		MDC_ID = mDC_ID;
	}

	public String getMDC_DESCRIPTION() {
		return MDC_DESCRIPTION;
	}

	public void setMDC_DESCRIPTION(String mDC_DESCRIPTION) {
		MDC_DESCRIPTION = mDC_DESCRIPTION;
	}

	public int getMDC_START() {
		return MDC_START;
	}

	public void setMDC_START(int mDC_START) {
		MDC_START = mDC_START;
	}

	public int getMDC_END() {
		return MDC_END;
	}

	public void setMDC_END(int mDC_END) {
		MDC_END = mDC_END;
	}
	
}
