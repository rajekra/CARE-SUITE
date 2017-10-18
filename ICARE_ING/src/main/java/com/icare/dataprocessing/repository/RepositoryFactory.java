package com.icare.dataprocessing.repository;

import com.icare.dataprocessing.repository.impl.InpatientAggregationRepoImpl;
import com.icare.dataprocessing.repository.impl.InpatientStagingRepoImpl;
import com.icare.dataprocessing.repository.intf.InpatientAggregationRepoIntf;
import com.icare.dataprocessing.repository.intf.InpatientStagingRepoIntf;

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
