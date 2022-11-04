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
    val dartCount = Array(2) { 0 }  // [0]:싱글/볼, [1]:더블/트리플
    var score = 0

    fun solution(target: Int): IntArray {
        score = target


        return intArrayOf(dartCount.sum(), dartCount[0])
    }

    private fun shootDart() {

    }
}

/**
 * 실패한 풀이
 * 반례 : 104의 경우 -> 50 + 54
 *      내 풀이의 정답  -> 60 + 40 + 4
 */
class XCountDown() {
    val dartCount = Array(2) { 0 }  // [0]:싱글/볼, [1]:더블/트리플
    var score = 0

    fun solution(target: Int): IntArray {
        score = target

        while (score != 0) {
            shootDart()
        }

        return intArrayOf(dartCount.sum(), dartCount[0])
    }

    /**
     * 70보다 큰 경우
     *  - 60보다 크면 볼로 나누는게 효율적
     *  - 60으로 나눈 횟수와 볼로 나눈 횟수가 일치하면 볼로 하는게 효율적
     *
     * 70보다 작거나 같은 경우
     *  => 60보다 큰 경우
     *      - 50(볼) + 싱글
     *  => 50보다 큰 경우
     *      - 3의 배수면 트리플
     *      - 3의 배수가 아니면 50(볼) + 싱글
     *  => 50인 경우 볼
     *  => 40보다 큰 경우
     *      - 3의 배수면 트리플
     *      - 3의 배수가 아니면 싱글 + 더블 || 트리플 + 싱글
     *  => 20보다 큰 경우
     *      - 2의 배수면 더블
     *      - 3의 배수면 트리플
     *      - 아니면 싱글 + 싱글
     *  => 20보다 작은 경우
     *      - 싱글
     */
    private fun shootDart() {
        if (score > 70) {
            val num1 = if (score % 60 == 0) score/60 else score/60 + 1
            val num2 = if (score % 50 == 0) score/50 else score/50 + 1

            if (num1 == num2) {
                dartCount[0] += 1
                score -= 50
            } else {
                dartCount[1] += 1
                score -= 60
            }
        } else {
            when (score) {
                in 1..20 -> {
                    dartCount[0] += 1
                }
                in 21..40 -> {
                    if (score % 3 == 0 || score % 2 == 0) dartCount[1] += 1
                    else dartCount[0] += 2
                }
                in 41..49 -> {
                    if (score % 3 != 0) dartCount[0] += 1
                    dartCount[1] += 1
                }
                in 51..60 -> {
                    if (score % 3 == 0) dartCount[1] += 1
                    else dartCount[0] += 2
                }
                50 -> dartCount[0] += 1
                else -> dartCount[0] += 2
            }
            score = 0
        }
    }
}

private fun main() {
//    println(CountDown().solution(21).toCollection(arrayListOf()).joinToString()) // [1,0]
//    println(CountDown().solution(58).toCollection(arrayListOf()).joinToString()) // [2,2]
//    println(CountDown().solution(2022).toCollection(arrayListOf()).joinToString()) // [34,0]
//    println(CountDown().solution(63).toCollection(arrayListOf()).joinToString()) // [2,2] :: 50(불)+13(싱글)
//    println(CountDown().solution(70).toCollection(arrayListOf()).joinToString()) // [2,2] :: 50(불)+20(싱글)
//    println(CountDown().solution(190).toCollection(arrayListOf()).joinToString()) // [4,3] :: 50(볼)+50(볼)+50(볼)+40(더블)
//    println(CountDown().solution(80).toCollection(arrayListOf()).joinToString()) // [2,1] :: 60(트리플)+20(싱글) || 50(볼)+30(더블)
//    println(CountDown().solution(130).toCollection(arrayListOf()).joinToString()) // [3,2] :: 50(볼)+50(볼)+30(더블)
//    println(CountDown().solution(140).toCollection(arrayListOf()).joinToString()) // [3,2] :: 50(볼)+50(볼)+40(더블)
//    println(CountDown().solution(160).toCollection(arrayListOf()).joinToString()) // [3,2] :: 50(볼)+50(볼)+60(트리플)
//    println(CountDown().solution(260).toCollection(arrayListOf()).joinToString()) // [5,4] :: 50(볼)+50(볼)+50(볼)+50(볼)+60(트리플)
//    println(CountDown().solution(270).toCollection(arrayListOf()).joinToString()) // [5,3] :: 60(트리플)+60(트리플)+50(볼)+50(볼)+50(볼)
//    println(CountDown().solution(29).toCollection(arrayListOf()).joinToString()) // [2,2] :: 20(싱글)+9(싱글)
//    println(CountDown().solution(27).toCollection(arrayListOf()).joinToString()) // [1,0] :: 27(트리플)
//    println(CountDown().solution(25).toCollection(arrayListOf()).joinToString()) // [2,2] :: 20(싱글)+5(싱글)
//    println(CountDown().solution(54).toCollection(arrayListOf()).joinToString()) // [1,0] :: 54(트리플)
//    println(CountDown().solution(43).toCollection(arrayListOf()).joinToString()) // [2,1] :: 40(더블)+3(싱글)
//    println(CountDown().solution(48).toCollection(arrayListOf()).joinToString()) // [1,0] :: 48(트리플)
//    println(CountDown().solution(33).toCollection(arrayListOf()).joinToString()) // [1,0] :: 33(트리플)
//    println(CountDown().solution(34).toCollection(arrayListOf()).joinToString()) // [1,0] :: 34(더블)
//    println(CountDown().solution(37).toCollection(arrayListOf()).joinToString()) // [2,2] :: 20(싱글)+17(싱글)
//    println(CountDown().solution(53).toCollection(arrayListOf()).joinToString()) // [2,2] :: 50(볼)+3(싱글)
//    println(CountDown().solution(102).toCollection(arrayListOf()).joinToString()) // [2,0] :: 60(트리플)+42(트리플)
//    println(CountDown().solution(320).toCollection(arrayListOf()).joinToString()) // [6,1] :: 60(트리플)*2 + 50(볼)*4
//    println(CountDown().solution(353).toCollection(arrayListOf()).joinToString()) // [6,1] :: 60(트리플)*5 + 50(볼) + 3(싱글)
//    println(CountDown().solution(2020).toCollection(arrayListOf()).joinToString()) // [34,2] :: 60(트리플)*32 + 50(볼)*2
//    println(CountDown().solution(1853).toCollection(arrayListOf()).joinToString()) // [32,2] :: 60(트리플)*30 + 50(볼) + 3(싱글)
//    println(CountDown().solution(1854).toCollection(arrayListOf()).joinToString()) // [31,0] :: 60(트리플)*30 + 54(트리플)
//    println(CountDown().solution(83).toCollection(arrayListOf()).joinToString()) // [2,1] :: 50(볼)+33(트리플)
//    println(CountDown().solution(10555).toCollection(arrayListOf()).joinToString()) // [177,2] :: 60(트리플)*175 + 50(볼) + 4(싱글)
//    println(CountDown().solution(100000).toCollection(arrayListOf()).joinToString()) // [1667,2] :: 60(트리플)*1665 + 50(볼)*2
    println(CountDown().solution(324).toCollection(arrayListOf()).joinToString()) // [6,3] :: 60(트리플)*2 + 50(볼)*3 + 54(트리플)
    println(CountDown().solution(204).toCollection(arrayListOf()).joinToString()) // [4,3] :: 50(볼)*3 + 54(트리플)
    println(CountDown().solution(104).toCollection(arrayListOf()).joinToString()) // [2,1] :: 50(볼)+54(트리플)
//    println(CountDown().solution(99).toCollection(arrayListOf()).joinToString()) // [2,0] :: 60(트리플)+39(트리플)
//    println(CountDown().solution(99999).toCollection(arrayListOf()).joinToString()) // [1667,0]
}
