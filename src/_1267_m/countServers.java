package _1267_m;

/**
 * ClassName: countServers
 * Package: _1267_m
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/24 10:20
 * @Version 1.0
 */
public class countServers {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rows = new int[m][2];
        int[][] columns = new int[n][2];
        int total = 0;
        int single = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    rows[i][0]++;
                    rows[i][1] = j;
                    columns[j][0]++;
                    columns[j][1] = i;
                    total++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if(rows[i][0]==1 && columns[rows[i][1]][0]==1){
                single++;
            }
        }
        return total-single;
    }
}
