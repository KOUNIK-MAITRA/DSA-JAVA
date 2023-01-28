import java.io.*;
import java.util.*;
class Majority_Element_I
{  static int MajorityEle(int []arr)
    { int ansIndex=0;
        int count=0;
        for(int i=0;i<arr.length;i++)
        { if( arr[ansIndex]==arr[i])
                count++;
            else 
                count--;

            if(count==0)
            { ansIndex=i;
                count=1;
            }
        }

        int freq=0;
        for(int i=0;i<arr.length;i++)
        { if (arr[i]==arr[ansIndex])
                freq++;
        }

        if(freq>arr.length/2)
            return arr[ansIndex];
        else 
            return -99999;
    }

    public static void main(String args[])
    { int arr[]={2,2,1,1,1,2,2};
        System.out.println(MajorityEle(arr));
    }
}