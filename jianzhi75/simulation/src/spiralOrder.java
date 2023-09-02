import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: spiralOrder
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/11 22:53
 * @Version 1.0
 */
public class spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        int[][] matrix2 = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        spiralOrder3(matrix2);
    }

    /**
     * 我写的是转正方形的，看完题解改了
     * 1ms 89%
     */
    public static int[] spiralOrder(int[][] matrix) {
        int row =matrix.length;
        if(row == 0) return new int[0];
        int column =matrix[0].length;
        int[] ret = new int[row*column];
        int l = 0, r = column - 1;
        int t = 0, b = row - 1;
        int index = 0;
        while(true){
            // left to right.
            for (int x = l; x <= r; x++) {
                ret[index++] = matrix[t][x];
            }
            if(++t > b) break;
            // top to bottom.
            for(int y = t; y <= b; y++){
                ret[index++] = matrix[y][r];
            }
            if(l > --r) break;
            // right to left.
            for (int x = r; x >= l; x--) {
                ret[index++] = matrix[b][x];
            }
            if(t > --b) break;
            // bottom to top.
            for(int y = b; y >= t; y--){
                ret[index++] = matrix[y][l];
            }
            if(++l > r) break;
        }

        return ret;
    }


    /**
     * 状态转移
     * 2ms 23%
     */
    public static int[] spiralOrder2(int[][] matrix) {
        int row =matrix.length;
        if(row == 0) return new int[0];
        int column =matrix[0].length;
        int[] ret = new int[row*column];
        int index = 0;


        int[][] direction = new int[4][2];
        direction[0] = new int[]{0,1}; // right
        direction[1] = new int[]{1,0}; // down
        direction[2] = new int[]{0,-1}; // left
        direction[3] = new int[]{-1,0}; // up
        int loop = 0;
        int status = 0;
        int boundary = column-1;
        int x= -1,y = 0;
        while(index < row*column){
            switch (status){
                case 0:{
                    if(x < boundary -loop){
                        y += direction[status][0];
                        x += direction[status][1];
                        ret[index++] = matrix[y][x];
                        break;
                    }
                    else{
                        status = 1;
                        boundary = row-1;
                    }
                }
                case 1:{
                    if(y < boundary -loop){
                        y += direction[status][0];
                        x += direction[status][1];
                        ret[index++] = matrix[y][x];
                        break;
                    }
                    else{
                        status = 2;
                        boundary = 0;
                    }
                }
                case 2:{
                    if(x > boundary + loop){
                        y += direction[status][0];
                        x += direction[status][1];
                        ret[index++] = matrix[y][x];
                        break;
                    }
                    else{
                        status = 3;
                        boundary = 1;
                    }
                }
                case 3:{
                    if(y > boundary + loop){
                        y += direction[status][0];
                        x += direction[status][1];
                        ret[index++] = matrix[y][x];
                        break;
                    }
                    else{
                        status = 0;
                        boundary = column-1;
                        loop++;
                    }
                }
                default:
                    break;
            }
        }
        return ret;
    }

    /**
     * 状态转移2
     * 3ms 更慢了
     */
    public static int[] spiralOrder3(int[][] matrix) {
        int row =matrix.length;
        if(row == 0) return new int[0];
        int column =matrix[0].length;
        int[] ret = new int[row*column];
        int index = 0;

        int[][] direction = new int[4][2];
        direction[0] = new int[]{0,1}; // right
        direction[1] = new int[]{1,0}; // down
        direction[2] = new int[]{0,-1}; // left
        direction[3] = new int[]{-1,0}; // up
        int loop = 0;
        int status = 0;
        int lastStatus = 0;
        int x= 0,y = 0;
        int[][] bound = new int[4][4];
        bound[0] = new int[]{column-1,row+column,-column,-row};
        bound[1] = new int[]{column+row,row-1,-column,-row};
        bound[2] = new int[]{column+row,row+column,0,-row};
        bound[3] = new int[]{column+row,row+column,-column,1};
        while(index < row*column){
            if(lastStatus == status){
                ret[index++] = matrix[y][x];
            }
            else{
                lastStatus = status;
            }
            if(x < bound[status][0] -loop && y < bound[status][1] -loop && x >bound[status][2]+ loop && y >bound[status][3]+loop){
                y += direction[status][0];
                x += direction[status][1];
            }
            else{
                status++;
                if(status ==4) {
                    loop++;
                    status = 0;
                }
            }
        }
        return ret;
    }
}
