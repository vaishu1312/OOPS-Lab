import java.util.Scanner;
class Linear_Search
{
int a[] = new int[20];
int n,x;

int linear_Search(int a[],int n,int key)
{
int i;
for(i=0;i<n;i++)
  if(a[i]==key)
     break;
return i;
}
}

public class LinearSearchDemo
{
public static void main(String args[])
{
Scanner stdin=new Scanner(System.in);
int i,pos;
Linear_Search obj = new Linear_Search();
System.out.println("Enter the number of elements: ");
obj.n=stdin.nextInt();
System.out.println("Enter the elements: ");
for (i=0;i<obj.n;i++)
  obj.a[i]=stdin.nextInt();
System.out.println("Enter element to be searched: ");
obj.x=stdin.nextInt();
pos=obj.linear_Search(obj.a,obj.n,obj.x);
System.out.println("Element " +obj.x +" found at index "+pos);
}
}
