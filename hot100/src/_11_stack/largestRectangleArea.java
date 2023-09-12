package _11_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: largestRectangleArea
 * Package: _11_stack
 * Description:
 *
 * @Author hylic
 * @Create 2023/9/7 16:17
 * @Version 1.0
 */
public class largestRectangleArea {
    // 对某个矩形而言，包括它的最大矩形=(连续更长矩形的宽度)*该高度
    //优化：
    // 单调栈单调增，当出栈的时候，右侧有比它小的值，是第一个找到的
    // 可以直接计算能够获取的最大矩形
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int ret = Integer.MIN_VALUE;
        Deque<Integer> stack = new LinkedList<>();

        int[] myHeights = new int[len+2];
        System.arraycopy(heights,0,myHeights,1,len);
        myHeights[0] = -1;
        myHeights[len+1] = -1;
        stack.push(0);
        for(int i = 1;i<=len+1;i++){
            if(myHeights[stack.peek()] < myHeights[i]){
                stack.push(i);
            }
            else if(myHeights[stack.peek()]== myHeights[i]){
                stack.pop();
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && myHeights[stack.peek()]>= myHeights[i]){
                    int height = myHeights[stack.pop()];
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int right = i;
                        int rect = height*(right-left-1);
                        ret = (ret> rect)?ret:rect;
                    }
                }
                stack.push(i);
            }
        }
        return ret;
    }

    public int largestRectangleArea2(int[] heights) {
        // 找两侧第一个小于它的位置

        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];

        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0;i<len;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>= heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) left[i] = stack.peek();
            else left[i] = -1;
            stack.push(i);
        }

        stack = new LinkedList<>();
        for(int i = len-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>= heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) right[i] = stack.peek();
            else right[i] = len;
            stack.push(i);
        }

        int ret = Integer.MIN_VALUE;
        for(int i = 0;i<len;i++){
            int rect = heights[i]*(right[i]-left[i]-1);
            ret = (ret> rect)?ret:rect;
        }
        return ret;
    }
}
