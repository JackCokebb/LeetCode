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
class BSTIterator {

    Deque<TreeNode> queue;

    public BSTIterator(TreeNode root) {
        this.queue = new ArrayDeque<>();
        traverseNode(root);
    }
    
    public int next() {
        
        return this.queue.pollFirst().val;
    }
    
    public boolean hasNext() {
        
        return this.queue != null && !this.queue.isEmpty();
    }

    private void traverseNode(TreeNode root) {
        
        if(root == null) {
            return;
        }
        
        traverseNode(root.left);
        this.queue.addLast(root);
        traverseNode(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */