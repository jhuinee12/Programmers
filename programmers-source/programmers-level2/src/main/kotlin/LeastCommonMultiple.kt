package main.kotlin

import java.lang.Integer.min

class LeastCommonMultiple {
    fun solution(arr: IntArray): Int {
        var answer = arr

        while (true) {
            val r = lcm(answer)
            if (answer.size == 1) break
            else answer = r
        }

        return answer[0]
    }

    private fun lcm(arr: IntArray): IntArray {
        val gcd = IntArray(arr.size-1) { 0 }

        for (i in 1..arr.lastIndex) {
            for (j in min(arr[i], arr[i-1]) downTo  1) {
                if (arr[i] % j == 0 && arr[i-1] % j == 0) {
                    gcd[i-1] = arr[i-1]/j*arr[i]
                    break
                }
            }
        }

        return gcd
    }
}

private fun main() {
    println(LeastCommonMultiple().solution(intArrayOf(2,6,8,14))) // 정답: 168
    println(LeastCommonMultiple().solution(intArrayOf(1,2,3))) // 정답: 6
    println(LeastCommonMultiple().solution(intArrayOf(2,6,8,12))) // 정답: 24
    println(LeastCommonMultiple().solution(intArrayOf(2,3,4))) // 정답: 12
    println(LeastCommonMultiple().solution(intArrayOf(2,7,14))) // 정답: 14
}