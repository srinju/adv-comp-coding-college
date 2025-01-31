import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SortQueueWithoutSpace {
    
    public static void sortQueue(Queue<Integer> q) {
        int n = q.size();

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            int size = q.size();

            // Find the minimum element and its index
            for (int j = 0; j < size; j++) {
                int current = q.poll();
                if (current < min && j < size - i) { // Consider only the unsorted part
                    min = current;
                    minIndex = j;
                }
                q.offer(current);
            }

            // Reinsert elements, skipping the min element once
            for (int j = 0; j < size; j++) {
                int current = q.poll();
                if (j == minIndex) continue; // Skip the min element once
                q.offer(current);
            }

            // Append the min element at the end
            q.offer(min);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();

        System.out.println("Enter the number of elements in the queue:");
        int n = sc.nextInt();

        System.out.println("Enter the elements of the queue:");
        for (int i = 0; i < n; i++) {
            q.offer(sc.nextInt());
        }

        System.out.println("Original queue: " + q);

        sortQueue(q);

        System.out.println("Sorted queue: " + q);

        sc.close();
    }
}
