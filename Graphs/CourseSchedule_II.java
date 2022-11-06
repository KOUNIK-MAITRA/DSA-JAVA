import java.io.*;
import java.util.*;
class CourseSchedule_II {
    static int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<Integer>());

        for(int[] courses:prerequisites)
        {
            int course=courses[0];
            int preCourse=courses[1];
            adj.get(preCourse).add(course);
        }

        int indegree[]=new int[numCourses];
        for(ArrayList<Integer> courses:adj)
        {
            for(int course : courses)
                indegree[course]++;
        }

        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
                queue.offer(i);
        }

        int []courseOrder=new int[numCourses];
        int index=0;
        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            courseOrder[index++]=curr;

            for(int course:adj.get(curr))
            {
                indegree[course]--;
                if(indegree[course]==0)
                    queue.offer(course);
            }
        }
        if(index==numCourses)
            return courseOrder;
        else
            return new int[0];
    }

    public static void main(String args[])
    {
      int numCourses = 4;
      int [][]prerequisites = {{1,0},{2,0},{3,1},{3,2}};
      System.out.println(Arrays.toString(findOrder(numCourses,prerequisites)));
    }

}