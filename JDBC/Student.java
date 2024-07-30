package JDBC;

public class Student{
    private int studentID;
    private String studentname;
    private String studentmarks;
    public Student(){

    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }
    public void setStudentmarks(String studentmarks) {
        this.studentmarks = studentmarks;
    }
    public int getStudentID() {
        return studentID;
    }
    public String getStudentname() {
        return studentname;
    }
    public String getStudentmarks() {
        return studentmarks;
    }
    public void setInt(int i, Student student) {
    }
    
}