package com.icare.ing.util.spark;

import java.io.Serializable;

import com.ecams.claim.bo.ClaimHeader;
import com.icare.common.dto.CH;
import com.icare.ing.repository.impl.MasterDataRepositoryImpl;
import com.icare.ing.repository.intf.MasterDataRepositoryInf;

public class CHBuilder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CHBuilder() {
	}


	public void buildAndIngest(ClaimHeader row) {
		try {
			ClaimHeaderToCHConverter claimHeaderToCDConverter = new ClaimHeaderToCHConverter();
			MasterDataRepositoryInf repository = new MasterDataRepositoryImpl();
			CH cd = claimHeaderToCDConverter.translateClaimHeaderToCD(row,repository);
			repository.saveCD(cd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}