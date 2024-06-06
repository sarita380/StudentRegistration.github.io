/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Business.StudentInfoDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sara
 */
@WebServlet(urlPatterns = {"/lookupStudInfo"})
public class UpdateStudInfo extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             
          //  String action= request.getParameter("sb");
             RequestDispatcher rd;
           HttpSession ses1=request.getSession();
          
           
           String action;
           action = request.getParameter("sb");
           
          System.out.println("button print" + action);
  
            String p;
            p= request.getParameter("p");
            System.out.println("password " + p);
            
            String fn;
            fn= request.getParameter("fname");
            System.out.println("fname " + fn);
            
             String lsn;
            lsn= request.getParameter("last");
            System.out.println("lastname " + lsn);
            
             String st;
            st= request.getParameter("st");
            System.out.println("Street " + st);
            
             String c;
            c= request.getParameter("ct");
            System.out.println("City " + c);
            
            String stat;
            stat= request.getParameter("sta");
            System.out.println("State " + stat);
            
            //String sta;
            //int sa;
            //sta= request.getParameter("zip");
            //sa=Integer.parseInt(sta);
            //System.out.println("zip " + sa);
            
            String em;
            em= request.getParameter("em");
 
          
            if(action.equals("Submit")){
              System.out.println("In Submit");
            String ast;
             int id;
            ast = request.getParameter("sid");
            id=Integer.parseInt(ast);
            System.out.println("id retrieve " + id); 
            StudentInfoDB s2 = new StudentInfoDB();
            s2.selectDB(id);
            s2.setPassw(p);
            s2.setFirstN(fn);
            s2.setLastN(lsn);
            s2.setStreet(st);
            s2.setCity(c);
            s2.setState(stat);
            s2.setEMail(em);
            s2.selectDB(id);
            s2.updateDB();
            s2.display();
   
            ses1.setAttribute("s1",s2);
            rd = request.getRequestDispatcher("/SuccessUpdated.jsp");  
            rd.forward(request, response);
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
