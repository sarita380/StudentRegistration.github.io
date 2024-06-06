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
@WebServlet(urlPatterns = {"/addStudServlet"})
public class addStudServlet extends HttpServlet {
    private HttpSession HttpSession;

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
           RequestDispatcher rd;
           HttpSession ses1=request.getSession();
          
           
           String action;
           action = request.getParameter("sb");
           
          System.out.println("button print" + action);
  
            String p;
            p= request.getParameter("p");
            System.out.println("password " + p);
            
            String fn;
            fn= request.getParameter("fm");
            System.out.println("fname " + fn);
            
             String lsn;
            lsn= request.getParameter("la");
            System.out.println("lastname " + lsn);
            
             String st;
            st= request.getParameter("se");
            System.out.println("Street " + st);
            
             String c;
            c= request.getParameter("cy");
            System.out.println("City " + c);
            
            String stat;
            stat= request.getParameter("sa");
            System.out.println("State " + stat);
            
            String sta;
            int sa;
            sta= request.getParameter("zp");
            sa=Integer.parseInt(sta);
            //System.out.println("zip " + sa);
            
            String em;
            em= request.getParameter("m");
 
           
          
            
        if(action.equals("Find")){
            System.out.println("In Find"); 
            String ast;
            int id;
            ast = request.getParameter("sid");
            id=Integer.parseInt(ast);
            System.out.println("id retrieve " + id); 
            StudentInfoDB s1 = new StudentInfoDB();
            s1.selectDB(id);
            s1.display();
            ses1.setAttribute("s1",s1);
            rd = request.getRequestDispatcher("/addStudent.jsp");   
            rd.forward(request, response);
           }
        else if(action.equals("Insert")) {
            System.out.println("In Insert");
            String ast;
             int id;
            ast = request.getParameter("sid");
            id=Integer.parseInt(ast);
            System.out.println("id retrieve " + id); 
            StudentInfoDB s2 = new StudentInfoDB();
            s2.insertDB(id, p, fn, lsn, st, c, st, sa, em, 0.0); 
            s2.display();
           
            ses1.setAttribute("s1",s2);
            rd = request.getRequestDispatcher("/insertStudent.jsp");   
            rd.forward(request, response);
           }
        else if(action.equals("Update")){
            System.out.println("In Update"); 
           
            String ast;
            int id;
            ast = request.getParameter("sid");
            id=Integer.parseInt(ast);
            System.out.println("id retrieve " + id); 
            StudentInfoDB s3 = new StudentInfoDB();
            s3.selectDB(id);
            s3.setPassw(p);
            s3.setFirstN(fn);
            s3.setLastN(lsn);
            s3.setStreet(st);
            s3.setCity(c);
            s3.setState(stat);
            s3.setZipCode(sa);
            s3.setEMail(em);
            s3.updateDB();
            s3.display();
            
             ses1.setAttribute("s1",s3);
            rd = request.getRequestDispatcher("/updateStudent.jsp");   
            rd.forward(request, response);
        }
        else if(action.equals("Delete")) {
               System.out.println("In Delete"); 
               
                String ast;
            int id;
            ast = request.getParameter("sid");
            id=Integer.parseInt(ast);
            System.out.println("id retrieve " + id); 
            
                StudentInfoDB s4 = new StudentInfoDB();
                
                s4.selectDB(id);
                s4.DeleteDB();
             ses1.setAttribute("s1",s4);
            rd = request.getRequestDispatcher("/deleteStudent.jsp");   
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
