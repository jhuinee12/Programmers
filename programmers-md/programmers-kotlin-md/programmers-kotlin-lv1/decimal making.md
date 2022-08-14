> 최초작성 : 2022.04.19

## ******Level1 - 소수 만들기**** (kotlin)**

 [코딩테스트 연습 - 소수 만들기](https://programmers.co.kr/learn/courses/30/lessons/12977)

| **문제 설명** |
| --- |
| 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.<br>숫자들이 들어있는 배열 nums가 매개변수로 주어질 때,<br>nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요. |

| **제한 조건** |
| --- |
|-   nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.<br>-   nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.|

| **​입출력 예**    |  |
| --- | --- |
| nums | return |
| \[1,2,3,4\] | 1 |
| \[1,2,7,6,4\] | 4 |


 입출력 예#1
 - \[1,2,4\]를 이용해서 7을 만들 수 있습니다.
 
 입출력 예#2
 - \[1,2,4\]를 이용해서 7을 만들 수 있습니다.
 - \[1,4,6\]을 이용해서 11을 만들 수 있습니다.
 - \[2,4,7\]을 이용해서 13을 만들 수 있습니다.
 - \[4,6,7\]을 이용해서 17을 만들 수 있습니다.

---

### _**나의 풀이**_

1\. 숫자 세개를 추출하기 위해 세번의 for문을 돌림. (첫번째=0부터, 두번째=첫번째+1부터, 세번째=두번째+1부터)

2\. 추출한 세개의 숫자를 더한 값이 소수인지 여부 판별 (2부터 sum까지 나누어떨어지는 수가 있는지 확인)

3\. 소수인 경우 answer+1

```java
class Solution {
    fun solution(nums: IntArray): Int {
        var count = 0

        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                for (k in j+1 until nums.size) {
                    if (i==j || j==k || i==k) {
                        break
                    }
                    val sum = nums[i] + nums[j] + nums[k]
                    var zeroCount = 0
                    for (s in 2 until sum) {
                        if (sum % s == 0) {
                            zeroCount++
                            break
                        }
                    }
                    if (zeroCount == 0) {
                        count++
                    }
                }
            }
        }

        return count
    }
}
```
<center>

| 와... 작년에 풀었던 java와 소름돋는 싱크로율을 보여준다.<br>스스로 성장했다고 뻐기고 다녔는데, 나는 난가봐ㅋㅋㅋㅋ<br>진짜 모~든게 똑같다...<br>.<br>.<br>.<br>다시 보니 이거 말고 다른 방법은 없는가보다.. |
| :---: |

</center>