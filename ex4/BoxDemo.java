import java .util.Scanner;

interface cuboid
{
public double findVolume();
public double findArea();
public void compareVolume(Box a,Box b);
public void compareArea(Box a,Box b);
public void compareDim(Box a,Box b);
}

class Box implements cuboid
{
double l,b,h;
Box(double l,double b,double h)
{
 this.l=l;
 this.b=b;
 this.h=h;
}
Box(){    }
public double findVolume()
{  return l*b*h ;  }

public double findArea()
{  return 2*(l*b+b*h+h*l) ;  }

public void compareVolume(Box x,Box y)
{
if(x.findVolume()==y.findVolume())
 System.out.println("Both boxes are of same volume");
else if(x.findVolume()>y.findVolume())
 System.out.println("Volume of Box 1 is greater than Box 2");
else 
 System.out.println("Volume of Box 1 is lesser than Box 2");
}

public void compareArea(Box x,Box y)
{
if(x.findArea()==y.findArea())
 System.out.println("Both boxes have the same area");
else if(x.findArea()>y.findArea())
 System.out.println("Area of Box 1 is greater than Box 2");
else 
 System.out.println("Area of Box 1 is lesser than Box 2");
}

public void compareDim(Box x,Box y)
{
if(x.l==y.l)
  System.out.println("Both boxes are of same length");
else if (x.l>y.l)
  System.out.println("Length of Box 1 is greater than Box 2");
else
   System.out.println("Length of Box 1 is lesser than Box 2");

if(x.b==y.b)
   System.out.println("Both boxes are of same breadth");
else if (x.b>y.b)
   System.out.println("Breadth of Box 1 is greater than Box 2");
else
    System.out.println("Breadth of Box 1 is lesser than Box 2");


if(x.h==y.h)
   System.out.println("Both boxes are of same height");
else if (x.h>y.h)
   System.out.println("Height of Box 1 is greater than Box 2");
else
    System.out.println("Height of Box 1 is lesser than Box 2");
}

}

public class BoxDemo
{
public static void main(String args[])
{
Scanner stdin=new Scanner(System.in);
double l,b,h,v1,v2,a1,a2;
System.out.println("Enter length,breadth and height of Box 1: ");
l=stdin.nextDouble();
b=stdin.nextDouble();
h=stdin.nextDouble();
Box b1=new Box(l,b,h);
System.out.println("Enter length,breadth and height of Box 2: ");
l=stdin.nextDouble();
b=stdin.nextDouble();
h=stdin.nextDouble();
Box b2=new Box(l,b,h);
Box test=new Box();
v1=b1.findVolume();
System.out.println("The volume of Box1 is :"+v1);
a1=b1.findArea();
System.out.println("The area of Box1 is :"+a1);
v2=b2.findVolume();
System.out.println("The volume of Box2 is :"+v2);
a2=b2.findArea();
System.out.println("The area of Box2 is :"+a2);
test.compareVolume(b1,b2);
test.compareArea(b1,b2);
test.compareDim(b1,b2);
}
}