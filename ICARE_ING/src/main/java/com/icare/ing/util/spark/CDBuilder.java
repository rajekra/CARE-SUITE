package com.icare.ing.util.spark;

import java.io.Serializable;

import com.ecams.claim.bo.ClaimHeader;
import com.icare.common.dto.CH;
import com.icare.ing.repository.impl.SparkMongoRepositoryImpl;
import com.icare.ing.repository.intf.SparkRepositoryInf;

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
			SparkRepositoryInf repository = new SparkMongoRepositoryImpl();
			CH cd = claimHeaderToCDConverter.translateClaimHeaderToCD(row,repository);
			repository.saveCD(cd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}