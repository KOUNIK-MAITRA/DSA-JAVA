import java.io.*;
import java.util.*;
class RussianDolls_Envelopes {
    public static void main(String args[])
    {
        int envelopes[][]={{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(envelopes));
    }
    static int maxEnvelopes(int[][] envelopes) {
      // sort the envelopes array in ascending order of width
      // if 2 envelopes have the same width the envelope with greater height should come first  
        Arrays.sort(envelopes,(a,b)->(a[0]==b[0]?b[1]-a[1]:a[0]-b[0]));
       
        int dp[]=new int[envelopes.length];
        int ans=0;
        
        for(int[]envelope : envelopes)
        {
            int height=envelope[1];
            
            // find the position where envelope of this height should be placed
            int pos_to_insert=Arrays.binarySearch(dp,0,ans,height);
          
            //Arrays.binarySearch() returns in -ve if the number is not present in the array
            // position to insert = -(i+1) where is the -ve value returned by binarySearch func  
            if(pos_to_insert<0)
            {
              pos_to_insert=-(pos_to_insert+1);// compute the correct index
              if(pos_to_insert==ans) ans++; // increment ans if we are adding at the end
              dp[pos_to_insert]=height; // put the envelope in correct pos  
            }
        }
        
        return ans;
    }
}