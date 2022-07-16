import java.io.*;
import java.util.*;
 class Ship_Capacity_D_Days
{
   public static void main(String args[])
   { int [] weights={1,2,3,4,5,6,7,8,9,10};
     int days=5;
     System.out.println(shipWithinDays(weights,days));
    }
     static boolean isPossible(int[] weights,int curr_maxMinimumWeight,int days )
    {
        int daysRequired=1;
        int weightsTaken=0;
        
        for(int i=0;i<weights.length;i++)
        {
            if(weights[i]>curr_maxMinimumWeight)
                return false;
            
            if(weightsTaken+weights[i]>curr_maxMinimumWeight)
            {
                daysRequired++;
                weightsTaken=weights[i];
                
                if(daysRequired>days)
                    return false;
            }
            else {
                weightsTaken+=weights[i];
            }
            
        }
        return true;
    }
    
    static int shipWithinDays(int[] weights, int days) {
        int minWeight=Integer.MAX_VALUE;
        int sumOfWeights=0;
        
        for(int weight : weights)
        {
            minWeight=Math.min(minWeight,weight);
            sumOfWeights+=weight;
        }
        
        int low=minWeight;
        int high=sumOfWeights;
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid= low+(high-low)/2;
            int curr_maxMinimumWeight= mid;
            
            if(isPossible(weights,curr_maxMinimumWeight,days))
            {
                ans=curr_maxMinimumWeight;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        
        return ans;
    }
}
