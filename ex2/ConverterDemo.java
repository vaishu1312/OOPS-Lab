package Converter;

import ConvertionPackage.CurrencyConverter;
import ConvertionPackage.TimeConverter;
import ConvertionPackage.DistanceConverter;
import java.util.Scanner;

public class ConverterDemo {
public static void main(String args[])
{  int ch;double x, k=0;
    Scanner stdin=new Scanner(System.in);
    ConvertionPackage.DistanceConverter dc= new ConvertionPackage.DistanceConverter();
	ConvertionPackage.CurrencyConverter cc= new ConvertionPackage.CurrencyConverter();
	ConvertionPackage.TimeConverter tc= new ConvertionPackage.TimeConverter();
	System.out.println("****Welcome to Converter****\n");
	do{
	System.out.println("1.Currency converter\n2.Time converter");
	System.out.println("3.Distance converter\n");
	System.out.println("Enter your choice: ");
	ch=stdin.nextInt();
	if(ch==1)
	{ do{
		System.out.println("Welcome to currency converter\n");
		System.out.println("1.USD to INR\n2.EUR to INR\n3.YEN to INR");
		System.out.println("4.INR to USD\n5.INR to EUR\n6.INR TO YEN");
		System.out.println("Enter your choice");	
		ch=stdin.nextInt();
		System.out.println("Enter the value: ");
		x=stdin.nextFloat();
		switch(ch)
		{
		case 1:  k=cc.dollarToRupee(x);  break;
		case 2:  k=cc.euroToRupee(x);    break;
		case 3:  k=cc.yenToRupee(x);     break;
		case 4:  k=cc.rupeeToDollar(x);  break;
		case 5:  k=cc.rupeeToEuro(x);    break;
		case 6:  k=cc.rupeeToYen(x);     break;
		default: System.out.println("Invalid choice");
		}
		if (ch>=1 && ch<=6)
             System.out.println("The result is " +k);
		System.out.println("Do you want to continue?\n1-continue\n2-exit\n");
		ch=stdin.nextInt();
		}while(ch==1);
	  } //end ch==1
	else if (ch==2)
	{ do{
		System.out.println("Welcome to time converter\n");
		System.out.println("1.HOUR to MIN\n2.HOURto SEC\n3.MINto HOUR");
		System.out.println("4.SEC to HOUR\n");
		System.out.println("Enter your choice");	
		ch=stdin.nextInt();
		System.out.println("Enter the value: ");
		x=stdin.nextFloat();
		switch(ch)
		{
		case 1:  k=tc.hourToMin(x);  break;
		case 2:  k=tc.hourToSec(x);    break;
		case 3:  k=tc.minToHour(x);     break;
		case 4:  k=tc.secToHour(x);  break;
		default: System.out.println("Invalid choice");
		}
		if (ch>=1 && ch<=4)
            System.out.println("The result is " +k);
		System.out.println("Do you want to continue?\n1-continue\n2-exit");
		ch=stdin.nextInt();
		}while(ch==1);
	  } //end ch==2	
	else if(ch==3)
	{ do{
		System.out.println("Welcome to distance converter\n");
		System.out.println("1.METRE TO KILO\n2.MILE TO KILO\n3.KILO TO MILE");
		System.out.println("4.KILO TO METRE\n");
		System.out.println("Enter your choice");	
		ch=stdin.nextInt();
		System.out.println("Enter the value: ");
		x=stdin.nextFloat();
		switch(ch)
		{
		case 1:  k=dc.metreToKilo(x);  break;
		case 2:  k=dc.mileToKilo(x);    break;
		case 3:  k=dc.kiloToMile(x);     break;
		case 4:  k=dc.kiloToMetre(x);  break;
		default: System.out.println("Invalid choice");
		}
		if (ch>=1 && ch<=4)
            System.out.println("The result is " +k);
		System.out.println("Do you want to continue?\n1-continue\n2-exit\n");
		ch=stdin.nextInt();
		}while(ch==1);
	  } //end ch==3	
	else
		System.out.println("Invalid choice\nPlease enter your choice again");
	System.out.println("Do you want to continue?\n1-continue\n2-exit\n");
	ch=stdin.nextInt();
	}while(ch==1);
}
//x=tc.hourToMin(3);
//System.out.println("The ans is:"+x);
}

