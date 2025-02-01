import java.util.Scanner;

public class priorityQueueDLL {
    
    public static class Node {
        int data;
        int priority;
        Node next;
        Node prev;

        public Node(int data , int priority){
            this.data = data;
            this.priority = priority;
            this.next = null;
            this.prev = null;
        }
    }
    
    public static Node head;
    public static Node tail;

    public static void createNode(int data , int priority) {

        Node newNode = new Node(data, priority);

        if(head == null){
            head = tail  = newNode;
            return;
        }

        Node temp = head;
        Node prevNode = null;

        while(temp != null && temp.priority <= priority){
            //temp er priority less than the priority of new node we are adding>
            //mane choto priority more prioiryt .. that is jotokhon choto asche notun priority 
            //totokhon prevNode eer value temp store kore temp k agey barao

            prevNode = temp;
            temp = temp.next;

        }

        if(prevNode == null){
            //prevNode jodi null hye tale new Node has the highest prioruty >>
            //so make it the new head

            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        } else {
            //jodi null  na hue tale middle e add or at the end
            newNode.next = prevNode.next;
            newNode.prev = prevNode;

            //if inserting in the middle update the node's previous pointer >
            if(prevNode.next != null){
                prevNode.next.prev = newNode;
            }
            //insert at the last
            prevNode.next = newNode; //link prevNode to the new Node
        }

    }

    //method to remove the head of the priority queue

    public static int pop() {

        if(head == null){
            return -1;
        }

        int value = head.data;
        head = head.next; //increment the pointer of the head

        if(head != null){
            head.prev = null; //remove the head
        }

        return value; //return the value of the removed head

    }

    //method to check if the queue is empty or not >>

    public static boolean isEmpty() {
        return head == null;
    }

    //method to display the elements in the prioruty queue>>

    public static void display() {

        Node current  = head ;

        while(current != null){
            System.out.println("Data : " + current.data + "," + "priority : " + current.priority);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        
        priorityQueueDLL pq = new priorityQueueDLL();

        Scanner sc = new Scanner(System.in);

        

        while (true) {

            System.out.println("priority queue menu :- ");
            System.out.println("1. insert an element");
            System.out.println("2. remove highest priority element");
            System.out.println("3. Display queue");
            System.out.println("4. exit");
            System.out.println("enter your choice : ");

            int choice  = sc.nextInt();
            
            switch(choice) {

                case 1 :

                    System.out.println("Enter data : ");
                    int data = sc.nextInt();
                    System.out.println("enter priority (lower number is higher priority) : ");
                    int priority = sc.nextInt();
                    pq.createNode(data, priority);
                    System.out.println("inserted successfully!!");
                    break;

                case 2 : 

                    if(!pq.isEmpty()){
                        System.out.println("removed element : " + pq.pop());
                    } else {
                        System.out.println("priroty queue is empty!!");
                    }
                    break;

                case 3 : 

                    if(!pq.isEmpty()){
                        System.out.println("priority queue contents : ");
                        pq.display();
                    } else {
                        System.out.println("priority queue is empty!!");
                    }
                    break;

                case 4 : 
                    
                    System.out.println("exiting program!!");
                    sc.close();
                    return;

                default : 
                    System.out.println("invalid choice , please enter a valid option !!");
                    
            }
        }
        
    }
}
