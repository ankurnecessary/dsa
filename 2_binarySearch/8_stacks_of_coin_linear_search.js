// Stacks of coins

/*
There are N stacks of coins, each stack has certain value of coins.

The stacks are lying on a straight line, you have K friends with whom you can share these coins in K + 1 partitions. Your friends are greedy and they will pick the best K parts and you will get the last one. Maximise the value of coins that you will get.

 */

let obj = {

    main() {

        let answer = this.getCoins([10, 20, 15, 5, 8], 3);
        console.log(answer);

    },

    getCoins(coinsArr, noOfFriends) {

        let friendsCount = noOfFriends + 1;

        if (coinsArr.length < friendsCount) return 0;

        let min = this.getMin(coinsArr);
        let max = this.getMax(coinsArr);

        let maxCoins = 0;
        let answer = 0;

        while (min <= max) {

            let maxLeftOver = this.getMaxLeftOver(coinsArr, friendsCount, min);
            console.log("maxLeftOver: ", maxLeftOver, " min: ", min);
            if (maxLeftOver >= maxCoins) {
                maxCoins = maxLeftOver;
                answer = min;
            }
            min++;
        }

        return answer;

    },

    getMaxLeftOver(coinsArr, friendsCount, min) {

        let currentFriend = 1;
        let coinsTotal = 0;

        for (let i = 0; i < coinsArr.length; i++) {

            coinsTotal += coinsArr[i];

            if (coinsTotal >= min && currentFriend < friendsCount) {
                coinsTotal = 0;
                currentFriend++;
            }

        }

        if (currentFriend !== friendsCount) {
            return 0;
        }

        return coinsTotal;

    },

    getMin(arr) {

        let min = Number.MAX_SAFE_INTEGER;

        for (let val of arr) {
            min = Math.min(min, val);
        }

        return min;
    },

    getMax(arr) {
        let sum = 0;

        for (let val of arr) {
            sum += val;
        }

        return sum;
    }

}

obj.main();
