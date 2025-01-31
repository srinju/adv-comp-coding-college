public class mergeSortLL {
    
    //merge sort in a linked list

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public  void addLast(int data) {

        Node newNode = new Node(data);
    
        if(head == null){ //ll is empty
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail =  newNode;

    }

    public  void printList() {

        if(head == null){
            System.out.println("ll is empty");
        }

        Node current = head;

        while(current != null){

            System.out.print(current.data + " -> ");
            current = current.next;

        }
        System.out.println("null");

    }

    public static Node mergeSort(Node head){

        if(head == null || head.next == null){
            return head;
        }

        Node slow = head;
        Node fast  = head.next;

        while(fast != null && fast.next == null){
            
            slow = slow.next;
            fast = fast.next.next;

        }

        Node midNode = slow;
        Node rightHead  = midNode.next;
        Node leftHead  = head;
        
        //break the ll into two halves >>

        midNode.next = null;

        Node newLeftHead = mergeSort(leftHead);
        Node newRightHead = mergeSort(rightHead);

        //compare and add the nodes to a new ll

        Node mergedLL = new Node(-1);
        Node temp  = mergedLL; //pointer for the final ll

        while(newLeftHead != null && newRightHead != null){

            if(newLeftHead.data <= newRightHead.data){
                //newLefthead chota>
                temp.next = newLeftHead;

                temp = temp.next;
                newLeftHead = newLeftHead.next;

            } else {
                //newright head chota >>
                temp.next = newRightHead;

                temp = temp.next;
                newRightHead = newRightHead.next;

            } 
            
        }

        //for the remaining parts>>

        while(newLeftHead != null){
            temp.next = newLeftHead;
            temp = temp.next;
            newLeftHead = newLeftHead.next;
        }

        while(newRightHead != null){
            temp.next = newRightHead;
            temp = temp.next;
            newRightHead = newRightHead.next;
        }

        return mergedLL.next;

    }

    public static void main(String[] args) {
        
        mergeSortLL ll = new mergeSortLL();

        ll.addLast(5);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(7);
        ll.addLast(0);
        ll.addLast(1);

        ll.printList();
        ll.head = ll.mergeSort(ll.head);
        ll.printList();

    }
}
