package level1

class MockTest {
    fun solution(answers: IntArray): IntArray {
        val students = mutableListOf<Int>()

        val studentA_answers = intArrayOf(1,2,3,4,5)
        val studentB_answers = intArrayOf(2,1,2,3,2,4,2,5)
        val studentC_answers = intArrayOf(3,3,1,1,2,2,4,4,5,5)

        val correctAnswersCount = intArrayOf(0,0,0)

        for (i in answers.indices) {
            val indexForStudentA = if (studentA_answers.size-1 < i) { i % studentA_answers.size } else { i }
            val indexForStudentB = if (studentB_answers.size-1 < i) { i % studentB_answers.size } else { i }
            val indexForStudentC = if (studentC_answers.size-1 < i) { i % studentC_answers.size } else { i }

            if (answers[i] == studentA_answers[indexForStudentA]) { correctAnswersCount[0] += 1 }
            if (answers[i] == studentB_answers[indexForStudentB]) { correctAnswersCount[1] += 1 }
            if (answers[i] == studentC_answers[indexForStudentC]) { correctAnswersCount[2] += 1 }
        }

        for (i in 0..2) {
            if (correctAnswersCount[i] == correctAnswersCount.maxOrNull()) {
                students.add(i+1)
            }
        }
        return students.toIntArray()
    }
}

class MockTest1 {
    fun solution(answers: IntArray): IntArray {
        val students = mutableListOf<Int>()

        val studentA_answers = intArrayOf(1,2,3,4,5)
        val studentB_answers = intArrayOf(2,1,2,3,2,4,2,5)
        val studentC_answers = intArrayOf(3,3,1,1,2,2,4,4,5,5)

        val correctAnswersCount = intArrayOf(0,0,0)

        for (i in answers.indices) {
            if (answers[i] == studentA_answers[i % studentA_answers.size]) { correctAnswersCount[0] += 1 }
            if (answers[i] == studentB_answers[i % studentB_answers.size]) { correctAnswersCount[1] += 1 }
            if (answers[i] == studentC_answers[i % studentC_answers.size]) { correctAnswersCount[2] += 1 }
        }

        for (i in 0..2) {
            if (correctAnswersCount[i] == correctAnswersCount.maxOrNull()) {
                students.add(i+1)
            }
        }
        return students.toIntArray()
    }
}