/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, Integer> map;
    int preIndex=0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildTreeUtil(0, inorder.length-1, inorder, preorder);
    }

      private TreeNode buildTreeUtil(int start, int end, int[] inorder, int[] preorder) {
        if(start>end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int inorderIndex = map.get(preorder[preIndex++]);
        root.left = buildTreeUtil(start, inorderIndex-1, inorder, preorder);
        root.right = buildTreeUtil(inorderIndex+1, end, inorder, preorder);
        return root;
    }
}
