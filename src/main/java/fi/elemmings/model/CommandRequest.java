
package fi.elemmings.model;

import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author heikkikurhinen
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommandRequest {

    private String name;
    private List<String> args;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }
    
}
