/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(urlPatterns = {"/AddInstructorServlet"})
public class AddInstructorServlet extends HttpServlet {

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
            
          RequestDispatcher rda;
          
           HttpSession ses1=request.getSession();
           
           String action;
           action = request.getParameter("act");
           
           System.out.println("button print" + action);
           
           //String id;
          // id= request.getParameter("iid");
          // int sid = Integer.parseInt(id);
          // System.out.println(sid);
           
           String fname= request.getParameter("fnm");
           String lname= request.getParameter("lastn");
           String stree= request.getParameter("stre");
           String city= request.getParameter("ct");
           String state= request.getParameter("ste");
          // String zipc = request.getParameter("zp");
          // int z =Integer.parseInt(zipc);
           String office= request.getParameter("of");
           String em= request.getParameter("email");
           
            if(action.equals("Find")){
            System.out.println("In Find"); 
            String ast;
            int id;
            ast = request.getParameter("iid");
            id=Integer.parseInt(ast);
            System.out.println("id retrieve " + id); 
            InstructorsDB s1 = new InstructorsDB();
            s1.selectInstDB(id);
            s1.displayInstructor();
            
            ses1.setAttribute("s1",s1);
            rda = request.getRequestDispatcher("/AddInstructor.jsp");   
            rda.forward(request, response);
           }
           
            else if(action.equals("Insert")){
     
           System.out.println("in insert");
           
           String ast;
            int id;
            ast = request.getParameter("iid");
            id=Integer.parseInt(ast);
            System.out.println("id retrieve " + id);
            
            InstructorsDB s2 = new InstructorsDB();
            s2.insertInstDB(id, fname, lname, stree, city, state, 0, office, em);
            
            s2.displayInstructor();
            ses1.setAttribute("s1", s2);
            rda = request.getRequestDispatcher("/insertInstructor.jsp");
            rda.forward(request, response);
           
           }else if (action.equals("Update"))
           {
               System.out.println("in Update");
               
               String ast;
            int id;
            ast = request.getParameter("iid");
            id=Integer.parseInt(ast);
            System.out.println("id retrieve " + id);
            
            InstructorsDB s3 = new InstructorsDB();
            s3.selectInstDB(id);
            s3.setIname(fname);
            s3.setLastname(lname);
            s3.setInstreet(stree);
            s3.setIncity(city);
            s3.setInstate(state);
            //s3.setInzip(id);
            s3.setInoff(office);
            s3.setInemail(em);
            s3.updateInstDB();
            s3.displayInstructor();
            
            ses1.setAttribute("s1", s3);
            rda = request.getRequestDispatcher("/updateInstructor.jsp");
            rda.forward(request, response);
           }
           else if(action.equals("Delete"))
           {
               System.out.println("In Delete");
               
               String ast;
            int id;
            ast = request.getParameter("iid");
            id=Integer.parseInt(ast);
            System.out.println("id retrieve " + id); 
            InstructorsDB s4 = new InstructorsDB();
            
            s4.selectInstDB(id);
            s4.DeleteInstDB();
            
            ses1.setAttribute("s1", s4);
            rda = request.getRequestDispatcher("/deleteInstructor.jsp");
            rda.forward(request, response);
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
