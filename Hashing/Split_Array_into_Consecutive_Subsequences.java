import java.io.*;
import java.util.*; 
class Split_Array_into_Consecutive_Subsequences
{
 public static void main(String args[]){
    int nums[]={1,2,3,3,4,5};
    System.out.println(isPossible(nums));
 }
 static boolean isPossible(int[] nums) {
     //isAvailable map shows if a ele is available to be part of a subsequence
     // ele-->0 that means this element is not availabe to be a part of a subsequence
     // as it might already be present in another subsequence
     // ele--> >0 that means the ele is present to be a part of the subsequence
     // for e.g ele-->x means there are x no.of ele that are present to be part of a subsequence 
     HashMap<Integer,Integer> isAvailable=new HashMap<>();
     
     //isNeeded map shows if an ele is needed in a particular subsequence
     //if an element is present in the isNeeded map that means there exists a sequence
     //ending with ele-1 and hence ele can be a part of this subsequence    
     // suppose there is a subsequence 1--2--3
     //then isNeeded map will have 4-->1
     //which means there is a subsequence ending with 3 and hence 4 can be a part of it   
     HashMap<Integer,Integer> isNeeded=new HashMap<>();
     
     //initially all elements in the nums array are available to form a subsequence
     for(int ele :nums){
       isAvailable.put(ele,isAvailable.getOrDefault(ele,0)+1);
       isNeeded.put(ele,0);// initially no ele is needed as there are no existing subsequences  
     }
     
     //traverse all elements in the array   
     for(int ele:nums){
       //check if ele is available if not then continue
         
       if(isAvailable.get(ele)<=0)// ele is not available 
       continue;  
      
       else // ele is available
       {
         //check if this ele is needed by an existing subsequence
         //if this ele is needed by an existing subsequence then use it for the subsequence  
         if(isNeeded.get(ele)>0){
           // reduce its freq from the isNeeded map  
           isNeeded.put(ele,isNeeded.get(ele)-1);
           //since this ele is now used hence reduce its availability  
           isAvailable.put(ele,isAvailable.get(ele)-1);  
           // now ele+1 is needed for this subsequence
           isNeeded.put(ele+1,isNeeded.getOrDefault(ele+1,0)+1);  
         }
         
          // ele is not wanted by any pre exisiting subsequence
         //hence we can start a new subsequence with this ele
         //if and only if ele+1,ele+2 are also available
         // so the new probale subsequence will be ele,ele+1,ele+2  
         
         else 
         { // ele+1,ele+2 are available
           if(isAvailable.containsKey(ele+1) && isAvailable.get(ele+1)>0 &&
              isAvailable.containsKey(ele+2) && isAvailable.get(ele+2)>0)
           {  // since ele, ele+1,ele+2 are now used
              // reduce their availability 
              isAvailable.put(ele,isAvailable.get(ele)-1);
              isAvailable.put(ele+1,isAvailable.get(ele+1)-1);
              isAvailable.put(ele+2,isAvailable.get(ele+2)-1); 
              
              //now the next element that is needed for this subsequence is ele+3 
              isNeeded.put(ele+3,isNeeded.getOrDefault(ele+3,0)+1); 
           }
           
           else // we couldn't start a new subsequence from this ele
               return false;
         }  
       }  
     }
        return true;
    }
}
