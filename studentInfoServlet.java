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
@WebServlet(urlPatterns = {"/studentInfoServlet"})
public class studentInfoServlet extends HttpServlet {

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
            //get Parameter from previous page
          
            RequestDispatcher rd;
            
         /*  String action;
           action = request.getParameter("sb");*/
            String guiId;
            int id;
            
            
            guiId = request.getParameter("id");
            
            id=Integer.parseInt(guiId);
            System.out.println("id retrieve " + guiId);
            
            String pssw;
            pssw = request.getParameter("pw");
            System.out.println("password retrieve " + pssw);
            
            String passDB="";
            System.out.println("pass");
            
            StudentInfoDB c1;
            c1 = new StudentInfoDB();
            c1.selectDB(id);
            
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("s1", c1);
            
            String p;
            p= c1.getPassw();            
           System.out.println(p);
            if(pssw.equals(p)){   
            
            rd = request.getRequestDispatcher("/DisplayStudInfo.jsp");   
            rd.forward(request, response);
            
                }
            else
            {
                System.out.println("Error");
            rd = request.getRequestDispatcher("/errorLogin.jsp");
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
