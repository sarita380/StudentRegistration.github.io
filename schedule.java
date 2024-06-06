/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Business;
import java.util.ArrayList;
import java.util.List;
/***********************************************************************
 *
 *                Sara Aliaga 
 *          Business Object Schedule
 ****************************************************************************/
public class schedule {
    
    /*******************************************************
    *             Declarations
    *********************************************************/
    
    public List aList = new ArrayList<>();
    public int  count=0;
    
    SectionsDB sec1;
    
    public int index = 0;
    
    /******************************************************
    *               Add Section method
    * ****************************************************/
    public void addSection(SectionsDB s1)
    {
        aList.add(s1);
        index++;
    }
    /*******************************************************
     *              Drop Section Method
     * *****************************************************/
    public void dropSection(SectionsDB s1)
    {
        aList.remove(s1);
        index--;
    }
    /********************************************************
     *              Display SEctions
     * ******************************************************/
    public void displaySections()
    {
     SectionsDB s1;
     System.out.println("display section");
     for(int x=0; x<index; x++)
     {
      s1 =(SectionsDB)aList.get(x);
      s1.displaySect(); 
     }
    }
    /*********************************************************
    *               Main Method
    * ********************************************************/
    public static void main (String []args)
    {
    SectionsDB sec1, sec2;
    
    schedule sel = new schedule();
   // sec1 = new SectionsDB();
    //sec1.selectSect(30105);
   // sel.addSection(sec1);
   // sec1.displaySect();
    
    sec2 = new SectionsDB();
    sec2.selectSect(30116);
    sel.addSection(sec2);
    sel.displaySections();
    sel.dropSection(sec2);
    sec2.displaySect();
    }
}
