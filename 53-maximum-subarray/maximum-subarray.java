class Solution {
    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    private int divide(int[] nums, int left, int right) {

        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        int leftSum = divide(nums, left, mid);
        int rightSum = divide(nums, mid + 1, right);

        int leftMax = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }

        int rightMax = Integer.MIN_VALUE;
        sum = 0;

        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }

        int crossSum = leftMax + rightMax;

        return Math.max(
            Math.max(leftSum, rightSum),
            crossSum
        );
    }
}