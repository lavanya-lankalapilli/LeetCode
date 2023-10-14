package TopInterviewQuestions;

class ListNode {
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

    void add(int val) {
        ListNode temp = this;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new ListNode(val);
    }
}

public class Sum2LL {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode result = node;
        int sum = 0, carry = 0;
        int x = 0, y = 0;
        while (l1 != null || l2 != null) {
            x = (l1 == null) ? 0 : l1.val;
            y = (l2 == null) ? 0 : l2.val;
            sum = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            node.next = new ListNode(sum, null);
            node = node.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if(carry==1)
            node.next = new ListNode(1);
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4, null);
        l1.next.next = new ListNode(3, null);
        ListNode l2 = new ListNode(5, null);
        l2.next = new ListNode(6, null);
        l2.next.next = new ListNode(4, null);
        Sum2LL s = new Sum2LL();
        ListNode sum = s.addTwoNumbers(l1, l2);
        while (sum != null) {
            System.out.println(sum.val);
            sum = sum.next;
        }
    }
}
