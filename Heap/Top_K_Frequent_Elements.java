import java.io.*;
import java.util.*;
 class Top_K_Frequent_Elements
{
  public static void main(String args[]){
      int[] nums = {1,1,1,2,2,3};int k = 2;
      System.out.println(Arrays.toString(topKFrequent(nums,k)));
   }
  static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0) + 1); // mapping every element with its frequency
        }
        //modified max heap
        // store in heap in preferrence to the element's frequency
        // the element with max frequency will be at the top of the heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a)); 
        
        // add the keys in the heap
        for(int key : map.keySet()){
            maxHeap.add(key);
        }
        
        int ans[] = new int[k];
        // poll from the heap for k times
        for(int i = 0; i < k; i++){
            ans[i] = maxHeap.poll();
        }
        return ans;
    }
}
