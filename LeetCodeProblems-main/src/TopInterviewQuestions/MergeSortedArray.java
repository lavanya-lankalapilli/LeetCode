package TopInterviewQuestions;

public class MergeSortedArray {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int curIndex = 0;
        for (int i = 0; i < n; i++) {
            while (nums1[curIndex] <= nums2[i] && curIndex < m) {
                curIndex++;
            }
            nums1 = addAt(curIndex, nums1, nums2[i], m);
            m++;
        }
    }

    private int[] addAt(int curIndex, int[] nums1, int val, int m) {
        for (int i = m; i > curIndex; i--)
            nums1[i] = nums1[i - 1];
        nums1[curIndex] = val;
        return nums1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1, p1 = m - 1, p2 = n - 1;
        for (; p >= 0 & p2 >= 0; p--) {
            if(nums1[p1]>nums2[p2])
                nums1[p] = nums1[p1--];
            else
                nums1[p] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 0, 0, 0}, m = 3, nums2[] = {2, 5, 6}, n = 3;
        new MergeSortedArray().merge(nums1, m, nums2, n);
    }
}
