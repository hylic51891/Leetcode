/**
 * ClassName: copyRandomList
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/11 13:40
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class copyRandomList {
    /** 深拷贝
     *  有个random也需要拷贝，但是这个random可能在拷贝的时候还没有建立
     *  用两个hashmap维护
     *      1. done：    key是原节点，value是拷贝节点
     *      2. random：  key是random指向的原节点，value是 random指向key的node的list
     */
    /**
     * -ms
     * 100%
     */
    public Node copyRandomList(Node head) {
        Node sentinel = new Node(0);
        Node curNode = sentinel;
        Node origin = head;
        HashMap<Node, ArrayList<Node>> random = new HashMap<>();    // random指向的node   copy的node
        HashMap<Node,Node> done = new HashMap<>();  // 旧node  copy的node
        done.put(null,null);
        while(origin!=null){
            // 1 复制值
            Node copy = new Node(origin.val);
            // 2 新来的node是否在random里面
            if(random.containsKey(origin)){
                for (Node n: random.get(origin)) {
                    n.random = copy;
                }
            }

            // 3 已经存在的node对放入done
            done.put(origin,copy);

            // 4 判断random是否在done中存在（是否是之前的node）
            if(done.containsKey(origin.random)){    //已建立节点中有当前需要的random
                copy.random = done.get(origin.random);
            }
            else{ //已建立节点中没有当前需要的random（是之后的node）
                if(!random.containsKey(origin.random)){
                    random.put(origin.random,new ArrayList<Node>());
                }
                random.get(origin.random).add(copy);
            }
            // 5 放进复制链表
            curNode.next = copy;
            curNode = curNode.next;
            origin = origin.next;
        }
        return sentinel.next;
    }

    /** 题解 https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/solutions/476617/jian-zhi-offer-35-fu-za-lian-biao-de-fu-zhi-ha-xi-/
     *  1. 递归回溯，对next和random进行递归创建，用一个hashmap存储已存在的node防止多次复制
     *  2. 拼接+拆分：原链表每个node后插入一个相同的node，然后修改这个node的random指向，最后拆分开
     *  3. hashmap建立所有node的1对1映射，然后新链表直接创建。
     *
     */
}
