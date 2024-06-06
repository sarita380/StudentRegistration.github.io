/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;
import java.sql.*;
/****************************************
 *      Course Business Object
 * 
 ***************************************/
public class CoursesDB {
    /*********************************
    //properties
    **********************************/
    private String curid;
    private String curname;
    private String descript;
    private int cred;
    /***********************************
    //  getters and setters
    ************************************/
    public String getCurId() {
        return this.curid;
    }
    public void setCurId(String curid) {
        this.curid = curid;
    }
    public String getCname() {
        return this.curname;
    }
    public void setCname(String curname) {
        this.curname = curname;
    }
    public String getDescr(){
        return this.descript;
    }
    public void SetDescr(String descript){
        this.descript = descript;
    }
    public int getCred(){
        return this.cred;
    }
    public void SetCred(int cred){
        this.cred = cred;
    }
    /**************************************************
    //method with empty parameters
    ***************************************************/
    public CoursesDB(){
    curid = "";
    curname = "";
    descript = "";
    cred = 0;
    }
    /******************************************************
    //method with all properties parameter
    ********************************************************/
    public CoursesDB(String ci, String cname, String dsc, int cd){
    
        curid = ci;
        curname = cname;
        descript = dsc;
        cred = cd;
    }
    /****************************************************
    //method to display 
    *****************************************************/
    public void displayCourse(){
        System.out.println("CourseID: " + curid);
        System.out.println("CourseName: " + curname);
        System.out.println("Description: " + descript);	
        System.out.println("Credit Hours: " + cred);
        }
    
    public void selectCourseDB(String c){
        curid = c;
        try{
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection c1;
	c1 = DriverManager.getConnection("jdbc:odbc:RonDB");
	Statement statement = c1.createStatement();
	String sql = "Select * from Courses where CourseID = '"+c+"'";
	
        System.out.println(sql);
	ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        
        curname = resultSet.getString(2);
        descript = resultSet.getString(3);
        cred = resultSet.getInt(4);   
            
         c1.close();   
        }catch(Exception se){
            System.out.println(se);
        }
    }  
        public void insertCourseDB(String ci, String cname, String dsc,int cd){
		
		curid=ci;
		curname=cname;
		descript=dsc;
		cred=cd;
        try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c2;
		c2 = DriverManager.getConnection("jdbc:odbc:RonDB");
		Statement stm = c2.createStatement();
                String sql = "Insert into Courses values ('"+ci+"','"
							     +cname+"','"
							     +dsc+"',"
							     +cd +")";
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
public  void DeleteCourseDB(){
                
	try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c4;
		c4 = DriverManager.getConnection("jdbc:odbc:RonDB");
		Statement stt = c4.createStatement();
		//String sql = "Delete from Courses Where CourseID = " + curid;
                 String sql = "Delete from Courses Where CourseID= '"+curid+"'";	
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
public void updateCourseDB(){
		
	try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c3;
		c3 = DriverManager.getConnection("jdbc:odbc:RonDB");
		Statement stm = c3.createStatement();
		 
		String sql = "Update Courses set CourseName = '"+curname+"',"+
					        "Description= '"+descript+"',"+
					       "CreditHours= "+cred+
					   " Where CourseID='"+curid+"'";
                
              							
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

//CoursesDB s1 = new CoursesDB();
//s1.selectCourseDB("CIST 1510");
//s1.displayCourse();

CoursesDB s2 = new CoursesDB();
s2.insertCourseDB( "CIST 1000", "psycology", "psy", 1);
s2.displayCourse();
        
//CoursesDB s3 = new CoursesDB();
//s3.selectCourseDB("CIST 1000");
//s3.DeleteCourseDB();
        
//CoursesDB s3 = new CoursesDB();
//s3.selectCourseDB("SARA 7000");
//s3.setCname("WebDevelopment III");
//s3.updateCourseDB();


    }
    }

