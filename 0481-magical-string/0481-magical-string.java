class Solution {
    List<String> list = new ArrayList<>();
    int currIdx = 0;
    int appendingIdx = 0;

    public int magicalString(int n) {


        list.add("1");

        while(list.size() < n) {

            String currNum = list.get(currIdx);
            String lastNum = list.get(appendingIdx);

            if("1".equals(currNum)) {
                if(lastNum.equals("1")) {

                    list.add("2");
                } else {

                    list.add("1");
                }

                currIdx++;
                appendingIdx++;
                continue;
            }

            if("2".equals(currNum)) {
                if(lastNum.equals(getPreviousOf(appendingIdx))) {
                    
                    if(lastNum.equals("1")) {
                        list.add("2");
                    } else {
                        list.add("1");
                    }
                    currIdx++;
                    
                } else {
                    
                    list.add(lastNum);
                }
                
                appendingIdx++;
            }
        }

        list = list.size() > n ? list.subList(0, n + 1) : list;

        return (int) list.stream().filter("1"::equals).count();
    }

    private String getPreviousOf(int idx) {

        if(idx == 0) {
            return null;
        }

        return list.get(idx - 1);
    }
}