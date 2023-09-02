package _6_matrix;

import java.util.Arrays;

/**
 * ClassName: setZeroes
 * Package: _6_matrix
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/25 16:50 done 17:15
 * @Version 1.0
 */
public class setZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,0,7,8},
                {0,10,11,12},
                {13,14,15,0}
        };

    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false;
        boolean firstColumn = false;


        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) firstColumn = true;
        }
        for (int i = 0; i < n; i++) {
            if(matrix[0][i] == 0) firstRow = true;
        }

        for(int i = 1;i<m;i++){
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
//                    if(i==0 && j==0){
//                        firstRow = true;
//                        firstColumn = true;
//                    }
//                    else if(j==0){
//                        firstColumn = true;
//                        matrix[i][0] = 0;
//                    }
//                    else if( i==0){
//                        firstRow = true;
//                        matrix[0][j] = 0;
//                    }
//                    else{
//                        matrix[i][0] = 0;
//                        matrix[0][j] = 0;
//                    }

                }
            }
        }
        for (int i = 1; i < m; i++) {
            if(matrix[i][0] == 0) Arrays.fill(matrix[i],0);
        }
        for (int i = 1; i < n; i++) {
            if(matrix[0][i] == 0){
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if(firstRow){
            Arrays.fill(matrix[0],0);
        }
        if(firstColumn){
            for (int j = 0; j < m; j++) {
                matrix[j][0] = 0;
            }
        }

    }
}
