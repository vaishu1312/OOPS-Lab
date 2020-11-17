import java.util.*;

public class StringList {
public static void main(String[] args) {
Scanner stdin = new Scanner(System.in); 
ArrayList<String> fruits = new ArrayList<String>();
String str = null;
int choice = 0, position = 0,i;
boolean flag=true;
char c;
do {
System.out.println("\n****Array List Operations on String****");
System.out.print("1. Append a string at the end\n");
System.out.print("2. Insert a string at a given index\n");
System.out.print("3. Search for a string\n"+"4. Display all strings\n");
System.out.print("5. Display the Strings that begin with a letter\n");
System.out.print("6. Exit\n\nEnter your choice: "); 
choice = stdin.nextInt();
switch (choice)
{
case 1:
System.out.print("Enter a String: "); 
fruits.add(stdin.next());
break;

case 2:
System.out.print("Enter a string: "); 
str = stdin.next();
System.out.print("Enter a position to insert: ");
position = stdin.nextInt(); 
fruits.add(position-1, str);
System.out.println(str+" inserted at position "+position);
break;

case 3:
System.out.print("Enter the string to be searched: ");
str = stdin.next(); 
for (i=0;i<fruits.size();i++)
{ if( str.compareTo(fruits.get(i))==0 )
  { System.out.println("Element is present at the position "+(i+1));
    flag=false; break;
  }
}
if(flag)
  System.out.println("Element "+str+ " is not present");  
break;

case 4:
System.out.println("\nThe elements are: "); 
for (i=0;i<fruits.size();i++)
    System.out.println(i+1+". "+fruits.get(i)); 
break;

case 5:
System.out.print("Enter a letter: "); 
c=stdin.next().charAt(0);
System.out.println("The strings begining with "+c+ " are: ");
for (i=0;i<fruits.size();i++)
{   str=fruits.get(i);
    if ((str.charAt(0))==c )
         System.out.println(fruits.get(i)); 
}
break;

case 6:
break;

default:
System.out.println("Please enter valid input"); 
}
}while (choice != 6);
}
}