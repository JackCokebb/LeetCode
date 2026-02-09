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

        if(head == null) return true;
        if(root == null) return false;

        return dps(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean dps(ListNode refNode, TreeNode currNode) {

        if (refNode == null) {
            return true;
        }

        if (currNode == null) {
            return false;
        }

        if (refNode.val != currNode.val) {
            return false;
        } 

        return dps(refNode.next, currNode.left) || dps(refNode.next, currNode.right);
    }
}