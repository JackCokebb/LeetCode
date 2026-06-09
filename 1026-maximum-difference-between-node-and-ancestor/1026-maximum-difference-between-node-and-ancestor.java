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
    public int maxAncestorDiff(TreeNode root) {

        return goDeep(root, new ArrayList<>());
    }
    
    private int goDeep(TreeNode node, ArrayList<Integer> list) {
        int absMax = 0;
        
        if (node == null) {
            int min = Integer.MAX_VALUE, max = 0;
            for (int a : list) {
                min = Math.min(a, min);
                max = Math.max(a, max);
            }
            return Math.abs(max - min);
        }

        list.add(node.val);
        absMax = Math.max(absMax, goDeep(node.left, list));
        absMax = Math.max(absMax, goDeep(node.right, list));
        list.remove(list.size() - 1);

        return absMax;
    }
}