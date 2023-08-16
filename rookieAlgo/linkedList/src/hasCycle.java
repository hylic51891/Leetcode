/**
 * ClassName: hasCycle
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/10 22:18
 * @Version 1.0
 */
public class hasCycle {
    // O(n)
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null && fast.next.next!= null && fast.next.next.next!= null && fast.next.next.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==fast) return true;
        }
        return false;
    }
}
