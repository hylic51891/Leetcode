package _2_twoPtr;

/**
 * ClassName: trap
 * Package: _2_twoPtr
 *  接雨水
 *  https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-daeca/dan-diao-z-1bebe/
 *  单调栈
 *  双指针：和左右的最大高度有关
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/24 1:00
 * @Version 1.0
 */
public class trap {
    public int trap(int[] height) {

        int res = 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = 0,rightMax=0;
        while(left < right){
            leftMax = Math.max(height[left],leftMax);
            rightMax = Math.max(height[right],rightMax);
            if(leftMax<rightMax){
                res += leftMax-height[left++];
            }
            else{
                res += rightMax-height[right--];
            }
        }

        return res;
    }
}
