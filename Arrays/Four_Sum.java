import java.io.*;
import java.util.*;
class Four_Sum
{  static ArrayList<List<Integer>> FourSum(int nums[], int target)
    {  ArrayList<List<Integer>> ans=new ArrayList<>();
        
        if(nums==null||nums.length==0)
        return ans;
        Arrays.sort(nums); // sort the array
        int n=nums.length;
      
        
        for(int i=0;i<n;i++)
        { for(int j=i+1; j<n;j++)
            { int left =j+1;
                int right=n-1;
              int temp_target=target-nums[i]-nums[j]; // sum that we need to find using the two sum technique  
                while(left<right)
                { int curr_two_sum=nums[left]+nums[right];
                     if(curr_two_sum<temp_target)
                       left++;
                     else if(curr_two_sum>temp_target)
                       right--;
                       else
                       { ArrayList<Integer> quad=new ArrayList<>();
                           quad.add(nums[i]);
                           quad.add(nums[j]);
                           quad.add(nums[left]);
                           quad.add(nums[right]);
                           ans.add(quad);
                           
                           while(left<right && nums[left]==quad.get(2)) // skip duplicates
                            left++;
                            
                            while (left< right && nums[right]==quad.get(3)) // skip duplicates
                              right--;
                        }
                }
                while(j+1<n && nums[j]==nums[j+1]) // skip duplicates
                 j++;
            }
             while(i+1<n && nums[i]==nums[i+1]) // skip duplicates
                 i++;
        }
        return ans;
    }
    public static void main(String args[])
    { int nums[]={1,0,-1,0,-2,2};
       int target =0;
       System.out.println(FourSum(nums,target));
    }
}