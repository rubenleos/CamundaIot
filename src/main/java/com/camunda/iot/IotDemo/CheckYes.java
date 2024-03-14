package com.camunda.iot.IotDemo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CheckYes implements JavaDelegate {
    public void execute(DelegateExecution execution) throws Exception {
        URL url = new URL("http://34.28.106.98:9001/switch"); // Cambia esto por la URL a la que quieres enviar la petición
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);
        JsonObject jsonObject = new JsonObject();
        String encender=(String) execution.getVariable("encender");
       // System.out.print("encender" + encender);
        jsonObject.addProperty("flag", encender);
        String jsonInputString = new Gson().toJson(jsonObject);

       // String postData = "flag=true"; // Aquí envías el flag
        System.out.println("jason" + jsonInputString);
        try (OutputStream os = conn.getOutputStream()) {
        	  byte[] input = jsonInputString.getBytes("utf-8");
              os.write(input, 0, input.length);
        }

        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        conn.disconnect();
    }
}



