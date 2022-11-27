package src.main.kotlin

import java.lang.Integer.min
import kotlin.collections.ArrayList
import kotlin.math.abs


/**
 * Title: 숫자 타자 대회
 * Url: https://school.programmers.co.kr/learn/courses/30/lessons/136797
 */
class NumberTypingContest {
    fun solution(numbers: String): Int {
        var answer = Int.MAX_VALUE

        var weights = ArrayList<Triple<Int, IntArray, IntArray>>()
        weights.add(Triple(0, intArrayOf(1,0), intArrayOf(1,2)))

        numbers.forEachIndexed { index, c ->
            val subWeights = ArrayList<Triple<Int, IntArray, IntArray>>()

            while (weights.isNotEmpty()) {
                val w = weights[0]
                weights.removeAt(0)

                val leftWeight = key(c.toString().toInt(), w.second)
                val rightWeight = key(c.toString().toInt(), w.third)

                if (index == numbers.lastIndex) {
                    val max = if (leftWeight.first <= rightWeight.first) leftWeight.first
                    else rightWeight.first
                    if (w.first + max < answer) answer = w.first + max
                } else {
                    if (leftWeight.first == 1) {
                        subWeights.add(Triple(w.first + leftWeight.first, leftWeight.second, w.third))
                    } else if (rightWeight.first == 1) {
                        subWeights.add(Triple(w.first + rightWeight.first, w.second, rightWeight.second))
                    } else {
                        subWeights.add(Triple(w.first + leftWeight.first, leftWeight.second, w.third))
                        subWeights.add(Triple(w.first + rightWeight.first, w.second, rightWeight.second))
                    }
                }
            }

            weights = subWeights
        }

        return answer
    }

    private fun key(number: Int, hand: IntArray): Pair<Int, IntArray> {
        val position = when (number) {
            1 -> intArrayOf(0,0)
            2 -> intArrayOf(0,1)
            3 -> intArrayOf(0,2)
            4 -> intArrayOf(1,0)
            5 -> intArrayOf(1,1)
            6 -> intArrayOf(1,2)
            7 -> intArrayOf(2,0)
            8 -> intArrayOf(2,1)
            9 -> intArrayOf(2,2)
            else -> intArrayOf(3,1)
        }

        val weight = when (position[0]) {
            hand[0] -> {
                when (abs(position[1]-hand[1])) {
                    0 -> 1
                    1 -> 2
                    2 -> 4
                    else -> 0
                }
            }
            hand[0]+1, hand[0]-1 -> {
                when (abs(position[1]-hand[1])) {
                    0 -> 2
                    1 -> 3
                    2 -> 5
                    else -> 0
                }
            }
            hand[0]+2, hand[0]-2 -> {
                when (abs(position[1]-hand[1])) {
                    0 -> 4
                    1 -> 5
                    2 -> 6
                    else -> 0
                }
            }
            hand[0]+3, hand[0]-3 -> {
                when (abs(position[1]-hand[1])) {
                    0 -> 6
                    1 -> 7
                    else -> 0
                }
            }
            else -> 0
        }

        return Pair(weight, position)
    }

    fun solution2(numbers: String): Int {
        var answer = Int.MAX_VALUE

        val map = arrayOf(
            arrayOf(1, 7, 6, 7, 5, 4, 5, 3, 2, 3),
            arrayOf(7, 1, 2, 4, 2, 3, 5, 4, 5, 6),
            arrayOf(6, 2, 1, 2, 3, 2, 3, 5, 4, 5),
            arrayOf(7, 4, 2, 1, 5, 3, 2, 6, 5, 4),
            arrayOf(5, 2, 3, 5, 1, 2, 4, 2, 3, 5),
            arrayOf(4, 3, 2, 3, 2, 1, 2, 3, 2, 3),
            arrayOf(5, 5, 3, 2, 4, 2, 1, 5, 3, 2),
            arrayOf(3, 4, 5, 6, 2, 3, 5, 1, 2, 4),
            arrayOf(2, 5, 4, 5, 3, 2, 3, 2, 1, 2),
            arrayOf(3, 6, 5, 4, 5, 3, 2, 4, 2, 1),
        )

        var weights = Array(10) { Array<Int?>(10) {null} }
        weights[4][6] = 0

        numbers.forEachIndexed { index, c ->
            val subWeights = Array(10) { Array<Int?>(10) { null } }
            val num = c.toString().toInt()

            weights.forEachIndexed { left, ints ->
                ints.forEachIndexed { right, i ->
                    if (i != null) {
                        if (index == numbers.lastIndex) {
                            val max =
                                if (map[left][num] <= map[right][num]) map[left][num]
                                else map[right][num]
                            if (i + max < answer) answer = i + max
                        } else {
                            if (left == num) {
                                val weight = i + 1
                                if (subWeights[num][right] != null) {
                                    subWeights[num][right] = min(subWeights[num][right]!!, weight)
                                } else {
                                    subWeights[num][right] = weight
                                }
                            } else if (right == num) {
                                val weight = i + 1
                                if (subWeights[left][num] != null) {
                                    subWeights[left][num] = min(subWeights[left][num]!!, weight)
                                } else {
                                    subWeights[left][num] = weight
                                }
                            } else {
                                val leftWeight = i + map[left][num]
                                if (subWeights[num][right] != null) {
                                    subWeights[num][right] = min(subWeights[num][right]!!, leftWeight)
                                } else {
                                    subWeights[num][right] = leftWeight
                                }

                                val rightWeight = i + map[right][num]
                                if (subWeights[left][num] != null) {
                                    subWeights[left][num] = min(subWeights[left][num]!!, rightWeight)
                                } else {
                                    subWeights[left][num] = rightWeight
                                }
                            }
                        }
                    }
                }
            }

            weights = subWeights
        }

        return answer
    }
}

private fun main() {
    println(NumberTypingContest().solution2("1756")) // 10 => 왼손 17, 오른손 56 :: 2+2+2 + 2+2
    println(NumberTypingContest().solution2("5123")) // 8 => 왼손 123, 오른손 5 :: 2+2+2 + 2+2
    println(NumberTypingContest().solution2("13000")) // 13 => 2+2+7+1+1

}