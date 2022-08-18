import java.io.*;
import java.util.*;
class BusRoutes
{
  public static void main (String args[]){
    int routes[][]={{1,2,7},{3,6,7}}; 
    int source = 1; 
    int target = 6;
    System.out.println(numBusesToDestination(routes,source,target));
  }
  static class Pair{
        int stop;
        int busesNeeded;
        Pair(int stop, int busesNeeded){
            this.stop=stop;
            this.busesNeeded=busesNeeded;
        }
    }
    
  static int numBusesToDestination(int[][] routes, int source, int target) {
      HashMap <Integer,ArrayList<Integer>> map=new HashMap<>();
      HashSet<Integer> visited=new HashSet<>();
      
        //total no.of buses = total.no.of routes=routes.length  
        
        //create the adj list or HashMap
        for(int i=0;i<routes.length;i++){
           int bus=i; // curr bus = curr route
           int stops=routes[i].length;//no.of stops in this route or for bus i
           for(int j=0;j<stops;j++){
            int stop=routes[i][j];
            if(!map.containsKey(stop));
                map.put(stop,new ArrayList<Integer>());
            map.get(stop).add(bus);
           }   
        }
        
        Queue<Pair> queue= new LinkedList<>();
        queue.add(new Pair(source,0));
        visited.add(source);
        
        while(!queue.isEmpty()){
            Pair curr=queue.poll();
            int currStop=curr.stop;
            int currNoOfBusesNeeded=curr.busesNeeded;
            
            if(currStop==target)
                return currNoOfBusesNeeded;
            
            for(int route: map.get(currStop)){
                for(int stop:routes[route]){
                  if(!visited.contains(stop)){
                      visited.add(stop);
                      queue.add(new Pair(stop,currNoOfBusesNeeded+1));
                  } 
                }
            }
            
        }
        return -1;
        
    }
}
