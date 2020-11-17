import java.util.*;
import java.lang.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.*;
import java.util.Scanner;
import java.io.Console;
import java.io.*;
import java.io.Serializable;
import java.lang.instrument.Instrumentation;


interface Menu
{
	default void menuDisplay(){ 
    Food arr[]=new Food[15]; 
		for(int i=0;i<15;i++) { 
		arr[i]=new Food(); 
			arr[i].price=-1; 
		} 
       try{ 
            FileInputStream fin = new FileInputStream("food.bin"); 
            ObjectInputStream obj = new ObjectInputStream(fin); 
            Object ob = obj.readObject(); 
            arr = (Food[])ob; 
         } 
 catch(Exception e) { System.out.println(e);  } 
 
  int choice,i=0; 
      char x; 
   Clear.clrscr(); 
   System.out.println("\n\n\t\t*********MENU CARD*********"); 
     System.out.println("\n\n\t\tSNO       ITEM           PRICE       QTY\n" ); 
  System.out.println("\t\t***       *****          *****       ***");       
     for(i=0;i<arr.length;i++) 
     {	 if(arr[i].price!=-1) 
    	 {   
          System.out.printf("\n\t\t %-2d       %-10s",i+1,arr[i].i_name); 
          System.out.printf("     %-5.2f       %-4d",arr[i].price,arr[i].qty); 
          } 
         else 
    	    break; 
   } //end for 
    System.out.println("\n\n");  
}  
} 
 
class Clear 
{ 
public static void clrscr(){ 
    //Clears Screen in java 
    try { 
        if (System.getProperty("os.name").contains("Windows")) 
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
        else 
            Runtime.getRuntime().exec("clear"); 
    } catch (IOException | InterruptedException ex) {} 
} 
} 

class feedback implements Serializable 
{
String cname;
String str;
void get_feedback(String s,String n)
{
str=s;
cname=n;
}
}
 
class logout
{
public logout()
{
feedback fobj=new feedback();
String name,fback;
Scanner sc=new Scanner(System.in);
System.out.println("\n\tMeanwhile,please give us your feedback to improve our service :) \n");
System.out.print("\n\tName  : ");
name=sc.nextLine();
System.out.println("\tFeedback : ");
fback=sc.nextLine();
fobj.get_feedback(fback,name);
write_feedback_into_file(fobj);
System.out.println("\n\tTHANK YOU SO MUCH FOR YOUR VALUABLE FEEDBACK :)\n\tHOPE TO SEE YOU SOON!! ");
}

public static void write_feedback_into_file(feedback fobj)
{
File file=new File("feedback.bin");
try
{
FileOutputStream fout=new FileOutputStream(file);
ObjectOutputStream output=new ObjectOutputStream(fout);
output.writeObject(fobj);
output.close();
fout.close();
}catch(IOException e)
{
e.printStackTrace();
}
}
}

class flogin implements Runnable,Serializable
{

public void run()
{
File file=new File("feedback.bin");
try
{
int Min=0,Max=(int)(file.length());
FileInputStream fin=new FileInputStream(file);
ObjectInputStream input=new ObjectInputStream(fin);
feedback fb[]=new  feedback[30];
int i=0;
try
{
while(true)
{
fb[i]=(feedback)input.readObject();
i++;
}
}catch(EOFException e)
{
Max=i-1;
input.close();
fin.close();
}
catch(ClassNotFoundException e) {}
long pos=Min + (int)(Math.random() * ((Max - Min) + 1));
System.out.println("\n\t\tFEEDBACK FROM OUR CUSTOMERS\n");
System.out.println("\n\t\t   "+fb[(int)pos].str+"\n\t\t\t\t - "+fb[(int)pos].cname);
System.out.print("\n\nPLEASE WAIT...");
}catch(IOException e)
{
e.printStackTrace();
}
}//run
}//class

class userlogin implements Serializable,Cloneable
{
int flag=0;
String userid;
String pwd;
String emailid,name;
transient Scanner sc=new Scanner(System.in);
long mobno;
userlogin()
{
flag=0;}
void acct()
{
int ftemp=0;
if(flag==0)
{
System.out.println("\n\n\t\t1 : Create a new account - Sign Up\n\t\t2 : Have an account already - login\n\t\t3 : Go Bacck\n");
System.out.print("\n\t\tEnter your choice : ");
int opt=sc.nextInt();
switch(opt)
{
case 1:
Console console=System.console();
System.out.println("\n\n\tSIGN UP");
System.out.print("\tName  : ");
name=sc.next();
System.out.print("\tMobile Number  : ");
mobno=sc.nextLong();
System.out.print("\tEmail-id  : ");
emailid=sc.next();
System.out.print("\tUserid  : ");
userid=sc.next();
System.out.print("\tPassword  : ");
 char[] passwordChars = console.readPassword();
       pwd = new String(passwordChars);
//pwd=sc.next();
File file=new File("userdata.bin");
try
{
FileOutputStream fout=new FileOutputStream(file);
ObjectOutputStream output=new ObjectOutputStream(fout);
userlogin r=new userlogin();
r=(userlogin)this.clone();
output.writeObject(r);
output.close();
fout.close();
System.out.println("\n\tSUCCESSFULLY CREATED ACCOUNT");
acct();
}catch(IOException e)
{
e.printStackTrace();
}catch(CloneNotSupportedException e){}
break;
case 2 :
System.out.print("Userid  : ");
String uid=sc.next();
System.out.print("Password  : ");
console=System.console();
char p[]=console.readPassword();
String pid=new String(p);
try
{
File file1 = new File("userdata.bin");
FileInputStream fin=new FileInputStream(file1);
ObjectInputStream input=new ObjectInputStream(fin);
try
{
while(true)
{
userlogin temp=new userlogin();
temp=(userlogin)input.readObject();
if(temp.userid.equals(uid)&&temp.pwd.equals(pid))
{
flag=1;
name=temp.name;
break;
}
}//while
}catch(EOFException e)
{
System.out.println("\n\tINVALID USERID OR PASSWORD, TRY AGAIN :( ");
input.close();
fin.close();
acct();
}
catch(IOException e) {}
catch(ClassNotFoundException e) {}
}catch(FileNotFoundException e){}
catch (IOException e) {}
break;
case 3 : ftemp=1;
break;
}
try
{
if((flag==1)&&(ftemp!=1))
{
System.out.print("\n\tLOGGING IN...");
Thread.sleep(1000);
}
else if(ftemp!=1){
System.out.println("\nlogin failed...");
}
}catch(InterruptedException e)
{}
}
}
}

class RoomNotAvailableException extends Exception 
{ 
RoomNotAvailableException() 
{  System.out.println("\t\tSORRY! NO AVAILABLE ROOMS!");  } 
} 
 
class Room implements Serializable{ 
    int AC, allocated, bedSize, Rnum; 
    public Room(){ 
        allocated = 0; 
    } 
} 
 
class RoomImplement{ 
         final static int MAX_CAP=10; 
	 static Scanner sc; 
	 Room temp; 
 
	 static void reset_rooms() throws IOException { 
	        sc = new Scanner(System.in); 
	        System.out.println("\n\n\t\tTHIS WILL DELETE ALL THE RECORDS !! (if any)"); 
	        System.out.print("\n\t\t\tDO YOU WANT TO PROCEED (y/n) ? "); 
	        char c = sc.next().charAt(0); 
	        if(c == 'y' || c=='Y'){ 
	            Room[] arr = new Room[MAX_CAP+1]; 
	            for(int i=0; i<=MAX_CAP; i++){ 
	            	arr[i] = new Room(); 
	            	
	            } 
	   
File yourFile = new File("rooms.bin"); 
try{ 
yourFile.createNewFile(); // if file already exists will do nothing 
 
	            FileOutputStream fout = new FileOutputStream(yourFile); 
	            ObjectOutputStream objout = new ObjectOutputStream(fout); 
	            objout.writeObject(arr); 
objout.close(); 
fout.close(); 
System.out.println("\n\t\t      SUCCESSFULLY DELETED ALL RECORDS\n"); 
} 
catch (IOException e) { 
        e.printStackTrace(); 
    } 
	        } //end if 
	    } 
 
 
Room allot(){ 
	        Room[]  arr; 
	        temp = new Room(); 
	        temp.Rnum = -1; 
	        System.out.print("\n\t\tWant AC ? (y/n): "); 
	        sc = new Scanner(System.in); 
	        char ac_needed = sc.next().charAt(0); 
	        while(true){ 
	            if(ac_needed=='y' || ac_needed=='Y' || ac_needed=='n' || ac_needed=='N') break; 
	            System.out.print("\n\t\tWant AC ? (y/n): "); 
	            ac_needed = sc.next().charAt(0); 
	        } 
	        if(ac_needed=='y' || ac_needed=='Y'){ 
	            temp.AC = 1; 
	        } else temp.AC = 0; 
	        System.out.print("\n\t\tSingle or double bed ? (1/2): "); 
	        int c = sc.nextInt(); 
	        while(true){ 
	            if(c>0 && c<3) break; 
	            System.out.println("\n\t\tSingle or double bed ? (1/2): "); 
	            c = sc.nextInt(); 
	        } 
	         
	        if(c==1) temp.bedSize = 1; 
	        else temp.bedSize = 2; 
	         
	        try{ 
	            FileInputStream fin = new FileInputStream("rooms.bin"); 
	            ObjectInputStream obj = new ObjectInputStream(fin); 
	            Object ob = obj.readObject(); 
	            arr = (Room[])ob; 
	          
	            for(int i=1; i<=MAX_CAP; i++){ 
	                if(arr[i].allocated == 0){ 
	                    arr[i].AC = temp.AC; 
	                    arr[i].bedSize = temp.bedSize; 
	                    arr[i].allocated = 1; 
temp.allocated=1; 
	                    temp.Rnum = i; 
	             
	                    break; 
	                } 
	            } 
	        
	            fin.close(); 
	            FileOutputStream fout = new FileOutputStream("rooms.bin"); 
	            ObjectOutputStream objout = new ObjectOutputStream(fout); 
	            objout.writeObject(arr); 
	            objout.close(); 
	            fout.close(); 
	        } catch(Exception e){ 
	            System.out.println(e); 
	        } finally{ 
	            return temp; 
	        } 
	    } 
	     
int deAllot(int room_no){ 
	        try{ 
	            FileInputStream fin = new FileInputStream("rooms.bin"); 
	            ObjectInputStream obj = new ObjectInputStream(fin); 
	            Object ob = obj.readObject(); 
	            Room[] arr = (Room[])ob; 
	            if(room_no>MAX_CAP) { 
	                System.out.println("\n\t\tRoom is not allocated!"); 
	                fin.close(); 
	                return -1;   //ERROR allocating 
	            } 
	            else{ 
	                arr[room_no].allocated = 0; 
	                System.out.println("\n\t\t\tRoom no."+room_no+" has been vacated"); 
obj.close(); 
fin.close(); 
	                FileOutputStream fout = new FileOutputStream("rooms.bin"); 
	                ObjectOutputStream objout = new ObjectOutputStream(fout); 
	                objout.writeObject(arr); 
	                objout.close(); 
	                fout.close(); 
	                return 0;   //success 
	            } 
	        } catch(Exception e){ 
	            System.out.println(e); 
	        } 
			return -1; 
	    } 
} 
 
class Operations 
{ 
Scanner stdin = new Scanner(System.in); 
 
Customer checkIn() 
{ 
Customer newCustomer = new Customer(); 
Clear.clrscr(); 
 System.out.println("\n\n\t\t\t\tCHECK-IN MENU"); 
 System.out.println("\t\t\t\t*************"); 
System.out.print("\n\t\tEnter Customer name: "); 
newCustomer.name=stdin.next(); 
System.out.print("\n\t\tEnter Customer mobile number: "); 
newCustomer.mobile=stdin.nextLong(); 
System.out.print("\n\t\tEnter number of days of stay: "); 
newCustomer.days=stdin.nextInt(); 
RoomImplement newRoom = new RoomImplement(); 
newCustomer.ROOM=newRoom.allot(); 
try 
{ 
if (newCustomer.ROOM.Rnum == -1) 
 throw new RoomNotAvailableException(); 
else 
 { 
 System.out.println("\n\t\t\tROOM ALLOTTED SUCCESSFULLY!"); 
 newCustomer.iROOM=newRoom; 
 System.out.println("\n\t\t\t    THE ROOM NUMBER IS: "+newCustomer.ROOM.Rnum); 
 } 
} 
catch (RoomNotAvailableException e)  {  } 
finally 
{return newCustomer;} 
} 
 
void checkOut(Customer c) 
{ 
int deallotSuccess; 
deallotSuccess=(c.iROOM).deAllot(c.ROOM.Rnum); 
if(deallotSuccess==-1) 
 System.out.println("\n\t\t\tCheck-Out unsuccessful!"); 
else 
 { 
 System.out.println("\n\t\t\tCheck-Out successful!"); 
 System.out.println("\n\t   Generating the bill...Please wait for 10 seconds....."); 
 try{ 
 Thread.sleep(10000); 
 } 
 catch(InterruptedException e) { } 
 Bill f1bill = new Bill(); 
 f1bill.print_room_bill(c); 
 } 
} 
 
void orderFood(Customer cust) 
{ 
Bill fbill = new Bill(); 
fbill.food_bill(cust); 
} 
 
}//end operations 
 
 
class Food implements Serializable 
{ 
String i_name; 
float price; 
int qty;  //qty available currently 
int qtty; //for billing purposes 
 
Scanner stdin; 
} 
 
class Admin extends Operations implements Serializable,Menu
{ 
	Scanner stdin; 
	Food arr[]; 
 
	Admin() 
	{ 
		arr=new Food[15]; 
		for(int i=0;i<15;i++) { 
		arr[i]=new Food(); 
			arr[i].price=-1; 
		} 
	} 
 
 
int findItem(Food arr[], String toCheck){ 
		int s = arr.length; 
		for(int i=0; i<s; i++){ 
			if(arr[i].i_name.equalsIgnoreCase(toCheck)){ 
                               return i; 
			} 
		} 
		System.out.println("\nItem Not Found!\n"); 
		return -1;	//Error 
} 
 
void updateQty() 
{ 
String name; 
int n,x,q; 
stdin=new Scanner(System.in); 
try{ 
            FileInputStream fin = new FileInputStream("food.bin"); 
            ObjectInputStream obj = new ObjectInputStream(fin); 
            Object ob = obj.readObject(); 
            arr = (Food[])ob; 
	            FileOutputStream fout = new FileOutputStream("food.bin"); 
	            ObjectOutputStream objout = new ObjectOutputStream(fout); 
 
Clear.clrscr(); 
   System.out.println("\n\n\n\t\t UPDATE STOCK MENU"); 
   int i=0; 
   System.out.print("\n\n\t\tEnter no of items: "); 
   n=stdin.nextInt(); 
   while (i<n) 
   {   System.out.printf("\n\n\tEnter name of the product %d: ",i+1); 
       name=stdin.next(); 
      x=findItem(arr, name); 
      if(x!=-1)                
           {   
              System.out.print("\n\t\tEnter the quantity: ");  
              q=stdin.nextInt(); 
              arr[i].qty+=q; 
              System.out.printf("\n\t  Product %s stock updated\n",name); 
              i++; 
           } 
 
   }//end while 
   objout.writeObject(arr); 
} 
catch(Exception e) { System.out.println(e);  } 
} 
 
void writeFood() 
{ 
stdin=new Scanner(System.in); 
File yourFile = new File("C:/Users/elect/Desktop/code/food.bin"); 
try{ 
if (yourFile.exists()) 
{	  
    FileInputStream fin = new FileInputStream("food.bin"); 
    ObjectInputStream obj = new ObjectInputStream(fin); 
    Object ob = obj.readObject(); 
    arr = (Food[])ob; 
    obj.close(); 
    fin.close(); 
} 
 
 int n,choice; 
 do 
 { Clear.clrscr(); 
   System.out.println("\n\n\n\t\tADD PRODUCT MENU\n\n"); 
   System.out.print("\tEnter no of items: "); 
   n=stdin.nextInt(); 
   for(int i=0;i<n;i++) 
	{	 
	      for(int j=0;j<15;j++){ 
	             if(arr[j].price==-1){ 
               System.out.printf("\n\n\tEnter details for product %d:-",i+1); 
        	System.out.print("\n\n\tEnter product name: ");  
		arr[j].i_name=stdin.next(); 
		System.out.print("\n\tEnter MRP: "); 
		arr[j].price=stdin.nextFloat(); 
		System.out.print("\n\tEnter qty: "); 
		arr[j].qty=stdin.nextInt(); 
                break;  
                 } //end if 
               }// end for j             
     }//end for i 
   if (!yourFile.exists()) 
   {    yourFile.createNewFile(); // if file already exists will do nothing 
   	            FileOutputStream fout = new FileOutputStream(yourFile); 
   	           ObjectOutputStream objout = new ObjectOutputStream(fout); 
   	        objout.writeObject(arr); 
   	        objout.close(); 
   	        fout.close(); 
   } 
   else 
   { 
               FileOutputStream fout = new FileOutputStream("food.bin"); 
   	           ObjectOutputStream objout = new ObjectOutputStream(fout); 
   	        objout.writeObject(arr); 
	        objout.close(); 
   	        fout.close(); 
   } 
      
  System.out.println("\n\tDo you want to add more items?\n"); 
  System.out.println("\tPress 1 to add more items / Press 0 to return ");              choice=stdin.nextInt(); 
 }while(choice==1); 
} 
catch(Exception e) { System.out.println(e);  } 
} 
} 
 
 
class Bill{ 
Scanner stdin; 
ArrayList<Food> items= new ArrayList<Food>(); 
 float ac_charge, bed_charge; 
 float tax,total_charge, amt; 
 
void print_room_bill(Customer c) 
{ 
 int i; 
 Clear.clrscr(); 
 System.out.println("\n\n\t*******************************ROOM BILL*******************************\n"); 
  System.out.println("\n\t\t\t\t HOTEL XYZ\n\t\t\t  CARING LIKE YOUR FAMILY\n\n"); 
 System.out.printf("\n\n\tCUSTOMER NAME      : %s",c.name); 
 System.out.printf("\n\n\tCUSTOMER MOBILE NO : %s",c.mobile); 
 System.out.printf("\n\n\tROOM NO            : %s",c.ROOM.Rnum); 
 if(c.ROOM.AC==1) 
 {  
 System.out.printf("\n\n\tROOM TYPE          : AC"); 
   tax=(float) 0.1;  ac_charge=1000; } 
 else 
 {  
 System.out.printf("\n\n\tROOM TYPE          : NON-AC"); 
 tax=(float) 0.05;   ac_charge=0;  } 
 if(c.ROOM.bedSize==1) 
 { 
  System.out.printf("   SINGLE-BED");   bed_charge=500;  } 
 else 
 { System.out.printf("   DOUBLE-BED");   bed_charge= 800; } 
 System.out.printf("\n\n\tNO.OF DAYS         : %d",c.days); 
 total_charge=ac_charge+bed_charge; 
 System.out.printf("\n\n\tROOM RENT(PER-DAY) : %.2f",total_charge); 
 amt=total_charge*c.days; 
 tax=tax*amt; 
 System.out.printf("\n\n\tTAX                : %.2f",tax); 
 amt+=tax; 
 System.out.printf("\n\n\t\t\t\t\t\tTOTAL AMOUNT : %.2f\n\n",amt); 
} 
 
boolean checkItem(Food arr[], String toCheck){ 
		int s = arr.length; 
		for(int i=0; i<s; i++){ 
			if(arr[i].i_name.equalsIgnoreCase(toCheck)){ 
			    if(arr[i].qty<1){ 
		                    System.out.println("\nItem out of stock\n");   return false;  } 
                            else 
                                return true;  
			} 
		} 
		System.out.println("\nItem Not Found!\n"); 
		return false;	//Error 
	} 
 
 
void food_bill(Customer c) //this fn should be called to order food 
{ 
char choice; 
Food f; 
stdin=new Scanner(System.in); 
Food arr[]=new Food[20]; 
for(int i=0;i<20;i++) 
{ 
 arr[i]=new Food(); 
} 
 
 try{ 
            FileInputStream fin = new FileInputStream("./food.bin"); 
            ObjectInputStream obj = new ObjectInputStream(fin); 
            Object ob = obj.readObject(); 
            arr = (Food[])ob; 
 } 
 catch(Exception e) { System.out.println(e);  } 
Clear.clrscr(); 
System.out.println("\n\n\n\t\t*******Order your food here*******\n"); 
do 
{   f=new Food(); 
    System.out.print("\n\t\tEnter item name: "); 
    f.i_name=stdin.next(); 
    if(checkItem(arr,f.i_name)) 
    {      System.out.print("\n\t\tEnter quantity: "); 
           f.qtty=stdin.nextInt(); 
           items.add(f); 
    } 
    System.out.print("\n\t\tContinue ordering?(y/n): "); 
    choice=stdin.next().charAt(0); 
}while(choice=='y' || choice=='Y'); 
System.out.print("\n\t\tDo you want to proceed to billing?(y/n): "); 
choice=stdin.next().charAt(0); 
if (choice=='y' || choice=='Y') 
{ 
System.out.println("\n\n\t   Generating the bill...Please wait for 10 seconds....."); 
 try{ 
 Thread.sleep(10000); 
 } 
 catch(InterruptedException e) { } 
  print_food_bill(c); 
} 
else 
  return; 
} 
 
 double getPrice(Food arr[], String toFind){ 
		int s = arr.length; 
		for(int i=0; i<s; i++){ 
			if(arr[i].i_name.equalsIgnoreCase(toFind)){ 
				return arr[i].price; 
			} 
		} 
		System.out.println("Item Not Found!"); 
		return -1;	//Error 
} 
 
void print_food_bill(Customer c) 
{ 
 int i; 
 float price; 
  
Food arr[]=new Food[20]; 
for( i=0;i<20;i++) 
{ 
 arr[i]=new Food(); 
} 
 try{ 
            FileInputStream fin = new FileInputStream("./food.bin"); 
            ObjectInputStream obj = new ObjectInputStream(fin); 
            Object ob = obj.readObject(); 
            arr = (Food[])ob; 
 } 
 catch(Exception e) { System.out.println(e);  } 
 Clear.clrscr(); 
 System.out.println("\n\n\t***********************FOOD BILL***********************\n"); 
  System.out.println("\n\t\t\t\t HOTEL XYZ\n\t\t\t  CARING LIKE YOUR FAMILY\n"); 
  System.out.printf("\n\n\tCUSTOMER NAME      : %s",c.name); 
  System.out.printf("\n\n\tCUSTOMER MOBILE NO : %s",c.mobile); 
  System.out.printf("\n\n\tROOM NO            : %s\n\n",c.ROOM.Rnum); 
  System.out.println("\n\n\tSNO       ITEM           PRICE       QTY    AMOUNT    \n" ); 
  System.out.println("\t***       *****          *****       ***    ******"); 
  for( i=0;i<items.size();i++) 
  { 
    System.out.printf("\n\t %-2d       %-10s",i+1,items.get(i).i_name); 
    price=(float) getPrice(arr,items.get(i).i_name); 
    float  t=(items.get(i).qtty)* price; 
    amt+=t; 
    System.out.printf("     %-5.2f       %-4d   %-5.2f",price,items.get(i).qtty,t); 
  } 
  System.out.printf("\n\n\n\t\t\t\t\tTOTAL AMOUNT : %.2f\n\n",amt); 
} 
 
} 
 
 
class Customer implements Menu
{ 
String name; 
Long mobile; 
Room ROOM; 
RoomImplement iROOM; 
int days; 
Scanner stdin = new Scanner(System.in); 
int allotSuccess;

 
void checkIn() 
{ 
Clear.clrscr(); 
 System.out.println("\n\n\t\t\t\tCHECK-IN MENU"); 
 System.out.println("\t\t\t\t*************"); 
System.out.print("\n\t\tEnter Customer name: "); 
this.name=stdin.next(); 
System.out.print("\n\t\tEnter Customer mobile number: "); 
this.mobile=stdin.nextLong(); 
System.out.print("\n\t\tEnter number of days of stay: "); 
this.days=stdin.nextInt(); 
RoomImplement newRoom = new RoomImplement(); 
this.ROOM=newRoom.allot(); 
try 
{ 
if (this.ROOM.Rnum == -1) 
 throw new RoomNotAvailableException(); 
else 
{ 
System.out.println("\n\t\t\tROOM ALLOTTED SUCCESSFULLY!"); 
this.iROOM=newRoom; 
 System.out.println("\n\t\t\t    THE ROOM NUMBER IS: "+this.ROOM.Rnum); 
} 
} 
catch (RoomNotAvailableException e) {  } 
finally 
{return;} 
} 
 
void checkOut() 
{ 
int deallotSuccess; 
deallotSuccess=(this.iROOM).deAllot(this.ROOM.Rnum); 
if(deallotSuccess==-1) 
 System.out.println("\n\t\t\tCheck-Out unsuccessful!"); 
else 
 { 
 System.out.println("\n\t\t\tCheck-Out successful!"); 
 System.out.println("\n\t   Generating the bill...Please wait for 10 seconds....."); 
 try{ 
 Thread.sleep(10000); 
 } 
 catch(InterruptedException e) { } 
 Bill f1bill = new Bill(); 
 f1bill.print_room_bill(this); 
} 
} 
void orderFood() 
{ 
Bill fbill = new Bill(); 
fbill.food_bill(this); 
} 
} 
 
class Employee extends Operations implements Menu
{ 

} 
 
class Hotel 
{ 
public static void main(String[] args) 
{ 
Scanner stdin = new Scanner(System.in); 
int mainch,empch,cusch,admch,foodch; 
int rn,ch2=0; 
Employee emp = new Employee(); 
Customer cus = new Customer(); 
Admin adm = new Admin(); 
ArrayList<Customer> clist= new ArrayList<Customer>(); 
 
do 
{ 
Clear.clrscr(); 
System.out.println("\n\n\t\t\tWELCOME TO ABC HOTEL"); 
System.out.println("\t\t\t********************"); 
System.out.println("\n\t\t\t      MAIN MENU\n\n\t\t\t1.ADMIN\n\t\t\t2.EMPLOYEE\n\t\t\t3.CUSTOMER\n\t\t\t4.EXIT"); 
System.out.print("\n\t\t\tEnter your choice: "); 
mainch=stdin.nextInt(); 
switch(mainch) 
{ 
case 1: 
do{ 
 Clear.clrscr(); 
 System.out.println("\n\n\t\t\t\tADMIN MENU"); 
 System.out.println("\t\t\t\t**********"); 
System.out.println("\n\t\t\t1.CHECK-IN\n\t\t\t2.CHECK-OUT\n\t\t\t3.ORDER FOOD\n\t\t\t4.ADD NEW ITEMS TO MENU\n\t\t\t5.VIEW MENU-CARD\n\t\t\t6.UPDATE STOCK\n\t\t\t7.DELETE ALL THE RECORDS\n\t\t\t8.GO BACK"); 
System.out.print("\n\t\t\tEnter your choice: "); 
admch=stdin.nextInt(); 
switch(admch) 
{ 
 case 1: 
   cus=adm.checkIn(); 
   if(cus.ROOM.Rnum != -1) 
       clist.add(cus); 
   break; 
 case 2: 
   System.out.print("\n\t\t\tEnter the room no: "); 
   rn=stdin.nextInt(); 
   if(rn>RoomImplement.MAX_CAP) 
      System.out.println("\n\t\t\tNo such room!!"); 
   else  
   { 
    for(int i=0;i<clist.size();i++) 
      if(clist.get(i).ROOM.Rnum==rn) 
      {   adm.checkOut(clist.get(i)); 
          clist.remove(i); 
          rn=-1; 
      } 
   if(rn!=-1) 
      System.out.println("\n\t\t\tRoom not allocated yet!"); 
   } 
   break;      
 case 3: 
   System.out.print("\n\t\t\tEnter the room no: "); 
   rn=stdin.nextInt(); 
   for(int i=0;i<clist.size();i++) 
      if(clist.get(i).ROOM.Rnum==rn)
          {
           adm.menuDisplay();
           System.out.println("\n\t\tProceed to ordering?(yes=1/no=0)");
	  foodch=stdin.nextInt();
	  if (foodch==1)
           {
             adm.orderFood(cus);
	     rn=-1;
	   }
          else
           {
	     rn=-1;
             break;
           }
          }
   if(rn!=-1) 
      System.out.println("\n\t\t\tNo such room!!"); 
   break; 
 case 4: 
   adm.writeFood(); 
   break; 
 case 5: 
   adm.menuDisplay(); 
   break; 
 case 6: 
  adm.updateQty(); 
   break; 
 case 7: 
   try{  RoomImplement.reset_rooms();  } 
   catch(IOException e) { } 
 case 8: 
   ch2=0; 
   break; 
 default:  
   System.out.println("\t\t\tInvalid choice"); 
   break; 
} 
if(admch!=8) 
 { System.out.println("\n\tPress 1 to go back to admin menu / Press 0 to go to main menu "); 
  ch2=stdin.nextInt(); 
 } 
}while(ch2==1);  
 break; 
 
case 2: 
 
 do 
 { 
 Clear.clrscr(); 
 System.out.println("\n\n\t\t\tEMPLOYEE MENU:"); 
 System.out.println("\n\t\t\t1.CHECK-IN\n\t\t\t2.CHECK-OUT\n\t\t\t3.ORDER FOOD\n\t\t\t4.VIEW MENU-CARD\n\t\t\t5.GO BACK"); 
System.out.print("\n\t\t\tEnter your choice: "); 
 empch=stdin.nextInt(); 
  
 switch(empch) 
 { 
 case 1: 
   cus=emp.checkIn(); 
   if(cus.ROOM.Rnum != -1) 
       clist.add(cus); 
   break; 
 case 2: 
   System.out.print("\n\t\t\tEnter the room no: "); 
   rn=stdin.nextInt(); 
   if(rn>RoomImplement.MAX_CAP) 
      System.out.println("\n\t\t\tNo such room!!"); 
   else  
   { 
    for(int i=0;i<clist.size();i++) 
      if(clist.get(i).ROOM.Rnum==rn) 
      {   emp.checkOut(clist.get(i)); 
          clist.remove(i); 
          rn=-1; 
      } 
    if(rn!=-1) 
      System.out.println("\n\t\t\tRoom not allocated yet!"); 
   } 
   break; 
 case 3: 
   System.out.print("\n\t\t\tEnter the room no: "); 
   rn=stdin.nextInt(); 
   for(int i=0;i<clist.size();i++) 
      if(clist.get(i).ROOM.Rnum==rn) 
      {   
          adm.menuDisplay(); 
	  System.out.println("\n\t\tProceed to ordering?(yes=1/no=0)");
	  foodch=stdin.nextInt();
	  if (foodch==1)
           {
             emp.orderFood(cus);
	     rn=-1;
	   }
          else
           {
	     rn=-1;
             break;
           }
      } 
   if(rn!=-1) 
      System.out.println("\n\t\t\tNo such room!!"); 
   break; 
 case 4: 
 emp.menuDisplay();
 break; 
 case 5: 
   ch2=0; 
   break; 
 default:  
   System.out.println("\t\t\tInvalid choice"); 
   break; 
 } 
if(empch!=5) 
 { System.out.println("\n\tPress 1 to go back to employee menu / Press 0 to go to main menu "); 
  ch2=stdin.nextInt(); 
 } 
}while(ch2==1); 
 break; 
 

case 3:
Clear.clrscr();
Scanner sc=new Scanner(System.in);
userlogin data=new userlogin();
System.out.println(" ");
data.acct();
flogin v=new flogin();
Thread t=new Thread(v);
t.start();
try { Thread.sleep(4000); }
catch(InterruptedException e) { }
if(data.flag==1)
{

do
{
Clear.clrscr(); 
 System.out.println("\n\n\t\t\tCUSTOMER MENU:");
 System.out.println("\n\t\t\t1.CHECK-IN\n\t\t\t2.CHECK-OUT\n\t\t\t3.ORDER FOOD\n\t\t\t4.VIEW MENU-CARD\n\t\t\t5.LOG OUT");
System.out.print("\n\t\t\tEnter your choice: ");
 cusch=stdin.nextInt();
 switch(cusch)
 {
 case 1:
   cus.checkIn();
   if(cus.ROOM.Rnum != -1)
       clist.add(cus);
   break;
 case 2:
   System.out.print("\n\t\t\tEnter your room no: ");
   rn=stdin.nextInt();
   if(rn>RoomImplement.MAX_CAP)
      System.out.println("\n\t\t\tNo such room!!");
   else 
   {
    for(int i=0;i<clist.size();i++)
      if(clist.get(i).ROOM.Rnum==rn)
      {   clist.get(i).checkOut();
          clist.remove(i);
          rn=-1;
      }
    if(rn!=-1)
      System.out.println("\n\t\t\tRoom not allocated yet!");
   }
   break;
 case 3: 
   System.out.print("\n\t\t\tEnter your room no: "); 
   rn=stdin.nextInt(); 
   for(int i=0;i<clist.size();i++) 
      if(clist.get(i).ROOM.Rnum==rn) 
      {
          adm.menuDisplay();
          System.out.println("\n\t\tProceed to ordering?(yes=1/no=0)");
	  foodch=stdin.nextInt();
	  if (foodch==1)
           {
             clist.get(i).orderFood();
	     rn=-1;
	   }
          else
           {
	     rn=-1;
             break;
           }
 
      } 
   if(rn!=-1) 
      System.out.println("\n\t\t\tNo such room!!"); 
   break; 

 case 4: 
  cus.menuDisplay();
 break; 
 case 5:
System.out.println(" ");
System.out.print("\n\t"+data.name+", Are you sure you want to logout? (Y/N) : ");
char ch=sc.next().charAt(0);
if(ch=='y' || ch=='Y')
{
System.out.println("\t\tLOGGING OUT...PLEASE WAIT...");
try { Thread.sleep(2000); }
catch(InterruptedException e) { }
new logout();
data.userid="";
data.pwd="";
data.flag=0;
System.out.println("\t\tSUCCESSFULLY LOGGED OUT :)");
}
  ch2=0;
   break;
 default: 
   System.out.println("\t\t\tInvalid choice");
   break;
 }
if(cusch!=5)
 { System.out.println("\n\tPress 1 to go back to customer menu / Press 0 to go to main menu ");
  ch2=stdin.nextInt();
 }
 }while(ch2==1);
}//flg 1
break;
case 4: ch2=0;
  break;
default:
 System.out.println("\t\t\tInvalid choice!!");
 break;   
}
if(mainch!=4)
 { System.out.println("\n\tPress 1 to go back to main menu / Press 0 to exit ");
  ch2=stdin.nextInt();
 }
}while(ch2==1);
System.out.println("\t\t\tTHANK YOU!VISIT AGAIN!");
}
} 
