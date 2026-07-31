class Solution {
    public int minimumPushes(String word) {
        int[] frequency = new int[26];
        for (char c : word.toCharArray()) {
            frequency[c - 'a']++;
        }
        
        Arrays.sort(frequency);
        
        int pushes = 0;
        int key = 1;
        for (int i = 25; i >= 0; i--) {
            if (frequency[i] == 0) break;
            pushes += frequency[i] * key;
            key++;
            if (key > 9) key = 1; // Reset key after 9
        }
        
        return pushes;
    }
}