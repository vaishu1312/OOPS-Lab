import java.util.Scanner;
public class EmployeePayslip
{
 public static void main(String[] args)
 { 
  int n,i,id,choice;
  Scanner stdin= new Scanner(System.in);
  do{
    System.out.println("\n\nEmployee Payroll System");
    System.out.println("***********************\n");
    System.out.println("1.Programmer\n2.Assistant Professor\n"
    +"3.Associate Professor\n4.Professor\n"+
    "5.Exit\n\nEnter Your Choice"); 
    choice = stdin.nextInt();
    switch (choice)
    {
    case 1:
    Programmer p1 = new Programmer(); break;
    case 2:
    Assistant_Prof p2 = new Assistant_Prof(); 
    break;
    case 3:
    Associate_Prof p3 = new Associate_Prof();
    break;
   case 4:
    Professor p4 = new Professor();  break;
   case 5:   break;
   default:
   System.out.println("Invalid choice! "); break;
   }
  }while(choice!=5);
  System.out.println("*** Employee Payslip ***\n");
  
  System.out.println("***Programmer***");
  p1.displayPaySlip();
  System.out.println("***Assistant Professor***");
  p2.displayPaySlip();
  System.out.println("***Associate Professor***");
  p3.displayPaySlip();
  System.out.println("***Professor***");
  p4.displayPaySlip();
}
}

class Employee 
{
 String name;
 int id;
 String add;
 String mail;
 String mobile;
 double hra,da,pf,scf;
 double basic;
 double gross,net;
	 
 Employee(double b)
 {  this.basic=b; getDetails();  }

 protected void getDetails()
 { 
   Scanner stdin= new Scanner(System.in);
   System.out.println("\nEnter Employee Details:");
   System.out.print("Employee ID:");
   this.id=stdin.nextInt();
   System.out.print("Name:");
   this.name=stdin.next();
   System.out.print("Address:");
   this.add=stdin.next();
   System.out.print("Mail id:");
   this.mail=stdin.next();
   System.out.print("Mobile no:");
   this.mobile=stdin.next();
 }

 protected void calculatePay()
 {
   da=0.97*basic;
   hra=0.10*basic;
   pf=0.12*basic;
   scf=0.01*basic;	
   gross=basic+da+hra;
   net=gross-pf-scf;
 }
	 
 protected void displayPaySlip() 
 { 
   System.out.println("\n*****Employee Pay Slip*****");
   System.out.println("Name   : " + name);
   System.out.println("ID     : " + id);
   System.out.println("Address: " +add);
   System.out.println("Mail ID: " +mail);
   System.out.println("\n***Earnings***"); 
   System.out.println("--------");
   System.out.println("BASIC Pay: " + basic + " Rs");
   System.out.println("DA       : " + da + " Rs"); 
   System.out.println("HRA      : " + hra + " Rs");
   System.out.println("\n***Deductions***"); 
   System.out.println("----------");
   System.out.println("PF              : " + pf + " Rs");
   System.out.println("Staff club fund : " + scf + " Rs");	   
   System.out.println("\nGROSS PAY: " + gross + " Rs");
   System.out.println("NET PAY  : " + net + " Rs");
 }
}

class Programmer extends Employee
{
 static final double basic=35000;
 Programmer()
 { super(basic);  super.calculatePay();}
}
class Assistant_Prof extends Employee
{
 static final	double basic=50000;
 Assistant_Prof() 
 { super(basic);  super.calculatePay();}
}
class Associate_Prof extends Employee
{
 static final  double basic=60000;
 Associate_Prof() 
 { super(basic);  super.calculatePay();}
}
class Professor extends Employee
{
 static final	double basic=85000;
 Professor() 
 { super(basic);  super.calculatePay();}
}