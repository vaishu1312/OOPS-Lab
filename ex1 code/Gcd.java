package ex1;

import java.util.Scanner;

public class Gcd {

	public static void main(String[] args) {
		int n1,n2,a,b,rem,temp;
		Scanner stdin=new Scanner(System.in);
		System.out.println("Enter a number: ");
		n1=stdin.nextInt();
		System.out.println("Enter another number: ");
		n2=stdin.nextInt();
		a=n1;
		b=n2;
		if (n1<n2)
		{
			temp=n1;
			n1=n2;
			n2=temp;
		}
		rem=n1%n2;
		while (rem!=0)
		{
			n1=n2;
			n2=rem;
		    rem=n1%n2;
		}
		System.out.println("The GCD of "+a+" and "+b+" is "+n2);
	}

}
