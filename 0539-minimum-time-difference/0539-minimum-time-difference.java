import java.time.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        Set<String> times = new HashSet<>(timePoints);
        
        int min = Integer.MAX_VALUE;
        int setSize = times.size();

        if(timePoints.size() != setSize) {
            return 0;
        }

        timePoints = new ArrayList<>(times);

        for(int i = 0 ; i < setSize ; i++) {
            for(int j = i + 1 ; j < setSize ; j++) {
                min = Math.min(timeDiff(timePoints.get(i), timePoints.get(j)), min);
            }
        }

        return min;
    }

    private int timeDiff(String x, String y) {

        LocalTime time1 = LocalTime.parse(x);
        LocalTime time2 = LocalTime.parse(y);

        int diff = Math.abs((int) Duration.between(time1, time2).toMinutes());

        return Math.min(diff, 1440 - diff);
    }
}