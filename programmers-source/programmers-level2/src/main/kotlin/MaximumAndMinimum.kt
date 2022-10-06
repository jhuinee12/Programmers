package main.kotlin

import java.util.Collections.max
import java.util.Collections.min

class MaximumAndMinimum {
    fun solution(s: String): String {
        val numbers = s.split(" ").map { it.toInt() }
        return "${min(numbers)} ${max(numbers)}"
    }
}

private fun main() {
    println(MaximumAndMinimum().solution("1 2 3 4"))
    println(MaximumAndMinimum().solution("-1 -2 -3 -4"))
    println(MaximumAndMinimum().solution("1 2 -3 -4"))
    println(MaximumAndMinimum().solution("-1 -1"))
    println(MaximumAndMinimum().solution("-1"))
    println(MaximumAndMinimum().solution("1000 123 12345"))
    println(MaximumAndMinimum().solution("11 21 31 41"))
}