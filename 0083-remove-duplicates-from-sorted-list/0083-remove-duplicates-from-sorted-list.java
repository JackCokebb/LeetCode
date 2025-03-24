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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        boolean[] visited = new boolean[201];

        ListNode currNode = head;
        ListNode prevNode = head;

        visited[currNode.val + 100] = true;

        currNode = head.next;
        while (currNode != null) {
            if (visited[currNode.val + 100]) {
                prevNode.next = currNode.next;
                currNode = currNode.next;
            } else {
                visited[currNode.val + 100] = true;
                
                prevNode = currNode;
                currNode = currNode.next;
            }
        }

        return head;
    }
}