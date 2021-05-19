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
import objects.urlobj;


/**
 *
 * @author zelle
 */
@WebServlet(name = "geturl", urlPatterns = {"/r"})
public class geturl extends HttpServlet {



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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            response.addHeader("Access-Control-Allow-Origin", "*");

            String SHORTEND = request.getParameter("q");
            //int userid = Integer.parseInt(request.getParameter("userid"));

            Connection con;
             Statement st;
             ResultSet rs;
             

            
                
                try {

                    Class.forName("java.sql.Driver");
                    con = DriverManager.getConnection("jdbc:derby://localhost:1527/linkSQL", "root", "root");
                    st = con.createStatement();
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    rs = st.executeQuery("SELECT * FROM URLS WHERE SHORTEND = '"+SHORTEND+"'");
                    if(rs.next()){
                        
                    String url = rs.getString("URL");
                         st.executeUpdate("UPDATE URLS SET ACCESSEDCOUNT = ACCESSEDCOUNT +1 WHERE SHORTEND='"+SHORTEND+"'");
                    

                   
                        String html="<!DOCTYPE html>\n" +
                                    "<html lang=\"en\">\n" +
                                    "<head>\n" +
                                    "    <meta charset=\"UTF-8\">\n" +
                                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                                    "    <title>Redirecting</title>\n" +
                                    "</head>\n" +
                                    "<body>\n" +
                                    "\n" +
                                    "    loading...\n" +
                                    "</body>\n" +
                                    "<script>\n" +
                                    "    location.href = '"+url+"';\n" +
                                    "</script>\n" +
                                    "</html>";
                        
                        
                         out.println(html);
                    }else{
                        if(SHORTEND == null || SHORTEND == ""){
                            String html="<!DOCTYPE html>\n" +
                                    "<html lang=\"en\">\n" +
                                    "<head>\n" +
                                    "    <meta charset=\"UTF-8\">\n" +
                                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                                    "    <title>Redirecting</title>\n" +
                                    "</head>\n" +
                                    "<body>\n" +
                                    "\n" +
                                    "    loading...\n" +
                                    "</body>\n" +
                                    "<script>\n" +
                                    "    var urlhost = window.location.host;\n" +
                                    "    location.href = `http://${urlhost}/linkshortener/index.html`;\n" +
                                    "</script>\n" +
                                    "</html>";
                            
                            
                         out.println(html);
                        }else{
                            out.println("There is no such url as: "+SHORTEND);
                        }
                        
                    }
                    
                } catch (Exception e) {
                    //response.setStatus(444);
                    out.println(e);
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