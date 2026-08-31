class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, ans);
        return ans;
    }

    void solve(int[] nums, int index, List<List<Integer>> ans) {

        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int x : nums)
                temp.add(x);

            ans.add(temp);
            return;
        }

        for (int i = index; i < nums.length; i++) {

           
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;

            solve(nums, index + 1, ans);

           
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }
}