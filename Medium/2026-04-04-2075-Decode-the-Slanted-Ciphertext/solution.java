class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        if (n == 0 || rows == 0) return "";
        
        int cols = (n + rows - 1) / rows; // Calculate the number of columns
        char[][] matrix = new char[rows][cols];
        
        // Fill the matrix with characters from encodedText
        for (int i = 0; i < n; i++) {
            int r = i % rows;
            int c = i / rows;
            if (c < cols) {
                matrix[r][c] = encodedText.charAt(i);
            }
        }
        
        StringBuilder originalText = new StringBuilder();
        
        // Read the matrix in the slanted order
        for (int diag = 0; diag < cols; diag++) {
            for (int r = 0; r < rows; r++) {
                int c = diag - r;
                if (c >= 0 && c < cols && matrix[r][c] != '\u0000') {
                    originalText.append(matrix[r][c]);
                }
            }
        }
        
        return originalText.toString().trim(); // Remove trailing spaces
    }
}