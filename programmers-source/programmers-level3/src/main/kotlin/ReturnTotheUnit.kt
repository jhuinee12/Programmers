package src.main.kotlin

import kotlin.collections.ArrayList

/**
 * Title: 부대복귀
 * Url: https://school.programmers.co.kr/learn/courses/30/lessons/132266
 */
class ReturnTotheUnit {
    private lateinit var dist: IntArray
    private lateinit var graph: Array<Array<Int?>>

    /**
     * destination에서 sources까지의 최단 거리를 구하면??
     * ex. 1->2, 1->3
     *
     * 나의 풀이
     *  1. destination을 시작 노드로 지정함
     *  2. destination을 포함한 노드를 거리 1로 dist에 저장
     *  3. 거리 1로 저장된 값을 포함한 노드를 다시 거리 2로 dist에 저장 (최소값 비교)
     *  4. dist가 가득 채워질 때까지 반복
     *  => 시간초과
     *      완전탐색...
     */
    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
        val answer: ArrayList<Int> = arrayListOf()

        val visited = BooleanArray(n+1) { false }

        dist = IntArray(n+1) { n+1 }
        graph = Array(n+1) { Array(n+1) { null } }

        roads.forEach {
            graph[it[0]][it[1]] = 1
            graph[it[1]][it[0]] = 1
        }

        dist[destination] = 0
        visited[destination] = true

        sources.forEach { _ ->
            searchRoad(n, visited, destination, 1)
        }

        sources.forEach {
            if (dist[it] == n+1) {
                answer.add(-1)
            } else {
                answer.add(dist[it])
            }
        }

        return answer.toIntArray()
    }

    private fun searchRoad(n: Int, visited: BooleanArray, start: Int, count: Int) {
        graph[start].forEachIndexed { index, i ->
            if (i != null && !visited[index]
                    && (graph[start][index] == 1 || graph[index][start] == 1)
                    && dist[index] > count) {
                visited[index] = true
                dist[index] = count
                searchRoad(n, visited, index, count + 1)
                visited[index] = false
            }
        }
    }

}

private fun main() {
    println(ReturnTotheUnit().solution(
            3,
            arrayOf(
                intArrayOf(1,2), intArrayOf(2,3)
            ),
            intArrayOf(2,3),
            1)
        .toCollection(arrayListOf()).joinToString()
    ) // [1,2]
    println(ReturnTotheUnit().solution(
            5,
            arrayOf(
                intArrayOf(1,2), intArrayOf(1,4), intArrayOf(2,4), intArrayOf(2,5), intArrayOf(4,5)
            ),
            intArrayOf(1,3,5),
            5)
        .toCollection(arrayListOf()).joinToString()
    ) // [2,-1,0]
}