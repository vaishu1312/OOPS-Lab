package ex1;

public class Temperature {

	public static void main(String[] args) {
		float t;
		t=Float.parseFloat(args[0]);
		if (t>70)
			System.out.println("The temperature "+t+" is high.");
		else if (t<30)
			System.out.println("The temperature "+t+" is low.");
		else if (t>30 && t<70)
			System.out.println("The temperature "+t+" is medium.");


	
	}

}
