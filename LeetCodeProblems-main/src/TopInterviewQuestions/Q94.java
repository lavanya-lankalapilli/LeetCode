import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q94 {

    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalUtil(root, res);
        return res;
    }

    void inorderTraversalUtil(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorderTraversalUtil(node.left, res);
        res.add(node.val);
        inorderTraversalUtil(node.right, res);
    }*/

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    public static void main(String[] args) {

    }


}
