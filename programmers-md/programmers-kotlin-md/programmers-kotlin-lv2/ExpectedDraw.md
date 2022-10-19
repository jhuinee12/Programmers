> 최초작성 : 2022.10.18

## ******Level2 - 예상 대진표****(kotlin)**

 [코딩테스트 연습 - 예상 대진표](https://school.programmers.co.kr/learn/courses/30/lessons/12985)

### 문제 설명
△△ 게임대회가 개최되었습니다. 이 대회는 N명이 참가하고, 토너먼트 형식으로 진행됩니다. N명의 참가자는 각각 1부터 N번을 차례대로 배정받습니다. 그리고, 1번↔2번, 3번↔4번, ... , N-1번↔N번의 참가자끼리 게임을 진행합니다. 각 게임에서 이긴 사람은 다음 라운드에 진출할 수 있습니다. 이때, 다음 라운드에 진출할 참가자의 번호는 다시 1번부터 N/2번을 차례대로 배정받습니다. 만약 1번↔2번 끼리 겨루는 게임에서 2번이 승리했다면 다음 라운드에서 1번을 부여받고, 3번↔4번에서 겨루는 게임에서 3번이 승리했다면 다음 라운드에서 2번을 부여받게 됩니다. 게임은 최종 한 명이 남을 때까지 진행됩니다.

이때, 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 궁금해졌습니다. 게임 참가자 수 N, 참가자 번호 A, 경쟁자 번호 B가 함수 solution의 매개변수로 주어질 때, 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 return 하는 solution 함수를 완성해 주세요. **단, A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이긴다고 가정합니다.**


### 제한 조건
	• N : 21 이상 220 이하인 자연수 (2의 지수 승으로 주어지므로 부전승은 발생하지 않습니다.)
	• A, B : N 이하인 자연수 (단, A ≠ B 입니다.)

### **​입출력 예** 
| N | A | B | answer |
|---|---|---|--------|
| 8 | 4 | 7 | 3      |

#### **입출력 예**

첫 번째 라운드에서 4번 참가자는 3번 참가자와 붙게 되고, 7번 참가자는 8번 참가자와 붙게 됩니다. 항상 이긴다고 가정했으므로 4번 참가자는 다음 라운드에서 2번이 되고, 7번 참가자는 4번이 됩니다. 두 번째 라운드에서 2번은 1번과 붙게 되고, 4번은 3번과 붙게 됩니다. 항상 이긴다고 가정했으므로 2번은 다음 라운드에서 1번이 되고, 4번은 2번이 됩니다. 세 번째 라운드에서 1번과 2번으로 두 참가자가 붙게 되므로 3을 return 하면 됩니다.

<br>

---

<br>

### _**나의 풀이**_

```kt
import kotlin.math.absoluteValue

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var fight1 = a
        var fight2 = b

        while (true) {
            answer++

            if ((fight1-fight2).absoluteValue == 1) {
                if (fight1 % 2 == 0) {
                    if (fight2 < fight1) break
                } else {
                    if (fight1 < fight2) break
                }
            }

            if (fight1 % 2 == 0) fight1 /= 2
            else fight1 = (fight1+1) / 2

            if (fight2 % 2 == 0) fight2 /= 2
            else fight2 = (fight2+1) / 2
        }

        return answer
    }
}
```

#### 유의사항
* 만약에 a=2, b=3 인 경우이면 두 값의 차이는 1이지만 다음 대진에서 경기를 진행해야 한다.

<br>

### _**Kotlin 1**_

```kt
class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var x = a
        var y = b
        while (x != y) {
            x = (x + 1) / 2
            y = (y + 1) / 2
            answer++
        }
        return answer
    }
}
```

<br>

### _**Kotlin 2**_

```kt
class Solution {
    fun solution(n: Int, a: Int, b: Int) = ((a - 1) xor (b - 1)).toString(2).length
}
```