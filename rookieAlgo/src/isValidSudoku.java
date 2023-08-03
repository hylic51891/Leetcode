import java.util.HashMap;
import java.util.HashSet;

/**
 * ClassName: isValidSudoku
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/3 19:07
 * @Version 1.0
 */
public class isValidSudoku {
    /**
     * 我的思路：
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] takenCol = new boolean[9][9];
        boolean[][] takenRow = new boolean[9][9];
        boolean[][] takenSec = new boolean[9][9];
        int num;
        for(int i = 0;i< 9;i++){
            for(int j = 0;j< 9;j++){
                if(board[i][j]== '.'){
                    continue;
                }
                num = board[i][j] - '1';
                if(takenCol[num][i] || takenRow[num][j] || takenSec[num][i/3+3*(int)(j/3)]) {
                    return false;
                }
                takenCol[num][i] = true;
                takenRow[num][j] = true;
                takenSec[num][i/3+3*(int)(j/3)] = true;
            }
        }
        return true;
    }

}
