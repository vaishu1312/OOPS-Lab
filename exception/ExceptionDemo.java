import java.util.Random;
import java.util.Scanner;

class PANFormatMismatchException extends Exception
{
 PANFormatMismatchException()
 { System.out.println("PAN format does not match!");  }
}

class PANRequiredException extends Exception
{
 PANRequiredException()
 { System.out.println("PAN No is required for transactions"
                                        +" above 25000"); }
}
 
class MinBalRequiredException extends Exception
{
  MinBalRequiredException()
  { System.out.println("Minimum balance of 2500 required"); }
}

class NotEnougMoneyInAccountException extends Exception
{
  NotEnougMoneyInAccountException()
  {   System.out.println("Insufficient balance");  }
}

class AccountNotFoundException extends Exception
{
 AccountNotFoundException()
  {   System.out.println("No such Account exists!");  }
}

class BranchNotFoundException extends Exception
{
 BranchNotFoundException() 
 { System.out.println("No such branch exists"); }
}

class Account
{
public String name;
public long acct_no;
public String branch;
public double acct_bal;
public String PAN;

Account (String name,String branch,double amount)     
{ Random rnd = new Random();
  this.name=name;
  acct_no = 10000 + rnd.nextInt(90000);
  this.branch=branch;
  acct_bal=amount;  
}

public boolean checkFormat(String pan)
{
 int i=0;
 for(i=0;i<5||i==9;i++)   
   if(!Character.isLetter(pan.charAt(i)))  
     return false;     
 for(i=5;i<9;i++)    
  if(!Character.isDigit(pan.charAt(i)))  
     return false;   
 return true;
}

public void depositMoney (double amount) throws
                    PANFormatMismatchException
{  Scanner stdin= new Scanner(System.in);
   if(amount>25000)
   {
    try
    {  throw new PANRequiredException();  }
    catch (PANRequiredException e)
    {
     System.out.println("Enter your 10 digit PAN No: ");
     PAN=stdin.next();
     if(!checkFormat(PAN))
         throw new PANFormatMismatchException();
    }
   }
   acct_bal+=amount;
   System.out.println(amount + " rupees" 
              +" successfully deposited");  
}


public boolean withdrawMoney (double amount) 
throws MinBalRequiredException,NotEnougMoneyInAccountException
{
 if (amount>acct_bal)  
   throw new NotEnougMoneyInAccountException();  
 else if(acct_bal-amount<2500)
   throw new MinBalRequiredException(); 
 else
 { acct_bal-=amount;   
   System.out.println(amount + " rupees" 
   +" successfully withdrawn");   return true;  } 
}

public static int searchAccount(Account arr[],int n,long no)  
                          throws  AccountNotFoundException
 { 
 int flag=0,i;
  for (i=0;i<n;i++)
      if(arr[i].acct_no==no)  {flag=1;  break;  }
  if (flag==0)
    throw new AccountNotFoundException(); 
  return i; 
 }


public void displayDetails()
{ 
  System.out.println("\nAccount no: "+acct_no);
  System.out.println("Name      : "+name);
  System.out.println("Branch    : "+branch);
  System.out.println("Balance   : "+acct_bal+"\n");
}
}

public class ExceptionDemo
{
 public static void main(String args[])  throws 
  NotEnougMoneyInAccountException,BranchNotFoundException,
  MinBalRequiredException,AccountNotFoundException,
  PANFormatMismatchException
 {
  int i,n,j,ch;
  long no;
  double bal,amt;
  String name,branch;
  Scanner stdin=new Scanner(System.in);
  System.out.print("Enter the no of customers: ");  
  n=stdin.nextInt();   
  Account arr[] =new Account[n];  
  for (i=0;i<n;i++)
  {System.out.print("Enter customer's name: ");
   name=stdin.next();
   System.out.print("Enter customer's branch(egmore/perambur): ");
   branch=stdin.next();
   if (!(branch.equals("egmore") || branch.equals("perambur") ) )
      throw new BranchNotFoundException();
   System.out.print("Enter your balance: ");
   bal=stdin.nextDouble();
   arr[i]= new Account(name,branch,bal);
  }

  System.out.println("\n****Account Details****");
  for (i=0;i<n;i++)
    arr[i].displayDetails();  
  do {
  System.out.println("**MENU**");
  System.out.println("1.Deposit\n2.Withdrawal"+
        "\n3.Search for an account\n4.Exit");
  System.out.print("Enter your choice: ");
  ch=stdin.nextInt();
  switch(ch)
  {
  case 1:
  System.out.print("Enter account no in which" 
                    +" you want to deposit: "); 
  no=stdin.nextLong();  
  j=Account.searchAccount(arr,n,no);  
  System.out.print("Enter amount to be deposited" 
                              +" in the account: ");
  amt=stdin.nextDouble();
  arr[j].depositMoney(amt);
  System.out.println("\n****Account Details****");
  arr[j].displayDetails();  
  break;

  case 2:
  System.out.print("Enter account no from which"
                      +" you want to withdraw: "); 
  no=stdin.nextLong();  
  j=Account.searchAccount(arr,n,no);  
  System.out.print("Enter amount to be withdrawn"
                          +" from the account: ");
  amt=stdin.nextDouble();
  arr[j].withdrawMoney(amt); 
  System.out.println("\n****Account Details****");
  arr[j].displayDetails();    
  break;
  
  case 3:
  System.out.print("Enter account no to be searched: ");
  no=stdin.nextLong();  
  j=Account.searchAccount(arr,n,no);
  System.out.println("\n****Account Details****");
  arr[j].displayDetails();
  break;
 
 case 4: 

 default:
  System.out.print("Invalid choice");
 }
 } while(ch!=4);
}
}