package src.main.kotlin

/**
 * Title: 카운트 다운
 * Url: https://school.programmers.co.kr/learn/courses/30/lessons/131129
 * return: [최소의 다트 수, 불+싱글]
 * 과녁: 1~20
 * 싱글 x1 , 더블 x2 , 트리플 x3
 * 불,아우터불 50점
 * 값을 넘어가면 실격
 */
class CountDown {
    val dartCount = Array(4) { 0 }  // [0]:싱글, [1]:더블, [2]:트리플, [3]:불
    var score = 0

    fun solution(target: Int): IntArray {

        score = target

        while (score != 0) {
            shootDart()
        }

        return intArrayOf(dartCount.sum(), dartCount[0]+dartCount[3])
    }

    private fun shootDart() {
        if (score in 1..20) {
            dartCount[0] += 1
            score = 0
        } else if (score >= 50) {
            dartCount[3] += 1
            score -= 50
        } else {
            if (score % 3 == 0) {
                dartCount[2] += 1
                score = 0
            } else {
                when (score) {
                    in 21..40 -> {
                        if (score % 2 == 0) {
                            dartCount[1] += 1
                            score = 0
                        } else {
                            dartCount[1] += 1
                            dartCount[0] += 1
                            score = 0
                        }
                    }

                    in 41..49 -> {
                        dartCount[1] += 1
                        dartCount[0] += 1
                        score = 0
                    }
                }
            }
        }
    }
}

private fun main() {
    println(CountDown().solution(21).toCollection(arrayListOf()).joinToString())   // [1,0]
    println(CountDown().solution(58).toCollection(arrayListOf()).joinToString())   // [2,2]
}