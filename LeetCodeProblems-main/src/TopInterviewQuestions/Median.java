package TopInterviewQuestions;

public class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length, t = l1 + l2;
        double m1 = 0, m2 = 0;
        int i = 0, j = 0, k = 0;
        while (k < t / 2 && (i < l1 || j < l2)) {
            if (i < l1 && j < l2) {
                m1 = Math.min(nums1[i], nums2[j]);
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
                k++;
            } else if (i < l1) {
                m1 = nums1[i];
                i++;
                k++;
            } else {
                m1 = nums2[j];
                j++;
                k++;

            }
        }
        if (i < l1 && j < l2) {
            m2 = Math.min(nums1[i], nums2[j]);
        } else if (i < l1) {
            m2 = nums1[i];
        } else {
            m2 = nums2[j];
        }
        if (t % 2 == 0) {
            return (m1 + m2) / 2;
        } else {
            return m2;
        }
    }

    public static void main(String[] args) {
        Median median = new Median();
        int[] a = {}, b = {2, 3};
        System.out.println(median.findMedianSortedArrays(a, b));
    }

}
