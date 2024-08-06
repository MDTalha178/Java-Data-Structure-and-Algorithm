import java.util.Scanner;

public class search_element {

    // search an element
    public static void search_element(int arr[][], int row, int col, int find_ele){
        boolean is_present = false;
        for(int i =0; i<row; i++){
            for(int j=0; j< col; j++){
                if(arr[i][j] == find_ele){
                    System.out.println("Yes Given element is present at (" + i + "," + j +")");
                    is_present = true;
                    break;
                }
            }
        }
        if(!is_present){
            System.out.println("No, Given element is not present");
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

    // print array
    public static void printArray(int arr[][], int row, int col){
        for(int i =0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int arr[][] = new int[3][3];
        int row = arr.length, col= arr[0].length;

        // taking input array
        takeInput(arr, row, col);

        // print array
        printArray(arr, row, col);

        System.out.println("Searching and element please wait..");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number find in Array");
        int find_ele = sc.nextInt();
        search_element(arr, row, col, find_ele);
       
    }
}
