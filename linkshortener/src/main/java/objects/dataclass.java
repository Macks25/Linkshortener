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
public class dataclass {
    
    int hour;
    int day;
    int month;
    int year;

    public int getHour() {
        return hour;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    
    public void setDataclass(Timestamp s){
        hour = s.getHours();
        day = s.getDate();
        month = s.getMonth() +1;
        year = s.getYear() +1900;  
    }
    
}
