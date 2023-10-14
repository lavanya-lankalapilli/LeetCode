package TopInterviewQuestions;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class TreeHeight {
    public int maxDepth(TreeNode root) {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        return (Math.max(height(node.left), height(node.right))) + 1;
    }
}

















