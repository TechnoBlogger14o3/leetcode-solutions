import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        generateHappyStrings("", n, happyStrings);
        
        if (k > happyStrings.size()) {
            return "";
        }
        
        return happyStrings.get(k - 1);
    }
    
    private void generateHappyStrings(String current, int n, List<String> happyStrings) {
        if (current.length() == n) {
            happyStrings.add(current);
            return;
        }
        
        for (char c : new char[]{'a', 'b', 'c'}) {
            if (current.isEmpty() || current.charAt(current.length() - 1) != c) {
                generateHappyStrings(current + c, n, happyStrings);
            }
        }
    }
}