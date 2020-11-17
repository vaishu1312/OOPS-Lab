import java.util.Scanner;
public class SumNatural
{
 public static void main(String args[])
 {
  int n,i,sum=0;  
  Scanner stdin=new Scanner(System.in);
  System.out.println("Enter the value of n: ");
  n=stdin.nextInt();
  for(i=1;i<=n;i++)
	  sum+=i;
  System.out.println("The sum of first "+n+" natural nos is "+sum);
 }
}