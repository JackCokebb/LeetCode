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
    public boolean isCompleteTree(TreeNode root) {
        return bfs(root);
    }
    private boolean bfs(TreeNode root){
        Deque<TreeNode> queue = new ArrayDeque<>();
        boolean isNull = false;
        
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currNode = queue.poll();
            if(isNull && (currNode.left != null || currNode.right != null)){
                return false;
            }
            
            if(currNode.left != null){
                queue.add(currNode.left);
            }
            else{
                isNull = true;
            }
            
            if(currNode.right != null && !isNull){
                queue.add(currNode.right);
            }
            else if(currNode.right != null && isNull){
                return false;
            }
            else{
                isNull = true;
            }
        }
        return true;
    }
}