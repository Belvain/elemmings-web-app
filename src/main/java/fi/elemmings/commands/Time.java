/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.elemmings.commands;

import fi.elemmings.model.CommandRequest;
import fi.elemmings.model.CommandResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import spark.Request;

/**
 *
 * @author heikkikurhinen
 */
public class Time implements Command{

    @Override
    public String getName() {
        return "time";
    }

    @Override
    public String getHelpTxt() {
        return "Show current time";
    }

    @Override
    public CommandResponse fnc(CommandRequest cmdReq, Request httpReq) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return new CommandResponse("success", "Current time: "+dateFormat.format(date));
    }
    
}
