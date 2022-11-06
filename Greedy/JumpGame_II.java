import java.io.*;
import java.util.*;
class JumpGame_II
{
    public static void main(String args[]){
        int nums[]={2,3,1,1,4};
        System.out.println(jump(nums));
    }

    static int jump(int[] nums) {
        int jumps=0;
        int endOfCurrLevel=0;   
        int currFarthest=0;

        for(int i=0;i<nums.length;i++){

            currFarthest=Math.max(currFarthest,i+nums[i]);

            if(i==endOfCurrLevel) // if we have reached the end of curr level we have to make a jump
            {  
                if(endOfCurrLevel==nums.length-1) break;
                jumps++; 
                endOfCurrLevel=currFarthest;
            }
        }
        return jumps;
    }
}
