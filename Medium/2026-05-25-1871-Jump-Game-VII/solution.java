class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) != '0') return false;

        int maxReach = 0;
        for (int i = 0, lastReachable = 0; i < n; i++) {
            if (i > maxReach) return false;
            if (s.charAt(i) == '0') {
                if (i >= minJump) {
                    lastReachable = Math.max(lastReachable, i + minJump);
                }
                if (i <= maxReach) {
                    maxReach = Math.max(maxReach, i + maxJump);
                }
            }
        }
        return maxReach >= n - 1;
    }
}