import java.util.Scanner;
class Circle
{
private double radius;
public Circle(double r)
   { radius = r; }
public double getRadius() 
   { return radius; }
public double findCircumference() 
  {  return 2*Math.PI*radius; }
public double findArea() 
   { return radius*radius*Math.PI;}
}

class Cylinder extends Circle
{
private double length;
public double r;
public Cylinder(double r,double l)
   { 
     super(r);
     length=l; }
public double findArea(double l)
  { 
     r=super.getRadius();
     return 2*Math.PI*r*(r+l); } 
public double findVolume()
  {  return Math.PI*r*r*length; }
}

public class CircleDemo
{
 public static void main(String args[])
 {
  double r,l;
  Scanner stdin=new Scanner(System.in);
   
  System.out.println("Enter the radius: ");
  r=stdin.nextDouble();
  System.out.println("Enter the length: ");
  l=stdin.nextDouble();
  Cylinder cyl1 =new Cylinder(r,l); 

  System.out.printf("The area of the circle is : %.2f sq.units",cyl1.findArea());
  System.out.printf("\nThe circumference of the circle is : %.2f sq.units",cyl1.findCircumference());
  System.out.printf("\nThe area of the cylinder is : %.2f sq.units",cyl1.findArea(l));
  System.out.printf("\nThe volume of the cylinder is : %.2f sq.units",cyl1.findVolume());
 }
}