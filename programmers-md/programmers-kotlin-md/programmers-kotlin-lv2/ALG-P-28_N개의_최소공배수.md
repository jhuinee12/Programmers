> 최초작성 : 2022.11.30

## ******Level2 - N개의 최소공배수**** (kotlin)**

 [코딩테스트 연습 - N개의 최소공배수](https://school.programmers.co.kr/learn/courses/30/lessons/12953)

### **문제 설명**
두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

### **제한사항**
- arr은 길이 1이상, 15이하인 배열입니다.
- arr의 원소는 100 이하인 자연수입니다.

### **​입출력 예**
| arr        | result |
|------------|--------|
| [2,6,8,14] | 168    |
| [1,2,3]    | 6      |


<br>

---

<br>

### _**나의 풀이**_

1\. 숫자를 두개씩 뽑아 두개의 최소공배수를 구하여 배열에 저장한다. (두수의곱/최대공약수)

2\. 다시 그 배열에서 숫자를 두개씩 뽑아 최소공배수를 구하고 배열에 저장한다.

3\. 숫자가 하나만 남을 때까지 반복한다.


```kt
import java.lang.Integer.min

class Solution {
    fun solution(arr: IntArray): Int {
        var answer = arr

        while (true) {
            val r = lcm(answer)
            if (answer.size == 1) break
            else answer = r
        }

        return answer[0]
    }

    private fun lcm(arr: IntArray): IntArray {
        val gcd = IntArray(arr.size-1) { 0 }

        for (i in 1..arr.lastIndex) {
            for (j in min(arr[i], arr[i-1]) downTo  1) {
                if (arr[i] % j == 0 && arr[i-1] % j == 0) {
                    gcd[i-1] = arr[i-1]/j*arr[i]
                    break
                }
            }
        }

        return gcd
    }
}
```