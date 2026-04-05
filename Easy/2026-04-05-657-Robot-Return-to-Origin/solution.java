class Solution {
    public boolean judgeCircle(String moves) {
        int horizontal = 0;
        int vertical = 0;

        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
                    break;
                case 'L':
                    horizontal--;
                    break;
                case 'R':
                    horizontal++;
                    break;
            }
        }

        return horizontal == 0 && vertical == 0;
    }
}