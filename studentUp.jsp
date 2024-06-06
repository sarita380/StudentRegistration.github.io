<%-- 
    Document   : studentUp
    Created on : Nov 21, 2014, 8:10:30 PM
    Author     : Sara
--%>

<%@page import="Business.StudentInfoDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
     <body  bgcolor="#E6E6FA">
         <h1><font color="#4B8A08">View and Update Personal Information </font></h1>
           <img src = "chattahoochee.png" alt = "" width ="400" height="150"/>
            
         <form name="changeinfo" method="post" 
         action="http://localhost:8084/StudentRegistration/studentUpServlet">
           
       
        <%
            String passw, fname, lname, street, city, state, email;
            int id,zip;
            
            try
            {StudentInfoDB s1 = (StudentInfoDB)session.getAttribute("s1");
                
                id=s1.getStuId();
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
                <td><input type ="text" name="p" value="<%=passw %>" ></td>
                 
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
                <td><input type ="text" name="m" value="<%=email %>" >
            </tr> 
             
           </table>
        <br/>
       
        <input type ="submit" name ="sb" value ="Update">
       
        <input type ="reset" name ="reset" value ="clear">
        </form>
       <br/>
        <a href="DisplayStudInfo.jsp">Back to main page</a> 
    </body>
</html>
