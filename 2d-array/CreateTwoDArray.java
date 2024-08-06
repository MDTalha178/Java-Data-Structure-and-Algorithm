import java.util.Scanner;

public class CreateTwoDArray{

    public static void printArray(int arr[][], int row, int col){
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int arr[][] = new int[3][3];
        int row = 3 , col= 3;
        Scanner sc = new Scanner(System.in);

        for(int i =0; i< row; i++){
            for(int j = 0; j<col; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // print 2d Array
        printArray(arr, row, col);
    }
}