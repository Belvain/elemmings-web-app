/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.elemmings.model;

/**
 *
 * @author heikkikurhinen
 */
public class CommandResponse {
    
    private String type;
    private String data;
    private boolean raw = false;

    public CommandResponse(String type, String data) {
        this.type = type;
        this.data = data;
    }
    
    public CommandResponse(String type, String data, boolean raw) {
        this.type = type;
        this.data = data;
        this.raw = raw;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isRaw() {
        return raw;
    }

    public void setRaw(boolean raw) {
        this.raw = raw;
    }
    
    
    
    
}
