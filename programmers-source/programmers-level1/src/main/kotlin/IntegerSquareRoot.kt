package level1



class IntegerSquareRoot {
    fun solution(n: Long): Long {
        val sqrt = kotlin.math.sqrt(n.toDouble()).toLong()
        return if (sqrt*sqrt == n) (sqrt+1)*(sqrt+1)
            else -1
    }
}