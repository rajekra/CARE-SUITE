package com.icare.ing.repository.intf;

import com.icare.ing.dto.CH;

public interface MasterDataRepositoryInf {
	public String convertIcd9To10(String icd9Code);
	public String getMdcId(String drgCode);
	public void saveCD(CH cd);
}
