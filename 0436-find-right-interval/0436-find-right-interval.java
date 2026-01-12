class Solution {
    public int[] findRightInterval(int[][] intervals) {

        int len = intervals.length;

        int[] result = new int[len];
        Arrays.fill(result, -1);

        for (int i = 0 ;  i < len ; i++) {
            int iEnd = intervals[i][1];
            for (int j = 0 ;  j < len ; j++) {
                if (intervals[j][0] >= iEnd) {
                    if (result[i] == -1) {
                        result[i] = j;
                    } else {
                        if (intervals[result[i]][0] > intervals[j][0]) {
                            result[i] = j;
                        }
                    }
                }
            }
        }

        return result;
    }
}