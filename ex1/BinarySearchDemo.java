import java.util.Scanner;
class Binary_Search
{
int a[] = new int[20];
int n,x;

void bubble_Sort(int a[],int n)
{
int i,j,temp;
for (i=0;i<n;i++)
  for (j=0;j<n-1-i;j++)
   if (a[j]>a[j+1])
   { temp=a[j];
     a[j]=a[j+1];
     a[j+1]=temp;
   }
System.out.println("The sorted list: ");
for (i=0;i<n;i++)
   System.out.print(a[i] + "\t" );
}

int binary_Search(int a[],int n,int key)
{
int start=0,mid=0,end=n-1;
mid=(int)((start+end)/2);
while (a[mid] != key)
{
  if (a[mid]>key)
  {
   end=mid-1;
   mid=(start+end)/2;
  }
  else if (a[mid]<key)
  {
   start=mid+1;
   mid=(start+end)/2;
   }
}
return mid;
}
}

public class BinarySearchDemo
{
public static void main(String args[])
{
Scanner stdin=new Scanner(System.in);
int i,pos;
Binary_Search obj = new Binary_Search();
System.out.println("Enter the number of elements: ");
obj.n=stdin.nextInt();
System.out.println("Enter the elements: ");
for (i=0;i<obj.n;i++)
  obj.a[i]=stdin.nextInt();
obj.bubble_Sort(obj.a,obj.n);
System.out.println("\nEnter element to be searched: ");
obj.x=stdin.nextInt();
pos=obj.binary_Search(obj.a,obj.n,obj.x);
System.out.println("Element " +obj.x +" found at index "+pos);
}
}