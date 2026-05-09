class Solution {
    public int longestSubstring(String s, int k) {
        if (k > s.length()) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int len = chars.length;
        int targetLen = len;
        int left = 0;
        int right = len - 1;
        int[] freqs = new int[26];

        for (int i = 0; i < len; i++) {
            freqs[chars[i] - 'a']++;
        }

        if (isFulfilled(freqs, k)) {
            return targetLen;
        }

        while (targetLen >= k) {
            targetLen--;
            left = len - targetLen;
            right = len - 1;
            int[] currArr = Arrays.copyOf(freqs, freqs.length);
            
            for (int i = 0; i < left; i++) {
                currArr[chars[i] - 'a']--;
            }
            //System.out.println("L: " + left + ", R: " + right);
            if (isFulfilled(currArr, k)) {
                return targetLen;
            }

            while (left > 0) {
                left--; right--;
                //System.out.println("L: " + left + ", R: " + right);
                currArr[chars[left] - 'a']++;
                if (right + 1 < len) {
                    currArr[chars[right + 1] - 'a']--;
                }
                if (isFulfilled(currArr, k)) {
                    return targetLen;
                }
            }
        }

        return 0;
    }

    private boolean isFulfilled(int[] freqs, int k) {
        for (int i = 0 ; i < 26; i++) {
            if (freqs[i] < k && freqs[i] != 0) {
                //System.out.println("" + (char)(i + 'a') + ": " + freqs[i]);
                return false;
            }
        }

        return true;
    }
}