> 최초작성 : 2021.08.25

## **Level1 - 최대공약수와  최소공배수 (kotlin)**

 [코딩테스트 연습 - 최대공약수와 최소공배수](https://programmers.co.kr/learn/courses/30/lessons/12940)

| **문제 설명** |
| --- |
| 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해보세요.<br>배열의 맨 앞에 최대공약수, 그 다음 최소공배수를 넣어 반환하면 됩니다.<br>예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 \[3, 12\]를 반환해야 합니다. |

| **제한 조건** |
| --- |
|   -   두 수는 1 이상 1000000 이하의 자연수입니다.   |

| **​입출력 예** |  |  |
| --- | --- | --- |
| n | m | return |
| 3 | 12 | \[3,12\] |
| 2 | 5 | \[1,10\] |

---

### _**나의 풀이**_

1\. n과 m의 크기를 비교하여 max와 min에 저장

2\. 반복문을 이용하여 나누어떨어지는 수 중 가장 큰 수 저장

3\. 최소공배수 구하기 : n\*m\*최대공약수

```kt
fun solution(n: Int, m: Int): IntArray {
    var answer = intArrayOf(0,0)

    /* n과 m의 크기를 비교하여 max와 min에 저장 */
    var max = if (n > m) n else m
    var min = if (n > m) m else n
    
    /* 반복문을 이용하여 나누어떨어지는 수 중 가장 큰 수 저장 */
    for (i in 1..min) if (min%i==0 && max%i==0)
        answer[0] = i

    /* 최소공배수 구하기 : n*m*최대공약수 */
    answer[1] = max * min / answer[0]

    return answer
}
```

### _**Kotlin1 코드 정리**_

```kt
class Solution {
	fun solution(n: Int, m: Int): IntArray {
		var gcd = 1 // 최대공약수 도출 변수
		var lcm = n*m // 최소공배수 도출 변수
		
		for (i in Math.min(n, m) downTo 1) { // Math.min(n,m)에서 1씩 내려가기
			if (n%i == 0 && m%i == 0) {
				gcd = I // 최대공약수 도출
				break
			}
		}
		
		for (i in Math.max(n, m).. lcm) { // Math.max(n,m)에서 lcm까지 loop
			if (i%n == 0 && i%m == 0) {
				lcm = I // 최소공배수 도출
				break
			}
		}
		
		var answer = intArrayOf(gcd, lcm)
		return answer
	}
}
```

* Math.min()을 이용하여 작은 수 도출함
* 최소공배수를 구하는 방법은 비효율적임 ~_최대공약수 없이 최소공배수를 구하는 방법_~
* 최대공약수 : 나누어 떨어지는 수 중 가장 큰 수, 최소공배수 : 나누는 수 중 가장 큰 약수

### _**Kotlin2 코드 정리**_

```kt
class Solution {
	fun solution(n: Int, m: Int): IntArray = arrayOf(getGcd(n, m), getLcm(n, m)).toIntArray()
	
	private fun getGcd(numA : Int, numB : Int) : Int {
		var gcd : Int = numA
		var divisor : Int = numB
		var rest : Int
		while(divisor != 0) {
			rest = gcd % divisor
			gcd = divisor
			divisor = rest
		}
		
		return gcd
	}
	
	private fun getLcm(numA: Int, numB: Int) = numA * numB / getGcd(numA, numB)
}
```

<center>

| 최대공약수와 최소공배수를 함수를 만들어 계산하니 깔끔한 느낌 |
| --- |

</center>