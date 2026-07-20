class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        if (num / 1000 != 0) {
            for (int i = 0; i < num / 1000; i++) {
                sb.append("M");
            }
            num = num % 1000;
        }

        if (num / 100 != 0) {
            if (num / 100 == 9) {
                sb.append("CM");
                num -= 900;
            } else if (num / 100 == 4) {
                sb.append("CD");
                num -= 400;
            } 
            
            if (num / 100 >= 5) {
                sb.append("D");
                num -= 500;
            }

            for (int i = 0; i < num / 100; i++) {
                sb.append("C");
            }

            num = num % 100;
        }

        if (num / 10 != 0) {
            if (num / 10 == 9) {
                sb.append("XC");
                num -= 90;
            } else if (num / 10 == 4) {
                sb.append("XL");
                num -= 40;
            } 
            
            
            if (num / 10 >= 5) {
                sb.append("L");
                num -= 50; 
            }

            for (int i = 0; i < num / 10; i++) {
                sb.append("X");
            }  

            num = num % 10;
        }

        if (num != 0) {
            if (num == 9) {
                sb.append("IX");
                num -= 9;
            } else if (num == 4) {
                sb.append("IV");
                num -= 4;
            } 
            
            if (num >= 5) {
                sb.append("V");
                num -= 5;
            }

            for (int i = 0; i < num; i++) {
                sb.append("I");
            }
        }

        return sb.toString();
    }
}