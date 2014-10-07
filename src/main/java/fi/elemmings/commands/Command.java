
package fi.elemmings.commands;

import fi.elemmings.model.CommandRequest;
import fi.elemmings.model.CommandResponse;
import spark.Request;

/**
 *
 * @author belvain
 */
public interface Command {
    
    public String getName();
    
    public String getHelpTxt();
    
    public CommandResponse fnc(CommandRequest cmdReq, Request httpReq);
    
}
