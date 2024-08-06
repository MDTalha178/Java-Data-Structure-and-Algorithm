public class rat_maze {

    public static boolean isSafe(int maze[][] , int row, int col, int visited[][]){
        if((row >=0 && row < maze.length) && (col >=0 && col < maze.length) && (visited[row][col] != 1) && (maze[row][col] == 1)){
            return true;
        }
        return false;
    }

    public static void printMaze(int maze[][]){
        for(int i =0; i<maze.length; i++){
            for(int j =0; j<maze.length; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
    public static void rat_maze(int maze[][], int row, int col, int[][] visited , StringBuilder ans, String path){
        
        // base condtion
        if(row == maze.length-1 && col == maze.length-1){
            // System.out.println(path);
            ans.append(path + " ");
            return;
        }

        //  move from rigth
        if(isSafe(maze, row, col+1, visited)){
            visited[row][col] = 1;
            rat_maze(maze, row, col+1, visited, ans, path + 'R');
            visited[row][col] = 0;
        }

        // move from down
        if(isSafe(maze, row+1, col, visited)){
            visited[row][col] = 1;
            rat_maze(maze, row+1, col, visited, ans, path + 'D');
            visited[row][col] = 0;
        }
        // move from left
        if(isSafe(maze, row, col-1, visited)){
            visited[row][col] = 1;
            rat_maze(maze, row, col-1, visited, ans, path + 'L');
            visited[row][col] = 0;
        }
        // right from up
        if(isSafe(maze, row-1, col, visited)){
            visited[row][col] = 1;
            rat_maze(maze, row-1, col, visited, ans, path+'U');
            visited[row][col] = 0;
        }
        
    }
    public static void main(String args[]){

        int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
        int visited [][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        String path = "";
        StringBuilder ans = new StringBuilder();
        rat_maze(maze, 0, 0, visited, ans, path);
        System.out.println(ans);
    }
}
