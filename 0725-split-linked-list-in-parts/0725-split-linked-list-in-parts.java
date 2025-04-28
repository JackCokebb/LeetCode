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
    public ListNode[] splitListToParts(ListNode head, int k) {
        if(head == null) return new ListNode[k];

        int count = 0;
        ListNode curr = head;

        while(curr != null) {
            count++; 
            curr = curr.next;
        }
    
        int sectionCount = count / k;
        int remainder = count % k;
        
        ListNode[] result = new ListNode[k];

        curr = head;
        
        int currIdx = 0;
        result[currIdx] = curr;

        if(count < k) {
            for(int i = 0 ; i < count ; i++) {
                ListNode temp = curr.next;
                curr.next = null;
                curr = temp;
                currIdx++;

                if(currIdx < result.length) {
                    result[currIdx] = curr;
                }
            }
            return result;
        }
        

        for(int i = 0 ; i < count ; i++) {
            if(curr == null) break;

            if((i + 1) % sectionCount == 0 && remainder > 0) {
                
                curr = curr.next;
                ListNode temp = curr.next;
                curr.next = null;
                curr = temp;
                remainder--;
                currIdx++;

                if(currIdx < result.length) {
                    result[currIdx] = curr;
                }

            } else if((i + 1) % sectionCount == 0 && remainder <= 0) {
                
                ListNode temp = curr.next;
                curr.next = null;
                curr = temp;
                currIdx++;

                if(currIdx < result.length) {
                    result[currIdx] = curr;
                }

            } else {
                curr = curr.next;
                
            }
        }

        return result;
    }
}