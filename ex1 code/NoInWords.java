package ex1;

public class NoInWords {

	public static void main(String[] args) {
		int a;
		a=Integer.parseInt(args[0]);
		switch(a)
		{
		case 1:
			System.out.println("The number is one");
			break;
		case 2:
			System.out.println("The number is two");
			break;
		case 3:
			System.out.println("The number is three");
			break;
		case 4:
			System.out.println("The number is four");
			break;
		case 5:
			System.out.println("The number is five");
			break;
		default:
			System.out.println("Invalid Number");
		}
		
	}

}
