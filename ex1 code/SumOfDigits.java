package ex1;

import java.util.Scanner;


public class SumOfDigits {

	
	public static void main(String[] args) {
		int a,x,i,sum=0;
		Scanner stdin=new Scanner(System.in);
		System.out.println("Enter a number: ");
		x=stdin.nextInt();
		a=x;
		while(x>0)
		{ sum+=x%10;
		 x/=10;
		}
		System.out.println("The sum of the digits of "+a+" is "+sum);
		
	}

}