import java.util.Scanner;
class Complex
{
private float real;
private float imaginary;
Complex() { }
Complex(float r, float i)
{ real = r;
  imaginary = i;}
void display()
{ 
if (imaginary>=0)
  System.out.println(real+"+"+imaginary+"i");
else 
   System.out.println(real+""+imaginary+"i");
}
boolean isReal ()
{  if (imaginary==0)  return true;
   else               return false;  }
boolean isImag ()
{ if (real==0)  return true;
  else          return false;  }
final float getReal(){return real;}
final float getImaginary(){return imaginary;}

void mulComplexNos(Complex C1, Complex C2)
{   real = C1.real * C2.real - C1.imaginary * C2.imaginary;
    imaginary = C1.real * C2.imaginary + C1.imaginary * C2.real;
}
void mulComplexNos(Complex C1, float r)
{   real = C1.real * r;
    imaginary = C1.imaginary * r;
}
void mulComplexNos(Complex C1,String img)
{   float val = img.charAt(0)-48;
    real = C1.imaginary * val*-1;
    imaginary = C1.real *val;
}
void addComplexNos(Complex C1, Complex C2)
{   real = C1.real + C2.real;
    imaginary = C1.imaginary + C2.imaginary;
}
void addComplexNos(Complex C1, int n)
{   real = C1.real + n;
    imaginary = C1.imaginary;
}
void subComplexNos(Complex C1, Complex C2)
{   real = C1.real - C2.real;
    imaginary = C1.imaginary - C2.imaginary;
}
void subComplexNos(Complex C1, int n)
{   real = C1.real-n;
    imaginary = C1.imaginary;
}
}

public class ComplexDemo
{
 public static void main(String args[])
 {
  double b1,l1,b2,h2;
  Scanner stdin=new Scanner(System.in);
  Complex test1=new Complex(-7,0);
  Complex test2=new Complex(9,2);
  System.out.print("The complex no is: ");  test1.display();
  if (test1.isReal()==true)
  {   System.out.println("It is real"); }
  else
  {   System.out.println("It is not real"); }
  System.out.print("The complex no is: ");  test2.display();
  if (test2.isImag()==true)
  {  System.out.println("It is imaginary"); }
  else
  {  System.out.println("It is not imaginary"); }
  Complex x=new Complex(4,7);
  Complex y=new Complex(3,-2);
  Complex res=new Complex();
  System.out.print("The complex no X is: X=");  x.display();
  System.out.print("The complex no Y is: Y=");  y.display();
  res.mulComplexNos(x,y);
  System.out.print("The product of X and Y is: X*Y=");  res.display();
  res.mulComplexNos(x,(float)-5.1);
  System.out.print("The product of X and real number '-5.1' is: -5.1*X=");  
  res.display();
  res.mulComplexNos(x,"3i");
  System.out.print("The product of X and imaginary no '3i' is: 3i*X=");
  res.display();  
  res.addComplexNos(x,y);
  System.out.print("The sum of X and Y is: X+Y=");  res.display(); 
  res.addComplexNos(y,4); 
  System.out.print("The sum of Y and integer '4' is: Y+4="); res.display(); 
  res.subComplexNos(x,y);  
  System.out.print("The difference between X and Y is: X-Y=");
  res.display(); 
  res.subComplexNos(y,6);  
  System.out.print("The difference between Y and integer '6' is: Y-6=");
  res.display(); 
  }
}