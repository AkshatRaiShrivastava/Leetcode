/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        int nextVal = node.next.val;
        node.val = nextVal;
        ListNode nextNode = node.next;
        node.next = node.next.next;
        nextNode.next = null;
    }
}