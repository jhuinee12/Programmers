package src.main.kotlin

import java.util.*
import kotlin.collections.ArrayList

class `가장 먼 노드` {
    private lateinit var graph: Array<ArrayList<Int>>
    private lateinit var distance: IntArray
    private var max = 0

    fun solution(n: Int, edge: Array<IntArray>): Int {
        graph = Array(n+1) { arrayListOf() }
        distance = IntArray(n+1) { Int.MAX_VALUE }

        edge.forEach {
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
        }

        dijkstra(1)

        return searchMaxCount()
    }

    fun dijkstra(start: Int) {
        val q = PriorityQueue<Node>()

        q.add(Node(start, 0))
        distance[start] = 0

        while (q.isNotEmpty()) {
            val (now, dist) = q.poll()
            if (distance[now] < dist) continue

            for (i in graph[now]) {
                val cost = dist + 1

                if (cost < distance[i]) {
                    distance[i] = cost
                    q.add(Node(i, cost))
                }
            }
        }
    }

    private fun searchMaxCount(): Int {
        var count = 0
        distance.forEach {
            if (it == Int.MAX_VALUE) return@forEach
            if (it > max) {
                count = 1
                max = it
            } else if (it == max) {
                count++
            }
        }
        return count
    }

    // 거리 순으로 정렬
    data class Node(val index : Int, val value : Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int = value - other.value
    }
}

private fun main() {
    println(`가장 먼 노드`().solution(6, arrayOf(intArrayOf(3, 6), intArrayOf(4, 3), intArrayOf(3, 2), intArrayOf(1, 3), intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(5, 2))))

}