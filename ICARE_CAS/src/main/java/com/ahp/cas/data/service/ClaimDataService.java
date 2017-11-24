package com.ahp.cas.data.service;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import com.ahp.cas.data.repository.ClaimDataRepository;
import com.ahp.cas.domains.claims.adclaim.AdClaimHeader;

public class ClaimDataService {
	private ClaimDataRepository claimDataRepository = new ClaimDataRepository();
	
	public String getProcedureIID(String prcdrCode)
	{
		return claimDataRepository.getProcedureIID(prcdrCode);
	}
	public void save(AdClaimHeader claimHeaderAD) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException 
	{
		claimDataRepository.save(claimHeaderAD);
	}
	public String getMemberSID(String memberIdentifier)
	{
		System.out.println("ClaimDataService:" + memberIdentifier);
		return claimDataRepository.getMemberSID(memberIdentifier);
	}
}
