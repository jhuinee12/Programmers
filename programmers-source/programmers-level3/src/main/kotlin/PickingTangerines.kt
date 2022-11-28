package src.main.kotlin

class PickingTangerines {
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

private fun main() {
    println(PickingTangerines().solution(6, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3))) // 정답: 3
    println(PickingTangerines().solution(4, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3))) // 정답: 2
    println(PickingTangerines().solution(2, intArrayOf(1, 1, 1, 1, 2, 2, 2, 3))) // 정답: 1
}