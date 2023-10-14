package TopInterviewQuestions;

/*class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}*/

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return new ListNode();
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = mergeTwoLists(res, lists[i]);
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public void print(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4, null);
        l1.next.next = new ListNode(5, null);
        ListNode l2 = new ListNode(1, null);
        l2.next = new ListNode(3, null);
        l2.next.next = new ListNode(4, null);
        ListNode l3 = new ListNode(2, null);
        l3.next = new ListNode(6, null);
        l3.next.next = new ListNode(7, null);
        MergeKSortedLists m = new MergeKSortedLists();
        ListNode[] lists = new ListNode[0];
       /* lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;*/
        //lists[0] = new ListNode();
        ListNode res = m.mergeKLists(lists);
        m.print(res);
    }
}
