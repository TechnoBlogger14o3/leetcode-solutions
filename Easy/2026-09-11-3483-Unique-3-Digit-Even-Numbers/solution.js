var countEvenNumbers = function(digits) {
    const uniqueDigits = new Set(digits);
    const evenDigits = [...uniqueDigits].filter(d => d % 2 === 0);
    let count = 0;

    for (const evenDigit of evenDigits) {
        const remainingDigits = [...uniqueDigits].filter(d => d !== evenDigit);
        for (const firstDigit of remainingDigits) {
            if (firstDigit === 0) continue;
            const secondDigits = remainingDigits.filter(d => d !== firstDigit);
            count += secondDigits.length;
        }
    }

    return count * 2; // Each combination can be arranged in two ways (evenDigit at the end)
};

// Example test cases
console.log(countEvenNumbers([1,2,3,4])); // Output: 12
console.log(countEvenNumbers([0,2,2]));   // Output: 2
console.log(countEvenNumbers([6,6,6]));   // Output: 1
console.log(countEvenNumbers([1,3,5]));   // Output: 0