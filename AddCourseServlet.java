/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Business.CoursesDB;
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
@WebServlet(urlPatterns = {"/AddCourseServlet"})
public class AddCourseServlet extends HttpServlet {

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
           
           HttpSession ses1 = request.getSession();
           
           
           String action;
           action = request.getParameter("ac");
           
             System.out.println("button print" + action);
 
            String c;
            c= request.getParameter("crid");
            System.out.println("courseID " + c);
            
            String cnm;
            cnm= request.getParameter("cnm");
            System.out.println("CourseName " + cnm);
            
             String ds;
            ds= request.getParameter("descp");
            System.out.println("description " + ds);
            
           
            
           if (action.equals("Find"))
           {
               System.out.println("In Find" );
               
               String ast;
               
               ast=request.getParameter("crid");
               CoursesDB s1 = new CoursesDB();
               s1.selectCourseDB(c);
               s1.displayCourse();
               
               ses1.setAttribute("s1", s1);
               rd = request.getRequestDispatcher("/AddCourse.jsp");
               rd.forward(request, response);
     
           }else if(action.equals("Insert"))
           {
               System.out.println("In insert");
               
               String ast;
               ast= request.getParameter("crid");
               
               CoursesDB s2 = new CoursesDB();
               s2.insertCourseDB(c, cnm, ds, 0);
               s2.displayCourse();
               
               ses1.setAttribute("s1", s2);
               
               rd = request.getRequestDispatcher("/insertCourse.jsp");
               rd.forward(request, response);
           }
           else if (action.equals("Delete"))
           {
               System.out.println("In Delete");
               
               String ast = request.getParameter("crid");
               
               CoursesDB s3 = new CoursesDB();
               s3.selectCourseDB(ast);
               s3.DeleteCourseDB();
               
               ses1.setAttribute("s1", s3);
               
               rd=request.getRequestDispatcher("/deleteCourse.jsp");
               rd.forward(request, response);
           }else if (action.equals("Update"))
          {
          System.out.println("In Update ");
          
           String ast = request.getParameter("crid");
               
               CoursesDB s4 = new CoursesDB();
               
               s4.selectCourseDB(ast);
               s4.setCurId(c);
               s4.setCname(cnm);
               s4.SetDescr(ds);
               s4.updateCourseDB();
               s4.displayCourse();
               
               ses1.setAttribute("s1", s4);
               rd = request.getRequestDispatcher("/updateCourse.jsp");
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
