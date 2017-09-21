package com.icare.ing.repository.intf;

import com.icare.common.dto.CH;

public interface SparkRepositoryInf {
	public String convertIcd9To10(String icd9Code);
	public String getMdcId(String drgCode);
	public void saveCD(CH cd);
}
