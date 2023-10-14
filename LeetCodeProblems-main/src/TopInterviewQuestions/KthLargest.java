package TopInterviewQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i : nums) {
            q.add(i);
            if(q.size()>k)
                q.poll();
        }
        return q.peek();
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, 1, 5, 6, 4}, k = 2;
        System.out.println(new KthLargest().findKthLargest(nums, k));
    }
}
