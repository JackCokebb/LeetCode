class Solution {
    public int numTilePossibilities(String tiles) {
        int[] chars = new int[26];

        for (char c : tiles.toCharArray()) {
            chars[c - 'A']++;
        }

        return countAndBackTracking(chars);
    }

    private int countAndBackTracking(int[] chars) {

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (chars[i] <= 0) continue;

            chars[i]--;
            count++;

            count += countAndBackTracking(chars);

            chars[i]++;
        }

        return count;
    }
}