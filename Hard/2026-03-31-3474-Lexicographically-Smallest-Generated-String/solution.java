class Solution {
    public String findLexSmallestString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n + m - 1; i++) {
            if (i < n && str1.charAt(i) == 'T') {
                if (i + m <= n + m - 1) {
                    result.append(str2);
                } else {
                    return "";
                }
            } else if (i < n && str1.charAt(i) == 'F') {
                if (i + m <= n + m - 1) {
                    StringBuilder temp = new StringBuilder();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != str2.charAt(0)) {
                            temp.append(c);
                            break;
                        }
                    }
                    for (int j = 1; j < m; j++) {
                        temp.append('a');
                    }
                    result.append(temp);
                } else {
                    return "";
                }
            }
        }
        
        String generated = result.toString();
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                String sub = generated.substring(i, Math.min(i + m, generated.length()));
                if (sub.equals(str2)) {
                    return "";
                }
            }
        }
        
        return generated;
    }
}