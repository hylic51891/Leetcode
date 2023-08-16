/**
 * ClassName: maxProfit1
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/7 21:26
 * @Version 1.0
 */
public class maxProfit1 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices2 = new int[]{1};
        int[] prices3 = new int[]{1,2};
        System.out.println(maxProfit(prices3));
    }

    /**
     * 用前缀和,没有必要用前缀和，其实是找最小值和最大值
     */
//    public static int maxProfit(int[] prices) {
//
//        if(prices.length == 1) return 0;
//        int[] dp = new int[prices.length];
//        dp[0] = 0;
//        int minIndex = 0;
//        int maxIndex = 0;
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        for (int i = 1; i < prices.length; i++) {
//            dp[i] = dp[i-1] + prices[i] - prices[i - 1];
//            if (dp[i] < min){
//                minIndex = i;
//                min = dp[i];
//            }
//            if (dp[i] > max){
//                maxIndex = i;
//                max = dp[i];
//            }
//        }
//        if(maxIndex < minIndex) return 0;
//        return max - min;
//    }
    /**
     * 直接暴力搜索，超时
     */
    public static int maxProfit(int[] prices){
        int boughtPrice;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            boughtPrice = prices[i];
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j]-boughtPrice > maxProfit){
                    maxProfit = prices[j]-boughtPrice;
                }
            }
        }
        return (maxProfit > 0 )?(maxProfit):0;
    }
    /**
     * 记录最小值和最大收益，从前向后遍历，如果当前值小于最小值，则改为最小值，如果利润更大，则更新
     * 1ms 100%
     * 56mb 74%
     */
    public static int maxProfit2(int[] prices){
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < min) min = prices[i];
            else if(prices[i] - min > maxProfit) maxProfit = prices[i]- min;
        }
        return maxProfit;
    }
    /**
     * 动态规划：当前状态，dp[i][0]没有持有股票/dp[i][1]持有股票
     * 初始状态：钱=0
     * 当天持有股票的状态：
     *  1. 前一天就持有股票。则dp[i][1]=dp[i-1][1]
     *  2. 当天买入：dp[i][1] = -prices[i]
     * 当天没有持有股票的状态：
     *  1. 之前一直没有买 dp[i][0]=dp[i-1][0]
     *  2. 之前买了，今天卖了 dp[i][0]=dp[i-1][1]+prices[i]
     *
     *  dp[i]为最优解则两种状态都分别取最大值，从前向后遍历，最后一天不持有股票的状态就是最优解
     *
     *
     *
     * 3ms 26%
     * 56 54.2%
     */
     public static int maxProfit3(int[] prices){
         if(prices.length == 1) return 0;
         int dp[] = new int[]{0,-prices[0]};
         for (int i = 1; i < prices.length; i++) {
             dp[1] = (dp[1] > -prices[i])? dp[1]:-prices[i];
             dp[0] = (dp[0] > dp[1]+prices[i])? dp[0]:dp[1]+prices[i];
         }
         return dp[0];
     }
}
