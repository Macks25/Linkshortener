/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.sql.Timestamp;

/**
 *
 * @author zelle
 */
public class urlobj {
    String URL;
    String shortend;
    Timestamp timestamp;



    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getShortend() {
        return shortend;
    }

    public void setShortend(String shortend) {
        this.shortend = shortend;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


}
