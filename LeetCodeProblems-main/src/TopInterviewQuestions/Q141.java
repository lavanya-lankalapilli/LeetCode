class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fptr = head.next.next, sptr = head.next;
        while (fptr != null && fptr.next != null) {
            if (fptr == sptr) {
                return true;
            }
            sptr = sptr.next;
            fptr = fptr.next.next;
        }
        return false;
    }
}
