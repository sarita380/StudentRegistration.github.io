<%-- 
    Document   : DisplayNewStud
    Created on : Nov 14, 2014, 11:44:31 PM
    Author     : Sara
--%>

<%@page import="Business.StudentInfoDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert New Student</title>
    </head>
    <body  bgcolor="#E6E6FA">
          <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
         <form name="changeinfo" method="post" 
         action="http://localhost:8084/StudentRegistration/addStudent.jsp">
             <%--<% StudentInfoDB ac;
                ac = (StudentInfoDB)session.getAttribute("sid");
                ac.display();
                
                
                %> --%>
        
        <h1><font color="#4B8A08">New Student Admit</font></h1>
        <h3>Your information was successfully Inserted</h3>
        <%-- <table cellspacing="5" border="0"> 
               <tr>
                <td align="left"> Student ID:</td>
               <td><input type ="text" name="sid" value="" ></td> 
                
            </tr>
            <tr>
                <td align="left"> Password:</td>
                <td><input type ="text" name="p" value="" ></td>
                 
            </tr>
            <tr>
                <td align="left">First Name:</td>
                <td><input type ="text" name="fm" value="" ></td>
                  
            </tr>
            <tr>
                <td align="left"> Last Name:</td>
                <td><input type ="text" name="la" value="" >
            </tr>  
             <tr>
                <td align="left">Street:  </td>
                <td><input type ="text" name="se" value="" >
            </tr> 
             <tr>
                <td align="left"> City:</td>
                  
                  <td><input type ="text" name="cy" value="" >
            </tr>
             <tr>
                 <td align="left">State:</td>
                  <td><input type ="text" name="sa" value="" >
            </tr> 
             <tr>
                <td align="left">Zip:</td>
                <td><input type ="text" name="zp" value="" >
            </tr> 
             <tr>
                <td align="left">EMail:</td>
                <td><input type ="text" name="m" value="" >
            </tr> 
        </table>--%>
         </form>
    </body>
</html>
