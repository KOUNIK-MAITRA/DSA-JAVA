// O/1 Knapsnack Problem
import java.io.*;
import java.util.*;
class Knapsnack
{
    public static void main(String args[])
    {
        int w=10;// weight capacity of knacksnack
        int []val={10,40,30,50};// value of each item
        int []wt={5,4,6,3};// weight of items
        int ans=knapsnackProfit(val,wt,w);
        System.out.println("The maximum profit that can be obtained is Rs"+ans);
    }
    public static int knapsnackProfit(int[]val,int wt[],int w)
    {
        int n=wt.length;
        int mat[][]=new int[n+1][w+1]; // creating matrix
        
        // populating base cases
        for(int row=0;row<w+1;row++)
        { mat[0][row]=0; // making the first row 0
        }
        
        for(int col=0;col<n+1;col++)
        { mat[col][0]=0; // making the first col 0
        }
        
        for(int item=1;item<=n;item++)
        { for(int capacity=1;capacity<=w;capacity++)
            {
                int maxProfitWithoutCurr=mat[item-1][capacity];
                int maxProfitWithCurr=0;
                
                int weightOfCurr=wt[item-1]; //We use item -1 to account for the extra row at the top
                if(capacity>=weightOfCurr)
                { 
                    maxProfitWithCurr=val[item-1];
                    int remainingCapacity=capacity-weightOfCurr;
                    maxProfitWithCurr+=mat[item-1][remainingCapacity];
                }
                
                mat[item][capacity]=Math.max(maxProfitWithoutCurr,maxProfitWithCurr);
            }
        }
        //System.out.println(Arrays.deepToString(mat)); // Visualization of the table
         return mat[n][w]; 
    }
}