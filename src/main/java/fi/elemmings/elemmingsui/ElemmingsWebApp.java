package fi.elemmings.elemmingsui;

import fi.elemmings.commands.Command;
import fi.elemmings.model.CommandRequest;
import fi.elemmings.model.CommandResponse;
import java.io.File;
import java.io.IOException;
import java.util.ServiceLoader;
import org.codehaus.jackson.map.ObjectMapper;
import static spark.Spark.get;
import static spark.SparkBase.externalStaticFileLocation;

/**
 *
 * @author belvain
 */
public class ElemmingsWebApp {
    
    public static void main(String [] args) {
        
       externalStaticFileLocation("static");
       
       get("/", (request, response) -> {
           StringBuilder sb = new StringBuilder();
           sb.append("<html lang=\"en\">");
           sb.append("<head>");
           sb.append("<meta charset=\"utf-8\">");
           sb.append("<title>eLemmings</title>");
           sb.append("<link rel=\"stylesheet\" href=\"stylesheets/jquery.terminal.css\">");
           sb.append("<link rel=\"stylesheet\" href=\"stylesheets/main.css\">");
           sb.append("<script src=\"javascript/jquery-2.1.1.min.js\"></script>");
           sb.append("<script src=\"javascript/jquery.terminal-0.8.8.min.js\"></script>");
           sb.append("<script src=\"javascript/main.js\"></script>");
           sb.append("</head>");
           sb.append("<body>");
           sb.append("</body>");
           sb.append("</html>");
           
           return sb.toString();
      });
       
       get("/cmd/", (request,response) -> {
           ObjectMapper mapper = new ObjectMapper();
           try {
               CommandRequest cmdReq = mapper.readValue(request.queryParams("data"), CommandRequest.class);
               Command cmd = getCommand(cmdReq);
               if(cmd != null){
                   return mapper.writeValueAsString(cmd.fnc(cmdReq, request));
               }
               return mapper.writeValueAsString(new CommandResponse("error", "Command "+cmdReq.getName()+" does not exist!"));
           } catch (IOException ex) {
               ex.printStackTrace();
               return null;
           }
       });
    }
    
    private static Command getCommand(CommandRequest req){
        ServiceLoader<Command> commands = ServiceLoader.load(Command.class);
        for(Command cmd : commands){
            if(cmd.getName().equals(req.getName())){
                return cmd;
            }
        }
        return null;
    }
    
}
