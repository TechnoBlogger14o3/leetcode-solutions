class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        boolean[] toDelete = new boolean[m];
        int deletions = 0;

        for (int col = 0; col < m; col++) {
            boolean canKeep = true;
            for (int row = 1; row < n; row++) {
                if (!toDelete[col] && strs[row - 1].charAt(col) > strs[row].charAt(col)) {
                    canKeep = false;
                    break;
                }
            }
            if (!canKeep) {
                toDelete[col] = true;
                deletions++;
            } else {
                for (int row = 1; row < n; row++) {
                    if (toDelete[col]) continue;
                    if (strs[row - 1].charAt(col) < strs[row].charAt(col)) {
                        break;
                    }
                    if (row == n - 1) {
                        toDelete[col] = true;
                        deletions++;
                    }
                }
            }
        }
        return deletions;
    }
}