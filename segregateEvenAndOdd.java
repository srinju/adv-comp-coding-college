public class segregateEvenAndOdd {
    
    public static class Node{

        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addLast(int data) {
        Node newNode = new Node(data);
         
        if(head == null){
            head = tail = newNode;
            return;
        }
        
        tail.next = newNode;
        tail = newNode;
        
    }
    
    public void printList() {
        
        if(head == null){
            System.out.println("the linked list is empty!!");
            return;
        }
        
        Node current = head;
        
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
        
    }

    public static Node segregate(Node head){

        //we have to arrange odd and even index in the linked list
        //given a linked list

        if(head == null && head.next == null){
            return head;
        }

        Node oddNode = head;
        Node evenNode = head.next;
        Node evenHead = evenNode;
        Node oddHead = oddNode;

        while(evenNode != null && evenNode.next != null){

            //assemble odd Nodes >>

            oddNode.next = evenNode.next;
            oddNode = oddNode.next;

            //assemble even Nodes>>

            evenNode.next = oddNode.next;
            evenNode = evenNode.next;

        }

        //connect the even and odd Nodes together>
        //we init the evenNode at beginnig so it didsnt change
        //and the odd tail is now the oddNode itselg

        oddNode.next = evenHead;

        return oddHead; //return the evenHead as it is the newHead of the whole segregated linked list

    }

    public static void main(String[] args) {
        
        segregateEvenAndOdd ll = new segregateEvenAndOdd();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.printList();

        ll.head = ll.segregate(ll.head);

        ll.printList();
    }
}
