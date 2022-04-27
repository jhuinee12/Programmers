> 최초작성 : 2022.04.27

## **Level1 - 모의고사 (java/kotlin)**

[코딩테스트 연습 - 모의고사](https://programmers.co.kr/learn/courses/30/lessons/42840)

| **문제 설명** |
| --- |
| 수포자는 수학을 포기한 사람의 준말입니다.<br>수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.<br>수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.|
|1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...<br>2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...<br>3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...|
|1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,<br>가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요. |

| **제한 조건** |
| --- |
|   -   시험은 최대 10,000 문제로 구성되어있습니다.|
|   -   문제의 정답은 1, 2, 3, 4, 5중 하나입니다. |
|   -   가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.   |

| **​입출력 예**    |  |
| --- | --- |
| answer | return |
| \[1,2,3,4,5\] | \[1\] |
| \[1,3,2,4,2\] | \[1,2,3\] |

|입출력 예#1|
|---|
|- 수포자 1은 모든 문제를 맞혔습니다.|
|- 수포자 2는 모든 문제를 틀렸습니다.|
|- 수포자 3은 모든 문제를 틀렸습니다.|
|따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.|

|입출력 예#2|
|---|
|모든 사람이 2문제씩을 맞췄습니다.|

### **_나의 풀이_**

1\. 학생 1,2,3의 찍기 방법을 각각 배열에 저장한다.

2\. 학생 1,2,3의 정답 개수를 체크하기 위한 배열을 생성한다.

3\. 정답 answers와 비교하여 정답인 경우 (2)배열의 값을 올린다.

4\. 정답 개수가 (2)배열의 max값과 같은 학생을 배열에 담아 리턴한다.

```kt
class Solution {
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
```

<center>

|정답을 리턴할 때, filter를 사용하여 배열로 뽑아내고 싶었다.<br>하지만 value값이 아닌 index를 filter하는 방법을 몰라 결국 포기했다...<br>그냥 가장 베이직한 방법을 사용하여 리턴...|
|---|

</center>

### **_Kotlin1 코드 정리_**

1\. 학생 1,2,3의 찍기 방법을 각각 배열에 저장한다.

2\. 학생 1,2,3의 방법과 정답을 비교하기 위한 index를 각각의 변수 x,y,z에 선언한다.

3\. 학생 학생의 정답의 개수와 학생 번호를 <key,value>쌍으로 묶어 저장하는 map을 생성한다.

4\. map에서 max를 구하여 max와 일치하지 않는 값을 제거한다.

5\. map에서 key를 intArray로 형변환하여 리턴한다.

```kt
class Solution {
    fun solution(answers: IntArray): IntArray {
        var supo1 = intArrayOf(1,2,3,4,5)
        var supo2 = intArrayOf(2,1,2,3,2,4,2,5)
        var supo3 = intArrayOf(3,3,1,1,2,2,4,4,5,5)
        var x = 0; var y = 0; var z = 0

        var map = mutableMapOf<Int,Int>(Pair(1,0),Pair(2,0),Pair(3,0))
        for(i in answers) {
            if(i == supo1[x]) map.put(1,map[1]!! + 1)
            if(i == supo2[y]) map.put(2,map[2]!! + 1)
            if(i == supo3[z]) map.put(3,map[3]!! + 1)
            x = if(x < 4) x + 1 else 0
            y = if(y < 7) y + 1 else 0
            z = if(z < 9) z + 1 else 0
        }

        var max = map.maxBy({it.value})?.value
        for(i in 1..map.size) if(map[i] != max) map.remove(i)
        var answer = map.toList().sortedWith(compareBy({it.second})).toMap().keys.toIntArray()

        return answer
    }
}
```

<center>

|kotlin으로 문제를 풀이한 사람들 중 대부분이 비슷한 방식이다.|
|---|

</center>