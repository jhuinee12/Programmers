package src.main.kotlin

import kotlin.math.max

/**
 * Title    : 코딩 테스트 공부
 * Url      : https://school.programmers.co.kr/learn/courses/30/lessons/118668?language=kotlin
 * 참고      : https://tech.kakao.com/2022/07/13/2022-coding-test-summer-internship/
 */
class StudyingForCodingTest {

    /**
     * @param alp 초기 알고력
     * @param cop 초기 코딩력
     * @param problems 문제의 정보를 담은 2차원 배열 : [alp_req, cop_req, alp_rwd, cop_rwd, cost]
     *      - alp_req : 문제를 푸는데 필요한 알고력
     *      - cop_req : 문제를 푸는데 필요한 코딩력
     *      - alp_rwd : 문제를 풀었을 때 증가하는 알고력
     *      - cop_rwd : 문제를 풀었을 때 증가하는 코딩력
     *      - cost    : 문제를 푸는데 드는 시간
     */

    // 1. 알고력과 코딩력이 problems에서 가장 높은 alp_req, cop_req으로 달성해야 함
    // 2. [alp,cop]에서 [alp_req,cop_req]로 가는 최단 시간을 구해야 함
    // 3. dp[i][j] : [목표알고력, 목표코딩력]이 되는 최단 시간
    
    // 4,7,8,10번 런타임 에러 -> 초기값 세팅 에러
    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        val maxAlp = problems.maxOf { it[0] }
        val maxCop = problems.maxOf { it[1] }

        if (alp >= maxAlp && cop >= maxCop) {
            return 0
        }

        // DP 배열의 값은 제일 큰 값으로 초기화하고 초기 알고력/코딩력은 0으로 초기화
        val dp = Array(maxAlp + 1){ Array(maxCop + 1){ Integer.MAX_VALUE } }
        val initA = if (alp > maxAlp) maxAlp else alp
        val initC = if (cop > maxCop) maxCop else cop
        dp[initA][initC] = 0

        for (i in initA .. maxAlp) {
            for (j in initC .. maxCop) {
                if (i+1 <= maxAlp) { // 알고리즘 공부 -> 알고력 +1
                    dp[i+1][j] = if ( dp[i+1][j] > dp[i][j]+1 ) dp[i][j]+1 else dp[i+1][j]
                }
                if (j+1 <= maxCop) { // 코딩 공부 -> 코딩력 +1
                    dp[i][j + 1] = if (dp[i][j + 1] > dp[i][j] + 1) dp[i][j] + 1 else dp[i][j + 1]
                }

                problems.forEach { // 코딩테스트 문제 공부
                    if (i >= it[0] && j >= it[1]) {
                        val alpIndex = if ( i+it[2] > maxAlp ) maxAlp else i+it[2]
                        val copIndex = if ( j+it[3] > maxCop ) maxCop else j+it[3]

                        dp[alpIndex][copIndex] =
                            if ( dp[alpIndex][copIndex] > dp[i][j]+it[4])  dp[i][j]+it[4]
                            else dp[alpIndex][copIndex]
                    }
                }
            }
        }

        return dp[maxAlp][maxCop]
    }
}

fun main() {
    println(StudyingForCodingTest().solution(10, 10, arrayOf(intArrayOf(10,15,2,1,2), intArrayOf(20,20,3,3,4)))) // 정답: 15
    println(StudyingForCodingTest().solution(0, 0, arrayOf(intArrayOf(0,0,2,1,2), intArrayOf(4,5,3,1,2), intArrayOf(4,11,4,0,2), intArrayOf(10,4,0,4,2)))) // 정답: 13
    println(StudyingForCodingTest().solution(12, 0, arrayOf(intArrayOf(0,0,2,1,2), intArrayOf(4,5,3,1,2), intArrayOf(4,11,4,0,2), intArrayOf(10,4,0,4,2)))) // 정답: 13
}