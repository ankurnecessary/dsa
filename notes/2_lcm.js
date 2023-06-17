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

function getLCM(a, b) {
    return (a * b) / getHCForGCD(a, b);
}

console.log(getLCM(12, 15));
console.log(getLCM(15, 60));
console.log(getLCM(100, 1));