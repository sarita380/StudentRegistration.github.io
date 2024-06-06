<%-- 
    Document   : insertStudent
    Created on : Nov 18, 2014, 9:56:10 PM
    Author     : Sara
--%>

<%@page import="Business.StudentInfoDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Student Information</title>
    </head>
   <body  bgcolor="#E6E6FA">
         <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
         <form name="insertinfo" method="post" action="http://localhost:8084/StudentRegistration/addStudServlet">
        <h1>Student Information inserted</h1>
        <%
            String passw, fname, lname, street, city, state, email;
            int id, zip;
            
            try
            {StudentInfoDB s2 = (StudentInfoDB)session.getAttribute("s1");
                id=s2.getStuId();
                passw=s2.getPassw();
                fname=s2.getFirstN();
                lname=s2.getLastN();
                street=s2.getStreet();
                city=s2.getCity();
                state=s2.getState();
                zip=s2.getZipCode();
                email=s2.getEMail();
            }
            
             
            catch(Exception e){
                id=0;
                passw="";
                fname="";
                lname="";
                street="";
                city="";
                state="";
                zip=0;
                email="";
                
            }
            
            
            
            %>
         <table cellspacing="5" border="3"> 
               <tr>
                <td align="left"> Student ID:</td>
                <td><input type ="text" name="sid" value="<%=id%>" ></td> 
                
            </tr>
             <tr>
                <td align="left"> Password:</td>
                <td><input type ="text" name="p" value="<%=passw%>" ></td>
                 
            </tr>
            <tr>
                <td align="left">First Name:</td>
                <td><input type ="text" name="fm" value="<%=fname %>" ></td>
                  
            </tr>
            <tr>
                <td align="left"> Last Name:</td>
                <td><input type ="text" name="la" value="<%=lname %>" >
            </tr>  
             <tr>
                <td align="left">Street:  </td>
                <td><input type ="text" name="se" value="<%=street %>" >
            </tr> 
             <tr>
                <td align="left"> City:</td>
                  
                <td><input type ="text" name="cy" value="<%=city %>" >
            </tr>
             <tr>
                 <td align="left">State:</td>
                 <td><input type ="text" name="sa" value="<%=state %>" >
            </tr> 
             <tr>
                <td align="left">Zip:</td>
                <td><input type ="text" name="zp" value="<%=zip%>" >
            </tr> 
             <tr>
                <td align="left">EMail:</td>
                <td><input type ="text" name="m" value="<%=email%>" >
            </tr> 
             
           </table>
        <br>
        <a href="mainAdmin.jsp">Back to main page</a>
        </form>
    </body>
</html>
