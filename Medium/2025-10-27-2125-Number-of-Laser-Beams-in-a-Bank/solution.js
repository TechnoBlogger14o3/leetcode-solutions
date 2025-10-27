var numberOfBeams = function(bank) {
    let totalBeams = 0;
    let prevDevices = 0;

    for (let row of bank) {
        let currentDevices = row.split('').filter(c => c === '1').length;
        if (currentDevices > 0) {
            totalBeams += prevDevices * currentDevices;
            prevDevices = currentDevices;
        }
    }

    return totalBeams;
};