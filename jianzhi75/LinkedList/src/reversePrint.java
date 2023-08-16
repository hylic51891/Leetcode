import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: reversePrint
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/11 10:43
 * @Version 1.0
 */
public class reversePrint {
    /** 辅助栈
     * 1ms 68%
     */
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int[] ret = new int[stack.size()];
        int index = 0;
        while(!stack.isEmpty()){
            ret[index++] = stack.pop();
        }
        return ret;
    }
    /** 递归
     * 1ms 68%
     */
    public int[] reversePrint2(ListNode head){
        ArrayList<Integer> list = new ArrayList<>();
        reversePrintRecursive(head,list);
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }
    public void reversePrintRecursive(ListNode head, ArrayList<Integer> list){
        if(head ==null){
            return;
        }
        reversePrintRecursive(head.next,list);
        list.add(head.val);
    }
    /** 头插法，再遍历
     * 100%
     */
    public int[] reversePrint3(ListNode head){
        int count = 0;
        ListNode reverse = new ListNode();
        ListNode temp;
        while(head!=null){
            temp = reverse.next;
            reverse.next = head;
            head = head.next;
            reverse.next.next = temp;
            count++;
        }
        int[] ret = new int[count];
        for (int i = 0; i < count; i++) {
            reverse = reverse.next;
            ret[i] = reverse.val;
        }
        return ret;
    }
}
