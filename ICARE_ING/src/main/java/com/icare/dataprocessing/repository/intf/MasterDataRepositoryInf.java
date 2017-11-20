package com.icare.dataprocessing.repository.intf;

import com.icare.dataprocessing.dto.CH;

public interface MasterDataRepositoryInf {
	public String convertIcd9To10(String icd9Code);
	public String getMdcId(String drgCode);
	public void saveCD(CH cd);
	public String getAdmissionData(String mbrIdentifier);
}
