> 최초작성 : 2021.04.29

## **Level1 - 두 정수 사이의 합 (kotlin)**

 [코딩테스트 연습 - 두 정수 사이의 합r](https://programmers.co.kr/learn/courses/30/lessons/12912)

| **문제 설명** |
| --- |
| 두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수,   solution을 완성하세요.   예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다. |

| **제한 조건** |
| --- |
|   -   a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요. -   a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다. -   a와 b의 대소관계는 정해져있지 않습니다.​   |

| **​입출력 예**    |  |  |
| --- | --- | --- |
| a | b | return |
| 3 | 5 | 12 |
| 3 | 3 | 3 |
| 5 | 3 | 12 |

---

### _**나의 풀이**_

1\. a와 b의 대소관계 구분

2\. 작은 수부터 큰 수까지 for문을 이용하여 모든 숫자 합하기

```kt
class Solution {
    fun solution(a: Int, b: Int): Long {
        var sum: Long = 0
        if (a<b)
        {
            for (i in a..b)
                sum += i
        }
        else if (a>=b) {
            for (i in b..a)
                sum += i
        }
        return sum
    }
}
```

<center>

| 새삼... 사람은 본인이 생각하는 데에 고착되어 있다는 것이 느껴진다.<br>어쩜 예전에 짠 소스랑 이렇게 똑같지?ㅎㅎㅎㅎ....😅<br>그 때 분명 등차수열을 사용한 다른 사람의 풀이를 보며 감탄했는데<br>감탄에만 그치지 말고 새겼어야 하는데 난 여전히 if~else... |
| --- |

</center>

​

### _**Kotlin1 코드 정리**_

```kt
class Solution {
    fun solution(a: Int, b: Int) =
        if (a < b) ((a..b).average() * (b - a + 1)).toLong()
        else if (a > b) ((b..a).average() * (a - b + 1)).toLong()
        else a.toLong()
}
```

<center>

| 등차수열의 합 공식! |
| --- |

</center>

### _**Kotlin2 코드 정리**_

```kt
class Solution {
    fun solution(a: Int, b: Int): Long {
        val start : Long = (if(a>b) b else a).toLong()
        val end : Long = (if(a>b) a else b).toLong()
        return (start..end).sum()
    }
}
```

<center>

| 내 소스를 어떻게 하면 짧게 압축할 수 있을까 싶었는데 딱 이 방법이다.<br>그냥 a와 b의 대소관계만 비교하고 그 값을 sum() 함수를 써서 바로 리턴해버렸다.<br>sum() 기억하자! |
| --- |

</center>