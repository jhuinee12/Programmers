package level1

class TwoPickPlus {
    fun solution(numbers: IntArray): IntArray {
        /**
         * 나의 소스코드
         */
//        var answer: IntArray = intArrayOf()
//
//        for (i in numbers.indices) {
//            for (j in numbers.indices) {
//                val ins = numbers[i] + numbers[j]
//                if (!answer.contains(ins) && i!=j) {
//                    answer += ins
//                }
//            }
//        }
//
//        return answer.sortedArray()

        /**
         * Kotlin 1 소스코드
         */
        val list = numbers.toList()

        return list.withIndex().flatMap { i -> list.withIndex().map { j -> i to j } }
            .filter { it.first.index != it.second.index }
            .map { it.first.value + it.second.value }
            .toSortedSet()
            .toIntArray()
    }
}