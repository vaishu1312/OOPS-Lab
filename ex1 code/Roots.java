package ex1;

public class Roots {
	public static void main(String[] args) {
		float a,b,c;
		double d,x1,x2;
		a=Float.parseFloat(args[0]);
		b=Float.parseFloat(args[1]);
		c=Float.parseFloat(args[2]);
		d=Math.sqrt((b*b)-(4*a*c));
		if (d>0)
		{
		 x1=(-b+d)/(2*a);
		 x2=(-b-d)/(2*a);
		 System.out.println("The roots are real and unequal\n");
		 System.out.println("The roots are "+x1+" and "+x2);
		}
		else if (d==0)
		{
		 x1=(-b+d)/(2*a);
		 System.out.println("The roots are real and equal\n");
		 System.out.println("The roots are "+x1+" and "+x1);
		}
		else
		 {
			System.out.println("The equation has no real roots\n");
		 }

	}

}
