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
public class SectionsDB {
    
    private int crn;
    private String courseid;
    private String timed;
    private String room;
    private int instid;
    public  ScheduleList aList = new ScheduleList();
    
 //getters and setters  
    
    public int getCoursecrn() {
        return this.crn;
    }
    public void setCoursecrn(int crn) {
        this.crn = crn;
    }
    public String getCourid() {
        return this.courseid;
    }
    public void setCourid(String courseid) { 
        this.courseid = courseid;
    }
    public String getTimed() {
        return this.timed;
    }
    public void setTimed(String timed) { 
        this.timed = timed;
    }
    
    public String getRoom() {
        return this.room;
    }
    public void setRoom(String room) { 
        this.room = room;
    }
    public int getInstr() {
        return this.instid;
    }
    public void setInstr(int instid) { 
        this.instid = instid;
    }
    //method with no arguments
    public void SectionsDB(){
    
        crn = 0;
        courseid="";
        timed = "";
        room = "";
        instid=0;
    }
    
    public void SectionsDB(int cn, String ci, String td, String rn, int in ){
    
        crn = cn;
        courseid= ci;
        timed = td;
        room = rn;
        instid=in;
    }
    
    public void displaySect(){
    
        System.out.println("CRN: " + crn);
        System.out.println("CourseID: " + courseid);
        System.out.println("Time Days: " + timed);
        System.out.println("Room No: " + room);
        System.out.println("Instructor: " + instid);
        aList.displaySched();
    
    }
    
    public void selectSect(int c){
    
        crn=c;
    
         try{
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection c1;
	c1 = DriverManager.getConnection("jdbc:odbc:RonDB");
	Statement statement = c1.createStatement();
	String sql = "Select * from Sections where CRN = "+c;
	
        System.out.println(sql);
	ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        
        courseid = resultSet.getString(2);
        timed = resultSet.getString(3); 
        room = resultSet.getString(4);
        instid = resultSet.getInt(5);
        
         findStudSched();   
         c1.close();   
        }catch(Exception se){
            System.out.println(se);
        }
    }
    public void findStudSched(){
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection cf;
            cf = DriverManager.getConnection("jdbc:odbc:RonDB");
            Statement st = cf.createStatement();
            String sql = "Select CRN from StudentSchedule where StudentID = " + crn;
            System.out.println(sql);
            ResultSet resultSet = st.executeQuery(sql);
             
            resultSet.next();
            
            String an = "";
            StudScheduleDB s1;
            while(resultSet.next()){
            s1 = new StudScheduleDB();
            an = resultSet.getString(1);
            System.out.println(an);
            s1.selectStudSched(crn);
            aList.addSchedule(s1);
            }
            cf.close();
        }catch(Exception ex){
            System.out.println(ex);
         }
        }
     public void insertSect(int cn, String cd, String td, String rn,
		 int ins){
		
		crn=cn;
                courseid =cd;
                timed=td;
		room=rn;
                instid=ins;

		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c2;
		c2 = DriverManager.getConnection("jdbc:odbc:RonDB");
		Statement stm = c2.createStatement();
		String sql = "Insert into Sections values (" + cn  + ",'"
							        + cd + "','"
							        + td + "','"
							        + rn + "',"
                                                        	+ ins +  ")";
							        
							        
							        
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
 
     public  void deleteSection(){
	try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c4;
		c4 = DriverManager.getConnection("jdbc:odbc:RonDB");
		Statement stt = c4.createStatement();
		String sql = "Delete from Sections Where CRN = "+crn;							
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
     
    
public void updateSect(){
		
	try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c3;
		c3 = DriverManager.getConnection("jdbc:odbc:RonDB");
		Statement stm = c3.createStatement();
		 
		String sql ="Update Sections set CourseID = '"+courseid+"',"+
						    "TimeDays = '"+timed+"',"+
						    "RoomNo = '"+room+"',"+
						    "Instructor= '"+instid+"'"+
                                                    " Where CRN ="+crn;
									
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
     
public static void main (String[]args){

//SectionsDB s1 = new SectionsDB();
//s1.selectSect(30101);
//s1.displaySect();

//SectionsDB s2 = new SectionsDB();
//s2.insertSect(30001,"SVA 0000", "LNS2-7pm",  "F4444", 10);
//s2.displaySect();
    
//SectionsDB s3 = new SectionsDB();
//s3.selectSect(30001);
//s3.deleteSection();
    
//SectionsDB s4 = new SectionsDB();
//s4.selectSect(30001);
//s4.setTimed("SAB7-9pm");
//s4.updateSect();

SectionsDB c5;
c5 = new SectionsDB();
c5.selectSect(30101);
c5.displaySect();
int id = c5.getCoursecrn();
}
}


