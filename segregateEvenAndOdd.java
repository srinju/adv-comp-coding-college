import java.util.Scanner;

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
       
        Scanner sc = new Scanner(System.in);
        segregateEvenAndOdd ll = new segregateEvenAndOdd();

        System.out.println("enter the number of elements in the linked list : ");
        int n = sc.nextInt();

        System.out.println("emter the elements of the linked list : ");
        for(int i = 0 ; i < n ; i++){
            int data = sc.nextInt();
            ll.addLast(data);
        }

        System.out.println("original list : ");
        ll.printList();

        ll.head = segregate(ll.head);

        System.out.println("after segregations is : ");
        ll.printList();
    }
}
