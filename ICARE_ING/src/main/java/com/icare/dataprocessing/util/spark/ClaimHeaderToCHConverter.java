package com.icare.dataprocessing.util.spark;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.ecams.claim.bo.ClaimLine;
import com.ecams.claim.bo.ClmHdrAdmissionDetail;
import com.ecams.claim.bo.ClmHdrCondition;
import com.ecams.claim.bo.ClmHdrOccurrenceDetail;
import com.ecams.claim.bo.ClmHdrValueAmount;
import com.ecams.claim.bo.ClmHdrXDiagnosis;
import com.ecams.claim.bo.ClmHdrXProcedure;
import com.ecams.claim.bo.ClmHdrXPrvdrLctn;
import com.icare.dataprocessing.dto.CH;
import com.icare.dataprocessing.dto.CL;
import com.icare.dataprocessing.repository.intf.MasterDataRepositoryInf;
import com.icare.dataprocessing.service.ingestion.CSVReaderExample;

public class ClaimHeaderToCHConverter {
	
	String[] members = {"502886879WA","501220072WA","501392415WA","502703310WA","502467082WA","501470246WA","501673983WA","500854602WA","503649270WA","501679321WA","503216258WA","503395375WA","500073535WA","503607867WA","501395626WA","500099926WA","500449152WA","503465089WA","502755624WA","501275246WA","501173310WA","501534782WA","500476322WA","503511056WA","501414567WA","500068942WA","501497422WA","500576583WA","503204006WA","501691122WA","500165272WA","500823858WA","502458081WA","500539104WA","501704594WA","501991191WA","502805531WA","500654422WA","501384732WA","500000573WA","500174244WA","502847226WA","500072452WA","503030823WA","500119901WA","502052602WA","503030577WA","500680456WA","501611775WA"};
	String[] providers = {"1000000004","1000000005","1000000006","1000000007","1000000008","1000000009","1000000010"};
	
	
	/**
	 * 
	 * COPD Specific
	 */
	String[] procCodes = {"E0424","E0425","E0430","E0431","E0433","E0434","E0435","E0439","E0440","E0441","E0442","E0443","E0444","E1390","E1391","E1392","E1405","E1406","K0738","K0741","S8120","S8121"};
	//String[] procCodes = {"00520","70450","70460","70470","70480","70481","70482","70486","70487","70488","70490","70491","70492","70496","70498","71250","71260","71270","71275","72125","72126","72127","72128","72129","72130","72131","72132","72133","72191","72192","72193","72194","73200","73201","73202","73206","73700","73701","73702","73706","74150","74160","74170","74174","74175","74176","74177","74178","74261","74262","74263","75571","75572","75573","75574","75635","76380","76497","77011","77012","77013","77014","77078","78452","81001","81003"};
	String[] linePaidAmount = {"133.45","250.15","190.00","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",};
	String[] fromDates = {"8/26/2014","1/25/2014","3/11/2014","5/26/2014","12/19/2014","4/22/2014","5/16/2014","3/3/2014","1/7/2014","12/1/2014","3/18/2014","7/7/2014","7/9/2014","10/29/2014","12/26/2014","3/28/2014","3/25/2014","12/11/2014","10/24/2014","11/25/2014","2/8/2014","4/17/2014","5/16/2014","2/3/2014","1/12/2014","4/27/2014","12/27/2014","9/26/2014","12/14/2014","10/19/2014","4/12/2014","5/22/2014","8/27/2014","12/31/2013","12/31/2013","8/28/2014","10/30/2014","8/13/2014","2/21/2014","4/24/2014","7/2/2014","7/30/2014","8/15/2014","1/16/2014","2/16/2014","5/23/2014","2/10/2014","2/11/2014","11/7/2014","5/12/2014","1/24/2014","5/31/2014","1/4/2014","10/18/2014","5/23/2014","2/19/2014","4/13/2014","11/6/2014","12/17/2014","10/9/2014","12/20/2014","9/24/2014","1/3/2014","12/6/2014","3/6/2014","2/4/2014","3/1/2014","3/26/2014","6/21/2014","11/19/2014","1/5/2014","8/2/2014","8/29/2014","1/8/2014","5/13/2014","11/25/2014","12/14/2014","12/23/2014","5/25/2014","12/19/2014","10/6/2014","12/28/2014","11/6/2014","6/8/2014","1/3/2014","6/14/2014","5/12/2014","12/13/2014","6/10/2014","6/26/2014","7/1/2014","12/1/2014","6/19/2014","12/28/2014","5/16/2014","6/7/2014","7/6/2014","7/27/2014","8/10/2014","4/14/2014","12/13/2014","6/3/2014","1/24/2014","2/4/2014","3/27/2014","1/6/2014","2/6/2014","9/7/2014","3/6/2014","1/9/2014","1/30/2014","9/22/2014","10/7/2014","5/24/2014","9/19/2014","1/6/2014","4/11/2014","6/28/2014","11/24/2014","8/5/2014","4/30/2014","3/11/2014","8/9/2014","12/10/2014","9/23/2014","3/14/2014","5/1/2014","5/14/2014","7/12/2014","7/29/2014","8/7/2014","8/16/2014","3/13/2014","10/31/2014","9/9/2014","5/31/2014","9/23/2014","12/16/2014","2/4/2014","7/18/2014","7/31/2014","11/4/2014","4/18/2014","7/25/2014","5/19/2014","1/12/2014","3/16/2014","1/13/2014","9/27/2014","3/24/2014","3/27/2014","11/15/2014","3/26/2014","12/17/2014","12/6/2014","10/24/2014","7/10/2014","3/10/2014","3/31/2014","4/3/2014","2/6/2014","12/2/2014","6/24/2014","8/6/2014","5/5/2014","2/8/2014","8/2/2014","8/9/2014","12/23/2014","3/25/2014","1/30/2014","10/31/2014","10/30/2014","1/1/2014","5/3/2014","7/12/2014","2/10/2014","10/31/2014","3/10/2014","5/6/2014","10/21/2014","2/26/2014","1/12/2014","4/4/2014","4/5/2014","11/1/2014","2/4/2014","3/11/2014","8/9/2014","6/2/2014","1/24/2014","10/6/2014","5/20/2014","9/24/2014","10/29/2014","6/28/2014","12/3/2014","2/19/2014","3/29/2014","10/12/2014","4/3/2014","12/27/2013","11/3/2014","4/22/2014","7/23/2014","7/11/2014","5/15/2014","1/24/2014","4/2/2014","8/25/2014","5/13/2014","1/15/2014","12/17/2014","9/19/2014","9/24/2014","11/4/2014","12/30/2013","1/19/2014","5/19/2014","5/27/2014","4/15/2014","6/20/2014","5/22/2014","1/6/2014","2/8/2014","6/15/2014","5/15/2014","5/7/2014","1/27/2014","11/11/2014","9/7/2014","11/20/2014","4/4/2014","12/29/2013","7/31/2014","3/17/2014","1/17/2014","3/11/2014","7/5/2014","2/24/2014","1/27/2014","2/2/2014","7/16/2014","11/7/2014","8/5/2014","7/5/2014","4/3/2014","4/22/2014","5/12/2014","2/18/2014","6/12/2014","1/28/2014","12/1/2014","9/7/2014","11/13/2014","8/7/2014","5/10/2014","11/19/2014","10/5/2014","12/25/2014","11/13/2014","2/22/2014","10/11/2014","11/5/2014","2/26/2014","8/30/2014","7/22/2014","1/29/2014","8/13/2014","10/24/2014","11/17/2014","6/9/2014","2/19/2014","11/13/2014","7/1/2014","8/5/2014","11/22/2014","5/1/2014","4/5/2014","12/8/2014","12/31/2013","1/25/2014","1/2/2014","5/16/2014","9/27/2014","12/27/2014","3/2/2014","5/27/2014","8/9/2014","8/4/2014","12/30/2013","12/3/2014","3/20/2014","1/12/2014","12/25/2014","3/31/2014","4/21/2014","5/5/2014","6/16/2014","11/16/2014","6/7/2014","3/11/2014","7/13/2014","2/18/2014","1/22/2014","12/31/2013","5/6/2014","2/20/2014","10/11/2014","1/2/2014","3/29/2014","5/7/2014","11/16/2014","10/4/2014","12/3/2014","2/21/2014","5/7/2014","5/19/2014","5/26/2014","5/30/2014","10/28/2014","4/1/2014","3/28/2014","10/2/2014","6/10/2014","8/28/2014","5/15/2014","3/16/2014","3/10/2014","8/29/2014","9/8/2014","1/9/2014","4/27/2014","11/30/2014","3/8/2014","10/22/2014","8/30/2014","1/23/2014","2/22/2014","8/22/2014","9/28/2014","2/25/2014","12/12/2014","8/5/2014","6/5/2014","1/15/2014","2/26/2014","1/6/2014","4/7/2014","9/8/2014","9/16/2014","3/16/2014","12/14/2014","6/17/2014","7/11/2014","10/20/2014","7/16/2014","5/27/2014","10/9/2014","11/10/2014","11/18/2014","3/28/2014","5/1/2014","10/13/2014","4/12/2014","7/9/2014","1/1/2014","4/29/2014","2/7/2014","3/25/2014","1/22/2014","1/4/2014","11/8/2014","4/20/2014","3/5/2014","5/23/2014","8/24/2014","12/8/2014","11/19/2014","2/12/2014","9/16/2014","10/24/2014","4/1/2014","9/10/2014","5/29/2014","4/13/2014","2/10/2014","7/5/2014","4/19/2014","5/21/2014","9/17/2014","6/17/2014","6/21/2014","12/7/2014","10/29/2014","2/18/2014","1/22/2014","2/13/2014","5/24/2014","1/3/2014","9/18/2014","1/17/2014","12/1/2014","1/7/2014","3/7/2014","6/8/2014","5/19/2014","11/17/2014","7/4/2014","8/8/2014","5/25/2014","6/29/2014","8/25/2014","9/16/2014","11/29/2014","12/2/2014","7/28/2014","9/13/2014","1/27/2014","3/10/2014","10/14/2014","10/19/2014","4/25/2014","4/22/2014","5/27/2014","3/7/2014","5/10/2014","10/11/2014","10/30/2014","7/10/2014","6/3/2014","3/20/2014","7/31/2014","12/10/2014","3/4/2014","6/6/2014","3/28/2014","1/15/2014","5/19/2014","7/7/2014","10/15/2014","11/16/2014","12/1/2014","11/16/2014","1/31/2014","10/19/2014","5/31/2014","1/3/2014","10/24/2014","6/12/2014","1/16/2014","1/10/2014","11/4/2014","11/27/2014","11/3/2014","11/12/2014","10/22/2014","9/20/2014","11/6/2014","3/1/2014","10/27/2014","1/12/2014","12/22/2014","6/22/2014","1/17/2014","7/21/2014","1/10/2014","8/8/2014","7/3/2014","4/27/2014","4/13/2014","5/6/2014","11/20/2014","2/16/2014","12/13/2014","1/31/2014","4/6/2014","3/28/2014","4/18/2014","5/8/2014","2/3/2014","7/1/2014","4/20/2014","4/27/2014","10/26/2014","9/3/2014","4/9/2014","6/16/2014","12/1/2014","5/12/2014","4/30/2014","7/30/2014","3/22/2014","1/16/2014","4/26/2014","1/14/2014","1/21/2014","1/27/2014","8/1/2014","1/15/2014","9/27/2014","5/9/2014","6/11/2014","12/1/2014","11/23/2014","4/24/2014","12/23/2013","3/10/2014","4/1/2014","8/21/2014","8/17/2014","9/21/2014","11/14/2014","12/8/2014","2/12/2014","8/19/2014","12/23/2014","4/3/2014","1/14/2014","5/17/2014","10/12/2014","3/4/2014","4/4/2014","4/21/2014","10/18/2014","2/7/2014","10/11/2014","1/13/2014","12/4/2014","4/8/2014","6/16/2014","12/30/2013","10/27/2014","9/23/2014","12/28/2014","11/20/2014","4/27/2014","8/9/2014","9/17/2014","11/21/2014","2/28/2014","12/6/2014","10/30/2014","7/30/2014","12/10/2014","6/15/2014","5/23/2014","12/7/2014","5/14/2014","1/11/2014","3/12/2014","8/4/2014","5/4/2014","8/4/2014","10/17/2014","2/17/2014","2/19/2014","1/3/2014","4/7/2014","9/19/2014","1/17/2014","9/8/2014","12/30/2013","5/3/2014","7/12/2014","8/29/2014","4/9/2014","9/8/2014","5/9/2014","1/20/2014","9/19/2014","6/14/2014","1/8/2014","2/3/2014","5/15/2014","1/14/2014","5/5/2014","11/17/2014","11/7/2014","10/8/2014","1/19/2014","9/8/2014","1/31/2014","9/1/2014","3/14/2014","7/24/2014","11/28/2014","11/1/2014","12/8/2014","2/17/2014","7/18/2014","12/4/2014","1/4/2014","1/9/2014","6/11/2014","11/7/2014","8/4/2014","5/28/2014","11/19/2014"};
	CSVReaderExample csvReaderExample = new CSVReaderExample();
	
	
	public CH translateClaimHeaderToCD(com.ecams.claim.bo.ClaimHeader claimHeaderBo, MasterDataRepositoryInf repository)
	{
		CH cd = new CH();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//cd.setInDate(df.format(new Date(117,8,19)));
		cd.setInDate(df.format(new Date()));
		//cd.set_id(new ObjectId());
		System.out.println(claimHeaderBo.getPatientBirthDate());
		System.out.println(new Date());
		//getDate(date, currentFormat, expectedFormat);
		cd.setPatientBirthDate(df.format(claimHeaderBo.getPatientBirthDate()));
		cd.setPatientFirstName(claimHeaderBo.getPatientFirstName());
		cd.setPatientGender(claimHeaderBo.getPatientGender());
		cd.setPatientLastName(claimHeaderBo.getPatientLastName());
		cd.setPatientZip(claimHeaderBo.getPatientZipCode());
		cd.setPatientStatusLkpcd(claimHeaderBo.getPatientRelationshipLkpcd());
		
		Random random = new Random();
		int index = random.nextInt(members.length);
		cd.setMbrIdentifier(members[index]);
		
		index = random.nextInt(providers.length);
		cd.setBlngNationalPrvdrIdntfr(new BigDecimal(providers[index]));
		cd.setBlngPrvdrLctnZipCode(claimHeaderBo.getBlngPrvdrLctnZipCode());
		
		cd.setTcn(claimHeaderBo.getTcn());
		if(null!=claimHeaderBo.getFromServiceDate())
		{
			cd.setFromServiceDate(df.format(claimHeaderBo.getFromServiceDate()));
		}
		if(null!=claimHeaderBo.getToServiceDate())
		{
			cd.setToServiceDate(df.format(claimHeaderBo.getToServiceDate()));
		}
		if(null!=claimHeaderBo.getAdmissionDate())
		{
			cd.setAdmissionDate(df.format(claimHeaderBo.getAdmissionDate()));
		}
		cd.setAdmissionHour(claimHeaderBo.getAdmissionHour());
		if(null!=claimHeaderBo.getDischargeDate())
		{
			cd.setDischargeDate(df.format(claimHeaderBo.getDischargeDate()));
		}
		
		if(!StringUtils.isEmpty(claimHeaderBo.getFacilityTypeCode()))
		{
			cd.setFaciType_BillFirstDigit(claimHeaderBo.getFacilityTypeCode().substring(0,1));
			cd.setServType_BillSecondDigit(claimHeaderBo.getFacilityTypeCode().substring(1,2));
		}
		if(!StringUtils.isEmpty(claimHeaderBo.getClaimSubmissionReasonLkpcd()))
		{
			cd.setFreqType_BillThirdDigit(claimHeaderBo.getClaimSubmissionReasonLkpcd());
		}
		cd.setApc("");
		if(null==claimHeaderBo.getDrgCode())
		{
			if(null!=claimHeaderBo.getClmHdrDerivedElement() && null!=claimHeaderBo.getClmHdrDerivedElement().getDrgCode())
			cd.setDrgCode(claimHeaderBo.getClmHdrDerivedElement().getDrgCode());
		}
		else
		{
			cd.setDrgCode(claimHeaderBo.getDrgCode());
		}
		
		if(!StringUtils.isEmpty(claimHeaderBo.getDrgCode()))
		{
			cd.setMdc(repository.getMdcId(claimHeaderBo.getDrgCode()));
		}
		

		cd.setTotalBilledAmount(claimHeaderBo.getTotalBilledAmount());
		if(null!=claimHeaderBo.getClmHdrDerivedElement())
		{
			cd.setPaidAmount(claimHeaderBo.getClmHdrDerivedElement().getPaidAmount());
		}
		//Diagnosis
		if(null!=claimHeaderBo.getClmHdrXDiagnosis())
		{
			Set<ClmHdrXDiagnosis> diagSet = claimHeaderBo.getClmHdrXDiagnosis();
			for(ClmHdrXDiagnosis clmHdrXDiagnosis : diagSet){
				String diagcode = clmHdrXDiagnosis.getDiagnosisCode();
				//to be removed for non CNSI envs
				if(null==diagcode && clmHdrXDiagnosis.getDiagnosisIid()!=null)
				{
					try {
						diagcode = CNSIDBUtil.getDiagCode(clmHdrXDiagnosis.getDiagnosisIid());
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				//Principle Diag
				if("P".equals(clmHdrXDiagnosis.getPrimaryQlfr()) ||"P".equals(clmHdrXDiagnosis.getPrimaryQlfr()))
				{
					cd.setPrncplDgnsCd(repository.convertIcd9To10(diagcode));
					cd.setPrncplDgnsPoa(clmHdrXDiagnosis.getPoaLkpcd());
				}
				//Admitting Diag
				if("BJ".equals(clmHdrXDiagnosis.getDiagQlfr()) || "ABJ".equals(clmHdrXDiagnosis.getDiagQlfr()) || "A".equals(clmHdrXDiagnosis.getPrimaryQlfr()))
				{
					cd.setAdmtDiagCd(repository.convertIcd9To10(diagcode));
					cd.setAdmtDiagCdPoa(clmHdrXDiagnosis.getPoaLkpcd());
				}
				//Other Diag
				else if("T".equals(clmHdrXDiagnosis.getPrimaryQlfr()))
				{
					int seqNo = clmHdrXDiagnosis.getDiagnosisOrderSqncNmbr().intValue();
					seqNo = seqNo -1;
					if(seqNo<25)
					{
						//cd.setP1(clmHdrXProcedure.getPrcdrCode());
						cd = setValue(cd, "d"+seqNo,repository.convertIcd9To10(diagcode));
						cd = setValue(cd, "d"+seqNo+"_poa",clmHdrXDiagnosis.getPoaLkpcd());
					}
				}
			}
		}
			
		
		//Providers
		if(null!=claimHeaderBo.getClmHdrXPrvdrLctns())
		for(ClmHdrXPrvdrLctn clmHdrXPrvdrLctn:claimHeaderBo.getClmHdrXPrvdrLctns())
		{
			cd.setAttendingNationalPrvdrIdntfr(clmHdrXPrvdrLctn.getPrvdrLctnIdentifier());
		}
		//Procedures
		if(null!=claimHeaderBo.getClmHdrXProcedures())
		for(ClmHdrXProcedure clmHdrXProcedure:claimHeaderBo.getClmHdrXProcedures())
		{
			String prcdrCode = clmHdrXProcedure.getPrcdrCode();
			if(null==prcdrCode && clmHdrXProcedure.getProcedureIid()!=null)
			{
				try {
					prcdrCode = CNSIDBUtil.getProcCode(clmHdrXProcedure.getProcedureIid());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if("P".equals(clmHdrXProcedure.getProcedureTypeQlfr()))
			{
				cd.setPrncplPrcdrCd(repository.convertIcd9To10(prcdrCode));
				if(null!=clmHdrXProcedure.getSurgicalPrcdrDate())
				{
					cd.setPrncplPrcdrCdDate(df.format(clmHdrXProcedure.getSurgicalPrcdrDate()));
				}
			}
			else if("O".equals(clmHdrXProcedure.getProcedureTypeQlfr()))
			{
				int seqNo = clmHdrXProcedure.getPrcdrOrderSqncNmbr().intValue();
				seqNo = seqNo -1;
				cd = setValue(cd, "p"+seqNo,repository.convertIcd9To10(prcdrCode));
				cd = setValue(cd, "p"+seqNo+"_dt",df.format(clmHdrXProcedure.getSurgicalPrcdrDate()));
			}
		}
		
		//Admissions
		if(null!=claimHeaderBo.getClmHdrAdmissionDetails())
		{
			for(ClmHdrAdmissionDetail clmHdrAdmissionDetail:claimHeaderBo.getClmHdrAdmissionDetails())
			{
				cd.setAdmissionSourceLkpcd(clmHdrAdmissionDetail.getAdmissionSourceLkpcd());
				cd.setAdmissionSourceLkpcd(clmHdrAdmissionDetail.getAdmissionTypeLkpcd());
				cd.setAdmissionTypeLkpcd(clmHdrAdmissionDetail.getPatientStatusLkpcd());
			}
		}
		
		//Conditions
		if(null!=claimHeaderBo.getClmHdrConditions())
		{
			int seqNo =1;
			for(ClmHdrCondition clmHdrCondition: claimHeaderBo.getClmHdrConditions())
			{
				cd = setValue(cd, "cnd"+seqNo,clmHdrCondition.getClmConditionCid());
				seqNo++;
			}
		}
		
		//Occurence
		if(null!=claimHeaderBo.getClmHdrOccurrenceDetails())
		{
			int seqNo =1;
			for(ClmHdrOccurrenceDetail clmHdrOccurrenceDetail: claimHeaderBo.getClmHdrOccurrenceDetails())
			{
				cd = setValue(cd, "ocr"+seqNo,clmHdrOccurrenceDetail.getClmOccurrenceAndSpanCid());
				if(null!=clmHdrOccurrenceDetail.getFromDate())
				{
					cd = setValue(cd, "ocr"+seqNo+"_dt",df.format(clmHdrOccurrenceDetail.getFromDate()));
				}
				seqNo++;
			}
		}
		//Value codes
		if(null!=claimHeaderBo.getClmHdrValueAmounts())
		{
			int seqNo =1;
			for(ClmHdrValueAmount clmHdrValueAmount: claimHeaderBo.getClmHdrValueAmounts())
			{
				cd = setValue(cd, "val"+seqNo,clmHdrValueAmount.getAmountTypeLkpcd());
				cd = setValue(cd, "val"+seqNo+"_amt",clmHdrValueAmount.getClmAmountValue());
				seqNo++;
			}
		}
		
		int maximum = 900;
		int minimum = 50;
		List<CL> lines = new ArrayList<CL>();
		//Lines
		for(ClaimLine claimLine:claimHeaderBo.getClaimLines())
		{
			CL cl = new CL();
			//COPD Spec -STARTS
			cl.setMbrIdentifier(cd.getMbrIdentifier());
			index = random.nextInt(procCodes.length);
			cl.setPrcdrCode(procCodes[index]);
			Random rn = new Random();
			int range = maximum - minimum + 1;
			int randomNum =  rn.nextInt(range) + minimum;
			cl.setBilledAmount(String.valueOf(randomNum));
			String fromDate  = repository.getAdmissionData(cd.getMbrIdentifier());
			cl.setFromServiceDate(fromDate);
			cl.setToServiceDate(fromDate);
			//COPD ENDS
			
			//Enable below for non COPD
			//cl.setPrcdrCode(claimLine.getPrcdrCode());
			//cl.setBilledAmount(claimLine.getBilledAmount().toString());
//			SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd");
//			if(null!=claimLine.getFromServiceDate())
//			{
//				String date = sdfSource.format(claimLine.getFromServiceDate());
//				cl.setFromServiceDate(date);
//				cl.setToServiceDate(date);
//			}
			
			
			cl.setBilledUnits(claimLine.getBilledUnits().toString());
			cl.setClaimLineTcn(claimLine.getClaimLineTcn());
			
			
			if(null!=claimLine.getClmLnDerivedElement())
			{
				cl.setPaidAmount(claimLine.getClmLnDerivedElement().getPaidAmount().toString());
			}
			
			cl.setRevenueCode(claimLine.getRevenueCode());
			lines.add(cl);
		}
		cd.setLines(lines);
		return cd;
	}
	
	private CH setValue(CH c1, String p_sAttributeName, Object p_sAttributeValue)
	{
		Field field;
		try {
			field = c1.getClass().getDeclaredField(p_sAttributeName);
			field.setAccessible(true);
			field.set(c1, typeCastedObject(field, p_sAttributeValue));
			field.setAccessible(false);
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return c1;
	}
	private  Object typeCastedObject(Field field, Object value) {
		if (value != null && !value.toString().equals("") && !value.toString().equals("Blank")) {
			if (field.getType().equals(String.class)) {
				return value.toString();
			}
			if (field.getType().equals(double.class) || field.getType().equals(Double.class)) {
				return Double.parseDouble(value.toString());
			}
			if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
				return Integer.parseInt(value.toString());
			}
			if (field.getType().equals(long.class) || field.getType().equals(Long.class)) {
				return Long.parseLong(value.toString());
			}
			if (field.getType().equals(BigDecimal.class)) {
				return value.toString() != null ? new BigDecimal(value.toString()): new BigDecimal(0);
			}
			if (field.getType().equals(boolean.class)) {
				return Boolean.parseBoolean(value.toString());
			}
			if (field.getType().equals(Date.class)) {
				return value;
			}
		}
		return null;
	}
	
	public static String getDate(
	        String date, String currentFormat, String expectedFormat)
	throws ParseException {
	    // Validating if the supplied parameters is null 
	    if (date == null || currentFormat == null || expectedFormat == null ) {
	        return null;
	    }
	    // Create SimpleDateFormat object with source string date format
	    SimpleDateFormat sourceDateFormat = new SimpleDateFormat(currentFormat);
	    // Parse the string into Date object
	    Date dateObj = sourceDateFormat.parse(date);
	    // Create SimpleDateFormat object with desired date format
	    SimpleDateFormat desiredDateFormat = new SimpleDateFormat(expectedFormat);
	    // Parse the date into another format
	    return desiredDateFormat.format(dateObj).toString();
	}

}
