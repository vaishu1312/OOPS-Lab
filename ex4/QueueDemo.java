import java.util.Scanner;

interface queuerecord{
int dequeue();
void enqueue(int x);
boolean is_Empty();
boolean is_Full();
int return_Front();
int return_Rear();
void displayQueue();
void makeEmpty();
}

class Queue implements queuerecord {
int capacity;
int front;
int rear;
int size;
int arr[];

Queue(int c)
{ System.out.println("Queue created successfully");
   rear=front=-1;
   size=0;
   capacity=c;
   arr=new int[capacity];
}

    public boolean is_Full ()
   {  return (size == capacity); }

   public boolean is_Empty ()
   { return (size==0);  }

   public void makeEmpty()
   { while(!is_Empty())
         dequeue();
      size=0; front=rear=-1;   
      System.out.println("Queue is now empty!");
  }
	
   public void enqueue(int x)
   { 
   if(rear+1==capacity)
	rear=0;
   else
	rear++;
   arr[rear]=x;
   if(front==-1) 
       front=0;
   size++;
   }

   public int dequeue()
   {
    int data;
    if(is_Empty())
    {  System.out.println("Queue is empty");  return 0  ;}
    else
    {
      data = arr[front];
      if(front==rear)  //only one element is present
        front=rear=-1; 
      else if(front+1 == capacity)
          front=0;  //front is pointing to end of arr
      else
         front++;
      size--;
     return data;
    }
}

    public int return_Front()
   {
	  if(is_Empty())  //stack not empty
		  System.out.println("Stack is empty");
	  return arr[front];   
   }

   public int return_Rear()
   {
	  if(is_Empty())  //stack not empty
		  System.out.println("Stack is empty");
	  return arr[rear];   
   }

   public  void displayQueue(){
 	  if(is_Empty())  
		  System.out.println("Queue is empty"); 
          else      
          {  
            System.out.println("The queue elements are: ");
            for(int i=front;i!=rear; i=(i+1)%capacity)
               System.out.println(arr[i]);
            System.out.println(arr[rear]);
          } //end else   
  }
}

public class QueueDemo{
	public static void main(String[] args) {
                int n,ele,choice;
                Scanner stdin= new Scanner(System.in);
		System.out.println("Enter the maximum no of elements: ");
                n=stdin.nextInt();
		Queue q=new Queue(n);
   do{
        System.out.println("****QUEUE MENU****\n1.Enqueue\n2.Dequeue\n"+
        "3.Return front element\n4.Return top element\n5.Display queue elements\n"+
        "6.Empty the queue\n7.Exit\nEnter choice:");
        choice=stdin.nextInt();
        switch(choice){
        case 1:
            if(!q.is_Full())
            { System.out.println("Enter element to be enqueued:");
              ele=stdin.nextInt();
              q.enqueue(ele);  }
            else  {   System.out.println("Queue is full");  }
            break;
        case 2:
            ele=q.dequeue();
            if(ele!=0)
               System.out.println("Element dequeued: "+ele);
            break;
        case 3:
            ele=q.return_Front();
            System.out.println("Element at top: "+ele);
            break;
        case 4:
            ele=q.return_Rear();
            System.out.println("Element at top: "+ele);
            break;
        case 5:
            q.displayQueue();
            break;
        case 6:
            q.makeEmpty();
            break;
        case 7: break;
        default:System.out.println("Incorrect choice!");
        }
        }while(choice!=7);
	}

}
