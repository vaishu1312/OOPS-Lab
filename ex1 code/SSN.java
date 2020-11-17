public class SSN {

	public static void main(String[] args) {
		{  int a=3;
			SSNDetails sd= new SSNDetails();
			
		System.out.println("through method: ");
		sd.getDeptCount(a);
		sd.printDeptCount();
		System.out.println("through variable: "+sd.dept);
		}
	}

}

class SSNDetails {

	 int dept;
	void getDeptCount(int c)
	{
		dept=c;
	}
		void printDeptCount()
	
	{
		System.out.println("Department count: "+dept);


	}
}