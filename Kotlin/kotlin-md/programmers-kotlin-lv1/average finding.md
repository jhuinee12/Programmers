> 최초작성 : 2021.03.16

## **Level1 - 평균 구하기 (kotlin)**

 [코딩테스트 연습 - 평균 구하기](https://programmers.co.kr/learn/courses/30/lessons/12944)

| **문제 설명** |
| --- |
| 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요 |

| **제한 조건** |
| --- |
|   -   arr은 길이 1 이상, 100 이하인 배열입니다. -   arr의 원소는 -10000 이상 10,000 이하인 정수입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| arr | return |
| \[1,2,3,4\] | 2.5 |
| \[5,5\] | 5 |

---

### _**나의 풀이**_

1\. arr의 길이만큼 for문을 돌려서 총 합을 구한다.

2. 구한 합을 다시 arr의 길이로 나눠서 평균을 구한다.

```kt
class Solution {
    fun solution(arr: IntArray): Double {
        var answer:Double = 0.0

        for(i in arr) 
            answer += i

        answer /= arr.size
        return answer
    }
}
```

### _**Kotlin1 코드 정리**_

1\. 내장 average()함수를 사용 -> average 값이 있으면 average 리턴, 없으면 0 리턴

```kt
class Solution {
	fun solution(arr: IntArray): Double {return arr.average()}
}
```

**↓**

fun solution(arr: IntArray): Double = arr.average()

```kt
class Solution {
	fun solution(arr: IntArray): Double {
		return (arr.fold(0){ acc,i -> acc+i }.toDouble()/arr.size) // fold(0) : 초기값 0
	}
}
```

s* fold : 초기값을 설정해주고 왼쪽부터 오른쪽까지 현재의 계산값에 각각을 적용하는 함수

### _**Kotlin2 코드 정리**_

1\. 내장 sum()함수를 사용 -> 입력받은 arr의 총합 구함

2\. 그 값을 double로 변환한 후 arr의 크기만큼 나누어줌

```kt
class Solution {
	fun solution(arr: IntArray): Double {retrun arr.sum().toDouble()/arr.size}
}
```