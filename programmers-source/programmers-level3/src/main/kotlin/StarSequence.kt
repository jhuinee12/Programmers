package src.main.kotlin

class StarSequence {
    /**
     * 원래 시간초과(14-15번) 났던 이유 :: index의 이동과정을 알기 위해 contains를 사용했음.
     * 굳이 contains를 사용할 필요 없이 가장 마지막 배열의 요소를 확인하면 됨.
     *
     * 풀이
     * 1. a의 사이즈만큼의 이중 배열 array를 생성함 (index의 이동을 저장하기 위함)
     * 2. a의 요소를 확인하는 반복문 생성
     * 3. 조건문
     *  - 현재 index가 0(제일 앞)인 경우
     *    - array[현재요소]에 현재 index와 다음 index 추가
     *  - 현재 index가 last인 경우
     *    - (이전 index가 추가되어 있지 않은 경우!!) array[현재요소]에 현재 index와 이전 index 추가
     *  - 그 외
     *    - (다음 index가 추가되어 있지 않은 경우!!) array[현재요소]에 현재 index와 다음 index 추가
     *    - (이전 index가 추가되어 있지 않은 경우!!) array[현재요소]에 현재 index와 이전 index 추가
     * 4. array[현재요소]의 크기가 짝수이고 answer보다 큰 경우 asnwer를 바꿔줌
     */
    fun solution(a: IntArray): Int {
        if (a.size < 2) return 0

        var answer = 0

        val array = Array(a.size) { ArrayList<Int>() }

        a.forEachIndexed { idx, i ->
            if (answer > array[i].size+a.size-idx) return@forEachIndexed // 시간초과 방지

            val lastIndex = if (array[i].size != 0) array[i][array[i].size-1] else -1
            when (idx) {
                0 -> if (a[idx+1] != i) {
                    array[i].add(idx)
                    array[i].add(idx+1)
                }
                a.size-1 -> if (a[idx-1] != i && lastIndex != idx-1) {
                    array[i].add(idx)
                    array[i].add(idx-1)
                }
                else -> {
                    if (a[idx-1] != i && lastIndex != idx-1) {
                        array[i].add(idx-1)
                        array[i].add(idx)
                    } else if (a[idx+1] != i && lastIndex != idx+1) {
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