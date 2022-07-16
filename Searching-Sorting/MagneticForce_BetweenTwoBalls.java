import java.io.*;
import java.util.*; 
class MagneticForce_BetweenTwoBalls
{
  public static void main (String args[]){
    int position[] = {1,2,3,4,7}; int m = 3;
    System.out.println(maxDistance( position,m));
   }
  static boolean isPossible(int []position,int m, int curr_magneticForce)
    {
        int countBalls=1;
        int indexOfLastBall=position[0];
        
        for(int i=1;i<position.length;i++)
        {
            if(position[i]-indexOfLastBall>=curr_magneticForce)
            {
                countBalls++;
                indexOfLastBall=position[i];
            }
        }
        
        if(countBalls>=m)
            return true;
        else
            return false;
    }
    
  static int maxDistance(int[] position, int m) {
     Arrays.sort(position);
        int low=1 ;// minimum magnetic force b/w two balls
        int high=position[position.length-1]-position[0]; // maximum magnetic force b/w 2 balls
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int curr_magneticForce=mid;
            
            if(isPossible(position,m,curr_magneticForce))
            {
                low=mid+1;
            }
            else{
               high=mid-1;             
            }
        }
        
        return high;
    }
}
