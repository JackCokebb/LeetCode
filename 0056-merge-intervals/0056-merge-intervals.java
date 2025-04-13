class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] checked = new int[10002];
        List<int[]> result = new ArrayList<>();
        
        for(int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int count = 1;

            for(int i = start ; i <= end ; i++) {
                if(checked[i] != 0) {
                    count = checked[i] + 1;
                } else {
                    //System.out.println("Set: " + i + " as, " + count);
                    checked[i] = count; 
                    count++;
                }                
            }
        }

        // for(int i : checked) {
        //     System.out.print("" + i + ", ");
        // }

        boolean started = false;
        int startingIdx = 0;
        for(int i = 0 ; i <= 10001 ; i++) {
            
            if(checked[i] == 1 && !started) {
                startingIdx = i;
                started = true;
                continue;
            }

            if(checked[i] == 1 && started) {
                result.add(new int[] {startingIdx, i - 1});
                startingIdx = i;
                started = true;
                continue;
            }

            if(checked[i] < 1 && started) {
                result.add(new int[] {startingIdx, i - 1});
                started = false;
            }
        }

        return result.toArray(new int[0][]);
    }
}