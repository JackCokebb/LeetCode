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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traversal(root, result, 0);

        return result;
    }

    public void traversal(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null) return;

        if (list.size() - 1 < level) {
            list.add(new ArrayList<>());
        }

        list.get(level).add(node.val);

        traversal(node.left, list, level + 1);
        traversal(node.right, list, level + 1);
    }
}