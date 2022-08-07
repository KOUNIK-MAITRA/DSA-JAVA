class Count_Partitions_With_Given_Difference_Recursion
{
  public static void main(String args[]){
     int[] arr={5,2,5,1};
     int n=4;
     int d=3;
     System.out.println(countPartitions(n,d,arr));
  }
  public static int countPartitions(int n, int d, int[] arr) {
	int sum=0; 
        for(int ele: arr){
            sum+=ele;
        }
        //s1+s2=sum
        //s1-s2=d
        //sum-s2-s2=d
        //sum-2s2=d
        //(sum-d)/2=s2
        // there fore s2 must be even, s2 must be greater than 0
        if( (sum-d)<0 || (sum-d)%2!=0)
            return 0;
        int target= (sum-d)/2;
        return count(n-1,arr,target);
	}
  static int count(int index,int[] arr,int target){
       
        if(index==0)
        {    
          if(target==0 && arr[0]==0)
             return 2;
          if(target==0 || target==arr[0])
               return 1;
            
            return 0;
        }
        int mod=(int)(1e9+7);
        int notPick=count(index-1,arr,target);
        int pick=0;
        if(arr[index]<=target)
        {
            pick=count(index-1,arr,target-arr[index]);
        }
        
        return (pick+notPick)%mod;
    }
}
