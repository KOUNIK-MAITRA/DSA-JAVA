import java.io.*;
import java.util.*;
class VerticalOrderTraversal
{
     static class Node{
     int data;
      Node left;
      Node right;
      Node(int data)
     {this.data=data;
      left=null;
      right=null;
        }
    }
      static class Pair {
        int horizontalDistance;
        Node node;
        Pair(int horizotalDistance,Node node){
           this.horizontalDistance=horizontalDistance;
           this.node=node;
        }
    }
    static List<Integer> verticalTraversal(Node root) {

        List<Integer> ans=new ArrayList<>(); 
        
        Queue<Pair> q= new LinkedList<>();
        Map<Integer,ArrayList<Integer>> map=new TreeMap<>();
    
        q.add(new Pair(0,root));
        
       while(!q.isEmpty()){
         Pair curr=q.poll();
            if(map.containsKey(curr.horizontalDistance)){
                map.get(curr.horizontalDistance).add(curr.node.data);
            }
        
            else{
             ArrayList<Integer> temp=new ArrayList<>();
             temp.add(curr.node.data);
             map.put(curr.horizontalDistance,temp);
         }
        
         if(curr.node.left!=null)
          { int distanceFromRoot=curr.horizontalDistance-1;
             q.add(new Pair(distanceFromRoot,curr.node.left));
            }
         if(curr.node.right!=null)
             { int distanceFromRoot=curr.horizontalDistance+1;
                 q.add(new Pair(distanceFromRoot,curr.node.right));
                }
            
        }
     
        for(Map.Entry<Integer,ArrayList<Integer>> entry :map.entrySet()){
            ans.addAll(entry.getValue());
        }
        
        return ans;
        
    }
    
  
    public static void main (String args[])
    {
        Node root=new Node(3);
        root.left=new Node(9);
        root.right=new Node(20);
    
        root.right.left=new Node(15);
        root.right.right=new Node(7);
        
        System.out.println(verticalTraversal(root));
    }
}


