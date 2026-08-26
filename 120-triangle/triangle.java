class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[][] dp = new int[n][n];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {

            for (int j = 0; j <= i; j++) {

                if (j == 0) {
                    // Left edge
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }
                else if (j == i) {
                    // Right edge
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }
                else {
                    // Middle
                    dp[i][j] = Math.min(dp[i - 1][j - 1],
                                        dp[i - 1][j])
                              + triangle.get(i).get(j);
                }
            }
        }

        int answer = dp[n - 1][0];

        for (int j = 1; j < n; j++) {
            answer = Math.min(answer, dp[n - 1][j]);
        }

        return answer;
    }
}