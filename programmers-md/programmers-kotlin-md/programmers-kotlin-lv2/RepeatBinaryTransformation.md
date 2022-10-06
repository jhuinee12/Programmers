> 최초작성 : 2022.10.06

## ******Level2 - 이진 변환 반복하기****(kotlin)**

 [코딩테스트 연습 -  이진 변환 반복하기](https://school.programmers.co.kr/learn/courses/30/lessons/70129)

### 문제 설명
0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.

    1. x의 모든 0을 제거합니다.
    2. x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.

예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.

0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.

### 제한 조건
* s의 길이는 1 이상 150,000 이하입니다.
* s에는 '1'이 최소 하나 이상 포함되어 있습니다.

### ​입출력 예
| s              | return |
|----------------|--------|
| "110010101001" | [3,8]  |
| "01110"        | [3,3]  |
| "1111111"      | [4,1]  |

<br>

---

<br>

### _**나의 풀이**_

1\. 이진수로 바꾼 횟수를 저장할 count와 제거된 0의 개수를 저장할 zero를 선언한다.

2\. number가 1이 될 때까지 반복하는 반복문을 생성한다.

3\. number의 길이와 0이 제거된 길이의 차이를 구하여 zero에 더한다.

4\. 0이 제거된 길이을 이진수로 변경하고, count를 더한다.

```kt
class Solution {
    fun solution(s: String): IntArray {
        var count = 0
        var zero = 0
        var number = s

        while (number != "1") {
            val firstLength = number.length
            val secondLength = number.replace("0","").length
            number = secondLength.toString(2)
            zero += firstLength-secondLength
            count++
        }

        return intArrayOf(count, zero)
    }
}
```

###### 졸라쉬움