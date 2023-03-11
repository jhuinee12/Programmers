package src.main.kotlin

class `ALG-P-0035_연속_펄스_부분_수열의_합` {
    fun solution(sequence: IntArray): Long {
        val pulseSum1 = LongArray(sequence.size) { 0 }
        val pulseSum2 = LongArray(sequence.size) { 0 }

        var min1 = Long.MAX_VALUE
        var max1 = Long.MAX_VALUE * -1
        var min2 = Long.MAX_VALUE
        var max2 = Long.MAX_VALUE * -1

        sequence.forEachIndexed { index, i ->
            if (index == 0) {
                pulseSum1[index] = (i * -1).toLong()
                pulseSum2[index] = i.toLong()
            } else if (index % 2 != 0) {
                pulseSum1[index] = pulseSum1[index-1] + i
                pulseSum2[index] = pulseSum2[index-1] + i * -1
            } else {
                pulseSum1[index] = pulseSum1[index-1] + i * -1
                pulseSum2[index] = pulseSum2[index-1] + i
            }

            if (pulseSum1[index] < min1) min1 = pulseSum1[index]
            if (pulseSum1[index] > max1) max1 = pulseSum1[index]
            if (pulseSum2[index] < min2) min2 = pulseSum2[index]
            if (pulseSum2[index] > max2) max2 = pulseSum2[index]
        }

        if (max1 - min1 > max1) max1 -= min1
        if (max2 - min2 > max2) max2 -= min2

        return if (max1 >= max2) max1 else max2
    }
}

private fun main() {
    println(`ALG-P-0035_연속_펄스_부분_수열의_합`().solution(
        intArrayOf(2, 3, -6, 1, 3, -1, 2, 4)
    )) // 정답: 10
}