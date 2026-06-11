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
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        traverse(root, list);

        int last = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= last) return false;
            last = list.get(i);
        }

        return true;
    }

    private void traverse(TreeNode node, List<Integer> output) {

        if (node == null) return;

        traverse(node.left, output);
        output.add(node.val);
        traverse(node.right, output);
    }
}