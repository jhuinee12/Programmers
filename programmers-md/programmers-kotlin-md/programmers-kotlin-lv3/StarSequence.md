> 최초작성 : 2022.11.12

## ******Level3 - 스타 수열**** (kotlin)**

 [코딩테스트 연습 - 스타 수열](https://school.programmers.co.kr/learn/courses/30/lessons/70130)

### **문제 설명**
다음과 같은 것들을 정의합니다.

- 어떤 수열 x의 부분 수열(Subsequence)이란, x의 몇몇 원소들을 제거하거나 그러지 않고 남은 원소들이 원래 순서를 유지하여 얻을 수 있는 새로운 수열을 말합니다.
    - 예를 들어, [1,3]은 [1,2,3,4,5]의 부분수열입니다. 원래 수열에서 2, 4, 5를 제거해서 얻을 수 있기 때문입니다.
    
- 다음과 같은 조건을 모두 만족하는 수열 x를 스타 수열이라고 정의합니다.
    - x의 길이가 2 이상의 짝수입니다. (빈 수열은 허용되지 않습니다.)
    - x의 길이를 2n이라 할 때, 다음과 같은 n개의 집합 {x[0], x[1]}, {x[2], x[3]}, ..., {x[2n-2], x[2n-1]} 의 교집합의 원소의 개수가 1 이상입니다.
    - x[0] != x[1], x[2] != x[3], ..., x[2n-2] != x[2n-1] 입니다.
    - 예를 들어, [1,2,1,3,4,1,1,3]은 스타 수열입니다. {1,2}, {1,3}, {4,1}, {1,3} 의 교집합은 {1} 이고, 각 집합 내의 숫자들이 서로 다르기 때문입니다.

1차원 정수 배열 a가 매개변수로 주어집니다. a의 모든 부분 수열 중에서 가장 길이가 긴 스타 수열의 길이를 return 하도록 solution 함수를 완성해주세요. 이때, a의 모든 부분 수열 중에서 스타 수열이 없다면, 0을 return 해주세요.


### **제한사항**
- a의 길이는 1 이상 500,000 이하입니다.
- a의 모든 수는 0 이상 (a의 길이) 미만입니다.

### **​입출력 예**
| a                     | result |
|-----------------------|--------|
| [0]                   | 0      |
| [5,2,3,3,5,3]         | 4      |
| [0,3,3,0,7,2,0,2,2,0] | 8      |

### **입출력 예 설명**

#### 입출력 예 #1
a의 부분 수열 중에서 주어진 조건을 모두 만족하는 스타 수열이 없으므로, 0을 return 해야 합니다.

#### 입출력 예 #2
[5,2,5,3], [5,3,3,5] 는 a의 부분 수열인 동시에 스타 수열입니다. a의 부분 수열 중 이보다 더 긴 스타 수열은 없으므로, 4를 return 해야 합니다.

#### 입출력 예 #3
[0,3,3,0,7,0,2,0] 는 a의 부분 수열인 동시에 스타 수열입니다. a의 부분 수열 중 이보다 더 긴 스타 수열은 없으므로, 8을 return 해야 합니다.


<br>

---

<br>

### _**나의 풀이**_

1\. a의 사이즈만큼의 이중 배열 array를 생성함 (index의 이동을 저장하기 위함)

2\. a의 요소를 확인하는 반복문 생성

3\. 조건문
 - 현재 index가 0(제일 앞)인 경우
   - array[현재요소]에 현재 index와 다음 index 추가
 - 현재 index가 last인 경우
   - (이전 index가 추가되어 있지 않은 경우!!) array[현재요소]에 현재 index와 이전 index 추가
 - 그 외
   - (다음 index가 추가되어 있지 않은 경우!!) array[현재요소]에 현재 index와 다음 index 추가
   - (이전 index가 추가되어 있지 않은 경우!!) array[현재요소]에 현재 index와 이전 index 추가

4\. array[현재요소]의 크기가 짝수이고 answer보다 큰 경우 asnwer를 바꿔줌



```kt
class StarSequence {
    fun solution(a: IntArray): Int {
        if (a.size < 2) return 0

        var answer = 0

        val array = Array(a.size) { ArrayList<Int>() }

        a.forEachIndexed { idx, i ->
            if (answer > array[i].size+a.size-idx) return@forEachIndexed // 시간초과 방지

            val lastIndex = if (array[i].size != 0) array[i][array[i].size-1] else -1
            when (idx) {
                0 -> if (a[idx+1] != i) {
                    array[i].add(idx)
                    array[i].add(idx+1)
                }
                a.size-1 -> if (a[idx-1] != i && lastIndex != idx-1) {
                    array[i].add(idx)
                    array[i].add(idx-1)
                }
                else -> {
                    if (a[idx-1] != i && lastIndex != idx-1) {
                        array[i].add(idx-1)
                        array[i].add(idx)
                    } else if (a[idx+1] != i && lastIndex != idx+1) {
                        array[i].add(idx)
                        array[i].add(idx+1)
                    }
                }
            }
            if (array[i].size % 2 == 0 && answer < array[i].size) {
                answer = array[i].size
            }
        }

        return answer
    }
}
```

##### 원래 시간초과(14-15번) 났던 이유 :: index의 이동과정을 알기 위해 contains를 사용했음.
##### 굳이 contains를 사용할 필요 없이 가장 마지막 배열의 요소를 확인하면 됨.