import java.util.PriorityQueue;

public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassInfo> pq = new PriorityQueue<>((a, b) -> {
            double diffA = (double) (a.pass + 1) / (a.total + 1) - (double) a.pass / a.total;
            double diffB = (double) (b.pass + 1) / (b.total + 1) - (double) b.pass / b.total;
            return Double.compare(diffB, diffA);
        });

        for (int[] c : classes) {
            pq.offer(new ClassInfo(c[0], c[1]));
        }

        while (extraStudents > 0) {
            ClassInfo classInfo = pq.poll();
            classInfo.pass++;
            classInfo.total++;
            pq.offer(classInfo);
            extraStudents--;
        }

        double totalRatio = 0.0;
        while (!pq.isEmpty()) {
            ClassInfo classInfo = pq.poll();
            totalRatio += (double) classInfo.pass / classInfo.total;
        }

        return totalRatio / classes.length;
    }

    private static class ClassInfo {
        int pass;
        int total;

        ClassInfo(int pass, int total) {
            this.pass = pass;
            this.total = total;
        }
    }
}