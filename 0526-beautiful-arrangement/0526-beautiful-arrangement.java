class Solution {

    int result = 0;

    public int countArrangement(int n) {

        if (n == 0)
            return 0;
        int[] perm = new int[n + 1];
        boolean[] used = new boolean[n + 1];

        recursive(n, 1, perm, used);

        return result;
    }

    private void recursive(int n, int idx, int[] perm, boolean[] used) {

        if (idx > n) {
            result++;
            return;
        }

        for (int j = 1; j <= n; j++) {
            
            if (!used[j] && (idx % j == 0 || j % idx == 0)) {
                perm[idx] = j;
                used[j] = true;

                recursive(n, idx + 1, perm, used);

                perm[idx] = 0;
                used[j] = false;
            }
        }
    }
}