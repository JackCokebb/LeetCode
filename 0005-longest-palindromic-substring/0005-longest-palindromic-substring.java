class Solution {
    public String longestPalindrome(String s) {

        String maxStr = "";
        char[] sWithAsterisk = String.join("*", s.split("")).toCharArray();

        for (int pivot = 0 ; pivot < sWithAsterisk.length ; pivot++) {
            int x = pivot - 1;
            int y = pivot + 1;

            while (x >= 0 && y < sWithAsterisk.length) {
                if (sWithAsterisk[x] == sWithAsterisk[y]) {
                    x--;
                    y++;
                } else {
                    
                    break;
                }
            }

            String newStr = new String(sWithAsterisk, x + 1, (y - 1) - (x + 1) + 1).replace("*", "");
                    
            if (maxStr.length() < newStr.length()) {
                maxStr = newStr;
            }
        }

        return maxStr;
    }
}