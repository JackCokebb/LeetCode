class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
        int[] minCoins = new int[amount + 1];

        Arrays.fill(minCoins, amount + 1);
        minCoins[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coins[j] >= 0) {
                    minCoins[i] = Math.min(minCoins[i], minCoins[i - coins[j]] + 1);
                }
            }
        }

        return minCoins[amount] == amount + 1 ? -1 : minCoins[amount];
    }
}