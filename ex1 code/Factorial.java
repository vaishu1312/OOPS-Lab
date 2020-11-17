package ex1;

import java.util.Scanner;
public class Factorial {

	public static void main(String[] args) {
		int x,i;
		double fact=1;
		Scanner stdin=new Scanner(System.in);
		System.out.println("Enter a number: ");
		x=stdin.nextInt();
		for(i=x;i>=1;i--)
		 fact=fact*i;
		System.out.println("The factorial of "+x+" is "+fact);
		

	}

}