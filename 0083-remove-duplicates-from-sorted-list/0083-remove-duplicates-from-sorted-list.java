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

    HashMap<Integer, Boolean> visited;

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        
        visited = new HashMap<>();

        ListNode currNode = head;
        ListNode prevNode = head;

        visited.put(currNode.val, true);

        currNode = head.next;
        while (currNode != null) {
            if (visited.get(currNode.val) != null) {
                prevNode.next = currNode.next;
                currNode = currNode.next;
            } else {
                visited.put(currNode.val, true);
                
                prevNode = currNode;
                currNode = currNode.next;
            }
        }

        return head;
    }
}