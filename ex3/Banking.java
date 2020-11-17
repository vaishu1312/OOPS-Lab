import java.util.Random;
import java.util.Scanner;

class Account
{
private long acct_no;
private double acct_bal;
static double min_bal=7500;
Account() 
{  Random rnd = new Random();
   acct_no = 10000000 + rnd.nextInt(90000000);
   acct_bal=min_bal;    }
Account (long id, double amount)     //parameterized constructor 
{ acct_no=id;
  acct_bal=amount;  }
Account(Account x)           //copy constructor
{ this.acct_no=x.acct_no;
  this.acct_bal=x.acct_bal;   }

void deposit (double amount)  
{  acct_bal+=amount;
   System.out.println(amount + " rupees successfully deposited");   }
boolean withdraw (double amount)
{
 if (amount<acct_bal)  
 {  acct_bal-=amount;
    return true;
 }
 else
   return false;
}
long get_id ( )       {return acct_no;}
double get_balance ( ){return acct_bal;}
boolean transferMoney(Account from,double amnt)
{
 boolean j=from.withdraw(amnt);
 if(j==true)
 {  acct_bal+=amnt;   return true; }
 else
 { System.out.println("Insufficient balance");  return false;  }
}
void Displaydetails()
{
  System.out.println("Account no: "+acct_no);
  System.out.println("Balance   : "+acct_bal);
}
}

public class Banking
{
 public static void main(String args[])
 {
  boolean i;
  long no;
  double bal,amt;
  int ch=0;
  Scanner stdin=new Scanner(System.in);
  Account ravi=new Account();
  System.out.println("Account ravi successfully created");
  System.out.println("****Account Details of ravi****");
  ravi.Displaydetails();
  System.out.print("Enter mala's account id: ");
  no=stdin.nextLong();
  System.out.print("Enter mala's account balance: ");
  bal=stdin.nextDouble();
  Account mala=new Account(no,bal);
  System.out.println("Account mala successfully created");
  System.out.print("Enter amount to be deposited in mala's account: ");
  amt=stdin.nextDouble();
  mala.deposit(amt);
  System.out.println("Mala's account balance: "+mala.get_balance());
  System.out.print("Enter amount to be withdrawn from mala's account: ");
  amt=stdin.nextDouble();
  i=mala.withdraw(amt);
  do{
  if(i==true)
    System.out.println("Withdrawal successful");
  else
  { System.out.println("Insufficient balance");
    System.out.print("Press 1 to enter amount again\nPress 2 exit  ");
    ch=stdin.nextInt();   
    if(ch==1)
       i=mala.withdraw(amt); 
  }     
  }while(i==true && ch==1);
  System.out.println("****Account Details of mala****");
  mala.Displaydetails();
  Account leela=new Account(mala);
  System.out.println("Account leela successfully created");
  System.out.println("****Account Details of Leela****");
  leela.Displaydetails();
  Account jaya=new Account();
  System.out.println("Account jaya successfully created");
  System.out.println("****Account Details of jaya****");
  jaya.Displaydetails();
  System.out.println("1.Ravi\n2.Mala\n3.Leela");
  System.out.print("Enter the account from which you want to transfer money to jaya: ");
  ch=stdin.nextInt();
  if (ch>0 && ch<4)
  { System.out.print("Enter the amount to be transferred: ");
    amt=stdin.nextDouble();
    if(ch==1)
    {  if(jaya.transferMoney(ravi,amt)==true)
       System.out.println("Transfer successful!");
       System.out.println("Ravi's account balance : "+ravi.get_balance());   }
    else if(ch==2)
    {  if(jaya.transferMoney(mala,amt)==true)
       System.out.println("Transfer successful!");
       System.out.println("Mala's account balance: "+mala.get_balance());     }
    else if(ch==3)
    {  if(jaya.transferMoney(leela,amt)==true)
       System.out.println("Transfer successful!");
       System.out.println("Leela's account balance: "+leela.get_balance());   }
    System.out.println("Jaya's account balance: "+jaya.get_balance()); 
  }
  else
    System.out.println("Transfer unsuccessful due to lack of funds!");
}
}
 