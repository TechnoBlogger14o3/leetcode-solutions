function minOperations(grid, x) {
    const flatGrid = grid.flat();
    const minVal = Math.min(...flatGrid);
    const totalOps = flatGrid.reduce((acc, val) => {
        const diff = Math.abs(val - minVal);
        if (diff % x !== 0) return -1; // If not possible
        return acc + diff / x;
    }, 0);
    return totalOps;
}