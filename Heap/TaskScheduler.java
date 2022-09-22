import java.io.*;
import java.util.*;
class TaskScheduler {
    public static void main(String args[])
    {
        char tasks[]={'A','A','B','B','A','B'};
        int n=2;
        System.out.println(leastInterval(tasks,n));
    }
    static int leastInterval(char[] tasks, int n) 
    {
        // store the frequency of each task
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch : tasks)
            map.put(ch,map.getOrDefault(ch,0)+1);
        
        // sort in desecnding order
        //so task with max freq is at top
        // max heap is formed
        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        pq.addAll(map.entrySet());
        
        int time=0;
        
        while(!pq.isEmpty()) // while there are still tasks to perform
        {
            int interval=n+1; //time slot 
            
            //stores the updated freq of the performed tasks
            ArrayList<Map.Entry<Character,Integer>> temp=new ArrayList<>();
            
            while(interval>0 && !pq.isEmpty())
            {
                Map.Entry<Character,Integer> currTask=pq.poll();
                currTask.setValue(currTask.getValue()-1);
                temp.add(currTask);
                // 1 task is performed
                interval--;
                time++;
            }
            
            // add the tasks that are yet to completed
            for( Map.Entry<Character,Integer> task : temp)
            {
                if(task.getValue()>0)
                    pq.offer(task);
            }
            
            //if suppose all tasks were done and pq didnot need to be updated then our job is done
            if(pq.isEmpty()) break;
            
            //if we have performed task that could be done yet interval>0 
            // there for the machine has to be idle for time = interval
            
            if(interval>0) time+=interval;
        }
        
        return time;
        
    }
}