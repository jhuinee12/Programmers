import java.util.*
import kotlin.collections.ArrayList

/**
 * Date         : 2022-07-09-SAT
 * Title        : 타겟 넘버 (Target Number)
 * Algorithm    : DFS, BFS (깊이,너비 우선 탐색)
 */

class TargetNumber {

    val linkedList = LinkedList<Integer>()

    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0

        for (num in numbers) {

        }

        return answer
    }

    fun plus(a: Int, b: Int) = a + b
    fun minus(a: Int, b: Int) = a - b

    fun dfs(a: Int) {
        val visited = ArrayList<Boolean>()
        dfsUtil(a, visited)
    }

    fun dfsUtil(a: Int, visited: ArrayList<Boolean>) {
        visited[a] = true

    }

}

fun main() {
    println(TargetNumber().solution(intArrayOf(1,1,1,1,1),3))
    println(TargetNumber().solution(intArrayOf(4,1,2,1),4))
}