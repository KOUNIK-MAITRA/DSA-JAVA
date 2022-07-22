import java.io.*;
import java.util.*;
class ArrangingCoins
{
   public static void main(String args[]){
    }
   static int arrangeCoins(int n) {
        long low=1;
        long high=n;
        long ans=0;
        while(low<=high){
            long mid=low+(high-low)/2;
            // calculates the number of coins required to make "mid" rows
            long numberOfCoinsRequired=mid*(mid+1)/2; 
            
             if(numberOfCoinsRequired>n){
                high=mid-1;
            }
            else{
              ans=Math.max(ans,mid);// could be a possible ans
              low=mid+1;  
            }
        }
        
        return (int)ans;
    } 
}
