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
class Solution {
    public ListNode insertionSortList(ListNode head) {

        if(head.next == null) {
            
            return head;
        }

        ListNode currNode = head.next;

        ListNode newHead = new ListNode(head.val);
        ListNode diffNode = newHead;
        ListNode beforeDiffNode = null;

        while(currNode != null) {

            if(diffNode == null) {
                beforeDiffNode.next = new ListNode(currNode.val, beforeDiffNode.next);
                diffNode = newHead;
                beforeDiffNode = null;
                currNode = currNode.next;
                continue;
            }

            if(diffNode.val < currNode.val) {
                beforeDiffNode = diffNode;
                diffNode = diffNode.next;
                continue;
            }

            if(beforeDiffNode == null) {
                newHead = new ListNode(currNode.val, newHead);
            } else {
                beforeDiffNode.next = new ListNode(currNode.val, beforeDiffNode.next);
            }
            
            diffNode = newHead;
            beforeDiffNode = null;
            currNode = currNode.next;
        }

        return newHead;
    }
}