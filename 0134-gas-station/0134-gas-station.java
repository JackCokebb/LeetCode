class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length; 
        int totalGas = 0;
        int totalCost = 0;

        for (int i = 0 ; i < len ; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        int gasRemain = 0;
        int startIdx = 0;

        for (int i = 0 ; i < len ; i++) {
            gasRemain += gas[i];
            gasRemain -= cost[i];
            
            if(gasRemain < 0) {
                gasRemain = 0;
                startIdx = i + 1;
            }
            
        }

        return startIdx;
    }
}