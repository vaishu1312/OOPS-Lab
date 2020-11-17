import java.lang.*;
class GenericMethod{
  public static <T extends Comparable<T>> void max(T[] arr,int n) {
    T max_ele = arr[0];
    for (int i=1;i<n;i++) 
        if (arr[i].compareTo(max_ele) > 0) 
            max_ele = arr[i];
System.out.println("\nThe maximum element is : " + max_ele);
}
}

class GenericDemo {
public static void main(String args[]) {
GenericMethod ob1 = new GenericMethod();
Integer nums[] = {1, 2, 3, 4, 5};
System.out.println("The values are: ");
for(int i=0;i<5;i++)
  System.out.print(nums[i]+" ");
ob1.max(nums,5);
System.out.println("The values are: ");
String strs[] = {"a", "b", "r", "x", "z"};
for(int i=0;i<5;i++)
  System.out.print(strs[i]+ " ");
ob1.max(strs,5);
}
}