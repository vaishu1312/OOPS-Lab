import java.util.Scanner;

interface stackrecord{
    void push(int x);
    int pop();
    int return_Top();
    boolean is_Empty();
    boolean is_Full();
    void makeEmpty();
    void displayStack();
}
	
class Stack implements stackrecord {
	int capacity;
	int top;
	int arr[];

     Stack(int c)   //constructor
     { System.out.println("Stack created successfully");
       top=-1;
       capacity=c;
       arr=new int[capacity];
     }   
	public boolean is_Empty ()
	{ return (top==-1);	}
	
	public boolean is_Full ()
	{ return (top+1 == capacity);  }
		
	public void push(int x)
	{  if (is_Full())
		System.out.println("Stack is full");
	   else
	     arr[++top] = x;  
	}	
	public int pop()
	{
         int x;
	 if(is_Empty())
         {  System.out.println("Stack is empty");
            return 0;
         } 
	 else
         {  x=arr[top];
	    top--;
            return x;
	 }
        }
	public void makeEmpty()
	{
          while(!is_Empty())
             pop();
          top=-1;
          System.out.println("Stack is now empty!");
	}
	
        public int return_Top()
	{
	  if(is_Empty())  
	  { System.out.println("Stack is empty");  return 0; }
	  return arr[top];   
	 }
	
        public  void displayStack(){
	  if(!is_Empty())  
         {  System.out.println("The stack elements are: "); 
            for(int i=0;i<=top;i++)
                System.out.println(arr[i]);   }
         else  	  {  System.out.println("Stack is empty"); }
          }
}

public class StackDemo{
	public static void main(String[] args) {
                int n,ele,choice;
                Scanner stdin= new Scanner(System.in);
		System.out.println("Enter the maximum no of elements: ");
                n=stdin.nextInt();
		Stack s= new Stack(n);
   do{
        System.out.println("****STACK MENU****\n1.Push\n2.Pop\n"+
         "3.Return top\n4.Make stack empty\n5.Display stack\n6.Exit"+
         "\nEnter choice:");
        choice=stdin.nextInt();
        switch(choice){
        case 1:
            System.out.println("Enter element to be pushed:");
            ele=stdin.nextInt();
            s.push(ele);
            break;
        case 2:
            ele=s.pop();
            if(ele!=0)
               System.out.println("Element popped: "+ele);
            break;
        case 3:
	    if(!s.is_Empty())  
            { ele=s.return_Top();
              System.out.println("Element at top: "+ele);  }
            else
 		  System.out.println("Stack is empty"); 
            break;
        case 4:
            s.makeEmpty();
            break;
        case 5:
            s.displayStack();
            break;
        case 6: break;
        default:System.out.println("Incorrect choice!");
        }
        }while(choice!=6);
	}
}