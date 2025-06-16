class Solution {
    public int integerBreak(int n) {

        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int threeCount = n / 3;
        int remainder = n % 3;

        if (remainder == 1) {
            remainder = 4;
            threeCount -= 1;
        } else if (remainder == 0) {
            remainder = 1;
        }

        return (int) (Math.pow(3, threeCount) * remainder);
    }
}