package ex1;

public class SimpleCalculator {
	public static void main(String args[]) {
		int a,b,r = 0;
		char c;
		a=Integer.parseInt(args[0]);
		b=Integer.parseInt(args[1]);
		c=args[2].charAt(0);
		System.out.println(c);
		switch(c)
		{
		case 'a':
			r=a+b;
			break;
		case 's':
			r=a-b;
			break;
		case 'd':
			r=a/b;
			break;
		case 'm':
			r=a*b;
			break;
				
		}
		System.out.println("The result is: "+r);
  }

}