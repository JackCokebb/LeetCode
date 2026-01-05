class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int result = 0;
        int prevEnd = intervals[0][1];

        for (int i =  1 ; i < intervals.length ; i++) {
            if (intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
            } else {
                result++;
            }
        }

        return result;
    }
}