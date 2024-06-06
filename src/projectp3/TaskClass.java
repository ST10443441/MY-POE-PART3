
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectp3;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;


/**
 *
 * @author Cameron Griffin ST10443441
 */
public class TaskClass {
    //Member Variables
    private String tName, tDes,devDetails,tID,tStatus,output;
    private int tNum ,duration;
    private int totDur = 0;
    String[] status = {"To Do","Done","Doing"};

    ProjectP3 obj = new ProjectP3();
  
    public TaskClass(){}
    //Test Task Description length
    public boolean checkTaskDescription(String des)
    {
        return (des.length() < 50);
    }
    //Create the Task ID 
    public String createTaskID(String tName, int tNum)
    {
        //Generates the Task Id 
        return  tName.substring(0, 2)
                +";"+tNum+";"+
                (tName.substring(tName.length()-3, tName.length())).toUpperCase();
    }
    //Display Data to User in Joption Panes 
    public void printTaskDetails(EasyKanBan kanBan)
    {
        //Send Data to EasyKanBan seTable
        kanBan.setTable(tName, tDes, devDetails, tID, tStatus, tNum, duration);
    }
    //Sends Output to User
    public String userOut()
    {
        //Outputs Data in JoptionPane
       
        return "Status: " + tStatus +"\tDeveloper Details: " + devDetails + "\tTask Number: "+ tNum
                + "\nTask Name: " + tName + "\nTask Description: " + tDes + "\nTask ID: " + tID + "\tDuration: " + duration+" Hours";
    }
    
    //Create Text File for Data Storage
    public void textFileWrite(boolean append)
    {
        String line = tName+"|"+tDes+"|"+devDetails+"|"+tID+"|"+tStatus+"|"+tNum+"|"+duration+"\n";
        File file = new File("data.txt");            //(W3schools,2024)
        
        try {
            if (file.createNewFile())
            {
                //For Developer
                System.out.println("File Created : "+ file.getName());
            }
            else 
            {
                //For Developer
                System.out.println("File Found.");
            }
            
        } 
        catch (IOException ex) {
            //For Developer
            System.out.println("An error occurred.ln82:TaskClass");
        }
        
        try {                                               //(W3schools,2024)
            FileWriter myWriter = new FileWriter(file.getName(),append);
            myWriter.write(line);
            myWriter.close();
        }
        catch (IOException e) {
            //For Developer
            System.out.println("An error occurred. ln93:TaskClass");
        }
    }
    
    
    //Calc the total Hours 
    public void calcTotalHours()
    {
        totDur = totDur + duration;
    }
    //Return the Total Hours
    public int returnTotalHours()
    {
       return (totDur);
        
    }
    
    //Setters
    public void settName(String b){
        tName = b;
    }
    public void setDevDetails(String b){
        devDetails = b;
    }
    public void settDes(String b){
        tDes = addNewDescription(b);
    }
    public void settID(){
        tID  = createTaskID(tName, tNum);
    }
    public void setStatus(int i){
        tStatus = status[i];
    }
    public void setDur(int b){
        duration = b;
    }
    public void settNum(int t) {
        tNum = t;
    }
    //Getters
    public String gettName() {
        return tName;
    }
    public String getDevDetails() {
        return devDetails;
    }
    public int getDur() {
        return duration;
    }
    public String getOutput() {
        return output;
    }
    public String getStatus(int t) {
        return status[t];
    }

    
    
    //Gets and tests that the Description is less than 50 Characters
    private String addNewDescription(String b)
    {
        
        //Declare Variables
        String des = b;
        //Input
        
        if (!checkTaskDescription(des))
        {
            do {            
                des = JOptionPane.showInputDialog("Please enter a task descrpitin of less than 50 characters");
            } while (des.length() > 50);
        }
        else 
            output="Task Successfully Captured";
        return des;
    }

    

    
    
}
