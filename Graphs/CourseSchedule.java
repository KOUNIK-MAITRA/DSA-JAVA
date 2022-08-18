import java.io.*;
import java.util.*;
 class CourseSchedule
{
  public static void main(String args[]){
      int numCourses=5;
      int[][]prerequisites={{0,2},{0,1},{1,3},{1,4},{3,4}};
      System.out.println(canFinish(numCourses,prerequisites));
  }
  static boolean canFinish(int numCourses, int[][] prerequisites) { 
    if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) 
    return true; 
    
    // create the adj lists to represent the courses
    List<List<Integer>> adj = new ArrayList<List<Integer>>(numCourses);
    for(int i=0; i<numCourses; i++) {
        adj.add(new ArrayList<Integer>());
    }
    
    // create the dependency graph
    for(int i=0; i<prerequisites.length; i++) {
        adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }

    int[] visited = new int[numCourses]; 
    
    // dfs visit each course
    for(int i=0; i<numCourses; i++) {
           if (!dfs(i,adj, visited)) 
            return false; 
    }
    
    return true;
  }

  static boolean dfs(int course, List<List<Integer>> adj, int[] visited) {
    
    visited[course] = 1; // mark it being processed
    
    List<Integer> preCourses = adj.get(course); // get its children
    
    // dfs its children
    for(int preCourse :preCourses) {        
       
        if(visited[preCourse] == 1)
          return false; // cycle present 
       
        if(visited[preCourse]  == 0)
        { // not visited
           if (!dfs(preCourse,adj, visited)) 
             return false; 
        }

    }
    
    visited[course] = 2; // mark it visited
    return true;
    
  }
}
