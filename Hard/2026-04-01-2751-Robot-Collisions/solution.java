import java.util.*;

class Solution {
    public int[] robotCollisions(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<int[]> robots = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            robots.add(new int[]{positions[i], healths[i], directions.charAt(i)});
        }
        
        // Sort robots based on their positions
        robots.sort(Comparator.comparingInt(a -> a[0]));
        
        Stack<int[]> stack = new Stack<>();
        
        for (int[] robot : robots) {
            int pos = robot[0];
            int health = robot[1];
            char dir = robot[2];
            
            if (dir == 'R') {
                stack.push(new int[]{pos, health});
            } else {
                while (!stack.isEmpty() && stack.peek()[1] > 0) {
                    int[] lastRobot = stack.peek();
                    if (lastRobot[1] > health) {
                        health--;
                    } else if (lastRobot[1] < health) {
                        stack.pop();
                        health--;
                    } else {
                        stack.pop();
                        health--;
                        break;
                    }
                }
                if (health > 0) {
                    stack.push(new int[]{pos, health});
                }
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop()[1];
        }
        
        return result;
    }
}