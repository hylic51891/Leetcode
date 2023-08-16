import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: levelOrder
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/15 16:48
 * @Version 1.0
 */
public class levelOrder {
    /** 一个数组
     * 从根节点开始，放在一个deque里面，FIFO，先放左边的。等队列空的时候结束遍历
     */
    public int[] levelOrder(TreeNode root) {
        if(root== null) return new int[0];
        Deque<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            ret.add(curNode.val);
            if(curNode.left!=null) queue.add(curNode.left);
            if(curNode.right!=null) queue.add(curNode.right);
        }

        int n = ret.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = ret.get(i);
        }
        return result;
    }
    /**
     * 两个数组
     */
    public int[] levelOrder2(TreeNode root) {
        List<TreeNode> curLevel = new ArrayList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        if(root== null) return new int[0];
        curLevel.add(root);
        while(true){
            List<TreeNode> nextLevel = new ArrayList<>();
            for(TreeNode curNode:curLevel){
                ret.add(curNode.val);
                if(curNode.left!=null) nextLevel.add(curNode.left);
                if(curNode.right!=null) nextLevel.add(curNode.right);
            }
            if(nextLevel.isEmpty()) break;
            curLevel = nextLevel;
        }
        int n = ret.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = ret.get(i);
        }
        return result;
    }
    /** 我最开始的写法：两个deque，其实不需要queue,直接遍历即可
     * 两个数组
     */
    public int[] levelOrder3(TreeNode root) {
        Deque<TreeNode> lastQueue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        if(root== null) return new int[0];
        lastQueue.offer(root);
        while(true){
            Deque<TreeNode> curQueue = new LinkedList<>();
            while(!lastQueue.isEmpty()){
                TreeNode curNode = lastQueue.poll();
                ret.add(curNode.val);
                if(curNode.left!=null) curQueue.add(curNode.left);
                if(curNode.right!=null) curQueue.add(curNode.right);
            }
            if(curQueue.isEmpty()) break;
            lastQueue = curQueue;
        }
        int n = ret.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = ret.get(i);
        }
        return result;
    }
}
