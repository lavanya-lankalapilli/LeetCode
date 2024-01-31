import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution {

    /*public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            List<Integer> level = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode cur = q.poll();
                if (cur == null) {
                    res.add(level);
                    level = new ArrayList<>();
                    if (!q.isEmpty()) {
                        q.add(null);
                    }
                } else {
                    level.add(cur.val);
                    if (cur.left != null) {
                        q.add(cur.left);
                    }
                    if (cur.right != null) {
                        q.add(cur.right);
                    }
                }
            }
        }
        return res;
    }*/

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderUtil(root, 0 , res);
        return res;
    }

    void levelOrderUtil(TreeNode node, int level, List<List<Integer>> res) {
        if(node == null){
            return;
        }
        if(res.size() == level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        levelOrderUtil(node.left, level + 1, res);
        levelOrderUtil(node.right, level + 1, res);
    }

    public static void main(String[] args) {

    }


}
