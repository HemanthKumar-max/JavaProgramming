package com.bridgelabz.crud.Serviceprovider;

import java.sql.SQLException;
import com.bridgelabz.crud.Utils.InputUtility;
import com.bridgelabz.crud.controller.Runner;
import com.bridgelabz.crud.model.Student;
import com.bridgelabz.crud.repository.StudentRepo;

public class StudentInfoProvider implements StudentService {
	static StudentRepo str = new StudentRepo();
	static Runner runner = new Runner();

	@Override
	public void addDetails() {
		System.out.println("=====Adding Student Details========");
		System.out.println("Enter the name");
		String name = InputUtility.next();
		System.out.println("Enter the usn");
		String usn = InputUtility.next();
		System.out.println("Enter the age");
		int age = InputUtility.nextInt();
		System.out.println("Enter the schoolname");
		String schoolName = InputUtility.next();
		System.out.println("Enter the marks");
		int marks = InputUtility.nextInt();
		Student st = new Student(name, usn, age, schoolName, marks);
		str.addStudentRepo(st);
		System.out.println("---------------------");
		System.out.println("Do you want to add again");
		String choice = InputUtility.next();
		if (choice.equals("yes")) {
			addDetails();
		} else {
			Runner.studentMenu();
		}

	}

	@Override
	public void getDetails(String name) {
		try {
			Student st = str.getStudentDetailsRepo(name);
			System.out.println("======Student Details");
			System.out.println("Name:" + st.getName());
			System.out.println("usn:" + st.getUsn());
			System.out.println("Age:" + st.getAge());
			System.out.println("SchoolName:" + st.getSchoolName());
			System.out.println("Marks:" + st.getMarks());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateDetails(String name, int age) {
		try {
			int rs = str.updateStudentRepo(name, age);
			if (rs > 0) {
				System.out.println("data has been updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDetails(String name, int age) {
		try {
			int rs = str.deleteStudentRepo(name, age);
			if (rs > 0) {
				System.out.println("data has been deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void searchDetails(String name) {
		try {
			str.searchStudentRepo(name);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void greaterthanAverageAge() {
		try {
			str.listofAgeGreaterthanAverage();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void marksNotGreaterthan50() {
		try {
			str.marksScoredGreaterthan50();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
