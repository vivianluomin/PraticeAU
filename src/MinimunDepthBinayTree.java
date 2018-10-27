public class MinimunDepthBinayTree {

    public int run(TreeNode root){

        if(root == null){
            return  0;
        }

        int left = run(root.left);
        int right = run(root.right);
        if(left == 0){
            return right+1;
        }
        if(right == 0){
            return left+1;
        }
        if(left<right){
            return left+1;
        }else {
            return right+1;
        }

    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
