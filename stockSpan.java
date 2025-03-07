import java.util.Scanner;
import java.util.Stack;

public class stockSpan {
    
    //current price er theke beshi jodi agey theke thake tale current index - prevHigh er index
    public static int[] findSpan(int[] stocks , int[] span){
        
        Stack<Integer> s = new Stack<>();
        span[0] = 1; //span of the first stock is obv 1
        s.push(0); //push the first index;

        for(int i = 1 ; i < stocks.length ; i++){
            while(!s.isEmpty() && stocks[i] > stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()){
                //we are at the last
                span[i] = i+1;
            } else {
                //we are not at the last
                //calculate the span
                span[i] = i - s.peek();
            }

            s.push(i);
        }

        return span;

    }

    public static void main(String[] args) {
        //int[] stocks = {100,80,60,70,60,85,100};
        
        Scanner sc = new Scanner(System.in);

        System.out.println("enter no of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("enter the stocks data : ");
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        int[] span = new int[arr.length];
        int[] result = findSpan(arr, span);

        System.out.println("the span array is : ");
        for(int i = 0 ; i < result.length ; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

}
