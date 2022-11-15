import java.io.*;
import java.util.*;
class AggressiveCows
{
    public static void main (String args[])
    {
        int stalls[]={1,2,4,8,9};
        int n=5;
        int cows=3;
        System.out.println(minMaxDistance_bw_Cows(n,stalls,cows));
    }

    static boolean isPossible(int stalls[],int n,int cows, int minDist){
        int count_cows=1;
        int lastPlacedCow=stalls[0]; // place the first cow

        for(int i=1;i<n;i++)
        {
            if(stalls[i]-lastPlacedCow>=minDist) // if the cow can be placed
            { count_cows++;
              lastPlacedCow=stalls[i];
            }
        }
        if(count_cows>=cows) // if the cows can be placed
        {
            return true;
        }
        else
            return false;
    }

    static int minMaxDistance_bw_Cows(int n,int[]stalls, int cows)
    {
        Arrays.sort(stalls);
        int low=1; //minimum distance between 2 cows
        int high=stalls[n-1]-stalls[0]; //max distance bewteen 2 cows

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(isPossible(stalls,n,cows,mid)) // if the cows can be placed then we have  to try for greater min distance
            { low=mid+1; 
            }
            else // if the cows cannot be placed then we have to try for lesser min distance
            {
                high=mid-1;       
            }
        }
        return high;
    }
}
