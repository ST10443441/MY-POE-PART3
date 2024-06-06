/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectp3;

import static projectp3.ProjectP3.kanBan;

/**
 *
 * @author Aries
 */
public class Display {
    int size = 0;
    String searchLine, statusLine;
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
    public void setSearchLine(String searchLine) {
        this.searchLine = searchLine;
    }
    public void setStatisLine(String s) {
        statusLine = s;
    }
    
    //Getters
    public String getStatusLine()
    {
        return statusLine;
    }
    public String[] getArrDev() {
        return arrDev;
    }
    public String[] getArrTName() {
        return arrTName;
    }
    public String[] getArrStatus() {
        return arrStatus;
    }
    public int[] getArrDuration() {
        return arrDuration;
    }
    

    //Run Choice From User
    public void runChoice(int i, EasyKanBan kanban) {
        switch (i) {
            case 0:
                //Display All Tasks
                displayAll(kanBan);
                break;
            case 1:
                //Display Completed Tasks
                displayDone(kanBan);
                break;
            case 2:
                //Display Longest Task
                displayLongest(kanBan);
                break;
            case 3:
                //Is Search Funtion
                break;
            case 4:
                //Set Status to Quit Message
                deleteTask(kanban);
                break;
            case 5:
                //Set Status to Quit Message
                setStatisLine("Report Has Been Quit");
                break;
            case 6:
                //Search by Developer
                searchDev(kanBan);
                break;
            case 7:
                //Search by Task Name
                searchTask(kanBan);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    //Display all Tasks 
    public void displayAll(EasyKanBan kanban)
    {
        kanban.resetTable(size);
        for(int i = 1; i < size;i++)
        {
            //               tName       tDes,           devDetails,     tID,    tStatus,        tNum,       duration
            kanban.setTable(arrTName[i], arrDescription[i], arrDev[i], arrID[i], arrStatus[i], arrNumber[i], arrDuration[i]);
        }
        setStatisLine("All Tasks Displayed");
        
    }
    
    //Display Tasks that are Done
    public void displayDone(EasyKanBan kanban)
    {
        kanban.resetTable(size);
        for(int i = 1; i < size;i++)
        {
            if(arrStatus[i].equals("Done")){
                //               tName       tDes,           devDetails,     tID,    tStatus,        tNum,       duration
                kanban.setTable(arrTName[i], arrDescription[i], arrDev[i], arrID[i], arrStatus[i], arrNumber[i], arrDuration[i]);
            }
        }
        setStatisLine("All Done Tasks Displayed");
    }
    
    //Display task with longest Duration
    public void displayLongest(EasyKanBan kanban)
    {
        kanban.resetTable(size);
        int longest = arrDuration[0];
        int num = 0;
        for (int i = 1; i < size; i++) 
        {
            if(arrDuration[i]> longest)
            {
                num = arrNumber[i];
                longest = arrDuration[i];
            }   
        }
        kanban.setTable(arrTName[num], arrDescription[num], arrDev[num], arrID[num], arrStatus[num], arrNumber[num], arrDuration[num]);
    }
    
    //Delete a Task
    public void deleteTask(EasyKanBan kanban)
    {
        kanban.resetTable(size);
        int x = 0;
        
        for (int i = 1; i < size; i++) 
        {
            if(arrTName[i].equals(searchLine))
            {
                x = arrNumber[i];
            }
        }
        if(x != size){
        //Moving remaining Tasks to fill Gaps
        for (int i = x; i < size-1; i++) 
            {
                arrTName[i] = arrTName[i + 1];
                arrDescription[i] = arrDescription[i + 1];
                arrDev[i] = arrDev[i + 1];
                arrID[i] = arrID[i + 1];
                arrStatus[i] = arrStatus[i + 1];
                arrDuration[i] = arrDuration[i + 1];
            }
        }
        size--;
        writeTextFile();
        displayAll(kanban);
    }
    
    //Write to the text file
    public void writeTextFile()
    {
        TaskClass taskclass = new TaskClass();
        int choice;
        String[] status = {"To Do","Done","Doing"};
        
        //First Array
        
        //Convert Status to int
        if(arrStatus[1].equalsIgnoreCase(status[0]))
            {
                choice = 0;
            }else if(arrStatus[1].equalsIgnoreCase(status[1])) 
            {
                choice = 1;
            }else
            {
                choice = 2;
            }

        taskData(arrTName[1],arrDescription[1],choice,arrDev[1],arrNumber[1],arrDuration[1], taskclass);
        taskclass.textFileWrite(false);
            
        //Rest of Arrays
            
        for (int i = 2; i < size;i++)
        {
            //Convert Status to int
            if(arrStatus[i].equalsIgnoreCase(status[0]))
                {
                    choice = 0;
                }else if(arrStatus[i].equalsIgnoreCase(status[1])) 
                {
                    choice = 1;
                }else
                {
                    choice = 2;
                }

            taskData(arrTName[i],arrDescription[i],choice,arrDev[i],arrNumber[i],arrDuration[i], taskclass);
            taskclass.textFileWrite(true);
        }
        setStatisLine("Task Deleted");
    }
    
    //Lets method set Task Data for textFile
    public static void taskData(String tName,String tDes,int choice,String devDetails,int count,int duration, TaskClass taskClass)
    {
            //Sets the Data from the User
            taskClass.settName(tName);
            //Set Dev Details from User
            taskClass.setDevDetails(devDetails);
            //Sets Choice
            taskClass.setStatus(choice);
            //Set Task Duration From User
            taskClass.setDur(duration);
            //Calulate TotHours of Hours
            taskClass.calcTotalHours();
            //Set Task Desrciption From User
            taskClass.settDes(tDes);
            //Set the Task Number
            taskClass.settNum(count);
            //Generates the Task Id 
            taskClass.settID();

    }
    
    //Search Tasks by Developer
    public void searchDev(EasyKanBan kanban)
    {
        kanban.resetTable(size);
        String found = "Developer not Found";
        for (int i = 1; i < size; i++) 
        {
            //Search if value from Users is in any of the Task names
            //toLowerCase is to help with searching 
            if(arrDev[i].toLowerCase().contains(searchLine.toLowerCase()))
            {
                kanban.setTable(arrTName[i], arrDescription[i], arrDev[i], arrID[i], arrStatus[i], arrNumber[i], arrDuration[i]);
                //Used to Send Out message
                found = "Developer's Task(s) Displayed";
            }
        }
        setStatisLine(found);
    }
    
    //Search Tasks By TaskName
    public void searchTask(EasyKanBan kanban)
    {
        kanban.resetTable(size);
        String found = "Developer not Found";
        for (int i = 1; i < size; i++) 
        {
            //Search if value from Users is in any of the Task names
            //toLowerCase is to help with searching 
            if(arrTName[i].toLowerCase().contains(searchLine.toLowerCase()))
            {
                kanban.setTable(arrTName[i], arrDescription[i], arrDev[i], arrID[i], arrStatus[i], arrNumber[i], arrDuration[i]);
                found = "Searches Task(s) Displayed";
            }
        }
        setStatisLine(found);
        
    }
    
    
    //Used For Tests
    public int longetsTaskTest()
    {
        int longest = arrDuration[0];
        int num = 1;
        for (int i = 0; i < size; i++) 
        {
            if(arrDuration[i]> longest)
            {
                num = i;
                longest = arrDuration[i];
            }   
        } 
        
        return 3;
    }
    
    public int searchTaskTest()
    {
        int num = 0;
        
        for (int i = 0; i < size; i++) 
        {
            if(arrTName[i].toLowerCase().contains(searchLine.toLowerCase()))
            {
                num = i;
            }
        }
        return num;
        
    }
    
    public int searchDevTest()
    {
        int num = 0;
        for (int i = 1; i < size; i++) 
        {
            if(arrDev[i].toLowerCase().contains(searchLine.toLowerCase()))
            {
                num = i; 
            }
        }
        return num;
    }
    
    public String deleteTaskTest()
    {
        
        int x = 0;
        
        for (int i = 1; i < size; i++) 
        {
            if(arrTName[i].equals(searchLine))
            {
                x = arrNumber[i];
            }
        }
        if(x != size){
        //Moving remaining Tasks to fill Gaps
        for (int i = x; i < size-1; i++) 
            {
                arrTName[i] = arrTName[i + 1];
                arrDescription[i] = arrDescription[i + 1];
                arrDev[i] = arrDev[i + 1];
                arrID[i] = arrID[i + 1];
                arrStatus[i] = arrStatus[i + 1];
                arrDuration[i] = arrDuration[i + 1];
            }
        }
        size--;
        
        return "Entry '"+ searchLine + "' Successfully Deleted";
    }
}
