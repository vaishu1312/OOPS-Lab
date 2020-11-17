package emppayroll;
import java.util.Scanner;
import emppack.Employee;
public class EmpPayrollDemo {
	public static void main(String[] args)
	{   int ch,eId,flag=0,n,i;
		Scanner stdin= new Scanner(System.in);
		System.out.println("\nEmployee Payroll System");
		System.out.println("***********************\n");
		System.out.println("Enter no. of employees:");
		n=stdin.nextInt();
		Employee emp[]= new Employee[n];
		for(i=0;i<n;i++)//n employee database
		{	emp[i] = new Employee(); 
		System.out.println("\nEnter Employee Details:");
		System.out.print("Employee ID:");
		emp[i].eID=stdin.nextInt();
		System.out.print("Name:");
		emp[i].name=stdin.next();
		System.out.print("Designation:");
		emp[i].desn=stdin.next();
		if(emp[i].desn.compareTo("Intern")==0)
		{	System.out.print("No. of hours worked:");
			emp[i].hrs=stdin.nextInt();
			emp[i].wage_per_hr=100;
			emp[i].da=2000;
			emp[i].hra=1000;
			System.out.print("LIC is opted for?(if yes=1/no=0):");
			if(stdin.nextFloat()==1)
				emp[i].lic=1000;
			emp[i].pf=500;			
		}
		else if(emp[i].desn.compareTo("Manager")==0)
		{   System.out.print("Years of Experience:");
			emp[i].exp=stdin.nextInt();
			System.out.print("Basic Pay:");
			emp[i].basic=stdin.nextInt();
			emp[i].da=(float)(40/100.0)*emp[i].basic;
			emp[i].hra=(float)(10/100.0)*emp[i].basic;
			System.out.print("LIC is opted for?(if yes=1/no=0):");
			if(stdin.nextFloat()==1)
				emp[i].lic=1000;
			emp[i].pf=(float)(8/100.0)*emp[i].basic;
		}
		else
		{   System.out.print("Years of Experience:");
			emp[i].exp=stdin.nextInt();
			System.out.print("Basic Pay:");
			emp[i].basic=stdin.nextInt();
			emp[i].da=(float)(30/100.0)*(emp[i].basic);
			emp[i].hra=(float)(10/100.0)*(emp[i].basic);
			System.out.print("LIC is opted for?(if yes=1/no=0):");
			if(stdin.nextFloat()==1)
				emp[i].lic=1000;
			emp[i].pf=(float)(8/100.0)*(emp[i].basic);
		}
		emp[i].PayCalculation();
	  }//end for
System.out.print("\nPayslip of all employees");
for(i=0;i<n;i++)
	emp[i].displayPaySlip();
System.out.print("\nEnter Employee ID whose Pay Slip is to be displayed:");
eId=stdin.nextInt();
for(i=0;i<n;i++)
	if(eId==emp[i].eID)
	{  emp[i].displayPaySlip();
	   if(emp[i].exp>10)
		   System.out.println("\nYou are promoted!");
       else
		   System.out.println("\nNo promotion!");
	   flag=1;
	}
if(flag==0)
	System.out.println("Employee ID not found!");
}
}