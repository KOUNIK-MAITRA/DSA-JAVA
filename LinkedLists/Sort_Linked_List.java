 class Sort_Linked_List
{
    static class Node{
     int data;
     Node next;
     Node(int data){
      this.data=data;
      this.next=null;
     }
    }
     static void display(Node head){
     while(head!=null)
     { System.out.print(head.data+" --> ");
         head=head.next;
        }
        System.out.print("null");
        System.out.println();
    }
    static Node sortList(Node head) {
        if(head==null || head.next==null)
            return head;
        
        Node mid=getMid(head); // get the middle of the linked list
        Node left=head; // all nodes from head to mid
        Node right=mid.next; // all nodes from mid.next to the end
        mid.next=null; // break the link to make left and right two separate linked list
        
        left=sortList(left);
        right=sortList(right);
        
        Node sortedList=merge(left,right);
        return sortedList;
    }
    
    static Node getMid(Node head){
     
        Node slow=head;
        Node fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
    
    static Node merge(Node left , Node right){
        Node temp=new Node(-1);
        Node curr=temp;
        
        while(left!=null && right!=null){
            
            if(left.data<=right.data)
            {
                curr.next=left;
                curr=curr.next;
                left=left.next;
            }
            else{
                curr.next=right;
                curr=curr.next;
                right=right.next;
            }
        }
        
        while(left!=null){
         curr.next=left;
         curr=curr.next;
         left=left.next; 
        }
         while(right!=null){
         curr.next=right;
         curr=curr.next;
         right=right.next; 
        }
     
        return temp.next;
        
    }
    public static void main(String args[]){
     Node head=new Node(1);
     head.next=new Node(3);
     head.next.next=new Node(2);
     head.next.next.next=new Node(14);
     head.next.next.next.next=new Node(5);
     head.next.next.next.next.next=new Node(4);
     
     
     display(sortList(head));
     
    }
}
