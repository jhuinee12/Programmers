> 최초작성 : 2021.09.23

## **Level1 - 서울에서 김서방 찾기 (kotlin)**

 [코딩테스트 연습 - 서울에서 김서방 찾기](https://programmers.co.kr/learn/courses/30/lessons/12919)

| **문제 설명** |
| --- |
| String형 배열 seoul의 element 중 “Kim”의 위치 x를 찾아, “김서방은 x에 있다”는 String 반환   seoul에 “Kim”은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우 없음 |

| **제한 조건** |
| --- |
|   -   seoul의 길이 1 이상, 1000 이하 배열 -   seoul의 원소는 길이 1 이상, 20 이하인 문자열 -   “Kim”은 반드시 seoul 안에 포함   |

| **​입출력 예** |  |
| --- | --- |
| seoul | result |
| \[“Jane”, “Kim”\] | “김서방은 1에 있다” |

---

### _**나의 풀이**_

1\. indexOf를 이용하며 요소가 Kim인 위치를 바로 리턴

```kt
class Solution {
    fun solution(seoul: Array<String>) = "김서방은 ${seoul.indexOf("Kim")}에 있다"
}
```

1\. 위치를 리턴할 변수 cnt 선언

2\. seoul의 요소 s가 "kim"이면 반복문 break 후 cnt 리턴

```kt
class Solution {
    fun solution(seoul: Array<String>): String {
        var cnt = 0
        for (s in seoul) {
            if (s == "Kim")
                break
            cnt++
        }
        return "김서방은 ${cnt}에 있다"
    }
}
```

### _**Kotlin 코드 정리**_

```kt
class Solution {
	fun solution(seoul: Array<String>): Stirng {
		for((idx, word) in seoul.withIndex()) {
			if (word == "Kim") {
				return "김서방은 ${idx}에 있다"
			}
		}
	}
}
```

* (index, value)로 for문을 돌려 바로 index를 찾을 수 있음