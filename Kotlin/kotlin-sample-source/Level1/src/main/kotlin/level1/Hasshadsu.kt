package level1

class Hasshadsu {
    fun solution(x: Int): Boolean {
        var sum = 0
        for (num in x.toString())
            sum += num.toString().toInt()
        return x % sum == 0
    }
}