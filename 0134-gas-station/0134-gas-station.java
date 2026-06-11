class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalRemain = 0;

        for (int i = 0; i < n; i++) {
            totalRemain += gas[i];
            totalRemain -= cost[i];
        }

        if (totalRemain < 0) {
            return -1;
        }

        int tank = 0;
        int starting = 0;

        for (int i = 0; i < n; i++) {
            tank += gas[i];
            tank -= cost[i];

            if (tank < 0) {
                starting = i + 1;
                tank = 0;
            }
        }

        return starting;
    }
}