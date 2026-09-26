import java.util.HashMap;
import java.util.Map;

class Solution {
    public String evaluate(String s, String[][] knowledge) {
        Map<String, String> map = new HashMap<>();
        for (String[] entry : knowledge) {
            map.put(entry[0], entry[1]);
        }

        StringBuilder result = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                int j = i + 1;
                while (j < n && s.charAt(j) != ')') {
                    j++;
                }
                String key = s.substring(i + 1, j);
                result.append(map.getOrDefault(key, "?"));
                i = j; // Move i to the position of ')'
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}