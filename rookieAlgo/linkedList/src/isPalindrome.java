import java.util.HashMap;

/**
 * ClassName: isPalindrome
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/6 0:39
 * @Version 1.0
 */
public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        // 所有数字都重复两次的情况可以用，但没有考虑中点数字
        // 122134431221
        if(head == null || head.next == null) return true;
        int alpha = 1;
        int accum = head.val;
        int lastvalue = head.val;
        head = head.next;
        while(head != null ){
            if(head.val == lastvalue){
                alpha = alpha * -1;
            }
            lastvalue = head.val;
            accum += alpha*head.val;
            head = head.next;
        }

        return ( accum==0)?true:false;
    }
    //
    //


    /** 我的思路：
     * 1. 快慢指针找到中点
     * 2. 反转链表
     * 3. 依次比较是否相同
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 75.73%
     * 的用户
     * 内存消耗：
     * 57.8 MB
     * , 在所有 Java 提交中击败了
     * 36.49%
     * 的用户
     */
    public boolean isPalindrome2(ListNode head) {
        // 1 2 2 1
        if(head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        // 取得slow的位置，slow.next指向后半段的起始
        while( fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p1 = head;
        ListNode p2 = reverseList(slow.next);
        while(p2 != null){
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode Sentinal = new ListNode(0);
        ListNode temp;
        while(head != null){
            temp = Sentinal.next;
            Sentinal.next = head;
            head = head.next;
            Sentinal.next.next = temp;
        }
        return Sentinal.next;
    }

}

