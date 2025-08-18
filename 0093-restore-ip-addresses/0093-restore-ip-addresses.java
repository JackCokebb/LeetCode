class Solution {
    public List<String> restoreIpAddresses(String s) {

        List<String> answer = new ArrayList<>();

        if (s.length() < 4 || s.length() > 12) {

            return answer;
        }

        return divideAsIp(s, 4);
    }

    public List<String> divideAsIp(String s, int size) {

        List<String> answer = new ArrayList<>();

        if (size * 3 < s.length()) {
            return answer;
        }

        if (size == 1 && validateSingle(s)) {
            answer.add(s);
            return answer;
        }

        for (int i = 1; i <= 3; i++) {
            if (s.length() - 1 < i) {
                break;
            }
            String sub = s.substring(i, s.length());
            String head = s.substring(0, i);

            if(!validateSingle(head)) {
                continue;
            }

            //System.out.println("sub: " + sub + ", head: " + head);
            List<String> divResult = divideAsIp(sub, size - 1);

            if (!divResult.isEmpty()) {
                for (String r : divResult) {
                    answer.add(head + "." + r);
                }
            }
        }

        return answer;
    }

    public boolean validateSingle(String s) {
        int len = s.length();

        if (len <= 0 || len > 3) {
            return false;
        }

        if ((len >= 2 && s.charAt(0) == '0')) {
            return false;
        }

        int val = Integer.valueOf(s);

        if (val < 0 || val > 255) {
            return false;
        }

        return true;
    }
}