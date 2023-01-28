import java.io.*;
import java.util.*;
class Mountain{
    public static void main (String args[]){
        int heights[]={2,3,2,3};
        System.out.println(countPairs(4,heights));
    }

    static int countPairs(int n , int heights[]){
        int pairs=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(heights[j]<=heights[i])
                {
                    pairs++;
                }
                else {
                pairs++;
                break;
            }
            } 
        }
        return pairs-1;
    }
}