package ex1;
import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		int n,i,flag=0;
		Scanner stdin=new Scanner(System.in);
		System.out.println("Enter a number: ");
		n=stdin.nextInt();
		for(i=2;i<n;i++)
		{
			if(n%i==0)
			{
				System.out.println("The number "+n+" is not prime.");
				flag=1;
				break;
			}
		}
		if (flag==0)
			System.out.println("The number "+n+" is prime.");
	}

}
