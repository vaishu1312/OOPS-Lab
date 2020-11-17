import java.lang. *;

class Q {
int n;
boolean valueSet = false;

synchronized int get() {
while(!valueSet)
try {
wait();
} catch(InterruptedException e) {
System.out.println("InterruptedException caught");
}
System.out.println("Waiting for consumer to consume");
System.out.println("Consumed: " + n);
valueSet = false;
notify();
return n;
}

synchronized void put(int n) {
while(valueSet)
try {
wait();
} catch(InterruptedException e) {
System.out.println("InterruptedException caught");
}
this.n = n;
valueSet = true;
System.out.println("Waiting for producer to produce");
System.out.println("Produced: " + n);
notify();
}
}

class Producer implements Runnable {
Q q;
Producer(Q q) {
this.q = q;
new Thread(this, "Producer").start();
}
public void run() {
int i = 1;
while(true) {
  q.put(i++);
try{
Thread.sleep(1000);
}catch (InterruptedException e){ }
}
}
}
class Consumer implements Runnable {
Q q;
Consumer(Q q) {
this.q = q;
new Thread(this, "Consumer").start();
}
public void run() {
while(true) {
  q.get();
try{
Thread.sleep(1000);
}catch (InterruptedException e){ }
}
}
}
class PC {
public static void main(String args[]) {
Q q = new Q();
System.out.println("Press Control-C to stop.");
new Producer(q);
new Consumer(q);
}
}