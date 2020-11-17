import java.util.Scanner;
public class MatrixDemo {
   public static void main(String[] args) {
     int i,j,k,r1,c1,r2,c2,ch;
     Scanner stdin=new Scanner(System.in);
     do{
     System.out.println("\n1.Matrix Addition\n2.Matrix Subtraction");
     System.out.println("3.Matrix Multiplication\n");
     System.out.println("Enter your choice: ");
     ch=stdin.nextInt();
     MatrixOperation m=new MatrixOperation();
     do{
     System.out.println("Enter the no of rows and columns in matrix 1: ");
     r1=stdin.nextInt();
     c1=stdin.nextInt();
     System.out.println("Enter the no of rows and columns in matrix 2: ");
     r2=stdin.nextInt();
     c2=stdin.nextInt();

     if( ((ch==1 || ch==2) && (r1!=r2 || c1!=c2))  ||  (ch==3 && c1!=r2) )
     { System.out.println("\nNo of rows and columns are not equal");
        System.out.println("\nEnter the values again\n");
     }
     }while( ((ch==1 || ch==2) && (r1!=r2 || c1!=c2))  ||  (ch==3 && c1!=r2) );
     
       int a[][]=new int[r1][c1];
       int b[][]=new int[r2][c2];
       int res[][]=new int[r1][c2];

       System.out.println("Enter the elements for matrix-1");
       for(i=0;i<r1;i++) 		
       { System.out.println("Enter the elements for row-"+(i+1));
	 for(j=0;j<c1;j++)
	           a[i][j]=stdin.nextInt();
       }
       System.out.println("Enter the elements for matrix-2");
       for(i=0;i<r2;i++) 		
       { System.out.println("Enter the elements for row-"+(i+1));
	 for(j=0;j<c2;j++)
	           b[i][j]=stdin.nextInt();
       }
       System.out.println("Matrix -1: \n");
       m.matDisplay(a,r1,c2);
       System.out.println("Matrix -2: \n");
       m.matDisplay(b,r2,c2);
       if (ch==1)
	    res=m.computeSum(a, b,r1,c1);
       else if (ch==2)
              res=m.computeDiff(a, b,r1,c1);
       else if (ch==3)
	    res=m.computePro(a, b,r1,c1,r2,c2);
       else
                System.out.println("Invalid choice");

	if(ch>0 && ch<4) 
        {     System.out.println("The resultant matrix is\n");
	       m.matDisplay(res,r1,c2);
        }

       System.out.println("\nPress 1 to continue operation on matrices");
       System.out.println("Press 2 to exit");
       ch=stdin.nextInt();
       }while(ch==1);
}
}

class MatrixOperation {
	int i,j,k;
	Scanner stdin=new Scanner(System.in);
	int mat[][]=new int[3][3];

	int[][] Input(int r,int c)
	{
	    for(i=0;i<r;i++) 		
	    { System.out.println("Enter the elements for row-"+(i+1));
	          for(j=0;j<c;j++)
	                mat[i][j]=stdin.nextInt();
            }
	    return mat;
	}
	
	int[][] computeSum(int a[][],int b[][],int r,int c)
	{
         for(i=0;i<r;i++) 		
            for(j=0;j<c;j++)		
                mat[i][j]=a[i][j]+ b[i][j];
         return mat;
	}

	int[][] computeDiff(int a[][],int b[][],int r,int c)
	{
         for(i=0;i<r;i++) 		
            for(j=0;j<c;j++)		
                mat[i][j]=a[i][j]- b[i][j];
         return mat;
	}

	int[][] computePro(int a[][],int b[][],int r1,int c1,int r2,int c2)
	{
         for(i=0;i<r1;i++) 		
            for(j=0;j<c2;j++)
                for(k=0;k<r2;k++) 			
                   mat[i][j]+=a[i][k]*b[k][j];
         return mat;
	}
	
	void matDisplay(int mat[][],int r,int c)
	{
	 for(i=0;i<r;i++) 		
	 {   for(j=0;j<c;j++)	
	     	 System.out.print(mat[i][j]+"\t");
	      System.out.println();   
	  }
	}
}
