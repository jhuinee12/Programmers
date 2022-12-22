package src.main.kotlin

/**
 * Title: 110 옮기기
 * Url: https://school.programmers.co.kr/learn/courses/30/lessons/77886
 *
 * 사전순으로 0 > 1
 */
class MoveOneOneZero {
    fun solution(s: Array<String>): Array<String> {
        val answer: ArrayList<String> = arrayListOf()

        s.forEach {
            var delzzo = it
            var zzo = ""
            var zeroIdx: Int

            val stack = arrayListOf<Char>()
            val str = StringBuffer()

            while (true) {
                var isPop = false
                zeroIdx = -1

                delzzo.forEach { c ->
                    stack.add(c)
                    val index = stack.lastIndex
                    if (index >= 2) {
                        if ("${stack[index-2]}${stack[index-1]}${stack[index]}" == "110") {
                            stack.removeLast()
                            stack.removeLast()
                            stack.removeLast()

                            zzo += "110"

                            isPop = true
                        } else {
                            if (c == '0') zeroIdx = index
                        }
                    } else {
                        if (c == '0') zeroIdx = index
                    }
                }

                delzzo = String(stack.toCharArray())

                if (isPop) stack.clear()
                else break
            }

            if (zeroIdx == -1) {
                answer.add(zzo + delzzo)
            } else {
                str.append(delzzo)
                str.insert(zeroIdx+1, zzo)
                answer.add(str.toString())
            }
        }

        return answer.toTypedArray()
    }
}

private fun main() {
    println(MoveOneOneZero().solution(arrayOf("1110","100111100","0111111010")).toCollection(arrayListOf()).joinToString()) // 정답: "1101","100110110","0110110111"
    println(MoveOneOneZero().solution(arrayOf("1011110","01110","101101111010")).toCollection(arrayListOf()).joinToString()) // 정답: "1011011","01101","101101101101"
    println(MoveOneOneZero().solution(arrayOf("101101111010")).toCollection(arrayListOf()).joinToString()) // 정답: "101101101101"
    println(MoveOneOneZero().solution(arrayOf("1100111011101001")).toCollection(arrayListOf()).joinToString()) // 정답: "0101101101101101"
}