var totalMoney = function(n) {
    const weeks = Math.floor((n - 1) / 7);
    const extraDays = (n - 1) % 7;
    
    const totalFromWeeks = (weeks * (7 * (weeks + 1)) / 2) + (7 * weeks * (weeks + 1)) / 2;
    const totalFromExtraDays = (extraDays + 1) * (extraDays + 2) / 2 + weeks * (extraDays + 1);
    
    return totalFromWeeks + totalFromExtraDays;
};