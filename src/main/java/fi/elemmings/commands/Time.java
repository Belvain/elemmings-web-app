
package fi.elemmings.commands;

import fi.elemmings.model.CommandRequest;
import fi.elemmings.model.CommandResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import spark.Request;

/**
 *
 * @author belvain
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
