package com.camunda.iot.IotDemo;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class LoggerLEDOff implements JavaDelegate {
	 
	  private final Logger LOGGER = Logger.getLogger(LoggerLEDOff.class.getName());
	  
	  public void execute(DelegateExecution execution) throws Exception {
	    
		LOGGER.info("\n\n  ... LoggerDelegate invoked by "
		        + "LED Apagado" 
		        + " \n\n");
	    
	  }

}
