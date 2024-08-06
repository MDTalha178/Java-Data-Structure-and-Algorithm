import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class diagonal_sum {

    // diagonal sum
    public static void diagonal_sum(int arr[][], int row, int col){
        int sum = 0;
        for(int i= 0; i< arr.length; i++){
            // primary sum
            sum +=  arr[i][i];

            // secondary sum
            if(i != arr.length-1-i){
                sum += arr[i][arr.length-1-i];
            }
        }
        System.out.println(sum);
    }

    // taking input array
    public static void takeInput(int arr[][], int row, int col){
        Scanner sc = new Scanner(System.in);
        for(int i =0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }
    public static void main(String args[]){
        int arr[][] = new int[4][4];

        int row = arr.length, col = arr[0].length;
        // here we will take input 
        takeInput(arr, row, col);

        // diagonal_sum
        diagonal_sum(arr, row, col);
    }
}
