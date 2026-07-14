/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        slow = slow.next;
        if (fast.next != null) fast = fast.next.next;
        while(fast != null){
            if(slow == fast) break;
            slow = slow.next;
            if (fast.next != null) fast = fast.next.next;
        }
        if(slow == null || fast == null) return null;
        fast = head;
        
        while(slow != fast){
            fast = fast.next;
            if(slow != null) slow = slow.next;
        }

        return slow;
    }
}