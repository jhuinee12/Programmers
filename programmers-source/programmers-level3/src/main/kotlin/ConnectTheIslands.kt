package src.main.kotlin

/**
 * Title: 섬 연결하기
 * Url: https://school.programmers.co.kr/learn/courses/30/lessons/42861
 */
class ConnectTheIslands {
    var minCost = Int.MAX_VALUE
    lateinit var graph: Array<IntArray>

    fun solution(n: Int, costs: Array<IntArray>): Int {
        graph = Array(n) { IntArray(n) { 0 } }

        costs.forEach {
            graph[it[0]][it[1]] = it[2]
            graph[it[1]][it[0]] = it[2]
        }

        for (i in 0 until n) {
            val visited = BooleanArray(n) { false }
            visited[i] = true
            dfs(visited, i)
        }

        return minCost
    }

    private fun dfs(visited: BooleanArray, before: Int, cnt: Int = 1, cost: Int = 0) {
        graph[before].forEachIndexed { i, it ->
            if (!visited[i] && it != 0) {
                val newCost = cost+it
                if (newCost > minCost) return@forEachIndexed

                visited[i] = true

                if (cnt == graph.lastIndex) {
                    if (newCost < minCost) minCost = newCost
                } else {
                    dfs(visited, i, cnt+1, newCost)
                }

                visited[i] = false
            }
        }
    }
}

private fun main() {
    println(ConnectTheIslands().solution(
        4,
        arrayOf(
            intArrayOf(0,1,1),intArrayOf(0,2,2),intArrayOf(1,2,5),intArrayOf(1,3,1),intArrayOf(2,3,8))
    )) // 4
    println(ConnectTheIslands().solution(
        4,
        arrayOf(
            intArrayOf(0,1,5), intArrayOf(1,2,3), intArrayOf(2,3,3), intArrayOf(3,1,2), intArrayOf(3,0,4))
    )) // 9
    println(ConnectTheIslands().solution(
        5,
        arrayOf(
            intArrayOf(0,1,5), intArrayOf(1,2,3), intArrayOf(2,3,3), intArrayOf(3,1,2), intArrayOf(3,0,4), intArrayOf(2,4,6), intArrayOf(4,0,7))
    )) // 15
    println(ConnectTheIslands().solution(
        7,
        arrayOf(
            intArrayOf(2,3,7), intArrayOf(3,6,13), intArrayOf(3,5,23), intArrayOf(5,6,25),
            intArrayOf(0,1,29), intArrayOf(1,5,34), intArrayOf(1,2,35), intArrayOf(4,5,53), intArrayOf(0,4,75))
    )) // 159
    println(ConnectTheIslands().solution(
        5,
        arrayOf(
            intArrayOf(0, 1, 1), intArrayOf(3, 4, 1), intArrayOf(1, 2, 2), intArrayOf(2, 3, 4))
    )) // 8
    println(ConnectTheIslands().solution(
        4,
        arrayOf(
            intArrayOf(0,1,1),intArrayOf(0,2,2),intArrayOf(2,3,1))
    )) // 4
    println(ConnectTheIslands().solution(
        5,
        arrayOf(
            intArrayOf(0, 1, 1), intArrayOf(0, 2, 2), intArrayOf(1, 2, 5), intArrayOf(1, 3, 3), intArrayOf(2, 3, 8), intArrayOf(3, 4, 1))
    )) // 7
    println(ConnectTheIslands().solution(
        6,
        arrayOf(
            intArrayOf(0, 1, 5), intArrayOf(0, 3, 2), intArrayOf(0, 4, 3), intArrayOf(1, 4, 1),
            intArrayOf(3, 4, 10), intArrayOf(1, 2, 2), intArrayOf(2, 5, 3), intArrayOf(4, 5, 4))
    )) // 11
    println(ConnectTheIslands().solution(
        5,
        arrayOf(
            intArrayOf(0, 1, 1), intArrayOf(3, 1, 1), intArrayOf(0, 2, 2), intArrayOf(0, 3, 2), intArrayOf(0, 4, 100))
    )) // 104
}