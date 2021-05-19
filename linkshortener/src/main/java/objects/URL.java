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
public class URL {
    int ID;
    String URL;
    String shortend;
    Timestamp timestamp;
    int userid;
    int accessedcount;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getAccessedcount() {
        return accessedcount;
    }

    public void setAccessedcount(int accessedcount) {
        this.accessedcount = accessedcount;
    }
}
