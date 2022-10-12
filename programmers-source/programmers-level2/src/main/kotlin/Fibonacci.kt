package main.kotlin

/**
 * Title: 피보나치 수
 * Url: https://school.programmers.co.kr/learn/courses/30/lessons/12945
 */
class Fibonacci {
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
    println(Fibonacci().solution(3))    // 2
    println(Fibonacci().solution(5))    // 5
}