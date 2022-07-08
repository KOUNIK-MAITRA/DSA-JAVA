import java.io.*;
import java.util.*;
class Rescue_People_On_A_Boat
{
  public static void main (String args[])
  { int [] people={3,2,2,1};
    int limit=3;
    System.out.println(numRescueBoats(people,limit));
    }
  static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left=0;
        int right=people.length-1;
        
        int boats=0;
        while(left<=right)
        {
            if(people[left]+people[right]<=limit)
            {
                boats++;
                left++;
                right--;
            }
            else
            {
                boats++;
                right--;
            }
        }
        
        return boats;
    }
}
