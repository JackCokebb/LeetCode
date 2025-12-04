import java.util.Map.Entry;

class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int temp = map.getOrDefault(c, 0);
            map.put(c, temp + 1);
        }

        map.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(e -> sb.append(String.valueOf(e.getKey()).repeat(e.getValue())));

        return sb.toString();
    }
}