/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectp3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Cameron Griffin ST10443441
 */
public class ProjectP3 {
    public ProjectP3(){   }
    //Adding Variables to global 
    
    static BaseForm form = new BaseForm();
    static EasyKanBan kanBan = new EasyKanBan();
    static TaskClass taskClass = new TaskClass();
    
    public static void main(String[] args) 
    {
        form.setVisible(true);
        addExisting();
    }
    
    //Out put the message to the User and developer
    public static void output(String out)
    {
        form.setOutput(out);
        kanBan.setOutput(out);
        System.out.println(out);
    }
    
    //Returns the Login Status
    public String returnLoginStatus(boolean lC)
    {
        if (lC)
            return form.getTextOut()+"\nA Successful Login";
        else
            return "A Failed Login";
        
    }
    //Changes Forms from login to KanBan Forms
    public void changeForms(int t)
    {
        //Changes forms from the base to the EasyKanBan Forms
        switch (t) {
            case 0:
                form.setVisible(false);
                kanBan.setVisible(true);
                break;
            case 1:
                form.setVisible(true);
                kanBan.setVisible(false);
                break;
            default:
                throw new AssertionError();
        }
        
    }
    //ALlows Users to choose the action they want
    public int options()
    {
        //Gets the choice from user using JOptionPane
        int choice;
        String[] list = {"Add","Show Report","Quit"};
        choice = JOptionPane.showOptionDialog(null, "Choose an Option:", "Options", JOptionPane.YES_NO_CANCEL_OPTION, 0, null, list, list[0]);
        
        return choice;
    }
    //Acts on the User's Choice 
    public void OptionAct(int choice)
    {
        switch (choice) {
            case 0:
                //Inputs the Ammount of tasks User wants to add
                int t = Integer.parseInt(JOptionPane.showInputDialog("How many Tasks to Add?"));
                //Adds the Ammount of tasks user want to add
                addNew(t);
                break;
            case 1:
                //Displays Coming Soon message for User
                //From Part 2
//                JOptionPane.showMessageDialog(null, "Coming Soon");
                report();
                break;
            case 2: 
                //Display end of action message to User
                JOptionPane.showMessageDialog(null, "Thank You Have A good Day");
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public static void taskData(String tName,String tDes,int choice,String devDetails,int count,int duration)
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
            //Sends data to JTable
            taskClass.printTaskDetails(kanBan);
    }
    //Add Existing tasks to JTable
    public static void addExisting()
    {
        String[] status = {"To Do","Done","Doing"};
        int choice;
        try 
        {
            File file = new File("data.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
              String data = reader.nextLine();
              //For Dev
              System.out.println(data);
                if (!data.isEmpty()){
                int x = data.indexOf("|");

                String tName = data.substring(0, x);

                String temp = data.substring(x+1);
                data = temp;
                x = data.indexOf("|");

                String tDes = data.substring(0, x);

                temp = data.substring(x+1);
                data = temp;
                x = data.indexOf("|");

                String devDetails = data.substring(0, x);

                temp = data.substring(x+1);
                data = temp;
                x = data.indexOf("|");

                String tID = data.substring(0, x);

                temp = data.substring(x+1);
                data = temp;
                x = data.indexOf("|");

                String tStatus = data.substring(0, x);

                temp = data.substring(x+1);
                data = temp;
                x = data.indexOf("|");

                int count = Integer.parseInt(data.substring(0, x));

                temp = data.substring(x+1);
                data = temp;

                int duration = Integer.parseInt(data.substring(0, data.length()));

                if (tStatus.contains(status[0])) 
                {
                      choice = 0;
                }else if (tStatus.contains(status[1])) 
                {
                      choice = 1;
                }else
                {
                      choice = 2;
                }    
                taskData(tName,tDes,choice,devDetails,count,duration);
                }
            }
              
            
            reader.close();
        } catch (FileNotFoundException e) 
        {
            output("An error occurred. ln200:ProjectP3");
        }
    }
    //Adds Tasks based on user Input
    public void addNew(int t)
    {
        //Declare the Variables
        int last = kanBan.getLastID();
        String[] status = {"To Do","Done","Doing"};
        int size = last + t;
        
        //Adds an ammount of tasks based on User's choice 
        for (int i = 1; i < t+1; i++) 
        {
            int count = i+ last;
            //Gets the Data from the User
            String tName = JOptionPane.showInputDialog("Task Name");
            //Get Task Desrciption From User
            String des = JOptionPane.showInputDialog("Description Under 51 Characters");
            //MultiChoice for the Status of the Task being added
            int choice = JOptionPane.showOptionDialog(null, "Choose an Option:", "Options", JOptionPane.YES_NO_CANCEL_OPTION, 0, null, status, status[0]);
            //Get Dev Details from User
            String devDetails = JOptionPane.showInputDialog("First and Last Name of Developer");
            //Get Task Duration From User
            int dur = Integer.parseInt(JOptionPane.showInputDialog("How will it take in hours?"));
            //Sends DAta to be set
            taskData(tName,des,choice,devDetails,count,dur);
            //Output a Status
            taskClass.textFileWrite(true);
            
            output(taskClass.userOut());
            
//            output(taskClass.getOutput());
        }
        JOptionPane.showMessageDialog(null, taskClass.returnTotalHours()+" Hours","Total Duration",1);
    }
    
    public void report()
    {
        int size = 0;
        //Get the Size for the Arrays
        try 
        {
            File file = new File("data.txt");
            Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
              String data = reader.nextLine();
              size++;
            }  
            reader.close();
            
        } catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred. ln255:ProjectP3-report()");
        }
        //Declare Arrays
        size++;
        String[] arrTName = new String[size];
        String[] arrDescription = new String[size];
        String[] arrDev = new String[size];
        String[] arrID = new String[size];
        String[] arrStatus = new String[size];
        int[] arrNumber = new int[size];
        int[] arrDuration = new int[size];
        //Populate Arrays
        try        
        {
            File file = new File("data.txt");
            Scanner reader = new Scanner(file);
            for (int i = 1; i < size; i++) {
                String data = reader.nextLine();
            int x = data.indexOf("|");

            arrTName[i] = data.substring(0, x);

            String temp = data.substring(x+1);
            data = temp;
            x = data.indexOf("|");

            arrDescription[i] = data.substring(0, x);

            temp = data.substring(x+1);
            data = temp;
            x = data.indexOf("|");

            arrDev[i] = data.substring(0, x);

            temp = data.substring(x+1);
            data = temp;
            x = data.indexOf("|");

            arrID[i] = data.substring(0, x);

            temp = data.substring(x+1);
            data = temp;
            x = data.indexOf("|");

            arrStatus[i] = data.substring(0, x);

            temp = data.substring(x+1);
            data = temp;
            x = data.indexOf("|");

            arrNumber[i] = Integer.parseInt(data.substring(0, x));

            temp = data.substring(x+1);
            data = temp;

            arrDuration[i] = Integer.parseInt(data.substring(0, data.length()));
        }
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred. ln314:ProjectP3-report()");
        }
        
        Display display = new Display(size);
        
        //Sending arrays to dispaly class
        display.setArrDescription(arrDescription);
        display.setArrDev(arrDev);
        display.setArrDuration(arrDuration);
        display.setArrID(arrID);
        display.setArrNumber(arrNumber);
        display.setArrStatus(arrStatus);
        display.setArrTName(arrTName);
        
        //Ask USer which report they want to see
        String[] status = {"All","Done","Longest","Search","Delete","Quit"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an Option:", "Options", JOptionPane.YES_NO_CANCEL_OPTION, 0, null, status, status[0]);
        
        //Split Menu For search
        if (choice == 3) 
        {
            //Ask USer For Search Method
            String[] searchStatus = {"Quit","Developer","Task Name"};
            int searchChoice = JOptionPane.showOptionDialog(null, "Choose an Option:", "Options", JOptionPane.YES_NO_CANCEL_OPTION, 0, null, searchStatus, searchStatus[0]);
            
            //If user chooses Quit Report method Quits
            choice = 5 + searchChoice;
            
            //Get Search Parameters from User
            if((choice == 6)||(choice == 7))
            {
                String search = JOptionPane.showInputDialog(null,"Enter Search Parametors for: "+ searchStatus[searchChoice],"Search Function",1);
                if (search.isEmpty())
                {
                    search = "null";
                }
                display.setSearchLine(search);
            }
        }
        //Confirmation for Delete
        if(choice == 4)
        {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you Sure?","Confrimation",2);
            if(confirm == 0)
            {
                String search = JOptionPane.showInputDialog(null,"Enter Search Parametors for: Delete","Delete Function",1);
                if (search.isEmpty())
                {
                    search = "null";
                }
                display.setSearchLine(search);
            }else 
            {
                choice = 5;
            }
        }
        
        //Run Choice method in Display Class
        display.runChoice(choice, kanBan);   
        //Get Status to User
        output(display.getStatusLine());
        }
        
}

//OpenAI. (2024). ChatGPT (Jun 21 version) [GPT-3.5 model]. https://chat.openai.com/ 
 
//Oracle Help Center. 1995. Java Tutorials writen of JDK 8,
// 21 July 2022. [Online]. Available at: https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/border.html [Accessed 1 April 2024].

//W3Schools. 1998. To Create simplified and interavtive learning experiences,
// 17 November 2015. [Online]. Available at: https://www.w3schools.com/java/java_while_loop.asp [Accessed 31 March 2024].

//W3Schools. 1998. To Create simplified and interavtive learning experiences,
// 17 November 2015. [Online]. Available at: https://www.w3schools.com/java/java_files_create.asp [Accessed 04 June 2024].

//Serplat. 2010. How to add row in JTable? (Version 1.0) [Source code].
//https://stackoverflow.com/questions/3549206/how-to-add-row-in-jtable (Accessed 03 May 2024).

//Cedric Reichenbach. 2012. How to get data from a JTable? (Version 1.0) [Source code].
//https://stackoverflow.com/questions/11812142/how-to-get-data-from-a-jtable (Accessed 03 June 2024).
