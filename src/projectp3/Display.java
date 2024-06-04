/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectp3;

/**
 *
 * @author Aries
 */
public class Display {
    int size = 0;
    public Display(int s)
    {
        size = s;
    }
    String[] arrTName = new String[size];
    String[] arrDescription = new String[size];
    String[] arrDev = new String[size];
    String[] arrID = new String[size];
    String[] arrStatus = new String[size];
    int[] arrNumber = new int[size];
    int[] arrDuration = new int[size];

    //Setters
    public void setArrTName(String[] arrTName) {
        this.arrTName = arrTName;
    }
    public void setArrDescription(String[] arrDescription) {
        this.arrDescription = arrDescription;
    }
    public void setArrDev(String[] arrDev) {
        this.arrDev = arrDev;
    }
    public void setArrID(String[] arrID) {
        this.arrID = arrID;
    }
    public void setArrStatus(String[] arrStatus) {
        this.arrStatus = arrStatus;
    }
    public void setArrNumber(int[] arrNumber) {
        this.arrNumber = arrNumber;
    }
    public void setArrDuration(int[] arrDuration) {
        this.arrDuration = arrDuration;
    }
    
    public void displayDone(EasyKanBan kanban)
    {
        kanban.resetTable(size);
        for(int i = 0; i < size+1;i++)
        {
            if(arrStatus[i].equals("Done")){
                kanban.setTable(arrTName[i], arrDescription[i], arrDev[i], arrID[i], arrStatus[i], arrNumber[i], arrDuration[i]);
            }
        }
    }
    
}
