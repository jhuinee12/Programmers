> 최초작성 : 2022.01.05

## ******Level1 - 문자열 내 마음대로 정렬하기 (****kotlin)**

 [코딩테스트 연습 - 문자열 내 마음대로 정렬하기](https://programmers.co.kr/learn/courses/30/lessons/12915)

| **문제 설명** |
| --- |
| 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,<br>각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.<br>예를 들어 strings가 \[sun, bed, car\]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다. |

| **제한 조건** |
| --- |
|   -   strings는 길이 1 이상, 50이하인 배열입니다. -   strings의 원소는 소문자 알파벳으로 이루어져 있습니다. -   strings의 원소는 길이 1 이상, 100이하인 문자열입니다. -   모든 strings의 원소의 길이는 n보다 큽니다. -   인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.   |

| **​입출력 예**    |  |  |
| --- | --- | --- |
| **strings** | **n** | **return** |
| \[sun, bed, car\] | 1 | \[car, bed, sun\] |
| \[abce, abcd, cdx\] | 2 | \[abcd, abce, cdx\] |

입출력 예#1
- sun, bed, car의 1번째 인덱스 값은 각각 u, e, a 입니다. 이를 기준으로 strings를 정렬하면 \[car, bed, sun\] 입니다.

입출력 예#2
- abce와 abcd, cdx의 2번째 인덱스 값은 c, c, x입니다. 따라서 정렬 후에는 cdx가 가장 뒤에 위치합니다.
- abce와 abcd는 사전순으로 정렬하면 abcd가 우선하므로, 답은 \[abcd, abce, cdx\] 입니다.

---

### _**나의 풀이**_

1\. 입력받은 배열 strings를 수정가능한 Mutable리스트로 정렬해서 stringsArray에 넣는다.

2\. 버블정렬을 이용해 n번째 문자를 기준으로 stringsArray를 재정렬한다.

3\. MutableList는 리턴 타입이 다르므로 toTypedArray()를 사용하여 리턴 타입을 맞춰준다.

```kt
class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        val stringsArray = strings.sorted().toMutableList()

        for (i in stringsArray.indices) {
            for (j in 1..stringsArray.size-1-i) {
                if (stringsArray[j-1][n] > stringsArray[j][n]) {
                    val temp = stringsArray[j]
                    stringsArray[j] = stringsArray[j-1]
                    stringsArray[j-1] = temp
                }
            }
        }

        return stringsArray.toTypedArray()
    }
}
```

<center>

| 처음엔 n번째 문자를 기준으로 두개의 리스트로 나누었다. :: substring(0,n)..substring(n,length)<br>그런데 생각을 잘못했다.<br>정렬 조건 중   **"문자가 같을 경우 사전순 정렬!"**<br>이 부분을 나는 n번째 문자열 이후로 생각했으나<br>아예 그 경우에는 첫번째 문자부터 사전순 정렬을 했어야하는 것이었다.<br>따라서 우선 입력받은 문자열 기준으로 정렬한 후, 그 다음으로 문자 자릿수 기준으로 정렬하는 방법을 사용했다. |
| :---: |

</center>

### _**Kotlin1 코드 정리**_

1\. 입력받은 문자열 strings를 정렬한다.

2\. 입력받은 문자열을 자릿수 n 기준으로 다시 정렬한다.

```kt
class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings.also {
            it.sort()
            it.sortBy { it[n] }
        }
    }
}
```

* **sortBy : MutableList에서만 사용 가능.** 

  :: it.sortBy { it.first } → 첫번째 문자열을 기준으로 정렬 (이차원배열)

  :: it.sortBy { it.second } → 두번째 문자열을 기준으로 정렬 (이차원배열)

  :: it.sortBy { it\[n\] } → n번째 자릿수 기준으로 정렬

### _**Kotlin2 코드 정리**_

1\. sortedWith를 이용하여 strings 배열을 정렬한다

2\. 정렬한 배열의 타입을 리턴 타입이랑 맞춰준다. (toTypedArray())

```kt
class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        var answer = strings

        var list =  answer.sortedWith(compareBy({ it[n] }, { it }))
        return list.toTypedArray()
    }
}
```

* **sortedWith : Immutable List에서 사용**

* **sortWith : Mutable List에서 사용**