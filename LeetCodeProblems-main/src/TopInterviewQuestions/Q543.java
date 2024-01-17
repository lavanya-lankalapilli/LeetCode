
public class Q543 {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxLength(root);
        return diameter;
    }

    public int maxLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxLength(node.left);
        int right = maxLength(node.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

   
}
