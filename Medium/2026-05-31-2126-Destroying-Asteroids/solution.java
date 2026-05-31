import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for (int asteroid : asteroids) {
            if (mass >= asteroid) {
                mass += asteroid;
            } else {
                return false;
            }
        }
        return true;
    }
}