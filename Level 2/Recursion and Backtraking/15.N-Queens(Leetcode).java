class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] arr=new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }

        queenPutting(ans,arr,0);
        return ans;
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
