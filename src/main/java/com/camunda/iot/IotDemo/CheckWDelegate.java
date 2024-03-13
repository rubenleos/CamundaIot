package com.camunda.iot.IotDemo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import java.util.Random;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckWDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Random rando = new Random();
		boolean flag = true;
		
		// TODO Auto-generated method stub
       // execution.setVariable("name", "niall");
       // execution.setVariable("weatherOK", rando );
        String strNSev = (String) execution.getVariable("event_nseverity");
        String name = (String) execution.getVariable("name");
        Boolean weatherOK = (Boolean) execution.getVariable("weatherOK");
        if (weatherOK != null) {
            System.out.println("***strNSev***   " + strNSev);
            System.out.println("***name***  " + name);
            System.out.println("****watherstatus****  " + weatherOK);
        } else {
            System.out.println("***event_nseverity variable is null***");
            execution.setVariable("weatherOK", flag );
            // Handle the case when the variable is null
        }
	}

}
