/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            
            if (currNode.val == head.val) {
                if (dps(head, head, currNode)) {
                    return true;
                }
            }

            if (currNode.left != null) {
                stack.add(currNode.left);
            }

            if (currNode.right != null) {
                stack.add(currNode.right);
            }
        }
        
        return false;
    }

    public boolean dps(ListNode head, ListNode refNode, TreeNode currNode) {

        if (refNode == null) {
            return true;
        }

        if (currNode == null) {
            return false;
        }

        if (refNode.val == currNode.val) {
            boolean leftResult = dps(head, refNode.next, currNode.left);
            boolean rightResult = dps(head, refNode.next, currNode.right);

            return leftResult || rightResult;
        } else {
            return false;
        }
    }
}