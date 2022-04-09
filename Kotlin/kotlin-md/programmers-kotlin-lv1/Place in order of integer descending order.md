> 최초작성 : 2021.09.22

## ******Level1 - 정수 내림차순으로 배치하기**** (kotlin)**

 [코딩테스트 연습 - 정수 내림차순으로 배치하기](https://programmers.co.kr/learn/courses/30/lessons/12933)

| **문제 설명** |
| --- |
| 함수 solution은 정수 n을 매개변수로 입력받습니다.<br>n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.<br>예를들어 n이 118372면 873211을 리턴하면 됩니다. |

| **제한 조건** |
| --- |
|   -   n은 1이상 8000000000 이하인 자연수입니다.   |

| **​입출력 예** |  |
| --- | --- |
| n | return |
| 118372 | 873211 |

---

### _**나의 풀이**_

1.  매개변수 n을 string값으로 변경한 후, 각 문자들을 자른 문자열을 배열 array에 넣는다.

2\. array를 오름차순으로 정렬한다.

3\. 오름차순으로 정렬한 array를 내림차순으로 합쳐 string변수 answer에 넣는다.

4\. answer를 long으로 변환하고 리턴한다.

```kt
class Solution {
    fun solution(n: Long): Long {
        var array = n.toString().toCharArray()
        array.sort()
        var answer = ""
        for (a in array)
            answer = a + answer
        return answer.toLong()
    }
}
```

### _**Kotlin1 코드 정리**_

```kt
class Solution {
    fun solution(n: Long): Long {
        val s = n.toString()
        var array = ArrayList<Int>()
        for(c in s) {
            array.add(c.toInt() - 48)
        }
        array.sortDescending()

        var answerString = ""
        for(i in array) {
            answerString += "$i"
        }

        return answerString.toLong()
    }
}
```

```kt
class Solution {
    fun solution(n: Long): Long = String(n.toString().toCharArray().sortedArrayDescending()).toLong()
}
```