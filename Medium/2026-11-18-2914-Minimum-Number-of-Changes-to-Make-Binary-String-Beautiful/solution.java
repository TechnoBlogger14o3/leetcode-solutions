class Solution {
    public int minimumChanges(String s) {
        int changes = 0;
        for (int i = 0; i < s.length(); i += 2) {
            char expected = s.charAt(i);
            if (s.charAt(i + 1) != expected) {
                changes++;
            }
        }
        return changes;
    }
}