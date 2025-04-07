class Solution {
    public String simplifyPath(String path) {
        path = path.replaceAll("/+", "/");
        String[] stripPath = path.split("/");
        StringBuilder sb = new StringBuilder();

        for (int i = stripPath.length - 1 ; i >= 0 ; i--) {
            if (".".equals(stripPath[i])) {
                stripPath[i] = "";
            }
        }

        for (int i = 0 ; i < stripPath.length ; i++) {
            System.out.println("i: " + i + ", " + stripPath[i]);
        }

        System.out.println("=======");

        for (int i = stripPath.length - 1 ; i >= 0 ; i--) {
            if ("..".equals(stripPath[i]) && i > 0) {
                int dotCount = 1;
                stripPath[i] = "";
                while (i >= 0 && "..".equals(stripPath[i - 1])) {
                    stripPath[--i] = "";
                    dotCount++;
                }
                --i;

                while (dotCount-- > 0) {
                    System.out.println("curr i: " + i + ", dot cnt: " + dotCount + 1);
                    if (i >= 0 && stripPath[i] == "") {
                        dotCount++;
                        i--;
                    } else if (i >= 0 && "..".equals(stripPath[i])) {
                        dotCount += 2;
                        stripPath[i] = "";
                        i--;
                    } else {
                        System.out.println("i: " + Math.max(0, i) + ", " + stripPath[Math.max(0, i)] + " DEL");
                        stripPath[Math.max(0, i--)] = "";
                    }
                }
                i++;
            }
        }

        System.out.println("=======");
        for (int i = 0 ; i < stripPath.length ; i++) {
            System.out.println("i: " + i + ", " + stripPath[i]);
        }

        for (int i = 0 ; i < stripPath.length ; i++) {
            if (stripPath[i] != null && "" != stripPath[i]) {
                sb.append("/");
                sb.append(stripPath[i]);
            }
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}