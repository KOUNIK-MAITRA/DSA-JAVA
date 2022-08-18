import java.io.*;
import java.util.*; 
class LRUCache
{
    HashMap<Integer,Node> map=new HashMap<>();
    int capacity;
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
       
     LRUCache(int capacity) {
      this.capacity=capacity;
      head.next=tail;
      tail.prev=head;  
    }
    
     int get(int key) {
      if(map.containsKey(key)){
          Node node=map.get(key);
          remove(node);
          insert(node);
          return node.value;
      }
        else
            return -1;
    }
    
     void put(int key, int value) {
       if(map.containsKey(key)){
           Node node=map.get(key);
           remove(node);
       }
        if(map.size()==capacity)
        remove(tail.prev);
        
        insert(new Node(key,value));
    }
    
     void insert(Node node){
       map.put(node.key,node);
       Node headNext=head.next;
       head.next=node;
       node.prev=head;
       headNext.prev=node; 
       node.next=headNext;
    }
    
     void remove(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    
        
     class Node{
         int key;
         int value;
         Node next;
         Node prev;
         Node(int key,int value){
             this.key=key;
             this.value=value;
         }
    }
    public static void main(){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4

    }  
}

