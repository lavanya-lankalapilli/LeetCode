package Excel;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Temp {

    /*public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while (temp!=null){
            st.push(temp.val);
            temp = temp.next;
        }
        while (head!=null){
            if(head.val != st.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }*/

    ListNode forwardNode;

    public boolean isPalindrome(ListNode head) {
        forwardNode = head;
        return isPalindromeUtil(head);
    }

    public boolean isPalindromeUtil(ListNode head) {
        if (head != null) {
            if (!isPalindromeUtil(head.next) || head.val != forwardNode.val) {
                return false;
            }
            forwardNode = forwardNode.next;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.add(2);
        node.add(3);
        node.add(3);
        node.add(2);
        node.add(1);
        System.out.println(new Temp().isPalindrome(node));
    }
}
