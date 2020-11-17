import java.lang.*;
import java.util.Random;

class ThreadDemo{
public static void main(String args[]){
System.out.println("Press Ctrl-C to stop");
while(true){
try{
ThreadA t1= new ThreadA();
Thread.sleep(1000);
}catch (InterruptedException e){
System.out.println("Main thread interrupted");
}
}
}
}

class ThreadA implements Runnable{
Thread t;
int rn;

ThreadA(){
t = new Thread(this);
System.out.println("Generating a random no....");
t.start(); 
}
public void run(){
Random rnd = new Random();
rn=1+rnd.nextInt(9);
System.out.println("The no is: "+rn);
if(rn%2==0)
 new ThreadB(rn);
else
 new ThreadC(rn);
}
}

class ThreadB implements Runnable{
Thread t;
int rn;
ThreadB(int rn){
this.rn=rn;
t = new Thread(this);
t.start();
}
public void run(){
 System.out.println("The no is even");
 System.out.println("It's square is: " +rn*rn);
}
}


class ThreadC implements Runnable{
Thread t;
int rn;
ThreadC(int rn){
this.rn=rn;
t = new Thread(this);
t.start();
}
public void run(){
 System.out.println("The no is cube");
 System.out.println("It's cube is: " +rn*rn*rn);
}
}

