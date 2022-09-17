package src.main.kotlin

/**
 * Date     : 2022-09-16-FRI
 * Title    : 입국심사
 * Url      : https://school.programmers.co.kr/learn/courses/30/lessons/43238
 * Description
 * 문제 설명
 *  n명이 입국심사를 위해 줄을 서서 기다리고 있습니다.
 *  각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.
 *
 *  처음에 모든 심사대는 비어있습니다.
 *  한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다.
 *  가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다.
 *  하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.
 *
 *  모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
 *  입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때,
 *  모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 *  입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
 * 각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
 * 심사관은 1명 이상 100,000명 이하입니다.
 */
class Immigration {

    /**
     * @param n :: 대기하고 있는 인원
     * @param times :: 각 심사대 별 걸리는 시간
     * @return 모든 사람이 심사를 받는데 걸리는 시간의 최솟값
     */

    // 시간초과
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        var waitPerson = n

        times.sort()

        val timeArray: ArrayList<Int> = arrayListOf()
        val size = if (n < times.size) n else times.size
        for (i in 0 until size) { timeArray.add(times[i]) }

        while(waitPerson != 0 && timeArray.isNotEmpty()) {
            for (i in 0 until timeArray.size) {
                timeArray[i] -= 1

                if (timeArray[i] == 0) {
                    if (waitPerson > 0) {
                        --waitPerson
                        timeArray[i] = times[i]
                    } else {
                        timeArray.removeAt(i)
                    }
                }
            }
            answer++
        }

        return answer
    }

    // 시간초과
    fun solution2(n: Int, times: IntArray): Long {
        var answer: Long = 0
        var waitPerson = n

        times.sort()

        val timeArray: ArrayList<Int> = arrayListOf()
        val size = if (n < times.size) n else times.size
        for (i in 0 until size) { timeArray.add(times[i]) }

        while(waitPerson != 0) {
            val minTime = timeArray.sorted()[0]

            for (i in 0 until timeArray.size) {
                timeArray[i] -= minTime

                if (timeArray[i] == 0) {
                    --waitPerson
                    timeArray[i] = times[i]
                    if (waitPerson == 0) break
                }
            }
            answer += minTime
        }

        return answer
    }

    /*
        이진 탐색 알고리즘의 과정
        1) 배열의 중간에 있는 값을 선택하여 찾고자 하는 값 x와 비교
        2) x가 중간 값보다 작으면 중간 값을 기준으로 좌측의 데이터들을 대상으로,
        3) x가 중간값보다 크면 배열의 우측을 대상으로 다시 탐색
        4) 값을 찾을 때까지 2번 3번 반복
     */



    // ex. 6 / [7,10] 인 경우
    // 1. 가장 적게 걸리는 시간은 1(분), 오래 걸리는 시간은 10*6=60(분)
    // 2. 중간값(mid)에서 각 심사위원이 몇 명을 처리할 수 있는지 계산
    // 3. => 심사를 받는데 걸리는 시간(mid)은 30(분)이고, mid 이내에 처리 가능 인원한 인원은 각 심사대에 3(명),4(명)
    // 4. 심사대가 처리할 수 있는 인원은 7명인데 총 인원은 6명 => 최대 시간을 중간값보다 낮게 줄임 (high = mid)
    // 5. mid 시간을 줄여서 처리 가능 인원이 총 인원보다 작으면 최저 시간을 중간값보다 높게 올림 (low = mid)
    // 6. 최저 시간과 최대시간보다 커지면 정답 추출
    fun solution3(n: Int, times: IntArray): Long {
        var answer: Long = 0

        times.sort()

        var lowTime: Long = 1
        var highTime: Long = times[times.size-1] * n.toLong()
        
        while (lowTime <= highTime) {
            var sum: Long = 0
            val midTime: Long = (lowTime + highTime) / 2

            times.forEach {
                sum += midTime/it
            }

            if (sum >= n) {
                highTime = midTime - 1
                answer = midTime
            } else {
                lowTime = midTime + 1
            }
        }

        return answer
    }

}

fun main() {
    val sample = Immigration()
/*
    println(sample.solution(6, intArrayOf(7,10))) // 정답: 28
    println(sample.solution(8, intArrayOf(1,9))) // 정답: 8
    println(sample.solution(3, intArrayOf(1,1,1))) // 정답: 1
    println(sample.solution(3, intArrayOf(1,2,3))) // 정답: 2
    println(sample.solution(10, intArrayOf(6,8,10))) // 정답: 30
    println(sample.solution(7, intArrayOf(10,10))) // 정답: 40
    println(sample.solution(1, intArrayOf(10,10,10))) // 정답: 10
    println(sample.solution(1, intArrayOf(10,15,8))) // 정답: 8
    println(sample.solution(2, intArrayOf(10,15,8))) // 정답: 10
    println(sample.solution(2, intArrayOf(10,15,8))) // 정답: 10
    println(sample.solution(2, intArrayOf(1000000000))) // 정답: 2000000000
*/
/*
    println(sample.solution2(6, intArrayOf(7,10))) // 정답: 28
    println(sample.solution2(8, intArrayOf(1,9))) // 정답: 8
    println(sample.solution2(3, intArrayOf(1,1,1))) // 정답: 1
    println(sample.solution2(3, intArrayOf(1,2,3))) // 정답: 2
    println(sample.solution2(10, intArrayOf(6,8,10))) // 정답: 30
    println(sample.solution2(7, intArrayOf(10,10))) // 정답: 40
    println(sample.solution2(1, intArrayOf(10,10,10))) // 정답: 10
    println(sample.solution2(1, intArrayOf(10,15,8))) // 정답: 8
    println(sample.solution2(2, intArrayOf(10,15,8))) // 정답: 10
    println(sample.solution2(2, intArrayOf(10,15,8))) // 정답: 10
    println(sample.solution2(2, intArrayOf(1000000000))) // 정답: 2000000000
    */

    println(sample.solution3(6, intArrayOf(7,10))) // 정답: 28
    println(sample.solution3(8, intArrayOf(1,9))) // 정답: 8
    println(sample.solution3(3, intArrayOf(1,1,1))) // 정답: 1
    println(sample.solution3(3, intArrayOf(1,2,3))) // 정답: 2
    println(sample.solution3(10, intArrayOf(6,8,10))) // 정답: 30
    println(sample.solution3(7, intArrayOf(10,10))) // 정답: 40
    println(sample.solution3(1, intArrayOf(10,10,10))) // 정답: 10
    println(sample.solution3(1, intArrayOf(10,15,8))) // 정답: 8
    println(sample.solution3(2, intArrayOf(10,15,8))) // 정답: 10
    println(sample.solution3(2, intArrayOf(10,15,8))) // 정답: 10
    println(sample.solution3(2, intArrayOf(1000000000))) // 정답: 2000000000
    println(sample.solution3(1000, intArrayOf(1000,1,1))) // 정답: 2000000000

}