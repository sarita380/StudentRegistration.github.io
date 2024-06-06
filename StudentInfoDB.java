/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;
import java.sql.*;
/**
 *
 * @author Sara
 */
public class StudentInfoDB {


private int sid;
private String password;
private String firstName;
private String lastName;
private String street; 
private String city;
private String state;
private int zipCode;
private String office;
private String email;
private double gpa;
public  ScheduleList aList = new ScheduleList();

public int getStuId() {
        return this.sid;
    }

public void setStuId(int sid) {
        this.sid = sid;
    }
public String getPassw() {
        return this.password;
    }

public void setPassw(String password) {
        this.password = password;
    }
public String getFirstN() {
        return this.firstName;
    }

public void setFirstN(String firstName) {
        this.firstName= firstName;
    }
public String getLastN() {
        return this.lastName;
    }

public void setLastN(String lastName) {
        this.lastName= lastName;
    }

	public String getStreet() {
        return this.street;
    }

public void setStreet(String street) {
        this.street= street;
    }
	
	public String getCity() {
        return this.city;
    }

public void setCity(String city) {
        this.city= city;
    }
public String getState() {
        return this.state;
    }

public void setState(String state) {
        this.state= state;
    }

public int getZipCode() {
        return this.zipCode;
    }

public void setZipCode(int zipCode) {
        this.zipCode= zipCode;
    }	
	
public String getOffice() {
        return this.office;
    }

public void setOffice(String office) {
        this.office= office;
    }	

public String getEMail() {
        return this.email;
    }

public void setEMail(String email) {
        this.email= email;
    }	

	public double getGpa() {
        return this.gpa;
    }

public void setGpa(double gpa) {
        this.gpa= gpa;
    }		
public StudentInfoDB(){
        sid= 0;
        password="";
	firstName="";
	lastName="";
	street="";
	city="";
	state="";
	zipCode=0;
	office="";
	email="";
	gpa= 0.0;
}
public StudentInfoDB(int s,String psw, String fn, String ln,
		String st, String ct, String ste, int zc,  
		String em, double g){
		
		sid=s;
                password=psw;
		firstName=fn;
		lastName=ln;
		street=st;
		city=ct;
		state=ste;
		zipCode=zc;
		//office=ofc;
		email=em;	
		gpa= g;
}

public void display(){
System.out.println("StudentID: " + sid);
System.out.println("Password: " + password);
System.out.println("First Name: " + firstName);	
System.out.println("Last Name: " + lastName);
System.out.println("Street: " + street);
System.out.println("City " + city);
System.out.println("State: " + state);
System.out.println("ZipCode: " + zipCode);
System.out.println("Email: " + email);
System.out.println("GPA: " + gpa);
aList.displaySched();


}
public void selectDB(int s){
	sid = s;
	try{
	
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection c1;
	c1 = DriverManager.getConnection("jdbc:odbc:RonDB");
	Statement statement = c1.createStatement();
	String sql = "Select * from Students where ID = "+s;
	//String sql = "Select * from Students where ID  = '"+s+"'";
        System.out.println(sql);
	ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        
        password = resultSet.getString(2);
        //System.out.println("Password from DB="+password);
        firstName = resultSet.getString(3);
        lastName = resultSet.getString(4);
        street = resultSet.getString(5);
        city = resultSet.getString(6);
        state = resultSet.getString(7);
        zipCode = resultSet.getInt(8);
        email = resultSet.getString(9);
        gpa = resultSet.getDouble(10);
        
        findStudSched();
	c1.close();
	
	}catch(Exception ex){
		System.out.println("sorry not connection" + ex);
	}
	
}
public void findStudSched(){
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection cf;
            cf = DriverManager.getConnection("jdbc:odbc:RonDB");
            Statement st = cf.createStatement();
            String sql = "Select CRN from StudentSchedule where StudentID = " + sid;
            System.out.println(sql);
            ResultSet resultSet = st.executeQuery(sql);
             
            resultSet.next();
            
            String an = "";
            StudScheduleDB s1;
            while(resultSet.next()){
            s1 = new StudScheduleDB();
            an = resultSet.getString(1);
            System.out.println(an);
            s1.selectStudSched(sid);
            aList.addSchedule(s1);
            }
            cf.close();
        }catch(Exception ex){
            System.out.println(ex);
         }
        }
public void insertDB(int s,String p, String fn, String ln,
		String st, String ct, String ste, int zc, 
		String em, double g){
		
		sid=s;
                password =p;
		firstName=fn;
		lastName=ln;
		street=st;
		city=ct;
		state=ste;
		zipCode=zc;
		email=em;	
		gpa= g;
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c2;
		c2 = DriverManager.getConnection("jdbc:odbc:RonDB");
		Statement stm = c2.createStatement();
		String sql = "Insert into Students values (" + s  + ",'"
                                                             + p  + "','"
							     + fn + "','"
	    						     + ln + "','"
							     + st + "','"
							     + ct + "','"
							     +ste + "',"
						   	     + zc + ",'"
							     + em + "',"
				 			     + g  + ")";
		System.out.println(sql);
		int n = stm.executeUpdate(sql);
		if(n==1)
			System.out.println("Insert Succeeded!! ");
		else 
			System.out.println("Insert Failed!!");
		c2.close();	
			
		}catch(Exception se){
		System.out.println(se);
		}

}
public void updateDB(){
		
	try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c3;
		c3 = DriverManager.getConnection("jdbc:odbc:RonDB");
		Statement stm = c3.createStatement();
		 
		String sql = "Update Students set FirstName = '"+firstName+"',"+
									 "LastName= '"+lastName+"',"+
									 "Street= '"+street+"',"+
									 "City= '"+city+"',"+
									 "State='"+state+"',"+
									 "Zip="+zipCode+","+
									 "EMail='"+email+"',"+
									 "GPA="+gpa+
									 " Where ID ="+sid;
									
		System.out.println(sql);
		int n = stm.executeUpdate(sql);
		if(n==1)
			System.out.println("Update Succeeded!! ");
		else 
			System.out.println("Update Failed!!");
			c3.close();
	}catch(Exception se){
		System.out.println(se);
	}
}
public  void DeleteDB(){
	try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c4;
		c4 = DriverManager.getConnection("jdbc:odbc:RonDB");
		Statement stt = c4.createStatement();
		String sql = "Delete from Students Where ID = "+sid;							
		System.out.println(sql);
		int x = stt.executeUpdate(sql);
		
		if (x==1)
			System.out.println("Delete Succeeded!!");
			else
			System.out.println("Delete FAILED!!");
		
		c4.close();
	}catch(Exception se){
		System.out.println(se);
	}
}
public static void main (String[]args){

    //StudentInfoDB s1 = new StudentInfoDB();
//s1.selectDB(7);
//s1.display();
 
//StudentInfoDB s2 = new StudentInfoDB();
//s2.insertDB(300, "0000","Frank", "Mayes", "123 Main Street", "Atlanta", "GA", 30100, "fmayes@yahoo.com", 3.3f);
//s2.display();
 
//StudentInfoDB s3 = new StudentInfoDB();
 //s3.selectDB(30);
// s3.DeleteDB();
 
//StudentInfoDB s4 = new StudentInfoDB();
//s4.selectDB(30);
//s4.setZipCode(30062);
//s4.updateDB();
 
StudentInfoDB c5;
c5 = new StudentInfoDB();
c5.selectDB(7);
c5.display();
int id = c5.getStuId();

	}

  
}

