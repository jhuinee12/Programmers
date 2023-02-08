package src.main.kotlin

class `ALG-P-33_등대` {

    fun solution(n: Int, lighthouse: Array<IntArray>): Int {
        val graph = Array(n+1) { mutableSetOf<Int>() }
        val streets = Array(n+1) { mutableSetOf<Int>() }
        val isLights = mutableSetOf<Int>()

        lighthouse.forEach {
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])

            streets[it[0]].add(it[1])
            streets[it[1]].add(it[0])
        }

        graph.forEach {
            if (it.size == 1) {
                val i = it.first()

                isLights.add(i)

                streets[i].clear()
                streets.forEach { set -> set.remove(i) }
            }
        }

        streets.forEach {
            while (it.size > 0) {
                val i = it.first()

                isLights.add(i)

                streets[i].clear()
                streets.forEach { set -> set.remove(i) }
            }
        }

        return isLights.size
    }
}

private fun main() {
//    println(`ALG-P-33_등대`().solution(8, arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(1, 4), intArrayOf(1, 5), intArrayOf(5, 6), intArrayOf(5, 7), intArrayOf(5, 8)))) // 정답: 2
    println(`ALG-P-33_등대`().solution(10, arrayOf(intArrayOf(4, 1), intArrayOf(5, 1), intArrayOf(5, 6), intArrayOf(7, 6), intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(6, 8), intArrayOf(2, 9), intArrayOf(9, 10)))) // 정답: 3
}