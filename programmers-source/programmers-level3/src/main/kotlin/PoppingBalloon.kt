package src.main.kotlin

class PoppingBalloon {

    fun solution(a: IntArray): Int {
        var answer = 0
        var leftMin = 1000000000

        a.forEachIndexed { index, i ->
            when (index) {
                0, a.size - 1 -> answer++
                else -> {
                    if (a[index-1] < leftMin) leftMin = a[index-1]

                    if (leftMin > i) answer ++
                    else {
                        var isMin = true
                        for (x in index+1 until a.size) {
                            if (a[x] < i) {
                                isMin = false
                                break
                            }
                        }

                        if (isMin) answer++
                    }
                }
            }
        }

        return answer
    }
}

private fun main () {
//    println(PoppingBalloon().solution(intArrayOf(9,-1,-5)))  // 3
    println(PoppingBalloon().solution(intArrayOf(-16,27,65,-2,58,-92,-71,-68,-61,-33)))  // 6
    println(PoppingBalloon().solution(intArrayOf(-16,27,65,-2,58,-92,-68,-61,-71,-33)))  // 6 :: -16, -92, -71, -33
}