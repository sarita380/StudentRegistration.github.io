/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Business.StudScheduleDB;
import Business.SectionsDB;
import Business.StudentInfoDB;
import Business.schedule;
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
@WebServlet(urlPatterns = {"/scheduleListServlet"})
public class scheduleListServlet extends HttpServlet {

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
          
            
           String action;
          
           
           String crn=null;
           int sid = Integer.parseInt(crn);
         
           
           HttpSession ses1 = request.getSession();
           StudentInfoDB s1 = (StudentInfoDB)ses1.getAttribute("s1");
           
            action = request.getParameter("action");
           
           if(action.equals("Add"))
           {
        
            System.out.println("In Add");
            crn=request.getParameter("addCRN");
            int crnd = Integer.parseInt(crn);
            SectionsDB sec1 = new SectionsDB();
            sec1.selectSect(crnd);
            //s1.aList.addSection(sec1);
           }
           
           if (action.equals("Drop"))
           {
           System.out.println("In Drop");
           crn = request.getParameter("dropCRN");
           int crnd = Integer.parseInt(crn);
           SectionsDB sec1 = new SectionsDB();
           sec1.selectSect(crnd);
          // s1.aList.dropSections(sec1);
           }
           System.out.println(crn);
           RequestDispatcher rd;
          rd=request.getRequestDispatcher("/ViewSchedule.jsp");
          rd.forward(request, response);
           
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
