var maximumElementAfterDecreasingAndRearranging = function(arr) {
    arr.sort((a, b) => a - b);
    arr[0] = 1; // First element must be 1
    let maxElement = 1;

    for (let i = 1; i < arr.length; i++) {
        if (arr[i] > maxElement + 1) {
            arr[i] = maxElement + 1; // Decrease if necessary
        }
        maxElement = arr[i]; // Update the maximum element
    }

    return maxElement;
};