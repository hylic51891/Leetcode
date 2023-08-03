import java.util.Arrays;

/**
 * ClassName: maxProfit
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/3 20:46
 * @Version 1.0
 */
public class maxProfit {
    /** 简单粗暴，只持有一天，然后把差值中的正数加起来
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 29.18%
     * 的用户
     * 内存消耗：
     * 43.3 MB
     * , 在所有 Java 提交中击败了
     * 20.99%
     * 的用户
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        for (int i = prices.length-1;i > 0; i--) {
            prices[i] = prices[i] - prices[i-1];
        }
        prices[0] = 0;
        Arrays.sort(prices);
        int profit = 0;
        for (int i = prices.length-1; i > 0 ; i--) {
            if(prices[i] < 0) break;
            profit += prices[i];
        }
        return profit;
    }

    /** 算上升区间的总和，贪心算法：总是选择当前的最优解
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 43.1 MB
     * , 在所有 Java 提交中击败了
     * 47.60%
     * 的用户
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices){
        int profit = 0;
        for (int i = prices.length-1;i > 0; i--) {
            profit+= (prices[i] > prices[i-1])?(prices[i]-prices[i-1]):(0);
        }
        return profit;
    }
    /** 动态规划：当天手里有股票和当天手里没有股票
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 72.35%
     * 的用户
     * 内存消耗：
     * 43.1 MB
     * , 在所有 Java 提交中击败了
     * 54.03%
     * 的用户
     */
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int length = prices.length;
        //初始条件
        int hold = -prices[0];//持有股票
        int noHold = 0;//没持有股票
        for (int i = 1; i < length; i++) {
            //递推公式转化的
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, noHold - prices[i]);
        }
        //最后一天肯定是手里没有股票的时候利润才会最大，
        //所以这里返回的是noHold
        return noHold;
    }
}
