package com.icare.ing.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IngestionRepository {

	@Autowired
	 private JdbcTemplate phoenixJdbcTemplate;
	
}
