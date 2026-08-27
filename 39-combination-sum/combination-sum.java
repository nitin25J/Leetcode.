class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, target, candidates, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int index, int target, int[] candidates,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // Target reached
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Target exceeded
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Choose
            current.add(candidates[i]);

            // Same i because we can reuse the number
            backtrack(i, target - candidates[i],
                      candidates, current, ans);

            // Undo choice
            current.remove(current.size() - 1);
        }
    }
}