/*

 * * * * *
 *       *
 *       *
 * * * * *
 

 */

import java.util.Scanner;

public class print_hallow {
    public static void main(String args[]){
        System.out.println("Please enter row number:");
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();

        System.out.println("Please enter col number:");
        int col = sc.nextInt();

        int i = 0;
        while(i< row){
            int j = 0;
            if(i ==0  || row == i+1){
                while(j < col){
                    System.out.print("*");
                    j++;
                }
                System.out.println();
            }
            else{
                System.out.print("*");
                j++;
                while(j<col-1){
                    System.out.print(" ");
                    j++;
                }
                System.out.print("*");
                System.out.println();
            }
            i++;
        }

    }
}
