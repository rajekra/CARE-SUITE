package com.icare.dataprocessing.service_examples;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.phoenix.jdbc.PhoenixDriver;

import com.ecams.claim.bo.ClaimHeader;

public class PhoenixForwarder implements Serializable {
	private static final long serialVersionUID = 1L;
	String connectionString = "jdbc:phoenix:sandbox.hortonworks.com:2181:/hbase-unsecure:hbase";
	Connection con = null;
	PreparedStatement prepSales = null;
	PreparedStatement prepAgg = null;

	public PhoenixForwarder() {
		createConnection();
	}

	public void createConnection() {
		try {
			Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
			DriverManager.registerDriver(new PhoenixDriver());
			con = DriverManager.getConnection(connectionString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendSales(ClaimHeader row) {

	}

	public synchronized void closeCon() {
		try {
			if (con != null)
				con.commit();
			con.close();
			if (prepSales != null)
				prepSales.close();
			if (prepAgg != null)
				prepAgg.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}