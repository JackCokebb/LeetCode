class Solution {

    static char[] str = {'a', 'e', 'i', 'o', 'u'};

    public int countVowelStrings(int n) {
        int result = 0;
        for (int i = 0 ; i < 5 ; i++) {
            result += count(n, str[i]);
        }

        return result;
    }

    private int count(int n, char lastChar) {
        if (n == 1) {
            return 1;
        }

        int result = 0;

        switch (lastChar) {
            case 'a' :
                for (int i = 0 ; i < 5 ; i++) {
                    result += count(n - 1, str[i]);
                }
                break;
            case 'e' :
                for (int i = 1 ; i < 5 ; i++) {
                    result += count(n - 1, str[i]);
                }
                break;
            case 'i' :
                for (int i = 2 ; i < 5 ; i++) {
                    result += count(n - 1, str[i]);
                }
                break;
            case 'o' :
                for (int i = 3 ; i < 5 ; i++) {
                    result += count(n - 1, str[i]);
                }
                break;
            case 'u' :
                for (int i = 4 ; i < 5 ; i++) {
                    result += count(n - 1, str[i]);
                }
                break;
        }

        return result;
    }
}