package ex1;

import java.util.Scanner;
public class SumOddEven {
	public static void main(String[] args) {
		int a,x,i,osum=0,esum=0;
		Scanner stdin=new Scanner(System.in);
		System.out.println("Enter a number: ");
		x=stdin.nextInt();
		a=x;
		while(x>0)
		{ if(x%2==0)
			{esum+=x%10;
		    x/=10;}
		else
		 {osum+=x%10;
		  x/=10;
		 }
		}
		System.out.println("The sum of the even digits of "+a+" is "+esum);
		System.out.println("The sum of the odd digits of "+a+" is "+osum);		
	}

}