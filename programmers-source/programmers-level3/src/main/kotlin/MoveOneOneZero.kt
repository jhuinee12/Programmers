package src.main.kotlin

import java.util.*

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
            var zzo = ""
            var zeroIdx = -1

            val new = arrayListOf<Char>()
            val str = StringBuffer()

            it.forEach { c ->
                new.add(c)
                val index = new.lastIndex
                if (c == '0') {
                    if (index >= 2 && new[index-2] == '1' && new[index-1] == '1') {
                        new.removeLast()
                        new.removeLast()
                        new.removeLast()
                        zzo += "110"
                    } else {
                        zeroIdx = index
                    }
                }
            }

            if (zeroIdx == -1) {
                answer.add(zzo + new.joinToString(""))
            } else {
                str.append(new.joinToString(""))
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