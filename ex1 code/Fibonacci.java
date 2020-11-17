package ex1;

import java.util.Scanner;


public class Fibonacci {

	public static void main(String[] args) {
		int a,b,c,x,i,sum=0;
		Scanner stdin=new Scanner(System.in);
		System.out.println("Enter a number: ");
		x=stdin.nextInt();
		//x=Integer.parseInt(args[0]);
		a=0;
		b=1;
		for(i=1;i<=x-2;i++)
		{
			c=a+b;
			a=b;
			b=c;
		}
		System.out.println("The "+x+" th fibonacci number is "+b);
		
	}
}