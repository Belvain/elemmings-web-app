/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.elemmings.commands;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import fi.elemmings.commands.model.RestResponse;
import fi.elemmings.model.CommandRequest;
import fi.elemmings.model.CommandResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import spark.Request;

/**
 *
 * @author heikkikurhinen
 */
public class Weather implements Command {

    private static final String WEATHER_URL = "http://192.168.11.3:3000/api/weather/";
    
    @Override
    public String getName() {
        return "weather";
    }

    @Override
    public String getHelpTxt() {
        return "Display weather from city given as first argument";
    }

    @Override
    public CommandResponse fnc(CommandRequest cmdReq, Request httpReq) {
        if(cmdReq.getArgs().size() < 1){
            return new CommandResponse("error", "Invalid arguments!");
        }
        String url = WEATHER_URL+cmdReq.getArgs().get(0);
        
        System.out.println("Getting weather data from: "+url);
        
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource.accept("application/json")
           .get(ClientResponse.class);

        if (response.getStatus() != 200) {
           return new CommandResponse("error", "Connection to weather server failed with error: "+response.getStatus());
        }

        String output = response.getEntity(String.class);
        System.out.println("Got response: "+output);
        ObjectMapper mapper = new ObjectMapper();
        try {
            RestResponse weatherData = mapper.readValue(output, RestResponse.class);
            return new CommandResponse("success", "Weather in "+cmdReq.getArgs().get(0)+": "+weatherData.getMsg());
        } catch (IOException ex) {
            Logger.getLogger(Weather.class.getName()).log(Level.SEVERE, null, ex);
            return new CommandResponse("error", "Invalid response from weather server");
        } 
    }
    
}
