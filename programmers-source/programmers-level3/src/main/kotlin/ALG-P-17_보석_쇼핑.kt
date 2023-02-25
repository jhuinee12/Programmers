package src.main.kotlin

class `ALG-P-17_보석_쇼핑` {
    val leftCount = mutableMapOf<String,Int>()
    val rightCount = mutableMapOf<String,Int>()

    lateinit var gems: Array<String>

    fun solution(gems: Array<String>): IntArray {
        val idxs = intArrayOf(1, gems.size, 1, gems.size)

        this.gems = gems.clone()

        gemsCount()

        idxs[1] = left(leftCount)
        idxs[0] = right(leftCount)
        idxs[2] = right(rightCount)
        idxs[3] = left(rightCount)

        return if (idxs[1] - idxs[0] <= idxs[3] - idxs[2]) intArrayOf(idxs[0], idxs[1])
        else intArrayOf(idxs[2], idxs[3])
    }

    private fun gemsCount() {
        gems.forEach {
            val lc = leftCount[it]
            if (lc != null) leftCount[it] = lc+1
            else leftCount[it] = 1

            val rc = rightCount[it]
            if (rc != null) rightCount[it] = rc+1
            else rightCount[it] = 1
        }
    }

    private fun left(map: MutableMap<String,Int>): Int {
        for (i in gems.size-1 downTo 0) {
            val count = map[gems[i]]!!
            if (count == 1) {
                return i+1
            } else {
                map[gems[i]] = count-1
            }
        }
        return 0
    }

    private fun right(map: MutableMap<String,Int>): Int {
        for (i in gems.indices) {
            val count = map[gems[i]]!!
            if (count == 1) {
                return i+1
            } else {
                map[gems[i]] = count-1
            }
        }
        return 0
    }
}

private fun main() {
    println(`ALG-P-17_보석_쇼핑`().solution(arrayOf("DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA")).joinToString(",")) // 정답: [3,7]
    println(`ALG-P-17_보석_쇼핑`().solution(arrayOf("AA", "AB", "AC", "AA", "AC")).joinToString(",")) // 정답: [1,3]
    println(`ALG-P-17_보석_쇼핑`().solution(arrayOf("XYZ", "XYZ", "XYZ")).joinToString(",")) // 정답: [1,1]
    println(`ALG-P-17_보석_쇼핑`().solution(arrayOf("ZZZ", "YYY", "NNNN", "YYY", "BBB")).joinToString(",")) // 정답: [1,5]
    println(`ALG-P-17_보석_쇼핑`().solution(arrayOf("RUBY", "DIA", "RUBY", "RUBY", "EMERALD", "SAPPHIRE", "SAPPHIRE", "DIA", "DIA", "RUBY", "EMERALD", "SAPPHIRE")).joinToString(",")) // 정답: [9,12]
}