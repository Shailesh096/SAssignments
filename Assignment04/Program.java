package com.sunbeam;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Program {
	private static final String URL="jdbc:mysql://localhost:3306/internship_db";
	private static final String USERNAME="root";
	private static final String PASSWORD="manager";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	//select
	public static void getAllStudents() {
		//String sql="SELECT rollno,name,email,course FROM students"
		//course index is 4 here if above is used
		String sql="SELECT*FROM students";
		try {
		Connection connection=getConnection();
		PreparedStatement selectStatement=connection.prepareStatement(sql);
		ResultSet rs=selectStatement.executeQuery();
		while(rs.next()) {
			int rollno=rs.getInt(1);
			String name=rs.getString(2);
			String email=rs.getString(3);
			String course=rs.getString(5);
			System.out.println(rollno+"-"+name+"-"+email+"-"+course);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//insert
	public static void addStudent(){
		String name="Suresh";
		String email="suresh@gmail.com";
		String course="Java";
		String sql="INSERT INTO students(name,email,course) VALUES(?,?,?)";
		try {
			Connection connection=getConnection();
			PreparedStatement insertStatement=connection.prepareStatement(sql);
			insertStatement.setString(1,name);
			insertStatement.setString(2,email);
			insertStatement.setString(3,course);
			insertStatement.executeUpdate();
			connection.close();
			insertStatement.close();
			System.out.println("Student is Inserted ");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	//update
	public static void updateStudent(){
		String name="Chetan";
		int rollno=6;
		String sql="UPDATE students SET name=? WHERE rollno=?";
		try {
			Connection connection=getConnection();
			PreparedStatement updateStatement=connection.prepareStatement(sql);
			updateStatement.setString(1, name);
			updateStatement.setInt(2, rollno);
			updateStatement.executeUpdate();
			connection.close();
			updateStatement.close();
			System.out.println("Student Updated");
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
		
	}
	//delete
	public static void deleteStudent(){
		int rollno=6;
		String sql="DELETE FROM students WHERE rollno=?";
		try {
			Connection connection=getConnection();
			PreparedStatement deleteStatement=connection.prepareStatement(sql);
			deleteStatement.setInt(1, rollno);
			deleteStatement.executeUpdate();
			connection.close();
			deleteStatement.close();
			System.out.println("Deleted Student ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//socket connection between database and java
		//addStudent();
		//updateStudent();
		deleteStudent();
		getAllStudents();
		
		
	}
	

}

