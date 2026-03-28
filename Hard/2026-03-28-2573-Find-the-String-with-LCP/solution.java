class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] result = new char[n];
        boolean[] used = new boolean[26];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] > 0) {
                    if (i + lcp[i][j] > n || j + lcp[i][j] > n || lcp[i][j] != lcp[j][i]) {
                        return "";
                    }
                    for (int k = 0; k < lcp[i][j]; k++) {
                        if (result[i + k] == 0 && result[j + k] == 0) {
                            result[i + k] = 'a';
                        } else if (result[i + k] != 0 && result[j + k] == 0) {
                            result[j + k] = result[i + k];
                        } else if (result[i + k] == 0 && result[j + k] != 0) {
                            result[i + k] = result[j + k];
                        } else if (result[i + k] != result[j + k]) {
                            return "";
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (result[i] == 0) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (!used[c - 'a']) {
                        result[i] = c;
                        used[c - 'a'] = true;
                        break;
                    }
                }
            }
        }
        
        return new String(result);
    }
}