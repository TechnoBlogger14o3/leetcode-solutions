class Solution {
    public double angleClock(int hour, int minutes) {
        if (hour == 12) hour = 0; // Convert 12 to 0 for calculation
        double minuteAngle = minutes * 6; // Each minute is 6 degrees
        double hourAngle = (hour * 30) + (minutes * 0.5); // Each hour is 30 degrees and each minute contributes 0.5 degrees
        double angle = Math.abs(hourAngle - minuteAngle);
        return Math.min(angle, 360 - angle); // Return the smaller angle
    }
}