package src.main.kotlin

import java.util.Stack

class EditTable {
    /**
     * U X : 현재 선택된 행에서 X칸 위에 있는 행 선택
     * D X : 현재 선택된 행에서 X칸 아래에 있는 행 선택
     * C   : 현재 선택한 행을 삭제한 후, 바로 아래 행 선택
     * Z   : 최근 삭제한 행 복구, 선택행은 그대로
     */

    private lateinit var table: BooleanArray
    private var removes = Stack<Int>()
    private var idx = 0

    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        var answer = ""

        idx = k

        table = BooleanArray(n) { true }

        cmd.forEach {
            val chars = it.split(" ")
            when (chars[0]) {
                "U" -> u(chars[1].toInt())
                "D" -> d(chars[1].toInt())
                "C" -> c()
                "Z" -> z()
            }
        }

        table.forEach {
            answer += if (it) "O" else "X"
        }

        return answer
    }

    private fun u(x: Int) {
        var i = 0
        while (i != x) {
            if (table[--idx]) i++
        }
    }

    private fun d(x: Int) {
        var i = 0
        while (i != x) {
            if (table[++idx]) i++
        }
    }

    private fun c() {
        removes.push(idx)
        table[idx] = false
        if (idx == table.lastIndex) idx-- else idx++
    }

    private fun z() {
        val revoke = removes.pop()
        table[revoke] = true
    }
}

private fun main() {
    println(EditTable().solution(8,2, arrayOf("D 2","C","U 3","C","D 4","C","U 2","Z","Z"))) // 정답: "OOOOXOOO"
    println(EditTable().solution(8,2, arrayOf("D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"))) // 정답: "OOXOXOOO"
    println(EditTable().solution(12,5, arrayOf("C","D 3","C","U 8","Z","C"))) // 정답: "XOOOOXOOOOOO"
}