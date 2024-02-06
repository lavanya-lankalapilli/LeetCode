

public class Q160 {

    /*

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (headA != null) {
            s1.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            s2.push(headB);
            headB = headB.next;
        }
        ListNode res = null;
        while (!s1.isEmpty() && !s2.isEmpty()){
            ListNode temp1 = s1.pop();
            ListNode temp2 = s2.pop();
            if(temp2 != temp1){
                return res;
            }
            res = temp1;
        }
        return res;
    }
     */

    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }*/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(0);
        n1.next = new ListNode(1);
        n1.next.next = new ListNode(2);

        ListNode n2 = new ListNode(3);
        n2.next = new ListNode(4);
        n2.next.next = new ListNode(5);
        n2.next.next.next = new ListNode(6);

        System.out.println(new Q160().getIntersectionNode(n1,n2));

    }
}
