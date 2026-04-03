import java.util.*;

public class Solution {
    public int maximumWallsDestroyed(int[] robots, int[] distance, int[] walls) {
        Set<Integer> destroyedWalls = new HashSet<>();
        Map<Integer, Integer> robotMap = new HashMap<>();
        
        for (int i = 0; i < robots.length; i++) {
            robotMap.put(robots[i], distance[i]);
        }
        
        Arrays.sort(walls);
        Arrays.sort(robots);
        
        for (int robot : robots) {
            int maxDistance = robotMap.get(robot);
            int leftLimit = Math.max(0, robot - maxDistance);
            int rightLimit = robot + maxDistance;
            
            // Destroy walls to the left
            for (int wall : walls) {
                if (wall < robot && wall >= leftLimit) {
                    destroyedWalls.add(wall);
                }
                if (wall >= robot) {
                    break;
                }
            }
            
            // Destroy walls to the right
            for (int wall : walls) {
                if (wall > robot && wall <= rightLimit) {
                    destroyedWalls.add(wall);
                }
                if (wall > rightLimit) {
                    break;
                }
            }
        }
        
        return destroyedWalls.size();
    }
}