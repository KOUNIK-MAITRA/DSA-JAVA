import java.io.*;
import java.util.*;
 class Binary_Trees_With_Factors
{
  public static void main(String args[]){
      int arr[]={2,4,8};
      System.out.println(numFactoredBinaryTrees(arr));
   }
  static int numFactoredBinaryTrees(int[] arr) {
     int mod=(int)(1e9+7);
     int n=arr.length;
     Arrays.sort(arr); //sort the array so we get all the factors then their multiples
     
     long []dp=new long[n]; //create a dp array dp[i] stores the no.of binaryTrees that could be made using nums[i] as the root
     Arrays.fill(dp,1);//each element can for a binary tree with itself as the root
    
    HashMap<Integer,Integer> map=new HashMap<>(); //hashmap that stores each ele and its corresponding index
    for(int i=0;i<n;i++)
       map.put(arr[i],i);
        //check for every element in  arr[]
        for(int i=1;i<n;i++){
        //root of the curr binary tree will be arr[i]
            int root=arr[i];
        //check all the previous elements that could be potential factors of the root
            for(int j=0;j<i;j++){
            //if the prev ele i.e arr[j] is a factor
                if(root % arr[j]==0){
                    
                 int leftChild=arr[j];// make it the left child
                 int rightChild=root/leftChild;//then the probable right child is root/left child since root=leftChild x rightChild
                    
                if(map.containsKey(rightChild))//if the right Child exists update the dp[i] for the ele as root
                // total no.of binary trees as dp[i] as the root = dp[i]+(dp[indexOf leftChild] x dp[indexOf rightChild)]
                    dp[i]=(dp[i]+dp[map.get(leftChild)]*dp[map.get(rightChild)])%mod;
                
            }
        }
    }
        
    long total=0; 
    //add up all entries in dp array to find the total no.of binary trees that could be formed using the elements in arr[]
    for(long ele : dp)
      total+=ele;
        
     return (int)(total%mod);
  }
}
