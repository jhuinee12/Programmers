> 최초작성 : 2021.03.17

## **Level1 - 직사각형 별찍기 (kotlin)**

 [코딩테스트 연습 - x만큼 간격이 있는 n개의 숫자](https://programmers.co.kr/learn/courses/30/lessons/12954)

| **문제 설명** |
| --- |
| 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.   별(\*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 평태를 출력해보세요. |

| **제한 조건** |
| --- |
|   -   n과 m은 각각 1000 이하인 자연수입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| 입력예시 | 출력예시 |
| 5 3 | \*\*\*\*\*   \*\*\*\*\*   \*\*\*\*\* |

---

### _**나의 풀이**_

1\. for문

```kt
fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    for(i in 1..b) {
        for(j in 1..a) {
            print("*")
        }
        println()
    }
}
```

* redLine : 입력 -> java의 Scanner와 같은 역할
* val(a,b) => split으로 나눈 값 각각 저장

### _**Kotlin1 코드 정리**_

```kt
fun main(argsL Array<String>) {
	val(a,b) = readLine()!!.split(' ').map(String::toInt)
	
	var star : String = ""
	
	for (1 in 1..a) {
		star += "*"
	}
	
	for (i in 1..b) {
		println(star)
	}
}
```