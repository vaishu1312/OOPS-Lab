package ex1;

public class OddEven {
	public static void main(String args[]) {
		int a;
		a=Integer.parseInt(args[0]);
		if (a%2==0)
			System.out.println("The number "+a+" is even.");
		else
			System.out.println("The number "+a+" is odd.");

	}

}
