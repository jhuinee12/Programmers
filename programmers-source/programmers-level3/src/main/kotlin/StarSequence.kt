package src.main.kotlin

class StarSequence {
    fun solution(a: IntArray): Int {
        if (a.size < 2) return 0

        var answer = 0

        val array = Array(500000) { ArrayList<Int>() }

        a.forEachIndexed { idx, i ->
            if (answer > array[i].size+a.size-idx) return@forEachIndexed // 시간초과 방지

            when (idx) {
                0 -> if (a[idx+1] != i) {
                    array[i].add(idx)
                    array[i].add(idx+1)
                }
                a.size-1 -> if (a[idx-1] != i && !array[i].contains(idx-1)) {
                    array[i].add(idx)
                    array[i].add(idx-1)
                }
                else -> {
                    if (a[idx-1] != i && !array[i].contains(idx-1)) {
                        array[i].add(idx-1)
                        array[i].add(idx)
                    } else if (a[idx+1] != i && !array[i].contains(idx+1)) {
                        array[i].add(idx)
                        array[i].add(idx+1)
                    }
                }
            }
            if (array[i].size % 2 == 0 && answer < array[i].size) {
                answer = array[i].size
            }
        }

        return answer
    }
}

private fun main() {
    println(StarSequence().solution(intArrayOf(0))) // 0
    println(StarSequence().solution(intArrayOf(5,2,3,3,5,3))) // 4 :: [5,2,5,3], [5,3,3,5]
    println(StarSequence().solution(intArrayOf(0,3,3,0,7,2,0,2,2,0))) // 8 :: [0,3,3,0,7,0,2,0]
    println(StarSequence().solution(intArrayOf(0,3,0,3,3,2,3,2,2,0,0,0,0,0,0,3,0,0,3))) // 12 :: 3기준!! [0,3],[0,3],[3,2],[3,2],[0,3],[0,3]
    println(StarSequence().solution(intArrayOf(1,1,1,1,1,2,1,2,3,2,4))) // 6 :: 2기준!! [1,2],[1,2],[3,2]
}