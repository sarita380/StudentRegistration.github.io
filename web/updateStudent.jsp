<%-- 
    Document   : updateStudent
    Created on : Nov 18, 2014, 11:27:35 PM
    Author     : Sara
--%>

<%@page import="Business.StudentInfoDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student </title>
    </head>
        <body  bgcolor="#E6E6FA">
        
        <h1>Update Student Information</h1>
          <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
         <form name="insertinfo" method="post" action="http://localhost:8084/StudentRegistration/UpdateStudInfo">
       
        <%
            String passw, fname, lname, street, city, state, email;
            int id, zip;
            
            try
            {StudentInfoDB s1 = (StudentInfoDB)session.getAttribute("s1");
                id=0;
                passw=s1.getPassw();
                fname=s1.getFirstN();
                lname=s1.getLastN();
                street=s1.getStreet();
                city=s1.getCity();
                state=s1.getState();
                zip=s1.getZipCode();
                email=s1.getEMail();
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
             <br>
            
           </table>
        <br/>
        <a href="mainAdmin.jsp">Back to main page</a>
        </form>
    </body>
</html>
