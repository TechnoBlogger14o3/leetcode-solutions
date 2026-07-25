var maxProduct = function(n) {
    const digits = String(n).split('').map(Number);
    let maxProduct = 0;

    for (let i = 0; i < digits.length; i++) {
        for (let j = 0; j < digits.length; j++) {
            maxProduct = Math.max(maxProduct, digits[i] * digits[j]);
        }
    }

    return maxProduct;
};