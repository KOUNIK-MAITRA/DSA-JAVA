public class StudentMain
{
    public static void main(String args[]) // main is static so we can run main without creating a an object of class StudentMain
    {  
        System.out.println("total Students : "+Student.totalStudents); // static variables can be accessed even before an object of the class is created 
                                                                       // since they are object independent                    
        Student Kounik=new Student("Kounik",25);
        Student Rahul=new Student("Rahul",23);
        
        // static methods belong to the class and not the object
        // since total students was static and hence object independent
        // all 3 of the following statements give the same output
        System.out.println("total Students : "+Kounik.totalStudents); // gives correct output but wrong convention
        System.out.println("total Students : "+Rahul.totalStudents); // gives correct output but wrong convention
        System.out.println("total Students : "+Student.totalStudents); // correct convention

        // inside a static method no non-static method cannot be called
        // main is non static hence it is not dependent on objects then how can you have a no static method in it which is dependent on instace/object
        
        // StudentDetails(Kounik); -- this is not possible as StudentDetails is non-Static
        
        // this is possible 
        StudentMain obj=new StudentMain();
        obj.StudentDetails(Kounik);
    }
    void StudentDetails(Student student)
    {
        System.out.println("Name : "+student.name);
        System.out.println("Roll No : "+student.roll);
    }
}