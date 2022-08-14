> 최초작성 : 2021.05.01

## **Level1 - 제일 작은 수 제거하기 (kotlin)**

 [코딩테스트 연습 - 제일 작은 수 제거하기](https://programmers.co.kr/learn/courses/30/lessons/12935)

| **문제 설명** |
| --- |
| 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.   단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.   예를들어 arr이 \[4,3,2,1\]인 경우는 \[4,3,2\]를 리턴 하고, \[10\]면 \[-1\]을 리턴 합니다. |

| **제한 조건** |
| --- |
|   -   arr은 길이 1 이상인 배열입니다. -   인덱스 i, j에 대해 i ≠ j이면 arr\[i\] ≠ arr\[j\] 입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| arr | return |
| \[4,3,2,1\] | \[4,3,2\] |
| \[10\] | \[-1\] |

---

### _**나의 풀이**_

1\. 정답을 리턴할 0만 들어있는 배열 answer 생성

2\. 만약 입력받은 배열 arr의 크기가 1이면 바로 -1만 들어있는 배열 리턴

3\. 크기가 1이 아니면 arr 원소 중에서 최솟값(arr.min())이 아닌 경우 answer에 삽입

4\. 위 answer에서 맨 처음 삽입되었던 0을 제거한 후 리턴

```kt
class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer = mutableListOf(0)
        var count = 0
        if (arr.size != 1) {
            for (i in arr)
            {
                if (i != arr.min()) answer.add(i)
                count++
            }
            answer.removeAt(0)
            return answer.toIntArray()
        }
        else return intArrayOf(-1)
    }
}
```

<center>

| filter를 사용해서 구현해보려고 했는데, 도저히 filter 개념을 이해할 수가 없었다.<br>아무래도 코틀린 책 하나를 사서 개념을 자세히 공부해야할 것 같다.<br>그래서 그냥 자바 식으로 풀이....ㅎㅎ<br>그리고 코틀린 배열의 개념이 참 어렵다ㅠ 빈 동적배열 선언 어떻게 하는거지? |
| :---: |

</center>

### _**Kotlin1 코드 정리**_

1\. arr의 사이즈가 1이면 -1이 들어있는 IntArray 배열 리턴

2\. 1이 아니면 arr.min()이 아닐 경우 삽입 후 리턴

```kt
class Solution {
    fun solution(arr: IntArray): IntArray = if(arr.size == 1) arrayOf(-1).toIntArray() 
                                            else arr.filter { it != arr.min() }.toIntArray()
}
```

<center>

| 내가 이걸 계속 시도했다가 실패했던게 if문을 filter 안에 넣어서 그런거였구나...<br>if문을 따로 빼서 리턴을 따로 해주고 else문을 타서 그 안에서 filter...!!!! |
| :---: |

</center>