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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, prevNode = null, nextNode = null;
        while(temp != null){
            ListNode kNode = getKthNode(temp,k);
            if(kNode == null){
                if(prevNode != null) {
                    prevNode.next = temp; 
                }
                break;
            } 
            nextNode = kNode.next;
            kNode.next = null;
            ListNode revNode = reverseList(temp);
            if(head == temp){
                head = kNode;
            }
            else prevNode.next = kNode;
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
    public ListNode reverseList(ListNode head) {
        ListNode temp = head, prev = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    private ListNode getKthNode(ListNode head, int k){
        int count = 1 ;
        ListNode temp = head;
        while(temp != null){
            if(count == k) break;
            count++;
            temp = temp.next;
        }
        return temp;
    }
}