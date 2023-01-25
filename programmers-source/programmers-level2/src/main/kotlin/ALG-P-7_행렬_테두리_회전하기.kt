package main.kotlin

/**
 * Title : 행렬 테두리 회전하기
 * Url : https://school.programmers.co.kr/learn/courses/30/lessons/77485?language=kotlin
 */
class RotateMatrixBorders {

    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val numbers = arrayListOf<Int>()
        val table = arrayListOf<ArrayList<Int>>()

        // 행렬 생성
        for (i in 0 until rows) {
            val subTable = arrayListOf<Int>()
            for (j in 1 .. columns) {
                subTable.add(i*columns+j)
            }
            table.add(subTable)
        }

        queries.forEach {

            var min = 10000

            var i = it[0]-1
            var j = it[1]-1
            var temp = table[i][j]

            while (j < it[3]-1) {
                if (temp < min) min = temp

                j++
                val temp2 = table[i][j]
                table[i][j] = temp
                temp = temp2
            }

            while (i < it[2]-1) {
                if (temp < min) min = temp

                i++
                val temp2 = table[i][j]
                table[i][j] = temp
                temp = temp2
            }

            while (j > it[1]-1) {
                if (temp < min) min = temp

                j--
                val temp2 = table[i][j]
                table[i][j] = temp
                temp = temp2
            }

            while (i > it[0]-1) {
                if (temp < min) min = temp

                i--
                val temp2 = table[i][j]
                table[i][j] = temp
                temp = temp2
            }

            numbers.add(min)
        }

        return numbers.toIntArray()
    }
}

fun main() {
    println(RotateMatrixBorders().solution(6,6, arrayOf(intArrayOf(2,2,5,4), intArrayOf(3,3,6,6), intArrayOf(5,1,6,3)))) // [8, 10, 25]
    println(RotateMatrixBorders().solution(3, 3, arrayOf(intArrayOf(1,1,2,2), intArrayOf(1,2,2,3), intArrayOf(2,1,3,2), intArrayOf(2,2,3,3)))) // [1, 1, 5, 3]
    println(RotateMatrixBorders().solution(100, 97, arrayOf(intArrayOf(1,1,100,97)))) // [1]
}