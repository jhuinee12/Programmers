package level1


class AdditionOfMatrices {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer: Array<IntArray> = Array(arr1.size) { IntArray(arr1[0].size) }

        for (i in arr1.indices) {
            for (j in arr1[0].indices) {
                answer[i][j] = arr1[i][j] + arr2[i][j]
            }
        }

        for (i in arr1.indices) {
            for (j in arr1.indices) {
                println("${answer[i][j]} ")
            }
        }
        return answer
    }
}