class Solution {
    public int longestStrChain(String[] words) {
        
        int wordsLen = words.length; 
        Map<Integer, List<String>> wordsMap = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();
        
        int maxLen = 1;

        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int initLen = words[0].length();
        for (String s : words) {

            List<String> currWords = wordsMap.getOrDefault(s.length(), new ArrayList<>());
            currWords.add(s);
            wordsMap.put(s.length(), currWords);
        }

        for (String currStr : words) {
    
            int currStrLen = currStr.length();
            List<String> shorterList = wordsMap.getOrDefault(currStrLen - 1, new ArrayList<>());

            for (String ss: shorterList) {
                if (isOneCharDiff(currStr, ss)) {
                    int currResult = resultMap.getOrDefault(currStr, 2);
                    int nextResult = resultMap.getOrDefault(ss, 1) + 1;
                    resultMap.put(currStr, Math.max(currResult, nextResult));
                }
            }
        }

        // for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
        //     System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        // }

        for (int val : resultMap.values()) {
            if (maxLen < val) {
                maxLen = val;
            }
        }

        return maxLen;
    }

    public static boolean isOneCharDiff(String longer, String shorter) {
        if (longer.length() - shorter.length() != 1) {
            return false;
        }

        int i = 0, j = 0;
        boolean skipped = false;

        while (i < longer.length() && j < shorter.length()) {
            if (longer.charAt(i) == shorter.charAt(j)) {
                i++;
                j++;
            } else {
                if (skipped) return false; 
                skipped = true;
                i++; 
            }
        }

        return true;
    }
}