/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectp3;



import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cameron Griffin ST10443441
 */
public class ProjectP3Test {
    
    public ProjectP3Test() {    }


     boolean run = false;
    //Test Username
     @Test
    public void testUsername() 
    {   
        //Arrange 
        String expected = "kyl_1";
        //Act 
        Users p = new Users();
        p.setUsername("kyl_1");
        String actual = p.getUsername();
        //Assert
        assertEquals(expected, actual);
    }
    //Test Password
     @Test
    public void testPassword()
    {
        //Arrange 
        String expected = "Ch&&sec@ke99!";
        //Act 
        Users p = new Users();
        p.setPassword("Ch&&sec@ke99!");
        String actual = p.getPassword();
        //Assert
        assertEquals(expected, actual);   
        
        run = true;
    }
    //Test Username Requirments
     @Test
    public void testUsernameRequirements()
    {
        //Act
        Users p = new Users();
        boolean check = p.checkUserName("kyl_1");
        //Assert
        assertTrue(check);
    }
    //Test Password Complexity
     @Test
    public void testPasswordComplexity()
    {
        //Act
        Users p = new Users();
        boolean check = p.checkPasswordComplexity("Ch&&sec@ke99!");
        //Assert
        assertTrue(check);
    }
    //Test Login
    @Test
    public void testzLogin()
    {
        //Arrange 
        if (run){
        //Act 
        Users p = new Users();
        boolean l = p.loginUser();
        //Assert
        assertTrue(l);  }  
    }

    //Task One
    //Test Task Name
    @Test
    public void testTaskOneTName()
    {
     //Arrange 
        String exTaskName = "Create Login";
        //Act 
        TaskClass p = new TaskClass();
        p.settName("Create Login");
        String acTaskName = p.gettName();
        //Assert
        assertEquals(exTaskName, acTaskName);    
    }
    //Test Task Description
    @Test
    public void testTaskOneTDes()
    {
     //Arrange 
        TaskClass taskClass =new TaskClass();
        String expected = "Create Login to authenticate users";

        //Assert
        assertTrue(taskClass.checkTaskDescription(expected));    
    }
    //Test Task Developer Details
    @Test
    public void testTaskOneDevDetails()
    {
     //Arrange 
        String expected = "Mike Smith";
        //Act 
        TaskClass p = new TaskClass();
        p.setDevDetails("Mike Smith");
        String actual = p.getDevDetails();
        //Assert
        assertEquals(expected, actual);    
    }
    //Test Task Duration
    @Test
    public void testTaskOneDur()
    {
     //Arrange 
        String expected = "5hrs";
        //Act 
        TaskClass p = new TaskClass();
        p.setDur(5);
        
        String actual = String.valueOf(p.getDur())+"hrs";
        //Assert
        assertEquals(expected, actual);    
    }
    //Test Task Status
    @Test
    public void testTaskOneStatus()
    {
     //Arrange 
        String expected = "To Do";
        
        //Act 
        TaskClass p = new TaskClass();
        
        String actual = p.getStatus(0);
        //Assert
        assertEquals(expected, actual);    
    }
    
    //Task Two
    //Test Task Name
    @Test
    public void testTaskTwoTName()
    {
     //Arrange 
        String exTaskName = "Create Add Feature";
        //Act 
        TaskClass p = new TaskClass();
        p.settName("Create Add Feature");
        String acTaskName = p.gettName();
        //Assert
        assertEquals(exTaskName, acTaskName);    
    }
    //Test Task Description
    @Test
    public void testTaskTwoTDes()
    {
     //Arrange 
        TaskClass taskClass =new TaskClass();
        String expected = "Create Add Task feature to add task users";

        //Assert
        assertTrue(taskClass.checkTaskDescription(expected));    
    }
    //Test Task Developer Details
    @Test
    public void testTaskTwoDevDetails()
    {
     //Arrange 
        String expected = "Edward Harrison";
        //Act 
        TaskClass p = new TaskClass();
        p.setDevDetails("Edward Harrison");
        String actual = p.getDevDetails();
        //Assert
        assertEquals(expected, actual);    
    }
    //Test Task Duration
    @Test
    public void testTaskTwoDur()
    {
     //Arrange 
        String expected = "8hrs";
        //Act 
        TaskClass p = new TaskClass();
        p.setDur(8);
        String actual = String.valueOf(p.getDur())+"hrs";
        //Assert
        assertEquals(expected, actual);    
    }
    //Test Task Status
    @Test
    public void testTaskTwoStatus()
    {
     //Arrange 
        String expected = "Doing";
        //Act 
        TaskClass p = new TaskClass();
        
        String actual = p.getStatus(2);
        //Assert
        assertEquals(expected, actual);   
    }
    
    //Part Three
    //Test Task Name
    @Test
    public void testPartThreeTName()
    {
     //Arrange 
        String[] expected = {"Create Login","Create Add Features","Create Reports","Add Arrays"};
        //Act 
        Display p = new Display(4);
        p.setArrTName(expected);
        String[] actual = p.getArrTName();
        //Assert
        assertArrayEquals(expected, actual);    
    }
    //Test Task Developer Details
    @Test
    public void testPartThreeDevDetails()
    {
     //Arrange 
        String[] expected = {"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};
        //Act 
        Display p = new Display(4);
        p.setArrDev(expected);
        String[] actual = p.getArrDev();
        //Assert
        assertArrayEquals(expected, actual);     
    }
    //Test Task Duration
    @Test
    public void testPartThreeDur()
    {
     //Arrange 
        int[] expected = {5,8,2,11};
        //Act 
        Display p = new Display(4);
        p.setArrDuration(expected);
        int[] actual = p.getArrDuration();
        //Assert
        assertArrayEquals(expected, actual);   
    }
    //Test Task Status
    @Test
    public void testPartThreeStatus()
    {
     //Arrange 
         String[] expected = {"To DO","Doing","Done","To Do"};
        //Act 
        Display p = new Display(4);
        p.setArrStatus(expected);
        String[] actual = p.getArrStatus();
        //Assert
        assertArrayEquals(expected, actual);   
    }
    //Tests for the longest Task Duration
    @Test
    public void testLongest()
    {
        Display p = new Display(4);
        int[] dur = {5,8,2,11};
        p.setArrDuration(dur);
        String[] dev = {"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};
        p.setArrDev(dev);
        
        //Assert 
        String expected = "Glenda Oberholzer,11";
        //Act
        int x = p.longetsTaskTest();
        String actual = p.getArrDev()[x]+","+p.getArrDuration()[x];
        
        //Assert
        assertEquals(expected, actual);
    }
    //Test Search Function
    @Test
    public void testSearch()
    {
        Display p = new Display(4);
        
        String[] tName = {"Create Login","Create Add Features","Create Reports","Add Arrays"};
        p.setArrTName(tName);
        String[] dev = {"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};
        p.setArrDev(dev);
        
        //Assert 
        String expected = "Mike Smith,Create Login";
        //Act
        p.setSearchLine("Create Login");
        int x = p.searchTaskTest();
        String actual = p.getArrDev()[x]+","+p.getArrTName()[x];
        
        //Assert
        assertEquals(expected, actual);
    }
    //Test Search Developer
    @Test
    public void testSearchDev()
    {
        Display p = new Display(4);
        
        String[] tName = {"Create Login","Create Add Features","Create Reports","Add Arrays"};
        p.setArrTName(tName);
        String[] dev = {"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};
        p.setArrDev(dev);
        
        //Assert 
        String expected = "Create Reports";
        //Act
        p.setSearchLine("Samantha Paulson");
        int x = p.searchDevTest();
        String actual = p.getArrTName()[x];
        
        //Assert
        assertEquals(expected, actual);
    }
    //Test Search Developer
    @Test
    public void testDelete()
    {
        Display p = new Display(4);
        
        String[] tName = {"Create Login","Create Add Features","Create Reports","Add Arrays"};
        p.setArrTName(tName);
        String[] dev = {"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};
        p.setArrDev(dev);
        String[] arrDescription = new String[4];
        p.setArrDescription(arrDescription);
        String[] arrID = new String[4];
        p.setArrID(arrID);
        String[] arrStatus = new String[4];
        p.setArrStatus(arrStatus);
        int[] arrNumber = new int[4];
        p.setArrNumber(arrNumber);
        int[] arrDuration = new int[4];
        p.setArrDuration(arrDuration);
        
        //Assert 
        String expected = "Entry 'Create Reports' Successfully Deleted";
        //Act
        p.setSearchLine("Create Reports");
       
        String actual = p.deleteTaskTest();
        
        //Assert
        assertEquals(expected, actual);
    }
    
    
}

