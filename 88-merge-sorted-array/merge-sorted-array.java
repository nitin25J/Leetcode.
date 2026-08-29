class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;          // last element of nums1
        int j = n - 1;          // last element of nums2

        for (int k = m + n - 1; k >= 0; k--) {

            if (j < 0) {
                break;
            }

            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            
        } }
    }
}