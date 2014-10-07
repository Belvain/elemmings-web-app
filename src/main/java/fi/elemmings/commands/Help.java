
package fi.elemmings.commands;

import fi.elemmings.model.CommandRequest;
import fi.elemmings.model.CommandResponse;
import java.util.ServiceLoader;
import spark.Request;

/**
 *
 * @author belvain
 */
public class Help implements Command{
    
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getHelpTxt() {
        return "Show this text";
    }

    @Override
    public CommandResponse fnc(CommandRequest cmdReq, Request httpReq) {
        StringBuilder sb = new StringBuilder("Available commands:<br/><br/><table>");
        ServiceLoader<Command> commands = ServiceLoader.load(Command.class);
        for(Command command : commands){
            sb.append("<tr><td><b>&nbsp;&nbsp;"+command.getName()+"&nbsp;&nbsp;</b></td><td>"+command.getHelpTxt()+"</td></tr>");
        }
        sb.append("</table>");
        return new CommandResponse("success", sb.toString(), true);
    }
    
}
