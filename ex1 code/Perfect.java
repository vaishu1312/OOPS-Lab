package ex1;

import java.util.Scanner;

public class Perfect {

	public static void main(String[] args) {
		int n,i,sum=0;
		Scanner stdin=new Scanner(System.in);
		System.out.println("Enter a number: ");
		n=stdin.nextInt();
		for(i=1;i<n;i++)
		{
			if(n%i==0)
			    sum+=i;				
		}
		if (sum==n)
			System.out.println("The number "+n+" is a perfect number.");
		else
			System.out.println("The number "+n+" is not a perfect number.");
	}

}
