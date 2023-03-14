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
    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        
        digIn(root, "");
        return sum;
    }
    
    private void digIn(TreeNode currNode, String currStr){
        if(currNode.left == null && currNode.right == null){
            sum += Integer.parseInt(currStr + currNode.val);
            return;
        }
        if(currNode.left != null){
            digIn(currNode.left, currStr + currNode.val);
        }
        if(currNode.right != null){
            digIn(currNode.right, currStr + currNode.val);
        }
        
        return;
    }
}