> 최초작성 : 2021.09.15

## **Level1 - 행렬의 덧셈 (kotlin)**

 [코딩테스트 연습 - 행렬의 덧셈](https://programmers.co.kr/learn/courses/30/lessons/12950)

| **문제 설명** |
| --- |
| 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.   2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요. |

| **제한 조건** |
| --- |
|   -   행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.   |

| **​입출력 예** |  |  |
| --- | --- | --- |
| arr | arr2 | return |
| \[\[1,2\],\[2,3\]\] | \[\[3,4\],\[5,6\]\] | \[\[4,6\],\[7,9\]\] |
| \[\[1\],\[2\]\] | \[\[3\],\[4\]\] | \[\[4\],\[6\]\] |

---

### _**나의 풀이**_

1\. 다차원 배열 answer 선언

2\. arr1과 arr2의 값들을 더해서 answer에 넣고 리턴

```kt
class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer: Array<IntArray> = Array(arr1.size) { IntArray(arr1[0].size) }

        for (i in arr1.indices) {
            for (j in arr1[0].indices) {
                answer[i][j] = arr1[i][j] + arr2[i][j]
            }
        }

        return answer
    }
}
```

<center>

| 코틀린은 arrayOf()로 많이 만들어봐서 다차원 배열인 Array<IntArray>를 선언하는 방법을 몰라 헤맸다.<br>결국 자바 int\[\]\[\] answer = new int\[arr1.size\]\[arr1\[0\].size\]; 를 코틀린으로 변환해서 풀었다...<br>인텔리제이 감사 ㅠ |
| :---: |

</center>

### _**Kotlin 코드 정리**_

```kt
class Solution {
	fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
		return Array(arr1.size) {
			row ->
			IntArray(arr1[0].size) { // = size.length
				col ->
				arr1[row][col] + arr2[row][col]
			}
		}
	}
}
```