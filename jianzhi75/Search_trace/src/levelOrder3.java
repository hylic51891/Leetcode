import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: levelOrder3
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/15 18:40
 * @Version 1.0
 */
public class levelOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root== null) return ret;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            LinkedList<Integer> curLevel = new LinkedList<>();
            for(int i = queue.size();i>0;i--){
                TreeNode curNode = queue.poll();
                if(ret.size() % 2 == 0) curLevel.addLast(curNode.val); // 偶数层 -> 队列头部
                else curLevel.addFirst(curNode.val); // 奇数层 -> 队列尾部

                if(curNode.left!=null) queue.add(curNode.left);
                if(curNode.right!=null) queue.add(curNode.right);
            }
            ret.add(curLevel);
        }

        return ret;
    }
}
