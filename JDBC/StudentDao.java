package JDBC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DatabaseDao.RecordNotFoundException;

public class StudentDao{
    private Connection connection;
    public StudentDao(){
        try{
        connection=Database.getConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }


    public void createStudent(Student student) {

           // create patient
           String sql="insert into students(studentname,studentmarks)values(?,?)";
           try(PreparedStatement ps=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
           {
               ps.setString(1,student.getStudentname());
               ps.setString(2, student.getStudentmarks());
               ps.executeUpdate();
               ResultSet rs=ps.getGeneratedKeys();
               if(rs.next()){
                 student.setStudentID(rs.getInt(1));
               }

           }catch(SQLException e){
            e.printStackTrace();
           }
    }

    public List<Student> getAllStudents() {

        // return all patients
        List<Student> students=new ArrayList<>();
        String sql="select * from students  ";
        try(PreparedStatement ps=connection.prepareStatement(sql))
        {
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Student student=new Student();
                student.setStudentID(rs.getInt("studentID"));
                student.setStudentname(rs.getString("studentname"));
                student.setStudentmarks(rs.getString("studentmarks"));
                students.add(student);
            }
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return students;
}

    public Student getStudentByID(int studentID) throws RecordNotFoundException {
        // return patient by ID
        String sql="select * from students where studentID=? ";
        try(PreparedStatement ps=connection.prepareStatement(sql))
        {
            ps.setInt(1, studentID);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Student student=new Student();
                student.setStudentID(rs.getInt("studentID"));
                student.setStudentname(rs.getString("studentname"));
                student.setStudentmarks(rs.getString("studentmarks"));
                return student;
            }
            else{
                throw new RecordNotFoundException("Student Id" +studentID+ "not found");

            }
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        
        
    }

    public Student updateStudent(Student student) throws SQLException{
        
        // update patient record
        String sql="update students set  studentmarks=?  where studentID=?";
         PreparedStatement ps=connection.prepareStatement(sql);
            

            ps.setString(1, student.getStudentmarks());
            ps.setInt(2, student.getStudentID());
            ps.executeUpdate();
            return student;
        
       
    }

    public void deletePatient(int studentID) throws RecordNotFoundException {
        String sql="delete from students where studentID=?";
        try(PreparedStatement ps=connection.prepareStatement(sql))
        {
           ps.setInt(1, studentID);
           ps.executeUpdate(); 
           
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

