package ex1;
import java.util.Scanner;
public class ArmstrongNo {
	public static void main(String args[])
	{    Scanner stdin=new Scanner(System.in);
	     int n,a,l,sum= 0,digits=0;
	     double j;
	     System.out.println("Enter the value of n: ");
	     n=stdin.nextInt();
	     a = n;
	     while (n>0)
	     {
	      n=n/10;
	      digits+=1;
	     }
         n=a;
         while (n>0)
         {
           l=n%10;
           j=Math.pow(l,digits);
           sum+=j;
           n=n/10;
         }
         if(sum==a)
	            System.out.println(a + " is an Armstrong number.");
	     else
	            System.out.println(a + " is not an Armstrong number.");
}
}
