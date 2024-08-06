class N_Queen{
    public static boolean isSafeToPlace(char arr[][], int row, int col){

        // vertical up condtion
        for(int i = row-1; i>=0; i--){
            if(arr[i][col] == 'Q'){
                return false;
            }
        }

        // diagonal left
        for(int i = row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(arr[i][j] == 'Q'){
                return false;
            }
        }

        // diagonal right
        for(int i = row-1, j = col+1; i>=0 && j<arr.length; i--, j++){
            if(arr[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char arr[][]){
        for(int i =0; i<arr.length; i++){
            for(int j = 0; j<arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean printNQueen(char arr[][], int row, boolean is_solution){
        
        // base case
        if(row == arr.length){
            printBoard(arr);
            return true;
        }
        // recursive call
        for(int i =0; i<arr.length; i++){
            if(isSafeToPlace(arr, row, i)){
                arr[row][i] = 'Q';
                boolean is_sol = printNQueen(arr, row+1, is_solution);
                if(is_sol){
                    is_solution = true;
                }else{
                    is_solution = false;
                }
                arr[row][i] = '-';

            }
        }
        return is_solution;

    }
    public static void main(String args[]){
        char arr[][] = new char[3][3];
        for (int i =0; i< arr.length; i++){
            for(int j =0; j<arr.length; j++){
                arr[i][j] = '-';
            }
        }
        boolean is_sol = false;
        boolean is_solution = printNQueen(arr, 0, is_sol);
        if(!is_solution){
            System.out.println("On this Board Queen not able Placed");
        }
    }
}