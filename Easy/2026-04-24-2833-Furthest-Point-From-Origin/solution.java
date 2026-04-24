class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int leftMoves = 0;
        int rightMoves = 0;
        int unknownMoves = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'L') {
                leftMoves++;
            } else if (move == 'R') {
                rightMoves++;
            } else if (move == '_') {
                unknownMoves++;
            }
        }

        int maxDistance = Math.abs((leftMoves + unknownMoves) - rightMoves);
        maxDistance = Math.max(maxDistance, Math.abs(leftMoves - (rightMoves + unknownMoves)));

        return maxDistance;
    }
}