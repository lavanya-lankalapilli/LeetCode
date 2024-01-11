public class Q1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderUtil(preorder, 0, preorder.length - 1);
    }

    private TreeNode bstFromPreorderUtil(int[] preorder, int left, int right) {
        if(left>right){
            return null;
        }
        TreeNode node = new TreeNode(preorder[left]);
        int delimit = left;
        while (delimit<=right){
            if(preorder[left] < preorder[delimit]){
                break;
            } else {
                delimit++;
            }
        }
        node.left = bstFromPreorderUtil(preorder, left+1, delimit-1);
        node.right = bstFromPreorderUtil(preorder, delimit, right);
        return node;
    }

    public static void main(String[] args) {
        int pre[] = {8,5,1,7,10,12};
        TreeNode node = new Q1008().bstFromPreorder(pre);
    }


}
