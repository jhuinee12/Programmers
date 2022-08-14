import java.util.*
import kotlin.collections.ArrayList

/**
 * Date         : 2022-07-09-SAT
 * Title        : 타겟 넘버 (Target Number)
 * Algorithm    : DFS, BFS (깊이,너비 우선 탐색)
 */

class TargetNumber {

    val visited = arrayListOf<Boolean>()
    val queue = LinkedList<Int>()
    val adj = LinkedList<Int>()

    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0

        var sum = 0

        for (num in numbers) {
            sum = plus(sum, num)
        }

        return answer
    }

    fun plus(a: Int, b: Int) = a + b
    fun minus(a: Int, b: Int) = a - b

    fun bfs (rootNode: Int) {
        var rootNode = rootNode

        visited[rootNode] = true
        queue.add(rootNode)

        while (queue.size != 0) {
            rootNode = queue.poll()

            val i: Iterator<Int> = adj[rootNode].listIterator()
            while (i.hasNext()) {
                val n = i.next()
                // 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
                if (!visited[n]) {
                  visited[n] = true;
                  queue.add(n);
                }
            }
        }
    }

}

fun main() {
    println(TargetNumber().solution(intArrayOf(1,1,1,1,1),3))
    println(TargetNumber().solution(intArrayOf(4,1,2,1),4))
}