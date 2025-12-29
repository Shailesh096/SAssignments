package com.sunbeam;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PracticeProgram {
	
	private static final String URL="jdbc:mysql://localhost:3306/internship_db";
	private static final String USERNAME="root";
	private static final String PASSWORD="manager";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	
	public static void getAllStudent() {
		String sql="SELECT * FROM students";
		try {
		Connection connection=getConnection();
		PreparedStatement getallstudent=connection.prepareStatement(sql);
		ResultSet rs=getallstudent.executeQuery();
		while(rs.next()) {
			int rollno=rs.getInt(1);
			String name=rs.getString(2);
			String email=rs.getString(3);
			String course=rs.getString(5);
			System.out.println(rollno+"-"+name+"-"+email+"-"+course);
		}
		System.out.println();
		connection.close();
		getallstudent.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}
	
	public static void addStudents(Scanner sc) {
		System.out.println("Enter Student name:");
		String name=sc.next();
		System.out.println("Enter Student email:");
		String email=sc.next();
		System.out.println("Enter Student Course:");
		String course=sc.next();
		
		String sql="INSERT INTO students(name,email,course) VALUES(?,?,?)";
		try {
			Connection connection=getConnection();
			PreparedStatement insertStatement=connection.prepareStatement(sql);
			insertStatement.setString(1, name);
			insertStatement.setString(2, email);
			insertStatement.setString(3, course);
			insertStatement.executeUpdate();
			connection.close();
			insertStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void updateStudent(Scanner sc) throws SQLException {
		int choice;
				
		do {
			System.out.println("0.Exit");
			System.out.println("1.Update name");
			System.out.println("2.Update email");
			System.out.println("3.Update course");
			
			System.out.println("Enter choice:");
			choice=sc.nextInt();
			
			switch(choice) {
				case 1:
					System.out.println("Enter Student rollno:");
					int rollno=sc.nextInt();
					System.out.println("Enter New Name of Student:");
					String name=sc.next();
					String sql="UPDATE students SET name=? WHERE rollno=? ";
					Connection connection=getConnection();
					PreparedStatement updateName=connection.prepareStatement(sql);
					updateName.setString(1,name );
					updateName.setInt(2,rollno);
					updateName.executeUpdate();
					break;
				case 2:
					System.out.println("Enter Student rollno:");
					int rollno1=sc.nextInt();
					System.out.println("Enter New email of Student:");
					String email=sc.next();
					String sql1="UPDATE students SET email=? WHERE rollno=? ";
					Connection connection1=getConnection();
					PreparedStatement updateEmail=connection1.prepareStatement(sql1);
					updateEmail.setString(1,email );
					updateEmail.setInt(2,rollno1);
					updateEmail.executeUpdate();
					break;
				case 3:
					System.out.println("Enter Student rollno:");
					int rollno2=sc.nextInt();
					System.out.println("Enter New Course of Student:");
					String course=sc.next();
					String sql2="UPDATE students SET course=? WHERE rollno=?";
					Connection connection2=getConnection();
					PreparedStatement updateCourse=connection2.prepareStatement(sql2);
					updateCourse.setInt(1, rollno2);
					updateCourse.setString(2,course);
					updateCourse.executeUpdate();
					connection2.close();
					updateCourse.close();
					break;
				default:
					System.out.println("Wrong choice");
			}
		}while(choice!=0);
		
	}
	public static void deleteStudent(Scanner sc) {
		System.out.println("Enter Student ID to delete:");
		int rollno=sc.nextInt();
		String sql="DELETE FROM students WHERE rollno=?";
		try {
			Connection connection=getConnection();
			PreparedStatement deletestudent=connection.prepareStatement(sql);
			deletestudent.setInt(1, rollno);
			deletestudent.executeUpdate();
			connection.close();
			deletestudent.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
			System.out.println("0.Exit");
			System.out.println("1.Display Students");
			System.out.println("2.Add Student");
			System.out.println("3.Update Student");
			System.out.println("4.Delete Student");
			System.out.println();
			System.out.println("Enter the choice:");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				getAllStudent();
				break;
			case 2:
				addStudents(sc);
				break;
			case 3:
				updateStudent(sc);
				break;
			case 4:
				deleteStudent(sc);
				break;
			default:
				System.out.println("Wrong Choice");

			}
		}while(choice!=0);
			//deleteStudent(sc);
			
		System.out.println("SYSTEM CLOSED");
		
			//updateStudent(sc);
			//addStudents(sc);
		
			//getAllStudent();
	}

}
