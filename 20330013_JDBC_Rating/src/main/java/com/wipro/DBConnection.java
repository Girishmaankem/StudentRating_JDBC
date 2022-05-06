package com.wipro;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {

	private Connection connection;
	private Statement statement;
	    	        	 public Connection createConnection() throws  SQLException, ClassNotFoundException {
	    	        	       
	    	        	        Class.forName("oracle.jdbc.driver.OracleDriver");
	    	        	        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","Girishma");
	    	        	        System.out.println("Sucessfully Connected..");
	    	        	        /*String createSQL ="Create Table StudentAssignments (serialno integer," 
	    	 		                   + "name varchar(60), subject varchar(60), assignment varchar(60), points int)" ;
	    	        	        statement=connection.createStatement();
	    	        	        statement.executeUpdate(createSQL);*/
	    	        			
	    	        			return connection;
	    	        	 }
	    	        	 
	    	        	 }
