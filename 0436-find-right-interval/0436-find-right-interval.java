class Solution {
    public int[] findRightInterval(int[][] intervals) {

        int len = intervals.length;

        int[] result = new int[len];
        Arrays.fill(result, -1);

        int[][] sorted = new int[len][2];

        for (int i = 0 ; i < len ; i++) {
            sorted[i] = new int[]{intervals[i][0], i};
        }

        Arrays.sort(sorted, (a, b) -> a[0] - b[0]);

        for (int i = 0 ; i < len ; i++) {
            int left = 0;
            int right = len - 1;
            int mid = (left + right + 1) / 2;

            int iEnd = intervals[i][1];

            while(left <= right) {
                //System.out.println("i: " + i + ", iEnd: " + iEnd + ", left: " + left + ", right: " + right + ", mid: " + mid);
                if (iEnd > sorted[mid][0]) {
                    left = mid + 1;
                    mid = (left + right + 1) / 2;
                } else if (iEnd < sorted[mid][0]) {
                    result[i] = sorted[mid][1];
                    right = mid - 1;
                    mid = (left + right + 1) / 2;
                } else {
                    result[i] = sorted[mid][1];
                    break;
                }
            }
        }

        return result;
    }
}