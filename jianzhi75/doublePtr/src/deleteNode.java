/**
 * ClassName: deleteNode
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/11 15:04
 * @Version 1.0
 */
public class deleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode curNode = sentinel;
        while(curNode.next.val!=val){
            curNode = curNode.next;
        }
        curNode.next = curNode.next.next;
        return sentinel.next;
    }
}
