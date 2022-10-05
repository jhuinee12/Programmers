> 최초작성 : 2022.10.05

## ******Level2 - H-Index****(kotlin)**

 [코딩테스트 연습 - H-Index](https://school.programmers.co.kr/learn/courses/30/lessons/42747)

### 문제 설명
H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

### 제한 조건
	• 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
	• 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.

### **​입출력 예** 
| citations     | return |
|---------------|--------|
| \[3,0,6,1,5\] | 3      |

#### **입출력 예**

이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다. 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.

---

### _**나의 풀이**_

1\. 1부터 과학자가 발표한 논문의 수만큼 반복하는 반복문을 만든다.

2\. for문의 index 값보다 값이 큰 citations의 인자 개수를 구한다.

3\. (2)번의 개수가 for문의 index보다 크고, index가 answer 값보다 크면 answer를 index로 바꿔준다.

```kt
class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0

        for (i in 1..citations.size) {
            val quotation = citations.filter { it >= i }.size

            if (i in (answer + 1)..quotation) {
                answer = i
            }
        }

        return answer
    }
}
```

<center>

###### 원샷원킬!!

</center>