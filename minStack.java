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
        Scanner sc = new Scanner(System.in);
        
        System.out.println("enter the  no of operatiins :");
        int n = sc.nextInt();

        while (true) {
            
            System.out.println("methods : ");
            System.out.println("1.push");
            System.out.println("2.pop");
            System.out.println("3.top");
            System.out.println("4. get min");

            System.out.println("enter ur choice");

            int choice = sc.nextInt();

            switch(choice) {
                
                case 1 : 
                    
                    System.out.println("enter the elements");
                    int element = sc.nextInt();

                    minStack.push(element);
                    break;
                
                case 2 : 
                    
                    minStack.pop();
                    break;

                case 3 : 

                    int top = minStack.top();
                    System.out.println("top exec : " + top);
                    break;

                case 4 : 

                    int getMin = minStack.getMin();
                    System.out.println("get min exec " + getMin);
                    break;

                default : 
                    throw new IllegalArgumentException("invalid input");
            }
        }
    }
}
