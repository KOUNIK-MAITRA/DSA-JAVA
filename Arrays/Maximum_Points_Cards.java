import java.io.*;
import java.util.*;
 class Maximum_Points_Cards
{
   public static void main(String args[])
   {
       int cardPoints[]={1,2,3,4,5,6,1};
       int k=3;
       System.out.println(maxScore(cardPoints,k));
    }
   static int maxScore(int[] cardPoints, int k) {
        
        int sum=0; int ans=0;
        int n=cardPoints.length;
        
        for(int ele : cardPoints)
            sum+=ele;
        
        if(n==k)
            return sum;
       
        int window=0;
        
        for(int i=0;i<n-k-1;i++)
            window+=cardPoints[i];
        
        for(int i=n-k-1;i<n;i++)
        {
            window+=cardPoints[i];
            ans=Math.max(ans,sum-window);
            
            window-=cardPoints[i-(n-k-1)];
        }
        
        return ans;
    }
}
