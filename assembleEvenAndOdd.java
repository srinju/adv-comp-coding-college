import java.util.Scanner;

public class assembleEvenAndOdd {
    
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

    public static void addLast(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
        }

        tail.next = newNode;
        newNode.next = null;
        tail  = newNode;

    }

    public static void printList() {

        if(head == null){
            System.out.println("empty ll");
        }

        Node current = head;

        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        
        System.out.println("null");
    }

    public static Node reArrange(Node head) {

        //we have to group the even and odd nodes of the lls together

        Node evenNode  = new Node(-1);
        Node tempEven = evenNode; //pointer for even node

        Node oddNode = new Node(-1);
        Node tempOdd   = oddNode; //pointer for the oddNode

        Node current  = head;

        while(current != null){
            if(current.data % 2 == 0){
                //even node
                tempEven.next = current;
                
                tempEven = tempEven.next;
                current = current.next;

            } else {
                //odd node
                tempOdd.next = current;

                tempOdd =tempOdd.next;
                current = current.next;

            }
        }

        //two lls are formed one is even and one is odd

        //now we connect the tail of the even node with the head of the odd ll

        tempEven.next = oddNode.next; //connected
        tempOdd.next = null;

        return evenNode.next;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        assembleEvenAndOdd ll = new assembleEvenAndOdd();

        System.out.println("enter the no of elements in the ll : ");
        int n = sc.nextInt();

        System.out.println("enter the elemetns in the linked list : ");
        for(int i = 0 ; i < n ; i++){
            int data = sc.nextInt();
            ll.addLast(data);
        }
        
        System.out.println("original list : ");
        ll.printList();

        ll.head = reArrange(ll.head);

        System.out.println("re arranged ll is (even nodes followed by odd nodes) : ");
        ll.printList();

        sc.close();

    }
}
