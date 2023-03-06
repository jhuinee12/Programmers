package src.main.kotlin

/**
 * @build_frame = [x,y,a,b]
 *      x,y = 좌표
 *      a = 종류 :: 0 기둥 / 1 보
 *      b = 0 삭제 / 1 설치
 *
 * @result = [x,y,a]
 *      x,y = 좌표
 *      a = 종류 :: 0 기둥 / 1 보
 */
class `ALG-P-0034_기둥과_보_설치` {
    private lateinit var frame: Array<Array<Array<Int?>>>
    private var range: Int = 1

    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        val answer = arrayListOf<IntArray>()

        range = n

        frame = Array(n+1) { Array(n+1) { Array(n+1) { null } } }

        build_frame.forEach {
            val x = it[0]
            val y = it[1]
            val a = it[2]

            when (it[3]) {
                0 -> canDelete(x, y, a)
                1 -> when (a) {
                    0 -> canInstallPillar(x, y)
                    1 -> canInstallPaper(x, y)
                }
            }
        }

        frame.forEachIndexed { x, first ->
            first.forEachIndexed { y, second ->
                second.forEachIndexed { a, i ->
                    i?.let {
                        answer.add(intArrayOf(x,y,a))
                    }
                }
            }
        }

        return answer.toTypedArray()
    }

    private fun canInstallPillar(x: Int, y: Int, isCheck: Boolean = false): Boolean {
        var isInstall = false

        if (y == 0) {
            isInstall = true
        } else if (y in 1 until range)  {
            if (frame[x][y-1][0] != null || frame[x][y][1] != null) {
                isInstall = true
            } else if (x > 0) {
                if (frame[x-1][y][1] != null) {
                    isInstall = true
                }
            }
        }

        if (isInstall && !isCheck) frame[x][y][0] = 1

        return isInstall
    }

    private fun canInstallPaper(x: Int, y: Int, isCheck: Boolean = false): Boolean {
        var isInstall = false

        if (y != 0 && x in 0 until range) {
            if (frame[x][y-1][0] != null || frame[x+1][y-1][0] != null) {
                isInstall = true
            } else if (x>0) {
                if ((frame[x-1][y][1] != null && frame[x+1][y][1] != null)) {
                    isInstall = true
                }
            }
        }

        if (isInstall && !isCheck) frame[x][y][1] = 1

        return isInstall
    }

    private fun canDelete(x: Int, y: Int, value: Int) {
        frame[x][y][value] = null

        run loop@ {
            frame.forEachIndexed { i, first ->
                first.forEachIndexed { j, second ->
                    second.forEachIndexed { a, b ->
                        b?.let {
                            val isBoolean = when (a) {
                                0 -> canInstallPillar(i, j, true)
                                1 -> canInstallPaper(i, j, true)
                                else -> true
                            }

                            if (!isBoolean) {
                                frame[x][y][value] = 1
                                return@loop
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun main() {
    println(`ALG-P-0034_기둥과_보_설치`().solution(
        5,
        arrayOf(intArrayOf(1,0,0,1),intArrayOf(1,1,1,1),intArrayOf(2,1,0,1),intArrayOf(2,2,1,1),intArrayOf(5,0,0,1),intArrayOf(5,1,0,1),intArrayOf(4,2,1,1),intArrayOf(3,2,1,1)))
    ) // [[1,0,0],[1,1,1],[2,1,0],[2,2,1],[3,2,1],[4,2,1],[5,0,0],[5,1,0]]
    println(`ALG-P-0034_기둥과_보_설치`().solution(
        5,
        arrayOf(intArrayOf(0,0,0,1),intArrayOf(2,0,0,1),intArrayOf(4,0,0,1),intArrayOf(0,1,1,1),intArrayOf(1,1,1,1),intArrayOf(2,1,1,1),intArrayOf(3,1,1,1),intArrayOf(2,0,0,0),intArrayOf(1,1,1,0),intArrayOf(2,2,0,1)))
    ) //[[0,0,0],[0,1,1],[1,1,1],[2,1,1],[3,1,1],[4,0,0]]
    println(`ALG-P-0034_기둥과_보_설치`().solution(
        100,
        arrayOf(intArrayOf(2, 0, 0, 1), intArrayOf(100, 0, 0, 1), intArrayOf(100, 1, 1, 1), intArrayOf(99, 1, 1, 1), intArrayOf(99, 1, 0, 1), intArrayOf(99, 0, 0, 1)))
    ) //[[2, 0, 0], [99, 0, 0], [99, 1, 0], [99, 1, 1], [100, 0, 0]]
}