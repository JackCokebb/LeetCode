class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        
        int[] a = new int[n + 1];
        a[0] = 1; a[1] = 2; a[2] = 2;
        int currIdx = 2, appendingIdx = 3, num = 1, count = 1;
        
        while (appendingIdx < n) {
            for (int i = 0; i < a[currIdx]; i++) {
                a[appendingIdx] = num;
                if (num == 1 && appendingIdx < n) count++;
                appendingIdx++;
            }
            num = num ^ 3;
            currIdx++;
        }
        
        return count;
    }
}