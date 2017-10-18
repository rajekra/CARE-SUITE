package com.icare.dataprocessing.service.analytics.predictive;

import com.icare.dataprocessing.service.analytics.predictive.regression.linear_regression.InpatientMdcwisePrediction;

public class SpringLauncher {
public static void main(String[] args) throws Exception
{
	ClientWaiter waiter = new ClientWaiter();
	InpatientMdcwisePrediction inp = new InpatientMdcwisePrediction();
	waiter.setModelBuilder(inp);
	waiter.buildModel(null);
	waiter.predict(null);
}
}
