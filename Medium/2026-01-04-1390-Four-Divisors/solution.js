var sumFourDivisors = function(nums) {
    let totalSum = 0;

    const hasFourDivisors = (n) => {
        let divisors = [];
        for (let i = 1; i * i <= n; i++) {
            if (n % i === 0) {
                divisors.push(i);
                if (i !== n / i) {
                    divisors.push(n / i);
                }
            }
            if (divisors.length > 4) return null;
        }
        return divisors.length === 4 ? divisors.reduce((a, b) => a + b) : null;
    };

    for (const num of nums) {
        const sum = hasFourDivisors(num);
        if (sum) {
            totalSum += sum;
        }
    }

    return totalSum;
};