/**
 * ClassName: climbStairs
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/7 22:39
 * @Version 1.0
 */
public class climbStairs {
    /**
     * 直接递归，超时
     */
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }
    /** 非递归,斐波那契数列
     执行用时：
     0 ms
     , 在所有 Java 提交中击败了
     100.00%
     的用户
     内存消耗：
     38 MB
     , 在所有 Java 提交中击败了
     91.58%
     的用户
     */
    public int climbStairs2(int n) {
        if(n<=2) return n;
//        int dp[][] = new int[n+1][2];
//        dp[1][0] = 1;
//        dp[1][1] = 0;
//        dp[2][0] = 1;
//        dp[2][1] = 1;
//        for (int i = 3; i < n+1; i++) {
//            dp[i][0] = dp[i-1][0] + dp[i-1][1];
//            dp[i][1] = dp[i-2][0] + dp[i-2][1];
//        }
//        return dp[n][0]+ dp[n][1];
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    /** 动态规划，滚动数组
     * 0ms 100%
     * 38mb 91%
     */
    public int climbStairs3(int n) {
        if(n<=2) return n;
        int p = 0,q = 1,r = 2;
        for (int i = 3; i < n+1; i++) {
            p = q+r;
            q = r;
            r = p;
        }
        return p;
    }
    /** 矩阵快速幂
     * https://leetcode.cn/problems/climbing-stairs/solutions/286022/pa-lou-ti-by-leetcode-solution/
     */
    public int climbStairs4(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = fastPower(q, n);
        return res[0][0];
    }

    public static int[][] fastPower(int[][] base,int power){
        int[][] res = {{1, 0}, {0, 1}};
        while(power>0){
            if(power%2!=0){
                power = power-1;
                res = multiply(res,base);
            }
            power = power/2;
            base = multiply(base,base);
        }
        return res;
    }
    public static int[][] multiply(int[][] a,int[][] b){
        int length = a.length;
        int[][] c = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    c[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }
}
