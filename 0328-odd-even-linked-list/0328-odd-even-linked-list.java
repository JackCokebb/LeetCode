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
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            
            return head;
        }

        ListNode oddHead = new ListNode(head.val);
        ListNode currOdd = oddHead;
        head = head.next;
        ListNode evenHead = new ListNode(head.val);
        head = head.next;
        ListNode currEven = evenHead;
        boolean isOdd = true;

        while (head != null) {
            if (isOdd) {
                currOdd.next = head;
                head = head.next;
                currOdd = currOdd.next;
                isOdd= false;
            } else {
                currEven.next = head;
                head = head.next;
                currEven = currEven.next;
                isOdd= true;
            }
            
        }

        currEven.next = null;
        currOdd.next = evenHead;
        

        return oddHead;
    }
}