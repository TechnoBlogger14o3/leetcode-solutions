import java.util.*;

public class Solution {
    public double findMedianHeight(int[][] squares) {
        List<Double> heights = new ArrayList<>();
        for (int[] square : squares) {
            int x = square[0], y = square[1], l = square[2];
            heights.add((double) y);
            heights.add((double) (y + l));
        }
        
        Collections.sort(heights);
        double totalArea = 0;
        for (int[] square : squares) {
            totalArea += Math.pow(square[2], 2);
        }
        
        double halfArea = totalArea / 2;
        double areaAbove = 0, areaBelow = 0;
        double lastHeight = heights.get(0);
        
        for (double height : heights) {
            if (height == lastHeight) continue;
            double width = height - lastHeight;
            areaBelow += calculateArea(squares, lastHeight, height, true);
            areaAbove += calculateArea(squares, lastHeight, height, false);
            
            if (areaAbove >= halfArea) {
                return lastHeight + (halfArea - areaBelow) / (areaAbove - areaBelow) * width;
            }
            lastHeight = height;
        }
        
        return lastHeight;
    }
    
    private double calculateArea(int[][] squares, double line, double nextLine, boolean below) {
        double area = 0;
        for (int[] square : squares) {
            int x = square[0], y = square[1], l = square[2];
            if (below) {
                if (y < line) {
                    area += Math.min(nextLine, y + l) - line > 0 ? (Math.min(nextLine, y + l) - line) * l : 0;
                }
            } else {
                if (y + l > line) {
                    area += Math.min(nextLine, y + l) - line > 0 ? (Math.min(nextLine, y + l) - line) * l : 0;
                }
            }
        }
        return area;
    }
}