import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: validateStackSequences
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/12 0:36
 * @Version 1.0
 */
public class validateStackSequences {
    /** 没思路，看 Krahets大佬题解
     *  https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/solutions/215152/mian-shi-ti-31-zhan-de-ya-ru-dan-chu-xu-lie-mo-n-2/?envType=study-plan-v2&envId=coding-interviews
     * 用stack进行模拟，如果最后push完了，还没有pop完，就说明不可能
     * TO 1ms 97% O(2N)
     * 空间复杂度 O(N)
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = popped.length;
        Deque<Integer> stack = new LinkedList<>();
        int poppedIndex = 0;
//        int pushIndex = 0;
//        while(pushIndex<n){
//            if(pushIndex < n){
//                stack.push(pushed[pushIndex]);
//                pushIndex++;
//            }
//            while(!stack.isEmpty() && stack.peek() == popped[poppedIndex]){
//                stack.pop();
//                poppedIndex++;
//            }
//        }
        //优化
        for(int num:pushed){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[poppedIndex]){
                stack.pop();
                poppedIndex++;
            }
        }
        return poppedIndex==n;
    }

}
