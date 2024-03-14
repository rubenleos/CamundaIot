package com.camunda.iot.IotDemo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import java.util.Random;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckWDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Random rando = new Random();
        // Obtenemos las variables de la ejecución
        String strNSev = (String) execution.getVariable("event_nseverity");
        String name = (String) execution.getVariable("name");
        Boolean weather = (Boolean) execution.getVariable("weatherOK");
        //boolean  watherOK = (boolean) weather;
        // Imprimimos el estado del clima si está disponible
        if (weather != null) {
          //  System.out.println("**** Estado del clima ****: " + weatherOK);
            System.out.println("*** Severidad del evento ***: " + strNSev);
            System.out.println("*** Nombre ***: " + name);
        } else {
            // Imprimimos una advertencia si el estado del clima es nulo
            System.out.println("*** La variable 'weatherOK' es nula. Estableciendo en true por defecto. ***");
            execution.setVariable("weatherOK", true);
        }
    }
}