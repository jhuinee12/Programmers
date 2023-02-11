package src.main.kotlin

class `ALG-P-33_등대` {

    fun solution(n: Int, lighthouse: Array<IntArray>): Int {
        val graph = mutableMapOf<Int, MutableSet<Int>>()
        var count = 0

        for (i in 1 .. n) {
            graph[i] = mutableSetOf()
        }

        lighthouse.forEach {
            graph[it[0]]!!.add(it[1])
            graph[it[1]]!!.add(it[0])
        }

        while (graph.isNotEmpty()) {
            for (index in 1 .. n) {
                if (graph[index]?.size == 1) {
                    val first = graph[index]!!.first()

                    count++

                    graph[first]!!.forEach { i ->
                        if (graph[i]!!.size == 1) graph.remove(i)
                        else graph[i]!!.remove(first)
                    }

                    graph.remove(index)
                    graph.remove(first)
                }
            }
        }

        return count
    }
}

private fun main() {
    println(`ALG-P-33_등대`().solution(8, arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(1, 4), intArrayOf(1, 5), intArrayOf(5, 6), intArrayOf(5, 7), intArrayOf(5, 8)))) // 정답: 2
    println(`ALG-P-33_등대`().solution(10, arrayOf(intArrayOf(4, 1), intArrayOf(5, 1), intArrayOf(5, 6), intArrayOf(7, 6), intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(6, 8), intArrayOf(2, 9), intArrayOf(9, 10)))) // 정답: 3
    println(`ALG-P-33_등대`().solution(8, arrayOf(intArrayOf(1, 2), intArrayOf(2, 5), intArrayOf(1, 3), intArrayOf(3, 7), intArrayOf(7, 8), intArrayOf(1, 4), intArrayOf(4, 6)))) // 정답: 4
}