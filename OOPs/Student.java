import java.io.*;
import java.util.*;
public class Student
{
   String name;
   int roll;
   static int totalStudents; // this variable is same for objects of student class
                             // hence it is object independent so we declare it static
   public Student(String name, int roll)
   {
       this.name=name;
       this.roll=roll;
       Student.totalStudents+=1;// static keywords are called by class name and not by this or 
                                // object name
   }
   
   public static void strength()
   {
       // this keyword cannot be used inside a static method 
       // System.out.println("Strength of class "+this.totalStudents); --> this wrong
       System.out.println("Strength of class "+totalStudents);
   }
}
