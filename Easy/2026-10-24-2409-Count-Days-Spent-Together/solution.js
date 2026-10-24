var countDaysTogether = function(arriveAlice, leaveAlice, arriveBob, leaveBob) {
    const daysInMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

    const dateToDayOfYear = (date) => {
        const [month, day] = date.split('-').map(Number);
        return day + daysInMonth.slice(0, month - 1).reduce((a, b) => a + b, 0);
    };

    const startAlice = dateToDayOfYear(arriveAlice);
    const endAlice = dateToDayOfYear(leaveAlice);
    const startBob = dateToDayOfYear(arriveBob);
    const endBob = dateToDayOfYear(leaveBob);

    const start = Math.max(startAlice, startBob);
    const end = Math.min(endAlice, endBob);

    return Math.max(0, end - start + 1);
};