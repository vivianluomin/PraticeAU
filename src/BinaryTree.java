import java.util.ArrayList;

public class BinaryTree {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        postorderTrabersal(root,list);

        return list;
    }

    public void postorderTrabersal(TreeNode node,ArrayList<Integer> list){
        if(node == null){
            return;
        }
        postorderTrabersal(node.left,list);
        postorderTrabersal(node.right,list);
        list.add(node.val);
    }


    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        miSort(root,list);

        return list;
    }

    public void miSort(TreeNode node, ArrayList<Integer> list){
        if(node == null){
            return;
        }
        miSort(node.left,list);
        list.add(node.val);
        miSort(node.right,list);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}


