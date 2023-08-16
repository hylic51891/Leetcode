package _980_h;

/**
 * ClassName: uniquePathsIII
 * Package: _980_h
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/4 12:41
 * @Version 1.0
 */
public class uniquePathsIII {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,0,0,0},{0,0,0,0},{0,0,2,-1}
        };
        int[][] grid2 = new int[][]{
                {1,0,0,0},{0,0,0,0},{0,0,0,2}
        };
        int[][] grid3 = new int[][]{
                {1,0,2}
        };
        System.out.println(uniquePathsIII(grid));
        System.out.println(uniquePathsIII(grid2));
        System.out.println(uniquePathsIII(grid3));
    }
    /** 看完题解的思路：
     *  用回溯的方法：
     *  1. 找到起始点，同时计算需要走多少步（多少个0）到达终点算走完全部点
     *  2. 用一个和矩阵同样大小的数组维护是否走过
     *  3. 进行回溯，函数参数：还要走的步数，当前点的位置；返回值：是从该点到终点的有效路径数量
     *  4. 走到（x,y）点的流程：
     *      1. 判断当前点是否为终点，如果还要走的步数为0，则返回1；不为0，则返回0；
     *      2. 不是终点，判断是否为-1，是否已经走过，是否或者超出边界，返回
     *      3. 是0，则已走过数组对应位置置为true,则还要走的步数-1，当前点有效路径=周围四个点的有效路径，递归调用本函数
     */
    /**
     *  1. 需要的参数：维护是否走过的矩阵，矩阵长宽
     */
    private static int height;
    private static int width;
    private static boolean[][] visited;

    private static int endX;
    private static int endY;
    private static final int[] left = new int[]{-1,0};
    private static final int[] right = new int[]{1,0};
    private static final int[] down = new int[]{0,-1};
    private static final int[] up = new int[]{0,1};

    public static int uniquePathsIII(int[][] grid) {
        int res = 0;
        int x = 0;
        int y = 0;
        height = grid.length;
        width = grid[0].length;
        visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grid[i][j] == 1){
                    x = i;
                    y = j;
                }
                if(grid[i][j] == 2){
                    endX = i;
                    endY = j;
                }
                else if(grid[i][j] == 0){
                    res++;
                }
            }
        }
//        visited[x][y] = true;
//        int count = 0;
//        count = uniquePathRecursive(grid,x+up[0],y+up[1],res)+
//                uniquePathRecursive(grid,x+down[0],y+down[1],res)+
//                uniquePathRecursive(grid,x+left[0],y+left[1],res)+
//                uniquePathRecursive(grid,x+right[0],y+right[1],res);
//        return count;
        return uniquePathRecursive(grid,x,y,res+1);
    }
    public static int uniquePathRecursive(int[][] grid,int x,int y,int res){
        int count = 0;
        // 超出边界或此处为障碍或已经走过
        if(x < 0 || x >= height || y < 0 || y >= width){
            return 0;
        }
        if(grid[x][y] == -1 || visited[x][y]){
            return 0;
        }
        // 走到终点
        else if(x==endX && y==endY) {
            return (res==0)?(1):(0);
        }
        // 当前位置为0
        else{
            res = res -1;
            visited[x][y] = true;
            count = uniquePathRecursive(grid,x+up[0],y+up[1],res)+
                    uniquePathRecursive(grid,x+down[0],y+down[1],res)+
                    uniquePathRecursive(grid,x+left[0],y+left[1],res)+
                    uniquePathRecursive(grid,x+right[0],y+right[1],res);
            visited[x][y] = false;
        }
        return count;
    }


}
