class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] rotated = new char[n][m];

        for (int j = 0; j < n; j++) {
            int writeIndex = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (boxGrid[i][j] == '#') {
                    rotated[j][writeIndex--] = '#';
                } else if (boxGrid[i][j] == '*') {
                    while (writeIndex >= 0 && rotated[j][writeIndex] == '#') {
                        writeIndex--;
                    }
                    rotated[j][writeIndex--] = '*';
                }
            }
            while (writeIndex >= 0) {
                rotated[j][writeIndex--] = '.';
            }
        }
        return rotated;
    }
}