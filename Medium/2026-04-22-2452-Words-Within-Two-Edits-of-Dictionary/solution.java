import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        
        for (String query : queries) {
            for (String word : dictionary) {
                if (canMatch(query, word)) {
                    result.add(query);
                    break;
                }
            }
        }
        
        return result;
    }
    
    private boolean canMatch(String query, String word) {
        int edits = 0;
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) != word.charAt(i)) {
                edits++;
                if (edits > 2) {
                    return false;
                }
            }
        }
        return edits <= 2;
    }
}