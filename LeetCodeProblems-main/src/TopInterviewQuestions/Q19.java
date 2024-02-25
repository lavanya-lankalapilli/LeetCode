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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fptr = head, sptr = dummy;
        while (n-- > 0){
            fptr = fptr.next;
        }
        while (fptr!=null){
            fptr = fptr.next;
            sptr = sptr.next;
        }
        sptr.next = sptr.next.next;
        return dummy.next;
    }
}
