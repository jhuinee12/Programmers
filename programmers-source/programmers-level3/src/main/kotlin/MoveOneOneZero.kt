package src.main.kotlin

import java.lang.StringBuilder
import kotlin.collections.ArrayList

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
            var new = it

            while (true) {
                if (new.contains("110")) {
                    new = new.replace("110", "")
                } else {
                    break
                }
            }

            val count = (it.length - new.length)/3
            val str = StringBuilder()

            for (i in 0 until count) {
                var cont = 0
                var append = false

                for (j in 0..new.lastIndex) {
                    val value = new[j]
                    str.append(value)

                    if (!append) {
                        if (value == '0') cont = 0
                        else cont++

                        if (cont == 2) {
                            str.insert(j-1, "110")
                            append = true
                        } else if (j == new.lastIndex) {
                            when (cont) {
                                0 -> {
                                    str.append("110")
                                }
                                1 -> {
                                    str.insert(j, "110")
                                    append = true
                                }
                            }
                        }
                    }
                }

                new = str.toString()
                str.clear()
            }

            answer.add(new)
        }

        return answer.toTypedArray()
    }

    /*fun solution(s: Array<String>): Array<String> {
        val answer: ArrayList<String> = arrayListOf()

        s.forEach {
            var new = replace(it)

            val count = (it.length - new.length)/3
            val str = StringBuilder()

            for (i in 0 until count) {
                var cont = 0
                var append = false

                for (j in 0..new.lastIndex) {
                    val value = new[j]
                    str.append(value)

                    if (!append) {
                        if (value == '0') cont = 0
                        else cont++

                        if (cont == 2) {
                            str.insert(j-1, "110")
                            append = true
                        } else if (j == new.lastIndex) {
                            when (cont) {
                                0 -> {
                                    str.append("110")
                                }
                                1 -> {
                                    str.insert(j, "110")
                                    append = true
                                }
                            }
                        }
                    }
                }

                new = str.toString()
                str.clear()
            }

            answer.add(new)
        }

        return answer.toTypedArray()
    }

    private fun replace(s: String): String {
        var newString = s
        val stack = arrayListOf<Char>()

        while (true) {
            var isPop = false

            newString.forEach { c ->
                stack.add(c)
                if (stack.size > 2) {
                    val index = stack.lastIndex
                    if ("${stack[index-2]}${stack[index-1]}${stack[index]}" == "110") {
                        stack.removeLast()
                        stack.removeLast()
                        stack.removeLast()

                        isPop = true
                    }
                }
            }

            newString = String(stack.toCharArray())

            if (isPop) stack.clear()
            else return newString
        }
    }*/
}

private fun main() {
//    println(MoveOneOneZero().solution(arrayOf("1110","100111100","0111111010"))) // 정답: "1101","100110110","0110110111"
//    println(MoveOneOneZero().solution(arrayOf("1011110","01110","101101111010"))) // 정답: "1011011","01101","101101101101"
//    println(MoveOneOneZero().solution(arrayOf("101101111010"))) // 정답: "101101101101"
    println(MoveOneOneZero().solution(arrayOf("1100111011101001"))) // 정답: "0101101101101101"
}