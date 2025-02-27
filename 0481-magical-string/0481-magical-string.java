class Solution {
    String[] list;
    int currIdx = 2;
    int appendingIdx = 3;
    int count = 1;

    public int magicalString(int n) {

        if(n < 1) return 0;
        if(n < 4) return 1;

        list = new String[n + 1];
        list[0] = "1";
        list[1] = "2";
        list[2] = "2";

        int num = 1;

        while(appendingIdx < n) {

            for(int i = 0 ; i < Integer.parseInt(list[currIdx]) ; i++) {
                list[appendingIdx] = String.valueOf(num);

                if(num == 1 && appendingIdx < n) {
                    count++;
                }
                appendingIdx++;
            }

            num = num ^ 3;
            currIdx++;
        }

        return count;
    }
}