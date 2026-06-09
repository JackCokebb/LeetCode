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
    int max = 0;
    public int maxAncestorDiff(TreeNode root) {

        goDeep(root, root.val, root.val);
        return max;
    }
    
    private void goDeep(TreeNode node, int currMax, int currMin) {
        
        if (node == null) {
            return;
        }

        currMax = Math.max(currMax, node.val);
        currMin = Math.min(currMin, node.val);

        max = Math.max(max, Math.abs(currMax - currMin));

        goDeep(node.left, currMax, currMin);
        goDeep(node.right, currMax, currMin);
    }
}