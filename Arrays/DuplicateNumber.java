import java.io.*;
import java.util.*;

class DuplicateNumber
{
  public static void main(String args[])
   { 
       int nums[]={1,3,4,2,2};
       System.out.println(findDuplicate_mark(nums));
    }
  public static int findDuplicate_mark(int[] nums) {
      int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
