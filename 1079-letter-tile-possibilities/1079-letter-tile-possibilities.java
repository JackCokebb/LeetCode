class Solution {
    HashSet<String> result = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        for (char c : tiles.toCharArray()) {
            //System.out.println("ntpb: " + String.valueOf(c));
            //printSet(result);
            if (result.contains(String.valueOf(c))) {
                continue;
            }

            makeCombination(String.valueOf(c), tiles.replaceFirst(String.valueOf(c), ""));
        }

        return result.size();
    }

    private void makeCombination(String s, String rest) {
        //System.out.println("mc in: " + s);
        //printSet(result);
        if (result.contains(s)) {
            return;
        } else {
            result.add(s);
        }

        for (char c : rest.toCharArray()) {
            if (!result.contains(s + String.valueOf(c))) {
                makeCombination(s + String.valueOf(c), rest.replaceFirst(String.valueOf(c), ""));
            }
        }
    }

    // private void printSet(HashSet<String> set) {
    //     System.out.println(
    //         set.stream()
    //         .sorted()
    //         .map(String::valueOf)
    //         .collect(java.util.stream.Collectors.joining(","))
    //     );
    // }
}