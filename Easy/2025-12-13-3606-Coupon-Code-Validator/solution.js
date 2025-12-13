function couponCodeValidator(code, businessLine, isActive) {
    const validBusinessLines = ["electronics", "grocery", "pharmacy", "restaurant"];
    const validCoupons = [];

    for (let i = 0; i < code.length; i++) {
        const c = code[i];
        const bl = businessLine[i];
        const active = isActive[i];

        const isCodeValid = c.length > 0 && /^[a-zA-Z0-9_]+$/.test(c);
        const isBusinessLineValid = validBusinessLines.includes(bl);

        if (isCodeValid && isBusinessLineValid && active) {
            validCoupons.push({ code: c, businessLine: bl });
        }
    }

    validCoupons.sort((a, b) => {
        const businessLineOrder = validBusinessLines.indexOf(a.businessLine) - validBusinessLines.indexOf(b.businessLine);
        if (businessLineOrder !== 0) return businessLineOrder;
        return a.code.localeCompare(b.code);
    });

    return validCoupons.map(coupon => coupon.code);
}