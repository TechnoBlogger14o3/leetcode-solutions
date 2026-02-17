var readBinaryWatch = function(turnedOn) {
    const result = [];
    
    for (let h = 0; h < 12; h++) {
        for (let m = 0; m < 60; m++) {
            if (countBits(h) + countBits(m) === turnedOn) {
                result.push(`${h}:${m < 10 ? '0' : ''}${m}`);
            }
        }
    }
    
    return result;
};

function countBits(num) {
    let count = 0;
    while (num) {
        count += num & 1;
        num >>= 1;
    }
    return count;
}