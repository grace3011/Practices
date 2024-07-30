class Student{

    studentId: number;
    studentName: string;
    studentDept: string;

    constructor(studentId: number,studentName: string,studentDept: string){
        this.studentId=studentId;
        this.studentName=studentName;
        this.studentDept=studentDept;
    }
    showDetails(): void{
        console.log(`Student Id: ${this.studentId}\nStudent Name: ${this.studentName}\nStudent Department: ${this.studentDept}`);
    }
    hasCondition(condition: string): boolean{
        return this.studentDept.toLowerCase()===condition.toLowerCase();
    }

    
}
    
    const student=new Student(1,"John Doe","Computer Science");
    student.showDetails();

    if(student.hasCondition("Computer Science")){
        console.log(`Computer Science Department!!`);
    }
    else{
        console.log(`Not`);
    }