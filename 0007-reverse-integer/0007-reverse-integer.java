class Solution {
    public int reverse(int x) {
        int size = (int) Math.floor(Math.log10(Math.abs((long) x))) + 1;
        long temp = x;
        long result = 0;

        // System.out.println("size: " + size);
        // System.out.println("abs: " + Math.abs((long)x));
        // System.out.println("log: " + Math.log10(Math.abs((long) x)));

        for (int i = size - 1; i >= 0; i--) {
            long curr = (long) Math.pow(10, i) * (x % 10);

            result += curr;
            x /= 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }
}