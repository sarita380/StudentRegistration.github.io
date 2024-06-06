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
public class StudScheduleDB {
    
    // public StudentInfoDB[] alist= new StudentInfoDB[10];
    private int studid;
    private int cr;
    
   /* public void addSchedule(StudentInfoDB a1){
        alist[studid]= a1;
        studid++;
    }
    
    public void displaySched(){
     for(int x=0; x<studid; x++)  
         alist[x].display();
    }*/
    public int GetSid(){
    return this.studid;
    }
    public void SetSid(int si){
    studid = si;
    }
    
     public int GetCrn(){
    return this.cr;
    }
    public void SetCrn(int cn){
    cr = cn;
    }
    
    
    public void StudScheduleDB(){
    
        studid = 0;
        cr=0;
        
    }
    
    public void StudScheduleDB(int cn, int in ){
    
        studid = cn;
        cr= in;
        
    }
     public void displayStudSched(){
    
        System.out.println("Student ID: " + studid);
        System.out.println("CRN: " + cr);
       

    }
    public void selectStudSched(int sti){
    
        studid=sti;
    
         try{
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection c1;
	c1 = DriverManager.getConnection("jdbc:odbc:RonDB");
	Statement statement = c1.createStatement();
	String sql = "Select * from StudentSchedule where StudentID = "+sti;
	
        System.out.println(sql);
	ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        
        cr = resultSet.getInt(2);

         c1.close();   
        }catch(Exception se){
            System.out.println(se);
        }
    }
    
     public void insertStudSched(int cn,int ins){
		
		studid=cn;
                cr = ins;
        try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c2;
		c2 = DriverManager.getConnection("jdbc:odbc:RonDB");
		Statement stm = c2.createStatement();
		String sql = "Insert into StudentSchedule values (" + cn  + ","    
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
     public  void deleteStudSched(){
	try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c4;
		c4 = DriverManager.getConnection("jdbc:odbc:RonDB");
		Statement stt = c4.createStatement();
		String sql = "Delete from StudentSchedule Where StudentID = "+studid;							
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
     
     public void updateSched(){
		
	try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c3;
		c3 = DriverManager.getConnection("jdbc:odbc:RonDB");
		Statement stm = c3.createStatement();
		 
		String sql ="Update StudentSchedule set CRN = "+cr+" "+
						    
                                                    " Where StudentID ="+studid;
									
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

StudScheduleDB s1 = new StudScheduleDB();
s1.selectStudSched(1);
s1.displayStudSched();

//StudScheduleDB s2 = new StudScheduleDB();
//s2.insertStudSched(0, 10010);
//s2.displayStudSched();
        
 //StudScheduleDB s3 = new StudScheduleDB();
 //s3.selectStudSched(0);
 //s3.deleteStudSched();
        
 //StudScheduleDB s4 = new StudScheduleDB();       
 //s4.selectStudSched(0);
 //s4.SetCrn(22222);
 //s4.updateSched();

      //  StudScheduleDB alist;
      //   alist = new StudScheduleDB();
      //   StudentInfoDB a1=new StudentInfoDB();
      //   a1.selectDB(7);
      //   alist.addSchedule(a1);
}
}
