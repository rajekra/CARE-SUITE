package com.icare.ing.repository;

import com.icare.ing.repository.impl.InpatientAggregationRepoImpl;
import com.icare.ing.repository.impl.InpatientStagingRepoImpl;
import com.icare.ing.repository.intf.InpatientAggregationRepoIntf;
import com.icare.ing.repository.intf.InpatientStagingRepoIntf;

public class RepositoryFactory {
	
	public static InpatientStagingRepoIntf getInpatientStagingRepo()
	{
		return new InpatientStagingRepoImpl();
	}
	public static InpatientAggregationRepoIntf getInpatientAggregationRepo()
	{
		return new InpatientAggregationRepoImpl();
	}
}
