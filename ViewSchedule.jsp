<%-- 
    Document   : ViewSchedule
    Created on : Nov 17, 2014, 12:24:59 PM
    Author     : Sara
--%>

<%@page import="Business.InstructorsDB"%>
<%@page import="Business.SectionsDB"%>
<%@page import="Business.StudentInfoDB"%>
<%@page import="Business.schedule"%>
<%@page import="Business.CoursesDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Student Schedule</title>
    </head>
    <body bgcolor="#E6E6FA">
          <img src = "chattahoochee.png" alt = "" width ="300" height="150"/>
    <form name="schedule" action="">
    
        <p>Enter the Course CRN to Add or drop to your schedule</p>
        <table>
            <tr>
                <td><input type="submit" name="action" value="Add"/></td>
                <td><input type="text" name="addCRN" value=""/></td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Drop"/></td>
                <td><input type="text" name="dropCRN" value=""/></td>
            </tr>
        </table>   
        
        <h1>Display Schedule</h1>
        <table border="3">
            <tr>
                 <td>CRN</td>
                 <td>Course ID</td>
                 <td>Time Days</td>
                 <td>Room number</td>
                 <td>Instructor</td>
            </tr>
             <%--  
            <% StudentInfoDB  s1;
            s1 =(StudentInfoDB)session.getAttribute("s1");
            s1.aList.displaySched();
            SectionsDB sec1;
            System.out.println(s1.aList.count);
            String name;
            for(int x=0; x<s1.aList.count; x++){
           
            sec1=(SectionsDB)s1.aList.alist.get(x);
            sec1.displaySect();
            
            int iid; 
            iid = sec1.getInstr();
            InstructorsDB il = new InstructorsDB();
            il.selectInstDB(iid);
            name=il.getIname() +" " + il.getLastname();
   
            %>
        <tr>
            <td><%=sec1.getCoursecrn()%></td>
            <td><%=sec1.getCourid()%></td>
            <td><%=sec1.getTimed()%></td>
            <td><%=sec1.getRoom() %></td>
        </tr>
            <%
            }
            %>
         </table>
    
    </form>  --%>
        <a href="DisplayStudInfo.jsp">return to the Student Information</a>
        <br>
        <a href="DisplyCoursesList" >View Courses List</a>
         </body>
</html>
