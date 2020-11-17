import java.util.Scanner;
class Student 
             {
	     int id;
             double m1,m2,m3,total,avg;
	     String name,dept,grade;
             
             void Input()
             {
              Scanner stdin=new Scanner(System.in);
              System.out.println("Enter your name: ");
              name=stdin.next();
              System.out.println("Enter your dept: ");
              dept=stdin.next();
              System.out.println("Enter marks in maths: ");
              m1=stdin.nextInt();
              System.out.println("Enter marks in english: ");
              m2=stdin.nextInt();
              System.out.println("Enter marks in tamil: ");
              m3=stdin.nextInt();
             }
  void Calculate()
             {  total=m1+m2+m3;
		avg=total/3;
                if (avg>=91)
                    grade="O"; 
                else if (avg>=81)
                    grade="A+";
                else if (avg>=71)
                    grade="A";
                else if (avg>=61)
                    grade="B+";
                else if (avg>=51)
                   grade="B";
                else 
                   grade="FAIL";
               }
    void Display()
             {              
		System.out.println("NAME: "+name);
		System.out.println("DEPARTMENT: "+dept);
		System.out.println("MATHS: "+m1);
		System.out.println("ENGLISH: "+m2);
		System.out.println("PHYSICS: "+m3);
		System.out.println("TOTAL: "+total);
		System.out.println("AVERAGE: "+avg);                
                System.out.println("Your grade is: "+grade); 
            }	
}
public class StudentDemo{
  	public static void main(String[] args) {
             Student s =new Student();
             s.Input();
             s.Calculate();
             s.Display();
}
}
