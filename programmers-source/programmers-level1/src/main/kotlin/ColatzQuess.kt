package level1

class ColatzQuess {
    fun solution(num: Int): Int {
        // num*3 +1 에서 int의 범위를 넘어가는 경우 발생
        // num을 long으로 바꿔줌
        var num = num.toLong()
        var cnt = 0
        while (num != 1.toLong()) {
            if (cnt <500) {
                if (num % 2.toLong() == 0.toLong()) num /= 2
                else num = num * 3 + 1
            } else {
                return -1
            }
            cnt++
        }
        return cnt
    }
}