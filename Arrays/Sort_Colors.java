 class Sort_Colors
{
   public static void main(String args[])
    {
        int nums[]={2,0,2,1,1,0};
        sortColors(nums);
        for(int ele: nums)
        { System.out.print(ele+"  ");
        }
    }
   public static void swap(int nums[],int pos1, int pos2)
    {
        int temp=nums[pos1];
        nums[pos1]=nums[pos2];
        nums[pos2]=temp;
    }
    public static void sortColors(int[] nums) {
        
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while (mid<=high)
        {
            if (nums[mid]==0)
            {
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if (nums[mid]==1)
            {mid++;}
            else 
            {
                swap(nums,high,mid);
                high--;
            }
                
        }
    }
}
