/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.elemmings.commands;

import fi.elemmings.model.CommandRequest;
import fi.elemmings.model.CommandResponse;
import spark.Request;

/**
 *
 * @author heikkikurhinen
 */
public class Whoami implements Command{

    @Override
    public String getName() {
        return "whoami";
    }

    @Override
    public String getHelpTxt() {
        return "Show your ip address";
    }

    @Override
    public CommandResponse fnc(CommandRequest cmdReq, Request httpReq) {
        return new CommandResponse("success", "Your ip is: "+httpReq.ip());
    }
    
}
