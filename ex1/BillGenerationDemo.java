import java.util.Scanner;
public class BillGenerationDemo {
	public static void main(String[] args) {
		Scanner stdin=new Scanner(System.in);
		BillGeneration cn = new BillGeneration();
		System.out.println("Enter the consumer no: ");
		cn.cno=stdin.nextInt();
		System.out.println("Enter the consumer name: ");
		cn.cname=stdin.next();
		System.out.println("1-Domestic\n2-Commercial");
		System.out.println("Enter your type of connection:");
		cn.type=stdin.nextInt();
		System.out.println("Enter your previous month reading: ");
		cn.prev=stdin.nextInt();
		System.out.println("Enter your current month reading: ");
		cn.curr=stdin.nextInt();
		cn.units=cn.curr-cn.prev;
		if(cn.type==1)
			cn.cost=cn.DomesticBill(cn.units);
		else if(cn.type==2)
			cn.cost=cn.CommercialBill(cn.units);
		cn.DisplayBill(cn);
		}
}
class BillGeneration {
    int cno;
    String cname;
    int prev;
    int curr;
    int type;
    int units;
    double cost=0;
   double DomesticBill(int units)
    {
	if (units<=100)
    		cost=1*units;
    	else if (units>100 && units<=200)
    		cost=100*1+(units-100)*2.5;
       	else if (units>200 && units<=500)
    		cost=100*1+100*2.5+(units-200)*4;
       	else if (units>500)
    		cost=100*1+100*2.5+300*4+(units-500)*6;
    	return cost;
    }
    double CommercialBill(int units)
    {
    	if (units<=100)
    		cost=2*units;
    	else if (units>100 && units<=200)
    		cost=100*2+(units-100)*4.5;
       	else if (units>200 && units<=500)
       		cost=100*2+100*4.5+(units-200)*6;
       	else if (units>500)
       		cost=100*2+100*4.5+300*6+(units-500)*7;
    	return cost;
    }
    void DisplayBill(BillGeneration cn)
    {
    	System.out.println("\n\tELECTRICITY BILL\n");
    	System.out.println("CONSUMER NO: "+ cn.cno);
    	System.out.println("CONSUMER NAME: "+ cn.cname);
    	if(cn.type==1)
    	    System.out.println("TYPE OF CONNECTON: DOMESTIC ");
    	else
    		System.out.println("TYPE OF CONNECTON: COMMERCIAL ");
    	System.out.println("NO OF UNITS CONSUMED: "+ cn.units);
    	System.out.println("AMOUNT TO BE PAID: "+ cn.cost);
    }	
  }