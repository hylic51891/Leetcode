import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: maxSlidingWindow
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/11 20:11
 * @Version 1.0
 */
public class maxSlidingWindow {
    public static void main(String[] args) {
//        maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6},5);
    }

    /**
     * 我的思路：维护一个deque对应滑动窗口，每个值对应一个最大值
     * 思路错了，因为是FIFO，前面出栈对后面造成影响，但信息丢失了
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1) return nums;
        Deque<Integer> deque = new LinkedList<>();
        int[] ret = new int[nums.length-k+1];
        int max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;
//        for (int i = 0; i < k; i++) {
//            if(nums[i]> max) {
//                max = nums[i];
//                second_max = max;
//            }
//            else if ( nums[i]> second_max) {
//                second_max = nums[i];
//            }
//            deque.offer(nums[i]);
//        }
        for(int i=0;i< nums.length;i++){
            if(nums[i]> max) {
                max = nums[i];
                second_max = max;
            }
            else if ( nums[i]> second_max) {
                second_max = nums[i];
            }
            deque.offer(nums[i]);

            if(i >= k-1){
                ret[i-k+1] = max;
                int poll = deque.poll();
                if(poll == max){
                    max = second_max;
                    second_max = Integer.MIN_VALUE;
                } else if (poll == second_max) {
                    second_max = Integer.MIN_VALUE;
                }
            }


        }
        return ret;

    }
    /** 题解 单调队列
     * https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/submissions/?envType=study-plan-v2&envId=coding-interviews
     * 原理： 滑动窗口中，在max前面的元素可忽略，在max后面的元素，可能是后续滑动窗口最大值，不能忽略。
     * 进行迭代的时候，依次存储下标最小，值最大的值。
     *
     * 细节： 用deque维护一个单调队列
     * 1. 下标递增
     * 2. 对应值递减
     * deque中最多有K个元素，访问新元素的时候，如果大于任意deque中的值，则需要从尾部循环，维持单调性
     */
    public int[] maxSlidingWindow2(int[] nums, int k){
        if(k<=1) return nums;
        Deque<Integer> deque = new LinkedList<>();
        int[] ret = new int[nums.length-k+1];
        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty() && nums[i] >=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        ret[0] = nums[deque.peekFirst()];
        for (int i = k;i < nums.length; i++) {
            while(!deque.isEmpty() && nums[i] >=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(deque.peekFirst() <= i-k){
                deque.pollFirst();
            }
            ret[i-k+1] = nums[deque.peekFirst()];
        }
        return ret;
    }

    /** 20230824 hot100 又做了一次
     *  看过单调队列之后，自己写了一遍。
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        if(k<=1) return nums;
        int[] res = new int[nums.length-k+1];
        Deque<Integer> queue = new LinkedList<>();
        // 保存最大值以及下标在他之后的次最大值,次次最大值...
        // 单调队列，保存下标严格递增，值严格递减的值
        // 新入栈的值依次比较栈中最后的值
        // 栈中最多有K个值
        for (int i = 0; i < k-1; i++) {
            int cur = nums[i];
            while(!queue.isEmpty() && nums[queue.peekLast()]< cur) queue.pollLast();
            queue.offerLast(i);
        }
        // res[0] = nums[queue.pollFirst()];
        int right = k-1;
        while(right < nums.length){
            int cur = nums[right];
            while(!queue.isEmpty() && nums[queue.peekLast()]< cur) queue.pollLast();
            queue.offerLast(right);
            int maxIndex = queue.peekFirst();
            res[right-k+1] = nums[maxIndex];
            if(right-k+1== maxIndex) queue.pollFirst();
            right++;
        }
        return res;
    }
}
