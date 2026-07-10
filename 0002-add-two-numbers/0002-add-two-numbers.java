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
        ListNode dummyNode = new ListNode(-1);
        ListNode t1 = l1, t2 = l2, curr = dummyNode;
        int carry = 0;
        while(t1 != null || t2 != null){
            // int sum = t1.val + t2.val;
            int sum = 0;
            if(t1 != null) {
                sum += t1.val;
                t1 = t1.next;
            } 
            if(t2 != null){
                sum += t2.val;
                t2 = t2.next;
            } 
            sum += carry;
            int remainder = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(remainder);
            curr.next = newNode;
            curr = curr.next;
            
        }
        if (carry != 0){
            ListNode last = new ListNode(carry);
            curr.next = last;
        } 
        return dummyNode.next;
    }
}