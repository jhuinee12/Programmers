package main.kotlin

class Network {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        val network = arrayListOf(arrayListOf<Int>())
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j) continue
                if (computers[i][j] == 1) {
                }
            }
        }

        return 0
    }
}

private fun main() {
    println (Network().solution(3, arrayOf(intArrayOf(1,1,0), intArrayOf(1,1,0), intArrayOf(0,0,1))))   // 2
    println (Network().solution(3, arrayOf(intArrayOf(1,1,0), intArrayOf(1,1,1), intArrayOf(0,1,1))))   // 1
    println (Network().solution(4, arrayOf(intArrayOf(1,1,0,0), intArrayOf(1,1,0,0), intArrayOf(0,0,1,1), intArrayOf(0,0,1,1))))   // 2
}