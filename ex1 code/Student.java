package ex1;

public class Student {
	public static void main(String args[]) {
		int m1,m2,m3,total;
		float avg;
		String name,dept;
		name=args[0];
		dept=args[1];
		m1=Integer.parseInt(args[2]);
		m2=Integer.parseInt(args[3]);
		m3=Integer.parseInt(args[4]);
		total=m1+m2+m3;
		avg=(float)total/3;
		System.out.println("NAME: "+name);
		System.out.println("DEPARTMENT: "+dept);
		System.out.println("MATHS: "+m1);
		System.out.println("ENGLISH: "+m2);
		System.out.println("PHYSICS: "+m3);
		System.out.println("TOTAL: "+total);
		System.out.println("AVERAGE: "+avg);
		
	}

}
