import java.util.Scanner;
public class OddEven {
	public static void main(String args[]) {
		int a;
		Scanner stdin=new Scanner(System.in);
		System.out.println("Enter a number: \t");
		a=stdin.nextInt();
		if (a%2==0)
			System.out.println("The number "+a+" is even.");
		else
			System.out.println("The number "+a+" is odd.");
         }
}
