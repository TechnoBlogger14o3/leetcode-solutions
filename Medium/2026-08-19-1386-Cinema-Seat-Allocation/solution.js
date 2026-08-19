var maxNumberOfFamilies = function(n, reservedSeats) {
    const reserved = new Map();
    
    for (const [row, seat] of reservedSeats) {
        if (!reserved.has(row)) {
            reserved.set(row, new Set());
        }
        reserved.get(row).add(seat);
    }
    
    let maxGroups = 0;

    for (let i = 1; i <= n; i++) {
        const reservedSeatsInRow = reserved.get(i) || new Set();
        let count = 0;

        if (!reservedSeatsInRow.has(2) && !reservedSeatsInRow.has(3) && !reservedSeatsInRow.has(4) && !reservedSeatsInRow.has(5)) {
            count++;
        }
        if (!reservedSeatsInRow.has(4) && !reservedSeatsInRow.has(5) && !reservedSeatsInRow.has(6) && !reservedSeatsInRow.has(7)) {
            count++;
        }
        if (!reservedSeatsInRow.has(6) && !reservedSeatsInRow.has(7) && !reservedSeatsInRow.has(8) && !reservedSeatsInRow.has(9)) {
            count++;
        }

        maxGroups += count === 0 ? 0 : count === 2 ? 2 : 1;
    }

    return maxGroups;
};