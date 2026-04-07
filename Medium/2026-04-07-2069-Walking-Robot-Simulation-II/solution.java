class Robot {
    private int x, y, width, height, direction;
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // North, East, South, West

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.direction = 1; // Initially facing East
    }

    public void step(int num) {
        for (int i = 0; i < num; i++) {
            int newX = x + directions[direction][0];
            int newY = y + directions[direction][1];
            if (newX < 0 || newX >= width || newY < 0 || newY >= height) {
                direction = (direction + 3) % 4; // Turn 90 degrees counterclockwise
            } else {
                x = newX;
                y = newY;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        switch (direction) {
            case 0: return "North";
            case 1: return "East";
            case 2: return "South";
            case 3: return "West";
            default: return "";
        }
    }
}