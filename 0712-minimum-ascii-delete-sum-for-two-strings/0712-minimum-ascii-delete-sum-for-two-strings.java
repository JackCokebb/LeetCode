class Solution {
    public int minimumDeleteSum(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1 ; i < n + 1 ; i++) {
            for (int j = 1 ; j < m + 1 ; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int total = 0;
        for (char c : s1.toCharArray()) total += c;
        for (char c : s2.toCharArray()) total += c;

        return total - dp[n][m] * 2;

    }
}