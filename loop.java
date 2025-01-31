import java.util.Scanner;

public class loop {
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

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("empty ll");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }

        System.out.println();
    }

    public boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                System.out.println("cycle");
                return true;
            }
        }
        System.out.println("no cycle");
        return false;
    }

    public static void main(String[] args) {
        loop ll = new loop();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();

        // Create linked list
        System.out.println("Enter the data for the elements in the linked list: ");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            ll.addLast(data);
        }

        // Create cycle
        System.out.println("Enter the index (1-based) where you want to connect the cycle (0 to not create a cycle): ");
        int index = sc.nextInt();

        if (index > 0) {
            // Create cycle
            Node cycleNode = head;
            // Traverse to the cycle node index
            for (int i = 1; i < index; i++) {
                cycleNode = cycleNode.next;
            }

            // Connect the tail's next to the cycle node to form a cycle
            tail.next = cycleNode;
        }

        if (index == -1){
            System.out.println("no cycle");
        }

        // Check if cycle exists
        ll.isCycle();

        sc.close();
    }
}
