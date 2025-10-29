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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode head = new ListNode();
        ListNode currNode = head;
        int curr1Val = 0;
        int curr2Val = 0;
        int sum = 0;
        int leftOver = 0;

        while(curr1 != null || curr2 != null) {

            curr1Val = curr1 == null ? 0 : curr1.val;
            curr2Val = curr2 == null ? 0 : curr2.val;

            sum = curr1Val + curr2Val;
            sum += leftOver;
            currNode.next = new ListNode(sum % 10);
            leftOver = sum / 10;
            
            currNode = currNode.next;
            curr1 = curr1 == null ? curr1 : curr1.next;
            curr2 = curr2 == null ? curr2 : curr2.next;
        }

        while(leftOver != 0) {
            
            currNode.next = new ListNode(leftOver % 10);
            leftOver = leftOver / 10;
        }

        return head.next;
    }
}