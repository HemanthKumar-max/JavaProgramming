package com.bridgelabz.crud.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.crud.Serviceprovider.StudentInfoProvider;
import com.bridgelabz.crud.config.StudentConnection;
import com.bridgelabz.crud.model.Student;

public class StudentRepo {
	StudentConnection stdcon = new StudentConnection();
	Connection con = StudentConnection.getConnection();
	PreparedStatement prepstmt;


	public StudentInfoProvider factoryclass() {
		StudentInfoProvider studinfoprovider = new StudentInfoProvider();
		return studinfoprovider;
	}

	public void addStudentRepo(Student st) {
		try {
			String insertquery = "INSERT INTO info(name,usn,age,schoolName,marks) VALUES(?,?,?,?,?)";
			prepstmt = con.prepareStatement(insertquery);

			prepstmt.setString(1, st.getName());
			prepstmt.setString(2, st.getUsn());
			prepstmt.setInt(3, st.getAge());
			prepstmt.setString(4, st.getSchoolName());
			prepstmt.setInt(5, st.getMarks());
			int rs = prepstmt.executeUpdate();
			if (rs > 0) {
				System.out.println("data is inserted into database");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Student getStudentDetailsRepo(String name) throws SQLException {
		Student st = null;
		String selectquery = "Select * from info where name=?";
		prepstmt = con.prepareStatement(selectquery);
		prepstmt.setString(1, name);
		ResultSet rs = prepstmt.executeQuery();
		if (rs.next()) {
			st = new Student();
			st.setName(rs.getString("name"));
			st.setUsn(rs.getString("usn"));
			st.setAge(rs.getInt("age"));
			st.setSchoolName(rs.getString("schoolName"));
			st.setMarks(rs.getInt("marks"));
		}
		return st;
	}

	public int updateStudentRepo(String name, int age) throws SQLException {
		String updatequery = "UPDATE info SET name = ? where age = ?";
		prepstmt = con.prepareStatement(updatequery);
		prepstmt.setString(1, name);
		prepstmt.setInt(2, age);
		int rs = prepstmt.executeUpdate();
		return rs;
	}

	public int deleteStudentRepo(String name, int age) throws SQLException {
		String deletequery = "Delete from info  where name=?  and  age = ?";
		prepstmt = con.prepareStatement(deletequery);
		prepstmt.setString(1, name);
		prepstmt.setInt(2, age);
		int rs = prepstmt.executeUpdate();
		return rs;
	}

	public void searchStudentRepo(String name) throws SQLException {

		String searchquery[] = { "Select * from info where name like'" + name + "%" + "'" };
		for (String querysearch : searchquery) {
			prepstmt = con.prepareStatement(querysearch);
			ResultSet rs = prepstmt.executeQuery();
			System.out.println("RELATED NAMES STORED IN DATABASE:");
			System.out.println("=================================");
			while (rs.next()) {
				String names = rs.getString("name");
				System.out.println(names + " ");

			}
		}
	}

	public void listofAgeGreaterthanAverage() throws SQLException {
		String listquery[] = { "Select name,usn,age from info where age>(select AVG(age) from info)" };// sub qurery
																										// using where
																										// clause
		for (String querylist : listquery) {
			prepstmt = con.prepareStatement(querylist);
			ResultSet rs = prepstmt.executeQuery();
			System.out.println(" LIST OF AGE ,GREATER THAN AVG AGE STORED IN DATABASE:");
			System.out.println("=================================");
			while (rs.next()) {
				String name = rs.getString("name");
				String usn = rs.getString("usn");
				int ages = rs.getInt("age");
				System.out.println("Name:" + name);
				System.out.println("Ages:" + ages);
				System.out.println("usn:" + usn);
				System.out.println("=======================");
			}
		}
	}

	public void marksScoredGreaterthan50() throws SQLException// sub query using where clause
	{
		String[] query = { "Select marks,name from info WHERE marks>(Select AVG(marks) from info)" };
		for (String querymarks : query) {
			prepstmt = con.prepareStatement(querymarks);
			ResultSet rs = prepstmt.executeQuery();
			while (rs.next()) {
				String marks = rs.getString("marks");
				String name = rs.getString("name");
				System.out.println("marks:" + marks);
				System.out.println("name:" + name);
				System.out.println("================================");
			}
		}
	}

	public void findMaxminAvgMarks() {
		// String[] queryMaxmin= {"select MAX(marks),MIN(marks)";;
	}

}
