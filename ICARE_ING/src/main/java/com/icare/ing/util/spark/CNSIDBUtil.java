package com.icare.ing.util.spark;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class CNSIDBUtil {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@172.25.17.144:1521:WCMDEVDB";
	private static final String DB_USER = "WCMBPDEV";
	private static final String DB_PASSWORD = "O3cP4EM0Tt";
	
	public static void main(String[] argv) {


	}

	public static String getDiagCode(BigDecimal diagIID) throws SQLException {
		Connection dbConnection = null;
		System.out.println("diagIID:"+diagIID);
		String selectTableSQL = "SELECT distinct DIAGNOSIS_CODE from DIAGNOSIS WHERE DIAGNOSIS_IID=? and ROWNUM < 2";
		PreparedStatement prest = null;
		String diagCode = null;
		try {
			if(dbConnection==null)
			{
				dbConnection = getDBConnection();
			}
			
			prest  = dbConnection.prepareStatement(selectTableSQL);

			System.out.println(selectTableSQL);
			prest.setBigDecimal(1, diagIID);
			// execute select SQL stetement
			ResultSet rs = prest.executeQuery();

			while (rs.next()) {
				diagCode = rs.getString("DIAGNOSIS_CODE");
				break;
			}
			rs.close();
		} catch (SQLException e) {

			e.getMessage();

		} finally {

			if (prest != null) {
				prest.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		System.out.println("diagCode:" + diagCode);
		return diagCode;
	}
	public static String getProcCode(BigDecimal procIID) throws SQLException {
		System.out.println("procIID:"+procIID);
		String selectTableSQL = "SELECT distinct PRCDR_CODE from PROCEDURE WHERE PROCEDURE_IID=? and ROWNUM < 2";
		PreparedStatement prest = null;
		String PRCDR_CODE = null;
		Connection dbConnection = null;
		try {
			if(dbConnection==null)
			{
				dbConnection = getDBConnection();
			}
			
			prest  = dbConnection.prepareStatement(selectTableSQL);

			System.out.println(selectTableSQL);
			prest.setBigDecimal(1, procIID);
			// execute select SQL stetement
			ResultSet rs = prest.executeQuery();

			while (rs.next()) {
				PRCDR_CODE = rs.getString("PRCDR_CODE");
				break;
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (prest != null) {
				prest.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		System.out.println("PRCDR_CODE:" + PRCDR_CODE);
		return PRCDR_CODE;
	}

	
	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

}
