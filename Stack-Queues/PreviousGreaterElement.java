import java.io.*;
import java.util.*;
 class PreviousGreaterElement
{
    public static void main(String args[]){
      int a[]={1, 5, 0, 3, 4, 5};
      int n=a.length;
      System.out.println(leftSmaller(n,a));
    }
    static List<Integer> leftSmaller(int n, int a[])
    {
      List<Integer>ans= new ArrayList<>();
      Stack<Integer> stack=new Stack<>();//create a stack
      for(int ele:a){
         //if the element at the top of the stack is smaller than the curr ele
         //remove that element from the stack
         while(!stack.isEmpty() && stack.peek()<=ele){
             stack.pop();
         }
         //if there are no elements in the stack 
         //it means there are no elements that are greater than the curr element on its left
         if(stack.isEmpty())
          ans.add(-1);
         else // add the element at the top of the stack 
          ans.add(stack.peek());
         
         stack.push(ele);//push the curr ele to the stack
      }
      return ans;
    }
}
