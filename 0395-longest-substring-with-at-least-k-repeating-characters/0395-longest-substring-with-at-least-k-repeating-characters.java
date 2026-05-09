class Solution {
    public int longestSubstring(String s, int k) {
        if (k < 2) return s.length();
        
        return divideAndConquer(s, 0, s.length(), k);
    }

    private int divideAndConquer(String s, int start, int end, int k) {
        if (start >= end) return 0;
        int[] freq = new int[26];
        boolean valid = true;

        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = start; i < end; i++) {
            if (freq[s.charAt(i) - 'a'] < k && freq[s.charAt(i) - 'a'] > 0) {
                valid = false;
            }
        }
        if (valid) return end - start;

        int result = 0;
        int currStart = start;

        for (int i = start; i < end; i++) {
            if (freq[s.charAt(i) - 'a'] < k && freq[s.charAt(i) - 'a'] > 0) {
                result = Math.max(divideAndConquer(s, currStart, i, k), result);
                currStart = i + 1;
            }
        }

        result = Math.max(divideAndConquer(s, currStart, end, k), result);

        return result;
    }
}