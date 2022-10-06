> 최초작성 : 2022.10.06

## ******Level2 - 최댓값과 최솟값****(kotlin)**

 [코딩테스트 연습 -  최댓값과 최솟값](https://school.programmers.co.kr/learn/courses/30/lessons/12939)

### 문제 설명
문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

### 제한 조건
* s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.

### ​입출력 예
| s             | return  |
|---------------|---------|
| "1 2 3 4"     | "1 4"   |
| "-1 -2 -3 -4" | "-4 -1" |
| "-1 -1"       | "-1 -1" |

<br>

---

<br>

### _**나의 풀이**_


```kt
import java.util.Collections.max
import java.util.Collections.min

class Solution {
    fun solution(s: String): String {
        val numbers = s.split(" ").map { it.toInt() }
        return "${min(numbers)} ${max(numbers)}"
    }
}
```

###### 처음에 string으로 그대로 구하다가 애 먹었다. toInt()가 키포인트!!