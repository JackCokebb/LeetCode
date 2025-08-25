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

    Deque<TreeNode> queue = new ArrayDeque<>();

    public void flatten(TreeNode root) {
        traverseNode(root);

        TreeNode currNode = root;
        if(!queue.isEmpty()){
            queue.removeFirst();
        }

        while(!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            currNode.left = null;
            currNode.right = node;
            currNode = currNode.right;
        }
    }

    private void traverseNode(TreeNode root) {

        if(root == null) return;

        this.queue.addLast(root);
        traverseNode(root.left);
        traverseNode(root.right);
    }
}