import java.util.HashMap;
import java.util.Map;

class Spreadsheet {
    private int rows;
    private int[][] cells;
    private Map<String, Integer> cellMap;

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.cells = new int[rows][26];
        this.cellMap = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        int row = Integer.parseInt(cell.substring(1)) - 1;
        int col = cell.charAt(0) - 'A';
        cells[row][col] = value;
        cellMap.put(cell, value);
    }

    public void resetCell(String cell) {
        int row = Integer.parseInt(cell.substring(1)) - 1;
        int col = cell.charAt(0) - 'A';
        cells[row][col] = 0;
        cellMap.put(cell, 0);
    }

    public int getValue(String formula) {
        if (formula.charAt(0) == '=') {
            String[] parts = formula.substring(1).split("\\+");
            int sum = 0;
            for (String part : parts) {
                if (Character.isDigit(part.charAt(0))) {
                    sum += Integer.parseInt(part);
                } else {
                    sum += cellMap.getOrDefault(part, 0);
                }
            }
            return sum;
        }
        return 0;
    }
}