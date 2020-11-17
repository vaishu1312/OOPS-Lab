package emppack;
import java.util.Scanner;
public class Employee {
	public String name;
	public int eID;
	public String desn;
	public int exp;
	public double wage_per_hr;
	public double basic;
	public double hra;
	public double da;
	public double lic;
	public double pf;
	public int hrs;
	public double gross,net,ded;
	
	public Employee()
	{
		exp=0;
		lic=0;
	}
	
	public void PayCalculation()
	{
		if(desn.equals("Intern"))
		{	da=2000;
		    hra=1000;
		    pf=500;
		    lic=500;
		    ded=lic+pf;
		    gross=hrs*50+da+hra+pf+lic;  //hourly wage=50
		    net=gross-ded;
		 }
		else if (desn.equals("Manager"))
		{	da=0.4*basic;
		    hra=0.1*basic;
		    pf=0.08*basic;
		    lic=500;
		    ded=lic+pf;
		    gross=basic+da+hra+pf+lic;
		    net=gross-ded;
	        
		}
		else 
		{
			da=0.3*basic;
		    hra=0.1*basic;
		    pf=0.08*basic;
			lic=500;
		    ded=lic+pf;
		     gross=basic+da+hra+pf+lic;
		     net=gross-ded;
	    }
	}
	
	
public void displayPaySlip() 
{ System.out.println("\n*************Employee Pay Slip**************");
  System.out.println("Name: " + name);
  System.out.println("ID: " + eID);
  System.out.println("\nEarnings"); 
  System.out.println("--------");
  System.out.println("BASIC PAY: Rs. " + basic);
  System.out.println("DA       : Rs. " + da); 
  System.out.println("HRA      : Rs. " + hra);
  System.out.println("\nDeductions"); 
  System.out.println("----------");
  System.out.println("PF       : Rs. " + pf );
  System.out.println("PF       : Rs. " + lic);
  System.out.println("GROSS PAY: Rs. " + gross );
  System.out.println("NET PAY  : Rs. " + net );
}

}
