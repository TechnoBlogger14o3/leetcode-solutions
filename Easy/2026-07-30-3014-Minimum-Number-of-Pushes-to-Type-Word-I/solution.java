class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int pushes = 0;
        
        // Each key can hold at most 3 letters, so we calculate the number of pushes
        for (int i = 0; i < n; i++) {
            pushes += (i / 3) + 1;
        }
        
        return pushes;
    }
}