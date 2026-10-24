class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int startAlice = convertToDayOfYear(arriveAlice);
        int endAlice = convertToDayOfYear(leaveAlice);
        int startBob = convertToDayOfYear(arriveBob);
        int endBob = convertToDayOfYear(leaveBob);
        
        int start = Math.max(startAlice, startBob);
        int end = Math.min(endAlice, endBob);
        
        return Math.max(0, end - start + 1);
    }
    
    private int convertToDayOfYear(String date) {
        String[] parts = date.split("-");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        
        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonth[i];
        }
        
        return dayOfYear;
    }
}