package com.icare.ing.service;

import java.util.ArrayList;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icare.common.dto.CD;
import com.icare.common.service.PropUtilityService;
import com.icare.ing.repository.IngestionRepository;

@Service
public class InstitutionalIngestionService {

	@Autowired
	private IngestionRepository ingestionRepository;
	
	@Autowired
	private PropUtilityService propUtilityService;
	
	@Autowired
    private SparkSession sparkSession;
	
	public void ingest()
	{
		ArrayList<CD> data = new ArrayList<CD>();
		data.add(new CD());
		Dataset<Row> ds = sparkSession.createDataFrame(data, CD.class);
		//ds.write().mode("error").jdbc("jdbc:phoenix:127.0.0.1:2181:/hbase-unsecure", where, dbProperties);
	}
}
