package _23_h;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ClassName: mergeKLists
 * Package: _23_h
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/12 23:21
 * @Version 1.0
 */
public class mergeKLists {
    /** 我的思路，暴力遍历
     * 98ms 24%
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode sentinel = new ListNode();
        int n = lists.length;
        if(n == 1) return lists[0];
        for (int i = 0; i < lists.length; i++) {
            sentinel.next = mergeTwoList(sentinel.next,lists[i]);
        }
        return sentinel.next;
    }

    public static ListNode mergeTwoList(ListNode list1,ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode sentinel = new ListNode();
        sentinel.next = list1;
        ListNode cur = sentinel;
        while(list2!=null){
            // 找到最后一个小于当前list2值的node
            while(cur.next != null && cur.next.val < list2.val){
                cur = cur.next;
            }
            if(cur.next == null){
                cur.next = list2;
                break;
            }
            ListNode temp = cur.next;
            cur.next = list2;
            list2 = list2.next;
            cur.next.next = temp;
            cur = cur.next;
        }
        return sentinel.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode sentinel = new ListNode(0);
        int n = lists.length;
        if (n == 1) return lists[0];
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((ListNode n1, ListNode n2) -> n1.val - n2.val);
        for (int i = 0; i < n; i++) {
            if(lists[i]!=null) pq.offer(lists[i]);
        }
        ListNode tail = sentinel;
        ListNode curMin;
        while (!pq.isEmpty()) {
            curMin = pq.poll();
            tail.next = curMin;
            if(curMin.next != null) pq.offer(curMin.next);
            tail = tail.next;
        }
        return sentinel.next;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}