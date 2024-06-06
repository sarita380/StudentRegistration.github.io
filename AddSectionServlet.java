/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Business.SectionsDB;
import Business.CoursesDB;
import Business.InstructorsDB;
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
@WebServlet(urlPatterns = {"/AddSection"})
public class AddSectionServlet extends HttpServlet {

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
            
            String action = request.getParameter("ac");
            
          // String id = request.getParameter("crn");
           //int sid = Integer.parseInt(id);
          // System.out.println(sid);
           
           String course;
           course= request.getParameter("curid");
           
           String timeDays;
           timeDays= request.getParameter("days");
           String room;
           room= request.getParameter("room");
         //  String instructor = request.getParameter("ins");
          // int in = Integer.parseInt(instructor);
           if (action.equals("Find")){
               
              System.out.println("In find");
               
           String ast;
           int id;
           ast= request.getParameter("crn");
           id = Integer.parseInt(ast);
           System.out.println(id);
           
           SectionsDB s1 =new SectionsDB();
           
           s1.selectSect(id);
           s1.displaySect();
           
           ses1.setAttribute("s1", s1);
           
           rd = request.getRequestDispatcher("/addNewSection.jsp");
           rd.forward(request, response);
           
           }else if (action.equals("Insert"))
           {
           System.out.println("Insert!");
           
            String ast;
           int id;
           ast= request.getParameter("crn");
           id = Integer.parseInt(ast);
           System.out.println(id);
           
           SectionsDB s2 =new SectionsDB();
           
           s2.insertSect(id, course, timeDays, room, id);
           s2.displaySect();
           
           ses1.setAttribute("s1", s2);
           rd = request.getRequestDispatcher("/findSection.jsp");
           rd.forward(request, response);
          
           }else if(action.equals("Delete"))
                 {
              System.out.println("Delete!");
           
            String ast;
           int id;
           ast= request.getParameter("crn");
           id = Integer.parseInt(ast);
           System.out.println(id);
           
           SectionsDB s3 =new SectionsDB();
           
           s3.selectSect(id);
           s3.deleteSection();
           
           
           ses1.setAttribute("s1", s3);
           rd = request.getRequestDispatcher("/deleteCourse.jsp");
           rd.forward(request, response);    
                 }else if (action.equals("Update"))
                 {
                     System.out.println("Updated");
                     
              String ast;
           int id;
           ast= request.getParameter("crn");
           id = Integer.parseInt(ast);
           System.out.println(id);
           
           SectionsDB s4 =new SectionsDB();   
           s4.selectSect(id);
           s4.setCoursecrn(id);
           s4.setCourid(course);
           s4.setTimed(timeDays);
           s4.setRoom(room);
           s4.setInstr(id);
           
           ses1.setAttribute("s1", s4);
           
           rd = request.getRequestDispatcher("/updCourse.jsp");
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
