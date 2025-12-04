class Solution {
    public int countCollisions(String directions) {
        int collisions = 0;
        int n = directions.length();
        
        // Convert the string to a character array for easier manipulation
        char[] cars = directions.toCharArray();
        
        // Process the cars from left to right
        for (int i = 0; i < n; i++) {
            if (cars[i] == 'R') {
                // Check for collisions with 'L' or 'S'
                while (i + 1 < n && cars[i + 1] == 'L') {
                    collisions += 2; // R and L collide
                    i++;
                }
                if (i + 1 < n && cars[i + 1] == 'S') {
                    collisions += 1; // R and S collide
                }
            } else if (cars[i] == 'L') {
                // Check for collisions with 'S'
                if (i - 1 >= 0 && cars[i - 1] == 'S') {
                    collisions += 1; // L and S collide
                }
            } else if (cars[i] == 'S') {
                // Check for collisions with 'R' or 'L'
                if (i - 1 >= 0 && cars[i - 1] == 'R') {
                    collisions += 1; // R and S collide
                }
                if (i + 1 < n && cars[i + 1] == 'L') {
                    collisions += 1; // S and L collide
                }
            }
        }
        
        return collisions;
    }
}