/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.google.gson.*;
import objects.urlobj;
import java.net.URL;
import java.util.Random;

/**
 *
 * @author zelle
 */
@WebServlet(name = "createurl", urlPatterns = {"/createurl"})
public class createurl extends HttpServlet {

    private Gson gson = new Gson();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            response.addHeader("Access-Control-Allow-Origin", "*");

            String url = request.getParameter("url");
            //int userid = Integer.parseInt(request.getParameter("userid"));

            Connection con;
             Statement st;
             ResultSet rs;
             
            urlobj urlobj = new urlobj();

            if (isValidURL(url)) {
                
                try {

                    Class.forName("java.sql.Driver");
                    con = DriverManager.getConnection("jdbc:derby://localhost:1527/linkSQL", "root", "root");
                    st = con.createStatement();
                    
                    
                    
                    String upper ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    String lower = upper.toLowerCase();
                    String numbers = "0123456789";
                    String all = upper + lower + numbers;
                    
                    Random random = new Random();
                    
                    String shortend = "";
                    
                    
                    do{
                      for(int i=0; i<6; i++){
                        
                        int index = random.nextInt(all.length());
                        shortend += all.charAt(index);
                    }  
                      String sql = "Select SHORTEND from URLS where SHORTEND ='"+shortend+"'";
                      rs = st.executeQuery(sql);
                      
                      
                    }while(rs.next());
                    
                    Timestamp s = new Timestamp(System.currentTimeMillis());
                    
                    
                    
                    
                    rs = st.executeQuery("select max(ID) as \"max\" from URLS");
                    rs.next();
                    int id = rs.getInt("max") +1;
                    
                    
                    String sql = "INSERT INTO URLS (ID, URL, TIMESTAMP, USERID, ACCESSEDCOUNT, SHORTEND) VALUES ("+id+", '"+url+"', '"+s.toString()+"', 0, 0, '"+shortend+"')";

                    st.executeUpdate(sql);
                    
                    urlobj.setURL(url);
                    urlobj.setShortend(shortend);
                    urlobj.setTimestamp(s);

                    out.println(this.gson.toJson(urlobj));
                } catch (Exception e) {
                    //response.setStatus(444);
                    out.println(this.gson.toJson(e));
                }
                
            } else {
                out.println(this.gson.toJson("E1")); //Non vallid URL or wrong URL syntax
            }

        }
    }

    public static boolean isValidURL(String urlstring) {
        try {
            new URL(urlstring).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


}
