function findGCD(n) {
    const sumOdd = n * n; // Sum of first n odd numbers is n^2
    const sumEven = n * (n + 1); // Sum of first n even numbers is n * (n + 1)
    
    function gcd(a, b) {
        while (b) {
            [a, b] = [b, a % b];
        }
        return a;
    }
    
    return gcd(sumOdd, sumEven);
}