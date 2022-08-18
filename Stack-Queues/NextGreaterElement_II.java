import java.io.*;
import java.util.*;
 class NextGreaterElement_II
{
  public static void main(String args[]){
      int nums[]={1,2,1};
      System.out.println(Arrays.toString(nextGreaterElements(nums)));
  }
  static int[] nextGreaterElements(int[] nums) {
        int ans[]=new int[nums.length];
        Stack<Integer> stack= new Stack<>();
        for(int i=nums.length-1;i>=0;i--)
            stack.push(nums[i]);
        
       
        for(int i=nums.length-1;i>=0;i--){
            int ele=nums[i];
            while(!stack.isEmpty() && stack.peek()<=ele)
                stack.pop();
            if(stack.isEmpty())
                ans[i]=-1;
            else
                ans[i]=stack.peek();
            stack.push(nums[i]);
        }
        return ans;
        
    }
}
