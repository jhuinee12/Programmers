> 최초작성 : 2021.09.27

## **Level1 - 콜라츠 추측 (kotlin)**

 [코딩테스트 연습 - 콜라츠 추측](https://programmers.co.kr/learn/courses/30/lessons/12943)

| **문제 설명** |
| --- |
| 1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될때까지 다음 작업을 반복하면,<br>모든 수를 1로 만들 수 있다는 추측입니다.<br> 다음과 같습니다.|
|1-1. 입력된 수가 짝수라면 2로 나눕니다.<br>1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.<br>2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.|
|예를 들어, 입력된 수가 6이라면 6→3→10→5→16→8→4→2→1 이 되어 총 8번 만에 1이 됩니다.<br>위 작업을 몇 번이나 반복해야하는지 반환하는 함수, solution을 완성해 주세요.<br>단, 작업을 500번을 반복해도 1이 되지 않는다면 –1을 반환해 주세요. |

| **제한 조건** |
| --- |
|   -   입력된 수, num은 1 이상 8000000 미만인 정수입니다.   |

| **​입출력 예** |  |
| --- | --- |
| n | return |
| 6 | 8 |
| 16 | 4 |
| 626331 | \-1 |


입출력 예#1
- 16 -> 8 -> 4 -> 2 -> 1 이되어 총 4번만에 1이 됩니다.

입출력 예#2
- 626331은 500번을 시도해도 1이 되지 못하므로 -1을 리턴해야합니다.

---

### _**나의 풀이**_

1\. 입력받은 수(num)이 1이 아니면 while문 실행

2\. num이 짝수면 2로 나누고 카운트 +1(answer)

3\. num이 홀수면 3을 곱하고 1더한 후 카운트 +1(answer)

4\. 카운트값(answer)이 500이상이면 -1 리턴

* 프로그래머스에서는 num이 Int로 되어있는데, num\*3 +1 에서 int의 범위를 넘어가는 경우 발생하므로 long으로 타입 변환**

* solution(num: Long)으로 사용해도 됨**

```kt
class Solution {
    fun solution(num: Int): Int {
        var num = num.toLong()
        var cnt = 0
        while (num != 1.toLong()) {
            if (cnt <500) {
                if (num % 2.toLong() == 0.toLong()) num /= 2
                else num = num * 3 + 1
            } else {
                return -1
            }
            cnt++
        }
        return cnt
    }
}
```

### _**Kotlin 코드 정리**_

```kt
class Solution {
    fun solution(num: Int): Int {
        return processor(num.toLong(), 0) // processor 함수 호출
    }

    private fun processor(n: Long, c: Int): Int { 
        if (n == 1.toLong()) {
            return c //n의 값이 1이 되었을 때 c 호출
        } else if (c == 500) {
            return -1 //500번 반복문이 돌았을 때 -1 리턴
        }
        return processor(if (n % 2.toLong() == 0.toLong()) n / 2 else n * 3 + 1, c + 1)
	// processor를 다시 호출함으로써 c의 값이 1씩 증가 (c+1)
    }
}
```

```kt
class Solution {
    fun solution(num: Int): Int = collatzAlgorithm(num.toLong(),0)

    tailrec fun collatzAlgorithm(n:Long, c:Int):Int =
        when{
            c > 500 -> -1 // c의 값이 500 이상이면 -1
            n == 1L -> c // n의 값이 1이면 c
            else -> collatzAlgorithm(if( n%2 == 0L ) n/2 else (n*3)+1, c+1) 
	// collatzAlgorithm을 다시 호출함으로써 c의 값이 1씩 증가 (c+1)
        }
}
```

* 두 소스코드 모두 재귀함수 사용