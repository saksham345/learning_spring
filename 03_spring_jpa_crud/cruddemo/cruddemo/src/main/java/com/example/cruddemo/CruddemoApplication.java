package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return  runner ->{
			createStudent(studentDAO);

//			readStudent(studentDAO);

//			queryforStudents(studentDAO);

//			queryforStudentsbyFirstName(studentDAO);

//			updateStudent(studentDAO);

//			updateMultipleStudent(studentDAO);

//			deletestudent(studentDAO);

//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		studentDAO.deleteAll();
	}

	private void deletestudent(StudentDAO studentDAO) {
		int id = 2;
		System.out.println("Student ID to be deleted: "+ id);
		studentDAO.delete(id);
	}

	private void updateMultipleStudent(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findByFirstName("dfffvvf");

		System.out.println("Students before update: ");
		for(Student it: theStudents)
			System.out.println(it);

		studentDAO.updateMultipleRows(theStudents);

		System.out.println("Students after update: ");
		for(Student it: theStudents)
			System.out.println(it);

	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 1;
		Student myStudent = studentDAO.findbyID(id);

		myStudent.setFirstName("SCoby");
		studentDAO.update(myStudent);

		System.out.println("Updated Student: " + myStudent.getFirstName());
	}

	private void queryforStudentsbyFirstName(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findByFirstName("dfffvvf");

		for(Student it: theStudents)
			System.out.println(it);
	}

	private void queryforStudents(StudentDAO studentDAO) {

		List<Student> theStudents= studentDAO.findAll();

		for(Student it: theStudents)
			System.out.println(it);
	}

	private void createStudent(StudentDAO studentDAO){
		System.out.println("Creating new student obj....");
		Student tempStudent =  new Student("paurl", "kuma", "vff@b.com");

		System.out.println("Saving the student.....");
		studentDAO.save(tempStudent);

		System.out.println("Saving the student, ID generated:" + tempStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO){
		System.out.println("Creating a new student obj...");
		Student tempStudent = new Student("dfffvvf","kuma","aff@b");

		System.out.println("Saving the student.....");
		studentDAO.save(tempStudent);

		int id = tempStudent.getId();
		System.out.println("Gnerated id: "+ id);

		System.out.println("Retriving student with ID: "+ id);
		Student myStudent = studentDAO.findbyID(id);

		System.out.println("found student: " + myStudent);
	}


}
