package February;

public class NQuensII {
    private int count;
    public int totalNQueens(int n){
    count =0;
    int[] queens=new int[n];
    solvequeens(queens,0,n);
    return count;

    }

    private void solvequeens(int[] queens,int row,int n){
        if(row==n){
            count++;
            return;
        }

        for(int col=0;col<n;col++){
                if (isValid(queens, row, col)) {
                    queens[row] = col;
                    solvequeens(queens, row + 1, n);
                }
            }
        }

    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new NQuensII().totalNQueens(1));
    }
}
