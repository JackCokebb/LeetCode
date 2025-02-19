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

    static ArrayList<Integer> result;

    public List<Integer> preorderTraversal(TreeNode root) {
        
        result = new ArrayList<>();
        preorder(root);

        return result;
    }

    private void preorder(TreeNode root) {
        
        if(root == null) {
            return;
        }
        
        result.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}