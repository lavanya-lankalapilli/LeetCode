package Excel;


import java.util.*;

public class Temp {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    if (!queue.isEmpty())
                        queue.add(null);
                } else {
                    if (cur.left != null) {
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                    if (queue.peek() == null) {
                        result.add(cur.val);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(new Temp().rightSideView(root));
    }
}
