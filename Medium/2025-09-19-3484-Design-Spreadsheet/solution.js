class Spreadsheet {
    constructor(rows) {
        this.rows = rows;
        this.cells = new Map();
    }

    setCell(cell, value) {
        this.cells.set(cell, value);
    }

    resetCell(cell) {
        this.cells.delete(cell);
    }

    getValue(formula) {
        if (formula[0] === '=') {
            const parts = formula.slice(1).split('+');
            let total = 0;
            for (const part of parts) {
                const trimmedPart = part.trim();
                const num = parseInt(trimmedPart);
                if (!isNaN(num)) {
                    total += num;
                } else {
                    total += this.cells.get(trimmedPart) || 0;
                }
            }
            return total;
        }
        return 0;
    }
}