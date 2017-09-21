package com.icare.ing.util.spark;

import java.io.Serializable;

import com.ecams.claim.bo.ClaimHeader;
import com.icare.common.dto.CH;
import com.icare.ing.repository.ingestion.impl.MasterDataRepositoryImpl;
import com.icare.ing.repository.ingestion.intf.MasterDataRepositoryInf;

public class CDBuilder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CDBuilder() {
	}


	public void buildAndIngest(ClaimHeader row) {
		try {
			ClaimHeaderToCDConverter claimHeaderToCDConverter = new ClaimHeaderToCDConverter();
			MasterDataRepositoryInf repository = new MasterDataRepositoryImpl();
			CH cd = claimHeaderToCDConverter.translateClaimHeaderToCD(row,repository);
			repository.saveCD(cd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}