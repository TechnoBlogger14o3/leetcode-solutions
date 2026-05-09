class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            int[] layerElements = getLayer(grid, layer);
            int layerSize = layerElements.length;
            int effectiveK = k % layerSize;

            rotateLayer(layerElements, effectiveK);
            setLayer(grid, layer, layerElements);
        }

        return grid;
    }

    private int[] getLayer(int[][] grid, int layer) {
        int m = grid.length, n = grid[0].length;
        int layerSize = 2 * (m + n - 4 * layer) - 4;
        int[] layerElements = new int[layerSize];
        int index = 0;

        // Top row
        for (int j = layer; j < n - layer; j++) {
            layerElements[index++] = grid[layer][j];
        }
        // Right column
        for (int i = layer + 1; i < m - layer - 1; i++) {
            layerElements[index++] = grid[i][n - layer - 1];
        }
        // Bottom row
        for (int j = n - layer - 1; j >= layer; j--) {
            layerElements[index++] = grid[m - layer - 1][j];
        }
        // Left column
        for (int i = m - layer - 2; i > layer; i--) {
            layerElements[index++] = grid[i][layer];
        }

        return layerElements;
    }

    private void rotateLayer(int[] layerElements, int k) {
        int n = layerElements.length;
        reverse(layerElements, 0, n - 1);
        reverse(layerElements, 0, k - 1);
        reverse(layerElements, k, n - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private void setLayer(int[][] grid, int layer, int[] layerElements) {
        int m = grid.length, n = grid[0].length;
        int index = 0;

        // Top row
        for (int j = layer; j < n - layer; j++) {
            grid[layer][j] = layerElements[index++];
        }
        // Right column
        for (int i = layer + 1; i < m - layer - 1; i++) {
            grid[i][n - layer - 1] = layerElements[index++];
        }
        // Bottom row
        for (int j = n - layer - 1; j >= layer; j--) {
            grid[m - layer - 1][j] = layerElements[index++];
        }
        // Left column
        for (int i = m - layer - 2; i > layer; i--) {
            grid[i][layer] = layerElements[index++];
        }
    }
}