> 최초작성 : 2021.09.27

## **Level1 - 하샤드수 (kotlin)**

 [코딩테스트 연습 - 하샤드 수](https://programmers.co.kr/learn/courses/30/lessons/12947)

| **문제 설명** |
| --- |
| 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.<br>예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.<br>자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요. |

| **제한 조건** |
| --- |
|   -   x는 1 이상, 10000 이하인 정수입니다.<입출력 예>   |

| **​입출력 예** |  |
| --- | --- |
| arr | return |
| 10 | true |
| 12 | true |
| 11 | false |
| 13 | false |

입출력 예 #1
- 10의 모든 자릿수의 합은 1입니다. 10은 1로 나누어 떨어지므로 10은 하샤드 수입니다. 

입출력 예 #2
- 12의 모든 자릿수의 합은 3입니다. 12는 3으로 나누어 떨어지므로 12는 하샤드 수입니다.

입출력 예 #3
- 11의 모든 자릿수의 합은 2입니다. 11은 2로 나누어 떨어지지 않으므로 11는 하샤드 수가 아닙니다.

입출력 예 #4
- 13의 모든 자릿수의 합은 4입니다. 13은 4로 나누어 떨어지지 않으므로 13은 하샤드 수가 아닙니다.

---

### _**나의 풀이**_

1\. 각 자릿수를 더해서 sum에 누적

2\. x가 sum에 나누어떨어지는지 여부를 return

```kt
class Solution {
    fun solution(x: Int): Boolean {
        var sum = 0
        for (num in x.toString())
            sum += num.toString().toInt()
        return x % sum == 0
    }
}
```

### _**Kotlin 코드 정리**_

```kt
class Solution {
    fun solution(x: Int): Boolean { // (변수명: 타입): 리턴 변수타입
        return x % x.toString().fold(0){acc, c -> acc + c.toInt() - 48} == 0 
    }
}
```

* 여기서 c는 char, 1을 char로 바꾼 뒤 다시 int로 형 변환을 하면 49가 나온다. 따라서 -48

```kt
class Solution {
    fun solution(x: Int): Boolean {
        var sum = 0
        var num = x

        while (num > 0) {
            sum += num % 10
            num /= 10
        }

        return (x % sum == 0)
    }
}
```