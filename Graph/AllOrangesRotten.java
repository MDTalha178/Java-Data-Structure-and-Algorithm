import java.util.*;

public class AllOrangesRotten {
    
    public static void main(String args[]){
        int arr[][] = {{2,1,0,2,1}, {0,0,1,2,1}, {1,0,0,2,1}};
        RottenOranges rotOrg = new RottenOranges();
        System.out.println(rotOrg.rotAllOrganges(arr));
    }
}
class Matrix{

    int row;
    int col;
    
    Matrix(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class RottenOranges{

    public boolean rotAllOrganges(int oranges[][]){
        int row =  oranges.length;
        int col = oranges[0].length;
        int freshCount = 0;

        Queue<Matrix>matrix_queue = new LinkedList<>();

        boolean visited[][] = new boolean[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(oranges[i][j] == 2){
                    matrix_queue.add(new Matrix(i, j));
                }
                else if (oranges[i][j] == 1){
                    freshCount++;
                }
            }
        }
        int convertedFresToRottenCount =0;
        // here we will implement BFS
        while (!matrix_queue.isEmpty()) {
            
            Matrix curr = matrix_queue.remove();
            if(!visited[curr.row][curr.col]){

                visited[curr.row][curr.col] = true;

                if(curr.row < row && curr.col < col  && curr.row >=0 && curr.col >=0){

                   
                    if(oranges[curr.row][curr.col] == 2){
                        // rot right index
                        if(isValidPosition(oranges, curr.row, curr.col+1)){
                            oranges[curr.row][curr.col + 1] = 2;
                            matrix_queue.add(new Matrix(curr.row, curr.col + 1));
                            convertedFresToRottenCount++;

                        }
                        // rot left
                        if(isValidPosition(oranges, curr.row, curr.col-1)){
                            oranges[curr.row][curr.col-1] = 2;
                            matrix_queue.add(new Matrix(curr.row, curr.col-1));
                            convertedFresToRottenCount++;
                        }
                        if(isValidPosition(oranges, curr.row-1, curr.col)){
                            // rot up
                            oranges[curr.row - 1][curr.col] = 2;
                            matrix_queue.add(new Matrix(curr.row - 1, curr.col));
                            convertedFresToRottenCount++;
                        }
                        if(isValidPosition(oranges, curr.row+1, curr.col)){
                            oranges[curr.row+1][curr.col] = 2;
                            matrix_queue.add(new Matrix(curr.row+1, curr.col));
                            convertedFresToRottenCount++;
                        }

                    }
                }

            }
        }
        return convertedFresToRottenCount == freshCount;
    } 
    public boolean isValidPosition(int oranges[][], int i , int j){
        if(i < oranges.length && i >=0 && j<oranges[0].length && j>=0 && oranges[i][j] == 1){
            return true;
        }
        return false;
    }
}