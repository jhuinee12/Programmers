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

    /**
     * 70보다 큰 경우
     *  - 60보다 크면 볼로 나누는게 효율적
     * 70보다 작은 경우
     *  - 50(볼) + 싱글
     * 60보다 작은 경우
     *  - 3의 배수면 트리플
     *  - 3의 배수가 아니면 50(볼) + 싱글
     *  - 50인 경우 볼
     * 40보다 작은 경우
     *  - 2의 배수면 더블
     *  - 3의 배수면 트리플
     *  - 2의 배수가 아니면 싱글 + 싱글
     * 20보다 작은 경우
     *  - 싱글
     */
    private fun shootDart() {
        if (score > 70) {
            val num1 = if (score % 60 == 0) score/60 else score/60 + 1
            val num2 = if (score % 50 == 0) score/50 else score/50 + 1
            if (num1 == num2) {
                dartCount[3] += 1
                score -= 50
            } else {
                dartCount[2] += 1
                score -= 60
            }
        } else {
            if (score in 41..60 && score % 3 == 0) {
                dartCount[2] += 1
                score = 0
            } else if (score > 50) {
                dartCount[0] += 1
                dartCount[3] += 1
                score = 0
            } else if (score == 50) {
                dartCount[3] += 1
                score = 0
            } else if (score in 21..40) {
                if (score % 3 == 0) {
                    dartCount[2] += 1
                    score = 0
                } else if (score % 2 == 0) {
                    dartCount[1] += 1
                    score = 0
                } else {
                    dartCount[0] += 2
                    score = 0
                }
            } else {
                dartCount[0] += 1
                score = 0
            }
        }
    }
}

private fun main() {
    println(CountDown().solution(21).toCollection(arrayListOf()).joinToString()) // [1,0]
    println(CountDown().solution(58).toCollection(arrayListOf()).joinToString()) // [2,2]
    println(CountDown().solution(2022).toCollection(arrayListOf()).joinToString()) // [34,0]
    println(CountDown().solution(63).toCollection(arrayListOf()).joinToString()) // [2,2] :: 50(불)+13(싱글)
    println(CountDown().solution(70).toCollection(arrayListOf()).joinToString()) // [2,2] :: 50(불)+20(싱글)
    println(CountDown().solution(190).toCollection(arrayListOf()).joinToString()) // [4,3] :: 50(볼)+50(볼)+50(볼)+40(더블)
    println(CountDown().solution(80).toCollection(arrayListOf()).joinToString()) // [2,1] :: 60(트리플)+20(싱글) || 50(볼)+30(더블)
    println(CountDown().solution(130).toCollection(arrayListOf()).joinToString()) // [3,2] :: 50(볼)+50(볼)+30(더블)
    println(CountDown().solution(140).toCollection(arrayListOf()).joinToString()) // [3,2] :: 50(볼)+50(볼)+40(더블)
    println(CountDown().solution(160).toCollection(arrayListOf()).joinToString()) // [3,2] :: 50(볼)+50(볼)+60(트리플)
    println(CountDown().solution(260).toCollection(arrayListOf()).joinToString()) // [5,4] :: 50(볼)+50(볼)+50(볼)+50(볼)+60(트리플)
    println(CountDown().solution(270).toCollection(arrayListOf()).joinToString()) // [5,3] :: 60(트리플)+60(트리플)+50(볼)+50(볼)+50(볼)
}