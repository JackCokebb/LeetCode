class Solution {
    Map<Integer, String> map;
    public String convert(String s, int numRows) {

        map = new HashMap<>();

        int currIdx = 1;
        boolean isAsc = true;
        for(int i = 0 ; i < s.length() ; i++) {

            map.put(currIdx, map.getOrDefault(currIdx, "") + s.charAt(i));

            if(currIdx == 1) {
                isAsc = true;
            } else if (currIdx == numRows) {
                isAsc = false;
            }

            if(isAsc) {
                currIdx = currIdx + 1 > numRows ? numRows : currIdx + 1;
            } else {
                currIdx = currIdx - 1 < 1 ? 1 : currIdx - 1;
            } 
        }

        String result = "";

        for(int i = 1 ; i <= numRows ; i++) {
            result = result + map.getOrDefault(i, "");
        }

        return result;
    }
}