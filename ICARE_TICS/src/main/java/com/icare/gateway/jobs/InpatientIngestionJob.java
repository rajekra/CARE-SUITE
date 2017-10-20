package com.icare.gateway.jobs;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class InpatientIngestionJob {

	@Async
	public void la() throws IOException, InterruptedException
	{
		SparkLauncher sparkLauncher = new SparkLauncher()
         .setAppResource("/my/app.jar")
         .setMainClass("my.spark.app.Main")
         .setMaster("local")
         .setConf(SparkLauncher.DRIVER_MEMORY, "2g");
		
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		SparkAppListener sparkAppListener = new SparkAppListener(countDownLatch);
		SparkAppHandle appHandle = sparkLauncher.startApplication(sparkAppListener);
		Thread sparkAppListenerThread = new Thread(sparkAppListener);
		sparkAppListenerThread.start();
		long timeout = 120;
		countDownLatch.await(timeout, TimeUnit.SECONDS); 
	}
	private static class SparkAppListener implements SparkAppHandle.Listener, Runnable {
	    private final CountDownLatch countDownLatch;
	    public SparkAppListener(CountDownLatch countDownLatch) {
	        this.countDownLatch = countDownLatch;
	    }
	    @Override
	    public void stateChanged(SparkAppHandle handle) {
	        String sparkAppId = handle.getAppId();
	        org.apache.spark.launcher.SparkAppHandle.State appState = handle.getState();
	        if (sparkAppId != null) {
	            System.out.println("Spark job with app id: " + sparkAppId + ",\t State changed to: " + appState + " - ");
	        } else {
	        	System.out.println("Spark job's state changed to: " + appState + " - " );
	        }
	        if (appState != null && appState.isFinal()) {
	            countDownLatch.countDown();
	        }
	    }
	    @Override
	    public void infoChanged(SparkAppHandle handle) {}
	    @Override
	    public void run() {}
	}
}
