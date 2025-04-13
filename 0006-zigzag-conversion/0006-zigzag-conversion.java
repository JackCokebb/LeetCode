class Solution {
    public String convert(String s, int numRows) {
        if (s.length()<=numRows)return s;

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0;i<numRows;i++){
            sb[i] = new StringBuilder();
        }

        for (int i =0;i<s.length();){

            //Going down
            for (int j=0;j<numRows && i<s.length();j++){
                sb[j].append(s.charAt(i));
                i++;
            }

            //Going up
            for (int j=numRows-2;j>=1 && i<s.length();j--){
                sb[j].append(s.charAt(i));
                i++;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(StringBuilder temp:sb){
            ans.append(temp);
        }

        return ans.toString();
    }
}