//LeetCode N-Queen Version


class Solution {
    public int totalNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] arr=new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }

        queenPutting(ans,arr,0);
        return ans.size();
    }
    public void queenPutting(List<List<String>> ans,char[][] arr,int row){
        if(row==arr.length){
            ans.add(build(arr));
            return;
        }

        for(int col=0;col<arr[0].length;col++){
            if(isSafeQueen(arr,row,col)){
                arr[row][col]='Q';
                queenPutting(ans,arr,row+1);
                arr[row][col]='.';
            }
        }
    }
    public boolean isSafeQueen(char[][] arr,int row,int col){
        //check Vertically
        for(int i=row-1,j=col;i>=0;i--){
            if(arr[i][j]=='Q'){
                return false;
            }
        }

        //check left Diagonally

        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(arr[i][j]=='Q'){
                return false;
            }
        }

        //check right diagonally

        for(int i=row-1,j=col+1;i>=0 && j<=arr.length-1;i--,j++){
            if(arr[i][j]=='Q'){
                return false;
            }
        }


        return true;

    }
    private List<String> build(char arr[][])
    {
        List<String> val = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
            val.add(new String(arr[i]));
        return val;
    }
}

//================================================================================================================================================

//GeeksForGeeks N-Queen Version

class Solution {
    static ArrayList<ArrayList<Integer>> ans;
    public int totalNQueens(int n) {
        ans=new ArrayList<>();
        int[][] board=new int[n][n];
        
        queenPuttingTry(board,0);
        return ans.size();
    }
    
    static void queenPuttingTry(int[][] board,int row){
        if(row==board.length){
            createSolution(board);
            return;
        }
        
        for(int col=0;col<board[0].length;col++){
            if(isQueenSafe(board,row,col)){
                board[row][col]=1;
                queenPuttingTry(board,row+1);
                board[row][col]=0;
            }
        }
    }
    
    static void createSolution(int[][] board){
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==1){
                    list.add(j+1);
                }
            }
        }
        ans.add(list);
    }
    
    static boolean isQueenSafe(int [][]board,int row, int col){
        //check for vertically
        for(int i=row-1,j=col;i>=0;i--){
            if(board[i][j]==1){
                return false;
            }
        }
        
        // check for left diagonally
        for(int i=row-1,j=col-1;i>=0 && j>=0 ;i--,j--){
            if(board[i][j]==1){
                return false;
            }
        }
        
        
        //check for right diagonally
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]==1){
                return false;
            }
        }
        
        
        
        //otherwise
        return true;
    }
}
