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
            
            if(currNode.left != null && !isNull){
                queue.add(currNode.left);
            }
            else if(currNode.left != null && isNull){
                return false;
            }
            else if(currNode.left == null){
                isNull = true;
            }
            
            if(currNode.right != null && !isNull){
                queue.add(currNode.right);
            }
            else if(currNode.right != null && isNull){
                return false;
            }
            else if(currNode.right == null){
                isNull = true;
            }
        }
        return true;
    }
}

/*
queue - add() vs offer()
- add : null 값을 add 하려고 시도하면 예외 뜸
- offer : null 값을 offer하려고 하면 queue에 null이 들어가며 false를 리턴함

Queue는 null을 offer할 수 있음
Deque는 offer 써도 예외 뜸
==============================

queue - add() vs offer()
- add : add() returns a nullPoint exception when we try to add null into the queue
- offer : offer returns a false (bool) when we try to offer(add something into queue) null into the queue


Queue can have null by offering null into the queue
Deque cannot have null even by offering null into the queue
*/