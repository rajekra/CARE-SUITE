package com.icare.dataprocessing.util.spark;

import java.io.Serializable;

import com.ecams.claim.bo.ClaimHeader;
import com.icare.dataprocessing.dto.CH;
import com.icare.dataprocessing.repository.impl.MasterDataRepositoryImpl;
import com.icare.dataprocessing.repository.intf.MasterDataRepositoryInf;

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