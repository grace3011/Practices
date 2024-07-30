package JDBC;
import java.sql.SQLException;

import DatabaseDao.RecordNotFoundException;

public class Main {
    public static void main(String[] args) throws SQLException {
        StudentDao studentDao = new StudentDao();

        // Create a new patient record
        Student student = new Student();
        student.setStudentname("John Doe");
        student.setStudentmarks("Excellent");
        studentDao.createStudent(student);

        // Create another patient record
        

        try {
            // total number of patients
            System.out.println("Total number of student " + studentDao.getAllStudents().size());

            // Get a patient record by ID
            Student student2 = studentDao.getStudentByID(student.getStudentID());
            System.out.println("ID: " + student.getStudentID());
            System.out.println("Name: " + student.getStudentname());
            System.out.println("Marks: " + student.getStudentmarks());

            // Update a patient record
            student.setStudentmarks("Perfect");
            studentDao.updateStudent(student);
            Student updateStudent = studentDao.getStudentByID(student.getStudentID());
            System.out.println("Updated Marks: " + updateStudent.getStudentmarks());

            // Delete a patient
            studentDao.deletePatient(student.getStudentID());
            System.out.println("Total number of patients after deletion: " + studentDao.getAllStudents().size());

        } catch (RecordNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // Clean up and close the database connection
        studentDao.close();
    }
}