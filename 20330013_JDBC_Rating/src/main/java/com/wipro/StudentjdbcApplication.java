package com.wipro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;


public class StudentjdbcApplication {

	private static LoadStudentData lsd = new LoadStudentData();
	private static DBConnection dbcon = new DBConnection();
    private static StudentCalculator stuCal = new StudentCalculator();
    private static Connection con;
	
	public static void main(String[] args) 
	{
		boolean isAlive=true;
		try 
		{
			con = dbcon.createConnection();
		
			System.out.println("Started loading data...\n");
			lsd.loadStudentData(con); 
			System.out.println("Data loaded Successfull....");
			
			BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
			
			
	         while(isAlive) 
			{
				System.out.println("\n 1. Display Student Average \n 2. Display Subject Average \n 3. Display Data \n 4. Exit \n");
				System.out.print("Enter you Choice :");	
				int n = Integer.parseInt(data.readLine());
		
				switch(n)
				{
		   			case 1 : System.out.print("\n" + "Student : ");
		   					 String studentName = data.readLine().trim();
		   					 stuCal.studentAverage(con,studentName);
		   					 break;
		   		
		   			case 2:  System.out.print("\n" + "Subject : ");
  		                 	 String subName = data.readLine().trim();
  		                 	 stuCal.subjectAverage(con, subName);
  		                 	 break;
  		                 	
		   			case 3:  lsd.displayData(con);
		   			         break;
		   		
		   			case 4:   isAlive=false;
		   			break;
		   			
				
		   			default: System.out.println("Enter valid Input");
				}
			
			}
			//while(true);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}//main Ends
}
