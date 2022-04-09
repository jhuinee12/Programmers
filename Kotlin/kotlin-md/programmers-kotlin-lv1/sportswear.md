> 최초작성 : 2022.01.20

## ******Level1 - 체육복**** (kotlin)**

 [코딩테스트 연습 - 체육복](https://programmers.co.kr/learn/courses/30/lessons/42862)

| **문제 설명** |
| --- |
| 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.<br>다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.<br>학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.<br>예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.<br>체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.<br>전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,<br>여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,<br>체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요. |

| **제한 조건** |
| --- |
|-   전체 학생의 수는 2명 이상 30명 이하입니다.|
|-   체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.|
|-   여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.|
|-   여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.|
|-   여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.|
|이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.|

| **​입출력 예** |  |  |  |
| --- | --- | --- | --- |
| n | lost | reserve | return |
| 5 | \[2,4\] | \[1, 3, 5\] | 5 |
| 5 | \[2,4\] | \[3\] | 4 |
| 3 | \[3\] | \[1\] | 2 |

입출력 예#1
- 1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.

입출력 예#2
- 3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.

---

### _**나의 풀이**_

1\. 수업을 들을 수 있는 학생을 studentSet에 추가한다

   ① 1부터 n까지의 수를 studentSet에 추가

   ② 도난당한 학생 번호를 studentSet에서 삭제

   ③ 여벌을 가져온 학생 번호를 studentSet에 추가 (Set은 중복값 입력 불가, 도난/여벌 동시 학생 가리기 위함)

2\. lo(도난 학생번호)와 res(여벌 학생번호)의 차이가 1이고,

     res가 rentSet에 들어가있지 않고,

     lo가 studentSet에 들어가있지 않으면 rentSet에 res를 추가하고 studentSet에 lo를 추가

3\. studentSet의 길이를 리턴

```kt
class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val studentSet: MutableSet<Int> = mutableSetOf()
        val rentSet: MutableSet<Int> = mutableSetOf()

        for (i in 1..n)         {   studentSet.add(i)       }
        lost.sorted().filter    {   studentSet.remove(it)
                                    rentSet.add(it)         }
        reserve.sorted().filter {   studentSet.add(it)      }

        for (res in reserve.sorted()) {
            for (lo in lost.sorted()) {
                if (kotlin.math.abs(res-lo) == 1 && !rentSet.contains(res) && !studentSet.contains(lo)) {
                    rentSet.add(res)
                    studentSet.add(lo)
                }
            }
        }

        return studentSet.size
    }
}
```

<center>

| 이미 풀어봤던 문제라 이렇게 오래 걸릴 줄 몰랐다.<br>문제 푸는데 거의 3시간 걸린 것 같은데, 문제에 함정이 많았다.<br>우여곡절 끝에 풀기는 했지만 내 맘에 드는 풀이는 아니다.<br><br>참고!!<br>① 13,14번을 틀리는 사람 => lost와 reserve를 정렬해야함<br>② 5,7,11번 등을 틀리는 사람 => 도난/여벌에 동시에 들어가 있는 학생 고려해야함 |
| :---: |

</center>

### _**Kotlin 코드 정리**_

```kt
class Solution {
        fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {

            var answer = n
            var lostSet = lost.toSet() - reserve.toSet()
            var reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet

            for (i in lostSet) {
                when {
                    i + 1 in reserveSet -> reserveSet.remove(i + 1)
                    i - 1 in reserveSet -> reserveSet.remove(i - 1)
                    else -> answer--
                }
            }
            return answer
        }
}
```

<center>

| 같은 MutableSet인데 차이 무엇...? ㅠㅠ |
| --- |

</center>