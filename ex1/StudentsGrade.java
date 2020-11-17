import java.util.Scanner;
class Student 
             {
	     int i,j,id;
             double m[]= new double[3],total=0,avg;
	     String name,dept,grade;
             
void Input()
{
    Scanner stdin=new Scanner(System.in);
    System.out.println("Enter your ID No: ");
    id=stdin.nextInt();
    System.out.println("Enter your name: ");
    name=stdin.next();
    System.out.println("Enter your dept: ");
    dept=stdin.next();
    System.out.println("Enter your marks in 3 subjects: ");
    for(i=0;i<3;i++)
           m[i]=stdin.nextDouble();
}

void Calculate()
{  
              for(i=0;i<3;i++)
                     total+=m[i];
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
 void Search(String dt,Student s[],int n)
{
 for(i=0;i<3;i++)
   if((s[i].dept).compareTo(dt)==0)
   {   	System.out.println("\nDetails of the student");
      	System.out.println("\nNAME: "+s[i].name);
      	System.out.println("\nid: "+s[i].id);
	System.out.println("DEPARTMENT: "+s[i].dept);
        System.out.println("Your marks in 3 subjects: ");
        for(j=0;j<3;j++)
    	      System.out.println(s[i].m[j] + " ");
	System.out.println("TOTAL: "+s[i].total);
	System.out.println("AVERAGE: "+s[i].avg);                
        System.out.println("Your grade is: "+s[i].grade); 
        break;
  }
}
 void Search(int Id,Student s[],int n)
{
 for(i=0;i<3;i++)
   if(s[i].id==Id)
   {   	System.out.println("\nDetails of the student");
      	System.out.println("\nNAME: "+s[i].name);
      	System.out.println("\nid: "+s[i].id);
	System.out.println("DEPARTMENT: "+s[i].dept);
        System.out.println("Your marks in 3 subjects: ");
        for(j=0;j<3;j++)
    	      System.out.println(s[i].m[j] + " ");
	System.out.println("TOTAL: "+s[i].total);
	System.out.println("AVERAGE: "+s[i].avg);                
        System.out.println("Your grade is: "+s[i].grade); 
        break;
  }
}

void Display()
{              
	System.out.println("\nNAME: "+name);
	System.out.println("DEPARTMENT: "+dept);
        System.out.println("Your marks in 3 subjects: ");
        for(i=0;i<3;i++)
    	      System.out.println(m[i] + " ");
	System.out.println("TOTAL: "+total);
	System.out.println("AVERAGE: "+avg);                
        System.out.println("Your grade is: "+grade); 
            }	
}
public class StudentsGrade{
    public static void main(String[] args) {
       int i,x,n,ch;
       String key;
       Scanner stdin=new Scanner(System.in);  
       System.out.println("Enter no of students: ");
        n=stdin.nextInt();
        Student s[] =new Student[n];
        Student st = new Student();
        for(i=0;i<n;i++)
        {    s[i]=new Student();
             s[i].Input();
             s[i].Calculate(); 
        }
       System.out.println("\nDisplay of marks\n");
        for(i=0;i<n;i++)
             s[i].Display();
       do{
       System.out.println("\n1.Search by id\n2.Search by dept");
        ch=stdin.nextInt();
       if (ch==1)
       {
       System.out.println("Enter id no to be searched: ");
       x=stdin.nextInt();
       st.Search(x,s,n);
       }
       else if(ch==2)
       {
       System.out.println("Enter dept no to be searched: ");
       key=stdin.next();
       st.Search(key,s,n);
       }
       System.out.println("Press 1 to search again\nPress 2 to exit");
       ch=stdin.nextInt(); 
      }while(ch==1);
}
}