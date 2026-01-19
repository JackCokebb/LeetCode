class Solution {
    public int compareVersion(String version1, String version2) {
        String[] splitedV1 = version1.split("\\.");
        String[] splitedV2 = version2.split("\\.");
        int v1Len = splitedV1.length;
        int v2Len = splitedV2.length;
        int biggerLen = Math.max(v1Len, v2Len);

        // System.out.println("v1Len: " + v1Len + ", v2Len: " + v2Len + ", biigerLen: " + biggerLen);

        for (int i = 0 ; i < biggerLen ; i++) {
            int nextV1 = v1Len <= i ? 0 : Integer.valueOf(splitedV1[i]);
            int nextV2 = v2Len <= i ? 0 : Integer.valueOf(splitedV2[i]);

            // System.out.println("nextV1: " + nextV1 + ", nextV2: " + nextV2);

            if (nextV1 > nextV2) {
                return 1;
            } else if (nextV1 < nextV2){
                return -1;
            }
        }

        return 0;
    }
}