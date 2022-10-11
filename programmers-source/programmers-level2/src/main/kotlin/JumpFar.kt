package main.kotlin

/**
 * Title: 멀리 뛰기
 * Url: https://school.programmers.co.kr/learn/courses/30/lessons/12914
 */
class JumpFar {
    fun solution(n: Int): Long {
        val queue = ArrayDeque<Long>()

        for (i in 0L until n) {
            when (i) {
                0L -> queue.add(1L)
                1L -> queue.add(2L)
                2L -> queue.add(3L)
                else -> {
                    queue.removeFirst()
                    queue.add((queue[0] + queue[1]) % 1234567L)
                }
            }
        }

        return queue.last()
    }
}

private fun main() {
//    println(JumpFar().solution(4))  // 5
//    println(JumpFar().solution(3))  // 3
    println(JumpFar().solution(2000))  // 3
}