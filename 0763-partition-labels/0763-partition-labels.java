class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = -1; 
        int max = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0 ; i < s.length() ; i++) {
            map.put(s.charAt(i), i);
        }

        for (int i = 0 ; i < s.length() ; i++) {
            max = Math.max(max, map.get(s.charAt(i)));

            if (i == max) {
                result.add(max - left);
                left = max;
            }
        }
        
        return result;
    }
}