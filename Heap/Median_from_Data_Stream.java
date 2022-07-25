import java.io.*;
import java.util.*;
 class Median_from_Data_Stream
{
    class MedianFinder {
    
     PriorityQueue <Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());// stores the smaller numbers 
     PriorityQueue <Integer> minHeap=new PriorityQueue<>(); // stores the larger numbers    
    public MedianFinder() {
        
      }
    
     void addNum(int num) {
       if(maxHeap.isEmpty() ||num<=maxHeap.peek())
          maxHeap.add(num);
        else
            minHeap.add(num);
    
    
       if(maxHeap.size() > minHeap.size()+1){
        minHeap.add(maxHeap.poll());
        }
      
    
       else if(minHeap.size()>maxHeap.size())
        maxHeap.add(minHeap.poll());
    } 
     double findMedian() {
        
        int x= maxHeap.peek();
        
        int y=!minHeap.isEmpty() ? minHeap.peek(): 0;
        
        if(maxHeap.size()==minHeap.size()) // there are even no.of elements
        return (x+y)/2.0;
        
        return x;
    }
  }
    void main ()
  { MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(1);    // arr = [1]
    medianFinder.addNum(2);    // arr = [1, 2]
    System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
    medianFinder.addNum(3);    // arr[1, 2, 3]
    System.out.println(medianFinder.findMedian()); // return 2.0
   
    }
}
