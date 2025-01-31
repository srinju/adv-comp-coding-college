import java.util.*;
public class minStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public minStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val){
        stack.push(val);
        if(!minStack.isEmpty()){
            minStack.push(Math.min(val, minStack.peek()));
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            minStack.pop();
        } 
    }

    public int top() {
        if(!stack.isEmpty()){
           return stack.peek();
        } else {
            return -1;
        }
    }

    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        minStack minStack = new minStack();

        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        minStack.push(2);

        System.out.println("Top element: " + minStack.top()); // Output: 2
        System.out.println("Minimum element: " + minStack.getMin()); // Output: 2

        minStack.pop();
        System.out.println("Top element after pop: " + minStack.top()); // Output: 7
        System.out.println("Minimum element after pop: " + minStack.getMin()); // Output: 3

        minStack.pop();
        System.out.println("Minimum element after another pop: " + minStack.getMin()); // Output: 3

        minStack.pop();
        System.out.println("Minimum element after another pop: " + minStack.getMin()); // Output: 5
    }
}
