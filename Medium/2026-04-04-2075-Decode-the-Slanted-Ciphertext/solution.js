var decodeCiphertext = function(encodedText, rows) {
    const n = encodedText.length;
    const cols = Math.ceil(n / rows);
    let originalText = '';

    for (let i = 0; i < cols; i++) {
        for (let j = 0; j < rows; j++) {
            const index = j + i + j * (cols - 1);
            if (index < n) {
                originalText += encodedText[index];
            }
        }
    }

    return originalText.replace(/\s+$/, '');
};