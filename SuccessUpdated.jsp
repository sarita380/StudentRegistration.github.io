<%-- 
    Document   : SuccessUpdated
    Created on : Nov 17, 2014, 5:28:29 PM
    Author     : Sara
--%>

<%@page import="Business.StudentInfoDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UpDate Stud Info</title>
    </head>
    <body  bgcolor="#E6E6FA">
          <img src = "chattahoochee.png" alt = "" width ="200" height="200"/>
        <h1>Student Information Updated!</h1>
        <%--
        <h1>Student Information Updated!</h1>
        
         <form name="insertinfo" method="post" action="http://localhost:8084/StudentRegistration/lookupStudInfo">
       
        <%
            String passw, fname, lname, street, city, state, email;
           // int zip;
            
            try
            {StudentInfoDB s3 = (StudentInfoDB)session.getAttribute("s1");
             
                passw=s3.getPassw();
                fname=s3.getFirstN();
                lname=s3.getLastN();
                street=s3.getStreet();
                city=s3.getCity();
                state=s3.getState();
               // zip=s3.getZipCode();
                email=s3.getEMail();
            }
            
             
            catch(Exception e){
                passw="";
                fname="";
                lname="";
                street="";
                city="";
                state="";
              //  zip=0;
                email="";
                
            }
            
            
            
            %>
         <table cellspacing="5" border="3"> 
               <tr>
                <td align="left"> Student ID:</td>
                <td><input type ="text" name="sid" value="" ></td> 
                
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
                <td><input type ="text" name="zp" value="" >
            </tr> 
             <tr>
                <td align="left">EMail:</td>
                <td><input type ="text" name="m" value="<%=email%>" >
            </tr> 
             
           </table>
        <br/>
        </form>--%>
    </body>
</html>
