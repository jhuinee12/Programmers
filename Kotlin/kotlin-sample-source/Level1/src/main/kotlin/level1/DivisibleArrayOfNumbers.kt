package level1

class DivisibleArrayOfNumbers {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer: IntArray = arr.filter { it % divisor == 0 }.toIntArray()
        answer.sort()
        return if (answer.isEmpty()) intArrayOf(-1)
            else answer
    }
}