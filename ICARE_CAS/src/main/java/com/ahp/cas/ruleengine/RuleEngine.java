package com.ahp.cas.ruleengine;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.ExportDB;

import com.ahp.cas.business.service.ClaimBusinessService;
import com.ahp.cas.domains.claims.ClaimHeader;
import com.cnsi.ruleit.processor.bo.RuleProcessor;
import com.cnsi.ruleit.processor.common.RuleITInit;
import com.cnsi.ruleit.processor.common.RuleITInitilizer;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class RuleEngine {
	private static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws Exception {
		RuleEngine engine = new RuleEngine();
		engine.init();
		ClaimHeader claimHeader = mapper.readValue(new File("C:/DevelopmentStage/OWCP/HCE_DEMO/HCE_DEMO_JSONS/ICARE/1_RBRVS_Pricing_1_1_20171107_123313655.json"), ClaimHeader.class);
		System.out.println("Converted claimHeader:" + claimHeader);
		engine.adjudicate(claimHeader);
	}
	private String xmlDBPath = "C:/RuleIT Lightweight Processor 6.2/RuleITDB_xml";
	private String ruleAppHome = "C:/RuleIT Lightweight Processor 6.2/config";
	private RuleProcessor l_objRuleProcessor;
	
	public void init()
	{
	//	ExportDB.derivedData(xmlDBPath);
		TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();

		RuleITInitilizer.setM_sConfigFileLocation(ruleAppHome);
		ClassPathXmlApplicationContext  rulecontext = (ClassPathXmlApplicationContext) RuleITInit.ctx;
		l_objRuleProcessor = RuleITInit.getRuleProcessor();
		System.out.println("Rule Initilization Ends!!!");
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
	}
	public ClaimHeader load(String content) throws JsonParseException, JsonMappingException, IOException
	{
		return mapper.readValue(content, ClaimHeader.class);

	}
	public void adjudicate(ClaimHeader claimHeader) throws Exception
	{
		HashMap<String, Object> executionResult = null;
		Map<String, String> p_mapTimeSensitive = getTimeSensitive();
		Map<String, String> p_mapApplicationField = getApplicationFields();
		Map<String, Object> p_mapExternalObject = getExternalObjectsForLoading(claimHeader);
		System.out.println("\n********************************************************************\n");
		System.out.println("\n                Big Data Loading Starts                       \n");
		System.out.println("\n********************************************************************\n");
		executionResult = l_objRuleProcessor.process("BILL", "Derive Member ID", p_mapExternalObject, p_mapApplicationField, p_mapTimeSensitive);
		System.out.println(executionResult);
		System.out.println("\n********************************************************************\n");
		System.out.println("\n                Big Data Loading Ends                       \n");
		System.out.println("\n********************************************************************\n");
	}
	private Map<String, String> getTimeSensitive() {
		Map<String, String> l_mapTimeSensitive = new HashMap<String, String>();
		String l_sDate = "12/01/2012";// mm/dd/yyyy
		l_mapTimeSensitive.put("Time Sensitive Variable", l_sDate);
		return l_mapTimeSensitive;
	}
	private Map<String, String> getApplicationFields() {
		Map<String, String> l_mapApplicationField = new HashMap<String, String>();
		return l_mapApplicationField;
	}
	
	private Map<String, Object> getExternalObjectsForLoading(ClaimHeader claimHeader) throws Exception {
		Map<String, Object> l_mapExternalObject = new HashMap<String, Object>();
		l_mapExternalObject.put("ClaimBusinessService", new ClaimBusinessService(claimHeader));
		return l_mapExternalObject;
	}
}
