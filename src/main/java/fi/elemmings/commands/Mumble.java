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
public class Mumble implements Command{

    @Override
    public String getName() {
        return "mumble";
    }

    @Override
    public String getHelpTxt() {
        return "Prints information about Elemmings mumble server";
    }

    @Override
    public CommandResponse fnc(CommandRequest cmdReq, Request httpReq) {
        return new CommandResponse("success", "eLemmings mumble is avalailable at elemmings.dy.fi at port 9090");
    }
    
}
