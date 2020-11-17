
import java.util.Scanner;
public class abstractClass {
	public static void main(String[] args)
	{   int ch;
	    Scanner stdin= new Scanner(System.in);
		System.out.println("1.Rectangle\n2.Triangle\n3.Circle\n");
		System.out.println("Enter your choice: ");
		ch=stdin.nextInt();
		switch(ch)
		{
		case 1:
			Rectangle rect = new Rectangle();
			System.out.println("Enter the dimensions: ");
			rect.x=stdin.nextInt();
			rect.y=stdin.nextInt();
			rect.print_Area();
			break;
		case 2:
			Triangle tri=new Triangle();
			System.out.println("Enter the dimensions: ");
			tri.x=stdin.nextInt();
			tri.y=stdin.nextInt();
			tri.print_Area();
			break;
		case 3:
			Circle cir =new Circle();
			System.out.println("Enter the dimensions: ");
			cir.x=stdin.nextInt();
			cir.print_Area();
			break;
		}
		
	}

}

abstract class Shape {
	int x,y;
	abstract void print_Area();
}


class Rectangle extends Shape
{
	void print_Area()
	{
		System.out.println("The area is: " + (x*y) );	
	}
}

class Triangle extends Shape
{
	void print_Area()
	{
		System.out.println("The area is: " + (0.5*x*y) );	
	}	
}

class Circle extends Shape
{
	protected static final double PI =3.1415926535;
	void print_Area()
	{
		System.out.println("The area is: " + (PI*x*x) );	
	}
}
