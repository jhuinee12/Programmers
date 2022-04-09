> 최초작성 : 2021.09.17

## ******Level1 - 자연수 뒤집어 배열로 만들기**** (kotlin)**

 [코딩테스트 연습 - 자연수 뒤집어 배열로 만들기](https://programmers.co.kr/learn/courses/30/lessons/12932)

| **문제 설명** |
| --- |
| 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.   예를들어 n이 12345이면 \[5,4,3,2,1\]을 리턴합니다. |

| **제한 조건** |
| --- |
|   -   n은 10,000,000,000이하인 자연수입니다.   |

| **​입출력 예** |  |
| --- | --- |
| n | return |
| 12345 | \[5,4,3,2,1\] |

---

### _**나의 풀이**_

1.  리턴할 IntArray() 배열 생성

2\. long의 끝자리부터 차례로 배열에 넣기

```kt
class Solution {
    fun solution(n: Long): IntArray {
        val answer = IntArray(n.toString().length)
        var number = n
        for (i in n.toString().indices) {
            answer[i] = (number%10).toInt()
            number /= 10
        }
        return answer
    }
}
```

<center>

| 원래는 split()과 reverse()를 이용해 바로 넣으려고 했는데<br>List<String>을 IntArray로 변경하는 데에서 막혀 포기했고, 그냥 베이직한 방법으로 소스를 작성했다. |
| :---: |

</center>

### _**Kotlin1 코드 정리**_

```kt
class Solution {
    fun solution(n: Long): IntArray {
        return n.toString().reversed().map { it.toString().toInt() }.toIntArray()
    }
}
```

```kt
class Solution {
    fun solution(n: Long): IntArray {
        return n.toString()
            .reversed()
            .split("")
            .filter { it != "" }
            .map { it.toInt() }
            .toIntArray()
    }
}
```

* map() : 값을 변형해서 새로운 리스트 생성