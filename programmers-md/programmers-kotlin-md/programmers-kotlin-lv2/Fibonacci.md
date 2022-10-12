> 최초작성 : 2022.10.12

## ******Level2 - 피보나치 수****(kotlin)**

 [코딩테스트 연습 - 피보나치 수](https://school.programmers.co.kr/learn/courses/30/lessons/12945)

### 문제 설명
피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

예를들어

F(2) = F(0) + F(1) = 0 + 1 = 1<br>
F(3) = F(1) + F(2) = 1 + 1 = 2<br>
F(4) = F(2) + F(3) = 1 + 2 = 3<br>
F(5) = F(3) + F(4) = 2 + 3 = 5<br>
와 같이 이어집니다.

2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.

### 제한 조건
	• n은 2 이상 100,000 이하인 자연수입니다.

### **​입출력 예** 
| n | return |
|---|--------|
| 3 | 2      |
| 5 | 5      |

#### **입출력 예**
피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.

---

### _**나의 풀이**_

```kt
class Solution {
    fun solution(n: Int): Int {
        val nums = ArrayList<Int>()

        nums.add(0)
        nums.add(1)

        for (i in 2..n) {
            nums.add((nums[i-1] + nums[i-2]) % 1234567)
        }

        return nums.last()
    }
}
```

### _**Kotlin 1**_

```kt
class Solution {
    fun solution(n: Int): Int = if(n == 1 || n == 2) 1 else fib(n, 1, 1)  
    tailrec fun fib(n: Int, a: Int, b: Int): Int = if(n == 1) a else fib(n - 1, b % 1234567, (a + b) % 1234567)
}
```

* tailrec : 꼬리재귀