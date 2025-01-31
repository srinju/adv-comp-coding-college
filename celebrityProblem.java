public class celebrityProblem {
    
    /*
        BRUTE FORCE APPROACH >> 
    
    public static int celebrity(int[][] arr) {
        
        int n = arr.length;
        int[] in = new int[n]; //in matlab usko kon kon janta hai
        int[] out = new int[n]; //out matlab woh kis kis ko janta hai

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == 1){
                    //matlab i j k chene
                    in[j]++; //j k chene loke
                    out[i]++;// i lok jon m chene
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(in[i] == n-1 && out[i] == 0){
                //mane hocche i k sobai chene and i kaoke chene na tale i candidate
                return i;
            }
        }
        return -1;
    }
        */


    //OPTIMISED APPROACH >>

    //what we will do is we will check all the elements wheteher it knows other person or not 
    //the loop will run until we find a person who doesent know anyone
    //then we might find the ceelb 
    //but we have to see an edge case 
    //that is we will check for all the indexes where it knows someone that uske liye agar koi usko sab pahchan rha h toh theek and woh kisiko ni pahchan rha h toh bhi theek

    public static int celeb(int[][] arr){

        int n = arr.length;

        int c = 0 ;
        for(int i = 1  ; i < n ; i++){ //1 s start becasue mf nobody knows the first mf
            if(arr[c][i] == 1){
                //i k jodi keo jane tale c = i
                c = i;
            }
        }
        //now assure that i is that celeb for those 
        for(int i = 0 ; i < n ; i++){
            if(i != c && ( arr[c][i] == 1 || arr[i][c] == 0)){
                return -1;
            }
        }
        return c;
    }
    

    public static void main(String[] args) {
        
        int[][] arr = {
            {0, 1, 0},
            {0, 0, 0},
            {0, 1, 0}
        };

        int celeb = celeb(arr);
        if (celeb == -1) {
            System.out.println("No celebrity found");
        } else {
            System.out.println("id of the celeb : " + celeb);
        }
    }
}
