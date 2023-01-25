package main.kotlin

/**
 * Title: 피보나치 수
 * Url: https://school.programmers.co.kr/learn/courses/30/lessons/12945
 */
class `ALG-P-13_피보나치 수` {
    fun solution(n: Int): Int {
        val nums = ArrayList<Int>()

        nums.add(0)
        nums.add(1)

        for (i in 2..n) {
            nums.add((nums[i-1] + nums[i-2]) % 1234567)
        }

        return nums.last()
    }
}

private fun main() {
    println(`ALG-P-13_피보나치 수`().solution(3))    // 2
    println(`ALG-P-13_피보나치 수`().solution(5))    // 5
}