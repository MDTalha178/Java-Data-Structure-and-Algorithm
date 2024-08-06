import java.util.Scanner;

public class spiral_matrix {

    // print spiral array
    public static void printSpiralArray(int arr[][], int row, int col){
        int start_row = 0, start_col = 0, end_row = row-1, end_col = col -1;

        while (start_row <= end_row && start_col <= end_col) {
            // here we will print row
            for(int i =start_col; i<=end_col; i++){
                System.out.print(arr[start_row][i] + " ");
            }
            System.out.println();
            start_row++;

            // here will print last outer col
            for(int i=start_row; i<=end_row; i++){
                System.out.print(arr[i][end_col] + " ");
            }
            System.out.println();
            end_col--;

            // here we will print end outer row
            for(int i=end_col; i>=start_row-1; i--){
                System.out.print(arr[end_row][i] + " ");
            }
            System.out.println();
            end_row--;

            // here we will print front outer row
            for(int i=end_row; i>=start_row; i--){
                System.out.print(arr[i][start_col] + " ");
            }
            System.out.println();
            start_col++;

        }
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
        int arr[][] = new int[3][3];

        int row = arr.length, col = arr[0].length;
        // here we will take input 
        takeInput(arr, row, col);

        // print spiral array
        printSpiralArray(arr, row, col);

    }
}
