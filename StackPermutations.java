import java.util.Scanner;
import java.util.Stack;

public class StackPermutations {
    
    public static boolean isPermutations(int[] input , int[] output){

        int n = input.length;
        Stack<Integer> s = new Stack<>();
        int j = 0 ; //pointer for the output array

        for(int i = 0 ; i < n ; i++){

            s.push(input[i]); //push the input array element

            while(!s.isEmpty() && s.peek() == output[j] ){
                //if the s is not empty and the peek element is same as the element of the output array
                s.pop(); //we pop the element from the stack as checking is done
                j++; //increment the j pointer

            }
            //check if the checking is done >
            if(j == n && s.isEmpty()) {
                return true; //if it empty and the stack is empty then all checked and permutation is there
            } 

        }

        return false; //fasle
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the no of elements : ");
        int n = sc.nextInt();

        int[] input = new int[n];
        int[] output = new int[n];

        System.out.println("enter the elements of the input array : ");
        for(int i = 0 ; i < n ; i++){
            input[i] = sc.nextInt();
        }

        System.out.println("Enter the elements of the output array : ");
        for(int j = 0 ; j < n ; j++){
            output[j] = sc.nextInt();
        }
        sc.close();

        if(isPermutations(input, output)){
            System.out.println("true it is a stack permutation");
        } else {
            System.out.println("false it is not a stack permutation!!");
        }
    }
}
