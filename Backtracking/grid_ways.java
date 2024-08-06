public class grid_ways {
    public static int printGrid(int i, int j, int row, int col){
        if(i ==  row-1 && j == col-1){
            return 1;
        }
        if(i == row || j == col){
            return 0;
        }
        // rucrsive call
        int w1 = printGrid(i+1, j, row, col);
        int w2 = printGrid(i,j+1, row, col);
        return w1 + w2;
    }

    public static void main(String[] args) {
        int arr[][] = new int [3][3];
        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j<arr.length; j++){
                arr[i][j] = 0;
            }
        }
        int total_ways = printGrid(0, 0, 3, 3);
        System.out.println(total_ways);
    }
}
