import java.util.Scanner;
public class Calculator{
  public static void main(String args[]) {
     int a=Integer.parseInt(args[0]);
     int b=Integer.parseInt(args[1]);
     char ch=args[2].charAt(0);    
     switch(ch)     {
     case ('+'):
         System.out.println("The sum is: "+(a+b)); break;
     case ('-'):
         System.out.println("The difference is: "+(a-b));break;
     case ('X'):
         System.out.println("The product is: "+(a*b));break;
     case ('/'):
         System.out.println("The quotient is: "+(a/b));break;
    case ('%'):
         System.out.println("The remainder is: "+(a%b));break; 
    default:
          System.out.println("Invalid operation");
   }  
}
}