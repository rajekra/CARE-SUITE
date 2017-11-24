package com.ahp.cas.business.service;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import com.ahp.cas.data.service.ClaimDataService;
import com.ahp.cas.domains.claims.ClaimHeader;
import com.ahp.cas.domains.claims.ClaimLine;
import com.ahp.cas.domains.claims.adclaim.AdClaimHeader;
import com.ahp.cas.domains.claims.adclaim.AdClaimLine;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClaimBusinessService {
	
	private ClaimDataService claimDataService = new ClaimDataService();
	
	
	public ClaimBusinessService() {
		super();
	}
	public ClaimBusinessService(ClaimHeader claimHeader) {
		super();
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		claimDocument = claimHeader;
	}
	private ObjectMapper mapper = new ObjectMapper();
	/** The claim document. */
	private ClaimHeader claimDocument;
	
	/** The current line. */
	private ClaimLine currentLine;
	
	public ClaimHeader getClaimDocument() {
		return claimDocument;
	}
	public void setClaimDocument(ClaimHeader claimDocument) {
		this.claimDocument = claimDocument;
	}
	public ClaimLine getCurrentLine() {
		return currentLine;
	}
	public void setCurrentLine(ClaimLine currentLine) {
		this.currentLine = currentLine;
	}
	
	public String getProcedureIID(String prcdrCode)
	{
		return claimDataService.getProcedureIID(prcdrCode);
	}
	public void saveClaim()
	{
		System.out.println("saveclaim");
		AdClaimHeader claimHeaderAD = mapper.convertValue(claimDocument, AdClaimHeader.class);
		for(AdClaimLine line:claimHeaderAD.getClaimLines())
		{
			System.out.println("Header:"+line.getClaimHeader());
		}
		try {
			claimDataService.save(claimHeaderAD);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getMemberSID()
	{
		System.out.println("getMemberSID");
		String val = null;
		try{
			if(null==claimDataService)
			{
				System.out.println("claimdatasrevice is Null");
				claimDataService = new ClaimDataService();
			}
			val = claimDataService.getMemberSID(claimDocument.getMbrIdentifier());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		return val;
	}
}
