class Spreadsheet:
    def __init__(self, rows: int):
        self.rows = rows
        self.cells = {}
    
    def setCell(self, cell: str, value: int) -> None:
        self.cells[cell] = value
    
    def resetCell(self, cell: str) -> None:
        if cell in self.cells:
            del self.cells[cell]
    
    def getValue(self, formula: str) -> int:
        if formula[0] == '=':
            formula = formula[1:]
        parts = formula.split('+')
        total = 0
        for part in parts:
            part = part.strip()
            if part.isdigit():
                total += int(part)
            else:
                total += self.cells.get(part, 0)
        return total