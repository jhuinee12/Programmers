package src.main.kotlin

import java.util.*

class ASharedTaxiFare {
    /**
     * @n 지점의 개수
     * @s 출발지점
     * @a a의 도착 지점
     * @b b의 도착 지점
     * @fares 지점 경로 별 요금
     */

    /*fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer = Int.MAX_VALUE

        val graph = Array(n+1) { IntArray(n+1) { 0 } }
        val dist = Array(n+1) { IntArray(n+1) { Int.MAX_VALUE } }

        fares.forEach {
            graph[it[0]][it[1]] = it[2]
            graph[it[1]][it[0]] = it[2]
        }

        fun distance(start: Int) {
            graph[start].forEachIndexed { index, i ->
                if (i == 0) return@forEachIndexed

                dist[start][index] = i
                for (k in 1..n) {
                    val cost = i + graph[index][k]
                    if (cost < dist[start][k]) {
                        dist[start][k] = cost
                    }
                }
            }
        }

        distance(s)
        distance(a)
        distance(b)

        for (i in 0 .. n) {
            val sum = dist[s][i] + dist[a][i] + dist[b][i]
            if (sum < answer) answer = sum
        }

        return answer
    }*/

    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer = Int.MAX_VALUE

        val distance = Array(n+1) { IntArray(n+1) { Int.MAX_VALUE } }
        val graph = Array(n+1) { ArrayList<Pair<Int,Int>>() }

        fares.forEach {
            graph[it[0]].add(Pair(it[1], it[2]))
            graph[it[1]].add(Pair(it[0], it[2]))
        }

        fun dijkstraSearch(start: Int) {
            val q = PriorityQueue<Node>()

            q.add(Node(start, 0))
            distance[start][start] = 0

            while (q.isNotEmpty()) {
                val (now, dist) = q.poll()
                if (distance[start][now] < dist) continue

                for (i in graph[now]) {
                    val cost = dist + i.second

                    if (cost < distance[start][i.first]) {
                        distance[start][i.first] = cost
                        q.add(Node(i.first, cost))
                    }
                }
            }
        }

        // s,a,b를 시작으로 모든 거리의 최단경로를 구함
        dijkstraSearch(s)
        dijkstraSearch(a)
        dijkstraSearch(b)

        // s->x, a->x, b->x 거리의 합이 최소인 경우를 찾음
        for (i in 0 .. n) {
            val sum = distance[s][i] + distance[a][i] + distance[b][i]
            if (sum < answer) answer = sum
        }

        return answer
    }

    data class Node(val index : Int, val value : Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int = value - other.value
    }

}

private fun main() {
    println(ASharedTaxiFare().solution(6,4,6,2,
        arrayOf(
            intArrayOf(4, 1, 10), intArrayOf(3, 5, 24), intArrayOf(5, 6, 2), intArrayOf(3, 1, 41), intArrayOf(5, 1, 24), intArrayOf(4, 6, 50), intArrayOf(2, 4, 66), intArrayOf(2, 3, 22), intArrayOf(1, 6, 25)
        )
    )) // 82
    println(ASharedTaxiFare().solution(7, 3, 4, 1,
        arrayOf(
            intArrayOf(5, 7, 9), intArrayOf(4, 6, 4), intArrayOf(3, 6, 1), intArrayOf(3, 2, 3), intArrayOf(2, 1, 6)
        )
    )) // 14
    println(ASharedTaxiFare().solution(6,4, 5, 6,
        arrayOf(
            intArrayOf(2,6,6), intArrayOf(6,3,7), intArrayOf(4,6,7), intArrayOf(6,5,11), intArrayOf(2,5,12), intArrayOf(5,3,20), intArrayOf(2,4,8), intArrayOf(4,3,9)
        )
    )) // 18
}