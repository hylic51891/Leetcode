/**
 * ClassName: removeNthFromEnd
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/10 22:05
 * @Version 1.0
 */
public class removeNthFromEnd {
    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     *
     时间复杂度：O(L) L是链表的长度。
     空间复杂度：O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode curNode1 = sentinel;
        ListNode curNode2 = head;

        for(int i = 0;i<n;i++){
            curNode2 = curNode2.next;
        }
        while(curNode2!= null){
            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
        }
        // 此时curNode1的下一个节点就是要删除的节点
        curNode1.next = curNode1.next.next;
        return sentinel.next;
    }
}
