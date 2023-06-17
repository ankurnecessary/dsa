function getHCForGCD(a, b) {

    while (a !== 0 && b !== 0) { // a * b !== 0

        if (a > b) {
            a = a % b;
        }
        else {
            b = b % a;
        }

    }

    return a !== 0 ? a : b; // a + b

}