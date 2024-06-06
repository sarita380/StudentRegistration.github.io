/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

/**
 *
 * @author Sara
 */
public class ScheduleList {
    
    public StudScheduleDB[] alist= new StudScheduleDB[10];
    public int count = 0;
    //String cid;
    
    public void addSchedule(StudScheduleDB a1){
        alist[count]= a1;
        count++;
    }
    public void displaySched(){
     for(int x=0; x<count; x++)  
         alist[x].displayStudSched(); 
    }
     public static void main (String[]args){
     
         ScheduleList alist;
         alist = new ScheduleList();
         StudScheduleDB a1=new StudScheduleDB();
         a1.selectStudSched(1); 
         alist.addSchedule(a1);
         
         
         StudScheduleDB a2=new StudScheduleDB();
         a2.selectStudSched(1); 
         
         alist.addSchedule(a2);
         alist.displaySched();
     }
}
