import java.util.Scanner;
import java.util.Stack;

public class IterativeTowerOfHanoi {
    
    public static class Move{
        int disk;
        char fromRod , toRod;

        public Move(int disk , char fromRod , char toRod){
            this.disk = disk;
            this.fromRod = fromRod;
            this.toRod = toRod;
        }
    }

    public static void TowerOfHanoi(int numberOfDisks , char fromRod , char toRod , char auxRod){

        Stack<Move> stack = new Stack<>(); //stack to store moves
        Stack<Move> tempStack = new Stack<>(); //temp stack for processing moves

        //push all disks into the stack in descending order >>
        for(int i = numberOfDisks ; i >= 1 ; i--){
            stack.push(new Move(i, fromRod, toRod));
        }

        //process stack until all moves are completed >
        while(!stack.isEmpty()){
            while(!stack.isEmpty()){
                Move move = stack.pop();

                //if it is the smallest disk move it directly >>
                if(move.disk == 1){
                    System.out.println("Move disk 1 from " + move.fromRod +  "to " + move.toRod);
                } else {
                    //push moves onto temp stack to mimic recursion >>
                    tempStack.push(new Move(move.disk-1, auxRod, fromRod));
                    tempStack.push(new Move(1, move.fromRod, move.toRod));
                    tempStack.push(new Move(move.disk-1, fromRod, auxRod));
                }
            }

            //transfer moves back to main stack >>
            while(!tempStack.isEmpty()){
                stack.push(tempStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the no of disks : ");
        int numberOfDisks = sc.nextInt();

        //define the rods>

        char fromRod = 'A';
        char auxRod = 'B';
        char toRod = 'C';

        TowerOfHanoi(numberOfDisks, fromRod, toRod, auxRod);

        sc.close();
    }
 
}
