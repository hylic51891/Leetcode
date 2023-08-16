import java.util.HashSet;

/**
 * ClassName: getIntersectionNode
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/11 15:17
 * @Version 1.0
 */
public class getIntersectionNode {
    /**
     * hashset存放，看是否重复
     * 5ms 19%
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /** 1ms 100%
     * O(2n) O(1)
     *
     */
    ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
