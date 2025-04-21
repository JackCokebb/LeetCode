class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int nn = costs.length;
        int result = 0;
        int[] refund = new int[nn];
        

        for (int i = 0 ; i < nn ; i++) {
            refund[i] = costs[i][0] - costs[i][1];
            result += costs[i][0];
        }

        Arrays.sort(refund);

        for (int i = nn - 1 ; i >= nn / 2 ; i--) {
            result -= refund[i];
        }

        return result;
    }
}