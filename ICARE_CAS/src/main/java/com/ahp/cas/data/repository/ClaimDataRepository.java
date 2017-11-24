package com.ahp.cas.data.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import com.ahp.cas.domains.claims.adclaim.AdClaimHeader;

public class ClaimDataRepository {

	TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();

	//build the EntityManagerFactory as you would build in in Hibernate ORM
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ogmdemo");
	EntityManager em = emf.createEntityManager();
	public String getProcedureIID(String procedureCode)
	{
		Object value = null;
		try{
		Query query = em.createQuery("SELECT DISTINCT p.procedureIid FROM Procedure p WHERE p.prcdrCode = :procedureCode  ");
		query.setParameter("PRCDR_CODE", procedureCode);
		value = query.getSingleResult();
		}
		catch (NoResultException e) {
			//System.err.println("No Procedure IID found for the given code and category!!");
		}
		catch (NonUniqueResultException nure) {
			//System.err.println("More than one Procedure IID found for the given code and category!!");
		}
		return (String) value;
	}
	
	public String getMemberSID(String memberIdentifier)
	{
		System.out.println("ClaimDataRepository:" + memberIdentifier);
		String value = null;
		try{
		Query query = em.createQuery("SELECT DISTINCT p.mbrSid FROM MemberInfo p WHERE p.identifier = :memberIdentifier  ");
		query.setParameter("memberIdentifier", memberIdentifier);
		int val = (int) query.getSingleResult();
		value = String.valueOf(val);
		}
		catch (NoResultException e) {
			e.printStackTrace();
		}
		catch (NonUniqueResultException nure) {
			nure.printStackTrace();		}
		System.out.println("ClaimDataRepository value:" + value);
		return value;
	}
	
	public void save(AdClaimHeader claimHeaderAD) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
	{
		try
		{
			System.out.println("B4 persist");
			tm.begin();
			em.persist(claimHeaderAD);
		}
		catch(Exception ex)
		{
			//ex.printStackTrace();
		}
		finally{
			em.flush();
			em.close();
			tm.commit();
			System.out.println("After persist");
		}
	}
}
