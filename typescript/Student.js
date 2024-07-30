var Student = /** @class */ (function () {
    function Student(studentId, studentName, studentDept) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDept = studentDept;
    }
    Student.prototype.showDetails = function () {
        console.log("Student Id: " + this.studentId + "\nStudent Name: " + this.studentName + "\nStudent Department: " + this.studentDept);
    };
    Student.prototype.hasCondition = function (condition) {
        return this.studentDept.toLowerCase() === condition.toLowerCase();
    };
    return Student;
}());
var student = new Student(1, "John Doe", "Computer Science");
student.showDetails();
if (student.hasCondition("Computer Science")) {
    console.log("Computer Science Department!!");
}
else {
    console.log("Not");
}
