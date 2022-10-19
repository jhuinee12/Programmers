package src.main.kotlin

class PoppingBalloon {

    fun solution(a: IntArray): Int {
        var answer = 0
        var leftMin = 1000000000
        var rightMin = 1000000000

        // 나보다 작은 값이 없는 경우 true, 존재하는 경우 false
        val leftCheck = Array(a.size) { true }
        val rightCheck = Array(a.size) { true }

        for (i in 1 until a.size-1) {
            if (a[i-1] < leftMin) leftMin = a[i-1] // 왼쪽 최솟값 갱신
            if (a[a.size-i] < rightMin) rightMin = a[a.size-i] // 오른쪽 최솟값 갱신

            if (leftMin < a[i]) leftCheck[i] = false
            if (rightMin < a[a.size-i-1]) rightCheck[a.size-i-1] = false
        }

        for (i in a.indices) {
            if (leftCheck[i] || rightCheck[i]) answer++
        }

        return answer
    }
}

private fun main () {
//    println(PoppingBalloon().solution(intArrayOf(9,-1,-5)))  // 3
    println(PoppingBalloon().solution(intArrayOf(-16,27,65,-2,58,-92,-71,-68,-61,-33)))  // 6
    println(PoppingBalloon().solution(intArrayOf(-16,27,65,-2,58,-92,-68,-61,-71,-33)))  // 4 :: -16, -92, -71, -33
}