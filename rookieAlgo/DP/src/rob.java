/**
 * ClassName: rob
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/8 16:26
 * @Version 1.0
 */
public class rob {
    /**
     子问题：轮到第n个房屋的最高金额？
     状态：可以用两个最大值状态，dp1一个是抢了当前屋子，dp0一个是没有抢当前屋子
     状态转移：轮到第n个房屋的最高金额
     rob0 = (rob1 > rob0)? rob1:rob0;
     rob1 = (temp + nums[i] > rob1)?temp + nums[i]:rob1;
     初始状态：
     */
    /**
     * 0ms 100%
     * 38.6 96%
     */
    public int rob(int[] nums) {
        int rob0 = 0,rob1 = 0;
        int temp;
        for(int i = 0;i<nums.length;i++){
            temp = rob0;
            rob0 = (rob1 > rob0)? rob1:rob0;
            rob1 = (temp + nums[i] > rob1)?temp + nums[i]:rob1;

        }
        return (rob1>rob0)?rob1:rob0;
    }
}
