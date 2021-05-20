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
import java.util.ArrayList;
import java.util.Random;
import objects.dataclass;

/**
 *
 * @author zelle
 */
@WebServlet(name = "getdata", urlPatterns = {"/getdata"})
public class getdata extends HttpServlet {

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

            String shortnd = request.getParameter("shortnd");
            int pass = Integer.parseInt(request.getParameter("pass"));

            Connection con;
             Statement st;
             ResultSet rs;
             
            

                
                try {

                    Class.forName("java.sql.Driver");
                    con = DriverManager.getConnection("jdbc:derby://localhost:1527/linkSQL", "root", "root");
                    st = con.createStatement();
                    
                    
                    
                    rs = st.executeQuery("Select * from urls where shortend = '"+shortnd+"' and pass="+pass);
                    
                    if(rs.next()){
                        int id = rs.getInt("ID");
                        Timestamp s = rs.getTimestamp("TIMESTAMP");
                        String url = rs.getString("URL");  
                        
                        rs = st.executeQuery("Select * from ACCESS where URLID =" + id);
                        
                        
                        
                        if(rs.next()){
                            ArrayList<dataclass> data = new ArrayList<dataclass>();
                          do{
                            
                            dataclass dataclass = new dataclass();
                            dataclass.setDataclass(rs.getTimestamp("TIME"));
                            
                            data.add(dataclass);
                        }while(rs.next());
                        
                        out.print(this.gson.toJson(data));  
                        }else{
                            out.print(this.gson.toJson("No Data"));
                        }
                        
                    }else{
                        
                    }
                    
                    
                    

                } catch (Exception e) {
                    //response.setStatus(444);
                    out.println(this.gson.toJson(e));
                }
                
            

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
