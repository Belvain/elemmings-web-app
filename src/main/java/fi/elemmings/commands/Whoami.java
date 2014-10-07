
package fi.elemmings.commands;

import fi.elemmings.model.CommandRequest;
import fi.elemmings.model.CommandResponse;
import spark.Request;

/**
 *
 * @author belvain
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
