import java.util.Scanner;
class Figure {
private double dim1;
private double dim2;

Figure(double a, double b) {
dim1 = a;
dim2 = b;
}
double findArea(){
System.out.println("Area for Figure is undefined.");
return 0;
}
final double getDim1(){return dim1;}
final double getDim2(){return dim2;}
}

class Rectangle extends Figure
{
public Rectangle(double l,double b)
{ super(l,b);  }
double findArea()
{
double l=super.getDim1();
double b=super.getDim2();
return l*b;
}
}

class Triangle extends Figure
{
public Triangle(double b,double h)
{ super(b,h);  }
double findArea()
{
double b=super.getDim1();
double h=super.getDim2();
return 0.5*b*h;
}
}

public class FigureDemo
{
 public static void main(String args[])
 {
  double b1,l1,b2,h2;
  Scanner stdin=new Scanner(System.in);
   
  System.out.println("Enter the breadth of the rectangle: ");
  b1=stdin.nextDouble();
  System.out.println("Enter the length of the rectangle: ");
  l1=stdin.nextDouble();   
  Rectangle r =new Rectangle(l1,b1); 
  System.out.println("The area of the rectangle is : "+ r.findArea() +" sq.units");

  System.out.println("Enter the breadth of the triangle: ");
  b2=stdin.nextDouble();
  System.out.println("Enter the height of the rectangle: ");
  h2=stdin.nextDouble();
  Triangle t = new Triangle(b2,h2);
  System.out.println("The area of the triangle is : "+ t.findArea()+" sq.units");
 }
}