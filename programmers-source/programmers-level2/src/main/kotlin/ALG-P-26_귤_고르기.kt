package main.kotlin

class `ALG-P-26_귤_고르기` {
    fun solution(k: Int, tangerine: IntArray): Int {
        var index = 0
        var sum = 0
        var count = Array(100000001) { 0 }

        tangerine.forEach { count[it] += 1 }

        count = count.filter { it != 0 }.toList().sortedDescending().toTypedArray()

        while (true) {
            index++
            if (count[index] < k-sum) sum += count[index-1]
            else break
        }

        return index
    }
}