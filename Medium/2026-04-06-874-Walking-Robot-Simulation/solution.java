import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // North, East, South, West
        int x = 0, y = 0, dir = 0, maxDistance = 0;

        for (int command : commands) {
            if (command == -2) {
                dir = (dir + 3) % 4; // Turn left
            } else if (command == -1) {
                dir = (dir + 1) % 4; // Turn right
            } else {
                for (int i = 0; i < command; i++) {
                    int newX = x + directions[dir][0];
                    int newY = y + directions[dir][1];
                    if (!obstacleSet.contains(newX + "," + newY)) {
                        x = newX;
                        y = newY;
                        maxDistance = Math.max(maxDistance, x * x + y * y);
                    } else {
                        break; // Hit an obstacle
                    }
                }
            }
        }

        return maxDistance;
    }
}