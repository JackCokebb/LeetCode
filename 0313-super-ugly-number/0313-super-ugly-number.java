class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;

        long[] dp = new long[n];
        dp[0] = 1;

        int[] idx = new int[len];
        long[] cand = new long[len];

        for (int i = 0 ; i < len ; i++) {
            cand[i] = primes[i];
        }

        for (int i = 1 ; i < n ; i++) {
            long next = cand[0];
            for (int j = 1 ; j < len ; j++) {
                if (next > cand[j]) {
                    next = cand[j];
                }
            }

            dp[i] = next;

            for (int j = 0 ; j < len ; j++) {
                if (next == cand[j]) {
                    idx[j]++;
                    cand[j] = dp[idx[j]] * primes[j];
                }
            }
        }

        return (int )dp[n - 1];
    }
}