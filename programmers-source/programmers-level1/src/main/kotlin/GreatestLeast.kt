package level1

class GreatestLeast {
    fun solution(n: Int, m: Int): IntArray {
        var answer = intArrayOf(0,0)

        /* n과 m의 크기를 비교하여 max와 min에 저장 */
        var max = if (n > m) n else m
        var min = if (n > m) m else n
        
        /* 반복문을 이용하여 나누어떨어지는 수 중 가장 큰 수 저장 */
        for (i in 1..min) if (min%i==0 && max%i==0)
            answer[0] = i

        /* 최소공배수 구하기 : n*m*최대공약수 */
        answer[1] = max * min / answer[0]

        return answer
    }
}