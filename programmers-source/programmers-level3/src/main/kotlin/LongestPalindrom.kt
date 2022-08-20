package src.main.kotlin

/**
 * Date     : 2022-08-15-MON
 * Title    : 가장 킨 팰린드롬
 * Url      : https://school.programmers.co.kr/learn/courses/30/lessons/12904
 * Description
 * 문제 설명
 *  앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
 *  문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.
 *
 *  예를들면, 문자열 s가 "abcdcba"이면 7을 return하고 "abacde"이면 3을 return합니다.
 *
 * 제한사항
 *  문자열 s의 길이 : 2,500 이하의 자연수
 *  문자열 s는 알파벳 소문자로만 구성
 */
class LongestPalindrom {

    /**
     * @param 입력받은 영어 문자
     * 내 이름은 이효리 거꾸로 해도 이효리 를 찾아라 ?!
     */

    fun solution1(s: String): Int {
        /*
        통과는 했으나 너무 그지같이 작성해서인지 효율성 점수 0점
         */
        var answer = 0

        for (i in 0..s.length) {
            for (j in i..s.length) {
                val pLength = palindrom1(s.substring(i, j))
                if (pLength > answer) {
                    answer = pLength
                }
            }
        }

        return answer
    }

    // 효율성 0점
    private fun palindrom1(s: String): Int {
        val size = s.length
        val midIndex: Int = s.length / 2
        if (s.length %2 == 0) {
            val s1 = s.substring(0, midIndex)
            val s2 = s.substring(s.length/2, size).reversed()
            if (s1 == s2) {
                return size
            }
        } else {
            val s1 = s.substring(0 , midIndex)
            val s2 = s.substring(midIndex+1, size).reversed()
            if (s1 == s2) {
                return size
            }
        }
        return 0
    }

    fun solution2(s: String): Int {
        var answer = 1

        for (i in 0..s.length) {
            for (j in i+2..s.length) {
                val pLength = palindrom2(s.substring(i, j))
                if (pLength > answer) {
                    answer = pLength
                }
            }
        }

        return answer
    }

    private fun palindrom2(s: String): Int {
        val char = s.toCharArray()
        val midIndex: Int = s.length / 2
        var correct = true

        if (s.length <= 1) return 0

        for (i in 0 until midIndex) {
            if (char[i] != char[s.length-1-i]) {
                correct = false
                break
            }
        }

        return if (correct) s.length else 0
    }

    // 17,18 문제 실패
    // 한 글자는 무시했는데, 한글자여도 1 리턴해야함
    // 시간 초과
    fun solution3(s: String): Int {
        var answer = 1

        for (i in 0..s.length-2) {
            val pLength = palindrom3(s, i, i+2, answer)
            if (pLength > answer) {
                answer = pLength
            }
        }

        return answer
    }
    
    private fun palindrom3(s: String, startIndex: Int, endIndex: Int, pLength: Int): Int {
        val char = s.substring(startIndex, endIndex).toCharArray()
        val midIndex: Int = char.size / 2
        var correct = true

        for (index in 0 until midIndex) {
            if (char[index] != char[char.size-1-index]) {
                correct = false
                break
            }
        }

        val length = if (correct && s.length > pLength) char.size else pLength

        return if (endIndex < s.length) {
            palindrom3(s, startIndex, endIndex+1, length)
        } else {
            length
        }
    }

    // 효율성2 에서 실패
    lateinit var charArray: CharArray
    fun solution4(s: String): Int {
        var answer = 1
        charArray = s.toCharArray()

        for (i in 0..s.length-2) {
            val pLength = palindrom4(i, i+1, answer)
            if (pLength > answer) {
                answer = pLength
            }
        }

        return answer
    }

    private fun palindrom4(startIndex: Int, endIndex: Int, pLength: Int): Int {
        val size = endIndex - startIndex + 1
        val midIndex: Int = size / 2
        var correct = true

        for (index in 0 until midIndex) {
            if (charArray[index+startIndex] != charArray[endIndex - index]) {
                correct = false
                break
            }
        }

        val length = if (correct && size > pLength) size else pLength

        return if (size < charArray.size-startIndex) {
            palindrom4(startIndex, endIndex+1, length)
        } else {
            length
        }
    }

    // 통과!!!
    private lateinit var inputText: String
    private var answer = 1
    fun solution5(s: String): Int {
        inputText = s

        for (i in 0..s.length-2) {
            palindrom5(i, i+1)
        }

        return answer
    }

    private fun palindrom5(startIndex: Int, endIndex: Int) {
        val size = endIndex - startIndex + 1
        val midIndex: Int = size / 2
        var correct = true

        if (size > answer) {
            for (index in 0 until midIndex) {
                if (inputText[index + startIndex] != inputText[endIndex - index]) {
                    correct = false
                    break
                }
            }

            if (correct && size > answer) {
                answer = size
            }
        }

        if (size < inputText.length-startIndex) {
            palindrom5(startIndex, endIndex+1)
        }
    }
}

fun main() {
    val sample = LongestPalindrom()
//    println(sample.solution1("abcdcba"))
//    println(sample.solution2("abcdcba"))
//    println(sample.solution4("abcdcdcbacdcabcdefgfedcbcdeabaabaaba"))
//    println(sample.solution4("abacde"))
//    println(sample.solution4("abccba"))
//    println(sample.solution3("abacad"))
//    println(sample.solution3("abcde"))
//    println(sample.solution4("abbb"))
//    println(sample.solution5("abbb"))
    println(sample.solution5("abcdcdcbacdcabcdefgfedcbcdeabaabaaba"))
}