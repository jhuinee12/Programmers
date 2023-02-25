package main.kotlin

class `ALG-P-0033_SkillCheck_1` {
    fun solution(numbers: IntArray): String {
        var answer = ""

        val nums = Array(10) { Array(10) { Array(10) { Array(10) { arrayListOf<Int>() } } } }

        numbers.forEach {
            val number = it.toString().toCharArray()
            when (number.size) {
                1 -> {
                    val first = number[0] - '0'
                    nums[0][0][0][first].add(it)
                }
                2 -> {
                    val first = number[0] - '0'
                    val second = number[1] - '0'
                    nums[0][0][first][second].add(it)
                }
                3 -> {
                    val first = number[0] - '0'
                    val second = number[1] - '0'
                    val third = number[2] - '0'
                    nums[0][first][second][third].add(it)
                }
                4 -> {
                    val first = number[0] - '0'
                    val second = number[1] - '0'
                    val third = number[2] - '0'
                    val fourth = number[3] - '0'
                    nums[first][second][third][fourth].add(it)
                }
            }
        }

        for (i in 9 downTo 0) {
            for (j in 9 downTo 0) {
                for (k in 9 downTo 0) {
                    for (s in 9 downTo 0) {

                    }
                }
            }
        }

        return answer
    }
}

private fun main() {
    println(`ALG-P-0033_SkillCheck_1`().solution(intArrayOf(6, 10, 2)))
    println(`ALG-P-0033_SkillCheck_1`().solution(intArrayOf(3, 30, 34, 5, 9)))
}