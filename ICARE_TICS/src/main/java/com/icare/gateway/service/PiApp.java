package com.icare.gateway.service;

import java.io.File;
import java.net.URI;

import com.cloudera.livy.*;
import com.icare.dataprocessing.service.analytics.predictive.PredictionExecutor;


public class PiApp {

	public static void main(String[] args) throws Exception {

	    String livyUrl = "http://127.0.0.1:8999/";
	    LivyClient client = new LivyClientBuilder()
	      .setURI(new URI(livyUrl))
	      .build();

	    try {
	      System.out.println("Uploading livy-example jar to the SparkContext...");
//	      for (String s : System.getProperty("java.class.path").split(File.pathSeparator)) {
//	        if (new File(s).getName().startsWith("livy-examples")) {
//	          client.uploadJar(new File(s)).get();
//	          break;
//	        }
//	      }
	      URI uri = new URI("file:///root/hdp/lib/mongo-java-driver-3.4.2.jar");
	      client.addJar(uri);
	      client.uploadJar(new File("C:\\Users\\kandhasamyr\\OneDrive - CNSI\\ICARE\\CARE-SUITE-master\\CARE-SUITE-master\\ICARE_ING\\target\\ZING-0.0.1-SNAPSHOT.jar"));
	      client.uploadJar(new File("C:\\Users\\kandhasamyr\\OneDrive - CNSI\\ICARE\\lib\\icare\\mongo-java-driver-3.4.2.jar"));
	      client.uploadJar(new File("C:\\Users\\kandhasamyr\\OneDrive - CNSI\\ICARE\\lib\\icare\\mongo-spark-connector_2.10-2.1.0.jar"));
	      System.out.println("File uploaded...");
	      System.out.println("Pi is roughly " +client.submit(new PredictionExecutor("INPATIENT_MDC")).get());
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	      client.stop(true);
	  }

}
