package main.kotlin

import java.util.Collections.max
import java.util.Collections.min

class `ALG-P-9_최댓값과_최솟값` {
    fun solution(s: String): String {
        val numbers = s.split(" ").map { it.toInt() }
        return "${min(numbers)} ${max(numbers)}"
    }
}

private fun main() {
    println(`ALG-P-9_최댓값과_최솟값`().solution("1 2 3 4"))
    println(`ALG-P-9_최댓값과_최솟값`().solution("-1 -2 -3 -4"))
    println(`ALG-P-9_최댓값과_최솟값`().solution("1 2 -3 -4"))
    println(`ALG-P-9_최댓값과_최솟값`().solution("-1 -1"))
    println(`ALG-P-9_최댓값과_최솟값`().solution("-1"))
    println(`ALG-P-9_최댓값과_최솟값`().solution("1000 123 12345"))
    println(`ALG-P-9_최댓값과_최솟값`().solution("11 21 31 41"))
}