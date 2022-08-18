import java.io.*;
import java.util.*;
class NextSmallerElement
{
  public static void main(String args[]){
      int a[]={1, 5, 0, 3, 4, 2};
      int n=a.length;
      System.out.println(nextSmaller(n,a));
    }
    static List<Integer> nextSmaller(int n, int a[])
    {
      List<Integer>ans= new ArrayList<>();
      Stack<Integer> stack=new Stack<>();
      for(int i=a.length-1;i>=0;i--){
         int ele=a[i];
         while(!stack.isEmpty() && stack.peek()>=ele){
             stack.pop();
         }
        
         if(stack.isEmpty())
          ans.add(-1);
         else 
          ans.add(stack.peek());
         
         stack.push(ele);
      }
      Collections.reverse(ans);
      return ans;
    }
}
