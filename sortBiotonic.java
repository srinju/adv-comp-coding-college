public class sortBiotonic {

    public static class Node {
        int data;
        Node next;
        Node prev;
    
        public Node(int data) {
          this.data = data;
          this.next = null;
          this.prev = null;
        }
      }
    
      public static Node head;
      public static Node tail;
      
      public static void addLast(int data){
          
          Node newNode = new Node(data);
          
          if(head == null){
              tail = head = newNode;
          }
          
          tail.next = newNode;
          newNode.prev = tail;
          tail = newNode;
          
      }
      
      public static void printList() {
          
          Node current = head;
          
          while(current != null){
              System.out.print(current.data + "->");
              current = current.next;
          }
          System.out.println();
      }
    
      public static Node sortBiotonicLL(Node head){
          
          //first detect the peak
          //break the ll into two parts
          //reverse the second part for merging to be easier
          //then compare both the parts and return the sorted ll into a new ll
          
          Node peak = null;
          Node current = head;
          
          while(current != null && current.next != null){
              if(current.next.data < current.data){
                  //that means next value is smaller than current
                  //threrfore current is peak
                  peak  = current;
                  break ;
              }
              current = current.next;
          }
          
          if(peak == null){
              //list is already sorted in ascending order
              //return the head
              return head;
          }
          
          //found the peak
          //now breajk the ll
          
          Node rightHead = peak.next;
          peak.next = null;
          if(rightHead != null){
              rightHead.prev = null;
          }
          
          //ll broken into two parts 
          //now reverse the second part of the ll
          
          Node prevNode = null;
          Node currentNode = rightHead;
          
          while(currentNode != null){
              Node nextNode = currentNode.next;
              currentNode.next = prevNode;
              currentNode.prev = nextNode;
              
              prevNode = currentNode;
              currentNode = nextNode;
          }
          
          //prevNode is the new head of the right part
          
          rightHead = prevNode;
          
          //make a new ll of the merged ll
          Node mergedLL = new Node(-1);
          Node temp = mergedLL; //pointer for the dummyNode
          
          //head of the left ll is the normal head
          //head of the right ll is the rightHead
          
          Node leftHead = head;
          while(leftHead != null && rightHead != null){
              if(leftHead.data <= rightHead.data){
                  //left head is the smaller head
                  //add the leftHead to the result 
                  temp.next = leftHead;
                  leftHead.prev = temp;
                  
                  temp = temp.next;
                  leftHead = leftHead.next;
              } else {
                  //rightHead data smaller
                  //add the rightHead to the resulting ll
                  temp.next = rightHead;
                  rightHead.prev = temp;
                  
                  temp = temp.next;
                  rightHead = rightHead.next;
                  
              }
          }
          
          //for the remaing parts>>>
          
          while(leftHead != null){
              temp.next = leftHead;
              leftHead.prev = temp;
              
              temp = temp.next;
              leftHead = leftHead.next;
          }
          
          while(rightHead != null){
              temp.next = rightHead;
              rightHead.prev = temp;
              
              temp = temp.next;
              rightHead = rightHead.next;
          }
          
          //return the mergedLL
          return mergedLL.next;
      }
    
      public static void main(String[] args) {
        
        
        sortBiotonic dll = new sortBiotonic();
        
        dll.addLast(1);
        dll.addLast(5);
        dll.addLast(8);
        dll.addLast(4);
        dll.addLast(2);
        dll.addLast(1);
        
        dll.printList();
        
        dll.head = dll.sortBiotonicLL(dll.head);
        dll.printList();
    
      }
}
