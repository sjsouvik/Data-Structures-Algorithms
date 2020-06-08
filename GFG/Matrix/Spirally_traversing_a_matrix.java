import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    
	    int t, m, n;
	    
	    t=sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        m=sc.nextInt();
	        n=sc.nextInt();
	        
	        int a[][]=new int[m][n];
	        
	        for(int i=0;i<m;i++)
	        {
	            for(int j=0;j<n;j++)
	                a[i][j]=sc.nextInt();
	        }
	        
            //to print spirally	        
            printSpirally(a, m, n);            
            System.out.println();
	    }	    
     }

     
     static void printSpirally(int a[][], int m, int n)
     {
        int r1=0, r2=m, c1=0, c2=n;
	        
        while(r1 < r2 && c1 < c2)
        {
            for(int i=c1;i<c2;i++)
            {
                System.out.print(a[r1][i]+" ");
            }
            
            r1++;
            
            for(int i=r1;i<r2;i++)
            {
                System.out.print(a[i][c2-1]+" ");
            }
            
            c2--;
            
            if(r1 < r2 && c1 < c2)
            {
                for(int i=c2-1;i>=c1;i--)
                {
                    System.out.print(a[r2-1][i]+" ");
                }
                
                r2--;
            }
            
            if(r1 < r2 && c1 < c2)
            {
                for(int i=r2-1;i>=r1;i--)
                {
                    System.out.print(a[i][c1]+" ");
                }
                
                c1++;
            }
        }

     }

}