import java.util.Stack;

public class nextGreaterElement {
    
    public static int[]  nextGreater(int[] arr){

        Stack<Integer> s = new Stack<>();
        int[] ans = new int[arr.length];

        for(int i = arr.length-1 ; i >= 0 ; i--){
            
            while(!s.isEmpty() && arr[i]  >= s.peek()){
                s.pop();
            } 
            
            if(s.isEmpty()){
                ans[i] = -1;
            } else {
                ans[i] = s.peek();
            }

            s.push(arr[i]);

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2};
        int[] result = nextGreater(arr);

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
