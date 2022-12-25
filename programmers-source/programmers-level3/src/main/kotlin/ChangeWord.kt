package src.main.kotlin

class ChangeWord {
    lateinit var target: String
    lateinit var words: Array<String>

    var minCnt = Int.MAX_VALUE

    fun solution(begin: String, target: String, words: Array<String>): Int {
        this.target = target
        this.words = words

        val visited = BooleanArray(words.size) { false }

        if (!words.contains(target)) return 0

        dfs(visited, begin, 1)

        return minCnt
    }

    private fun dfs(visited: BooleanArray, word: String, count: Int) {
        words.forEachIndexed { i, w ->
            if (visited[i]) return@forEachIndexed

            var diff = 0

            word.forEachIndexed { j, c ->
                if (c != w[j]) diff++
            }

            if (diff == 1) {
                if (w == target && count < minCnt) minCnt = count
                visited[i] = true
                dfs(visited, w, count+1)
                visited[i] = false
            }
        }
    }
}

private fun main() {
    println(ChangeWord().solution("hit","cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog"))) // 정답: 4
    println(ChangeWord().solution("hit","cog", arrayOf("hot", "dot", "dog", "lot", "log"))) // 정답: 0
}