package level1

/**
 * 고려사항
 * 1. 체육복 여분을 가져온 학생이 도난당할 수 있다.
 * 2. lost와 reserve를 정렬한다.
 */

class GymSuit {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val studentSet: MutableSet<Int> = mutableSetOf()
        val rentSet: MutableSet<Int> = mutableSetOf()

        for (i in 1..n)         {   studentSet.add(i)       }
        lost.sorted().filter    {   studentSet.remove(it)
                                    rentSet.add(it)         }
        reserve.sorted().filter {   studentSet.add(it)      }

        for (res in reserve.sorted()) {
            for (lo in lost.sorted()) {
                if (kotlin.math.abs(res-lo) == 1
                    && !rentSet.contains(res)
                    && !studentSet.contains(lo)) {
                    rentSet.add(res)
                    studentSet.add(lo)
                }
            }
        }

        return studentSet.size
    }
}