package level1

class NumbersToReverseArray {
/*    fun solution(n: Long): IntArray? {
        var n = n
        val a = "" + n
        val answer = IntArray(a.length)
        var cnt = 0
        while (n > 0) {
            answer[cnt] = (n % 10).toInt()
            n /= 10
            cnt++
        }
        return answer
    }*/

    fun solution(n: Long): IntArray {
        val answer = IntArray(n.toString().length)
        var number = n
        for (i in n.toString().indices) {
            answer[i] = (number%10).toInt()
            number /= 10
        }
        return answer
    }
}