package src.main.kotlin

class 순위 {
    fun solution(n: Int, results: Array<IntArray>): Int {
        // 0:경기안함, 1:승, 2:패
        // league[a][b] = 1 :: a가 b한테 승리함
        val league = Array(n+1) { IntArray(n+1) { 0 } }

        results.forEach {
            league[it[0]][it[1]] = 1
            league[it[1]][it[0]] = 2
        }

        while (true){
            var isBreak = true

            for (i in 1 .. n) {
                val winArray = arrayListOf<Int>()
                val loseArray = arrayListOf<Int>()

                league[i].forEachIndexed { index, it ->
                    if (it == 1) winArray.add(index)
                    if (it == 2) loseArray.add(index)
                }

                winArray.forEach { w ->
                    loseArray.forEach { l ->
                        if (league[w][l] == 0) {
                            league[l][w] = 1
                            league[w][l] = 2
                            isBreak = false
                        }
                    }
                }

            }

            if (isBreak) break
        }

        var answer = 0

        league.forEach {
            if (it.filter { i -> i != 0 }.size == n-1) answer++
        }

        return answer
    }
}

private fun main() {
    println(순위().solution(5,
        arrayOf(intArrayOf(4, 3), intArrayOf(4, 2), intArrayOf(3, 2), intArrayOf(1, 2), intArrayOf(2, 5)))) // 2
}