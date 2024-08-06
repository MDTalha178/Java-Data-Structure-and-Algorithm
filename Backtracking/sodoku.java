public class sodoku {
    public static boolean isSafeToPlace(int arr[][], int row, int col, int digit){
        // column
        for(int i =0; i<=8; i++){
            if(arr[row][i] == digit){
                return false;
            }
        }

        // row
        for(int i =0; i<=8; i++){
            if(arr[i][col] == digit){
                return false;
            }
        }

        // current grid
        int starting_row = (row /3) *3;
        int starting_col = (col/3) * 3;
        for(int i = starting_row; i< starting_row + 3; i++){
            for(int j = starting_col; j< starting_col+3; j++){
                if(arr[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean is_sodoku_solved(int arr[][], int row, int col){

        // base case 
        if( row == 9){
            return true;
        }
        
        // recursion
        int nextRow = row , nextCol = col + 1;
        if(col + 1 == 9){
            nextRow = row +1;
            nextCol =0;
        }

        if(arr[row][col] != 0){
            return is_sodoku_solved(arr, nextRow, nextCol);
        }
        for(int digit = 1; digit<=9; digit++){
            if(isSafeToPlace(arr, row, col, digit)){
                arr[row][col] = digit;
                // here we check solution exists
                if(is_sodoku_solved(arr, nextRow, nextCol)){
                    return true;
                }
                // if solution not exits we need back track
                arr[row][col] = 0;
            }
        }
        return true;
    }
    public static void main(String args[]){
        int arr[][] = new int[9][9];
        boolean is_solved = is_sodoku_solved(arr, 0, 0);
    }
}
