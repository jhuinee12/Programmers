> 최초작성 : 2022.10.02

## ******Level2 - 점프와 순간 이동**** (java)**

 [코딩테스트 연습 - 점프와 순간 이동](https://school.programmers.co.kr/learn/courses/30/lessons/12980)

### **문제 설명**
OO 연구소는 한 번에 K 칸을 앞으로 점프하거나, (현재까지 온 거리) x 2 에 해당하는 위치로 순간이동을 할 수 있는 특수한 기능을 가진 아이언 슈트를 개발하여 판매하고 있습니다. 이 아이언 슈트는 건전지로 작동되는데, 순간이동을 하면 건전지 사용량이 줄지 않지만, 앞으로 K 칸을 점프하면 K 만큼의 건전지 사용량이 듭니다. 그러므로 아이언 슈트를 착용하고 이동할 때는 순간 이동을 하는 것이 더 효율적입니다. 아이언 슈트 구매자는 아이언 슈트를 착용하고 거리가 N 만큼 떨어져 있는 장소로 가려고 합니다. 단, 건전지 사용량을 줄이기 위해 점프로 이동하는 것은 최소로 하려고 합니다. 아이언 슈트 구매자가 이동하려는 거리 N이 주어졌을 때, 사용해야 하는 건전지 사용량의 최솟값을 return하는 solution 함수를 만들어 주세요.

예를 들어 거리가 5만큼 떨어져 있는 장소로 가려고 합니다.
아이언 슈트를 입고 거리가 5만큼 떨어져 있는 장소로 갈 수 있는 경우의 수는 여러 가지입니다.

- 처음 위치 0 에서 5 칸을 앞으로 점프하면 바로 도착하지만, 건전지 사용량이 5 만큼 듭니다.
- 처음 위치 0 에서 2 칸을 앞으로 점프한 다음 순간이동 하면 (현재까지 온 거리 : 2) x 2에 해당하는 위치로 이동할 수 있으므로 위치 4로 이동합니다. 이때 1 칸을 앞으로 점프하면 도착하므로 건전지 사용량이 3 만큼 듭니다.
- 처음 위치 0 에서 1 칸을 앞으로 점프한 다음 순간이동 하면 (현재까지 온 거리 : 1) x 2에 해당하는 위치로 이동할 수 있으므로 위치 2로 이동됩니다. 이때 다시 순간이동 하면 (현재까지 온 거리 : 2) x 2 만큼 이동할 수 있으므로 위치 4로 이동합니다. 이때 1 칸을 앞으로 점프하면 도착하므로 건전지 사용량이 2 만큼 듭니다.

위의 3가지 경우 거리가 5만큼 떨어져 있는 장소로 가기 위해서 3번째 경우가 건전지 사용량이 가장 적으므로 답은 2가 됩니다.

### **제한 조건** 
- 숫자 N: 1 이상 10억 이하의 자연수
- 숫자 K: 1 이상의 자연수

### **​입출력 예**

| n | result |
|:--|:--|
| 5 | 2 |
| 6 | 2 |
| 5000 | 5 |

---

### _**나의 풀이**_

1\. 도착지점이 짝수인 경우, 순간이동으로 올 수 있는 거리이므로 절반을 돌아감

2\. 도착지점이 홀수인 경우, 한 칸씩만 이동알 수 있으므로 한 칸 돌아가고 건전지 소비를 +1

```java
public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n > 0) {
            if (n % 2 == 0) { // 짝수인 경우 순간이동
                n /= 2;
            } else { // 홀수인 경우 한 칸 이동
                n--;
                ans++;
            }
        }

        return ans;
    }
}
```

###### 생각의 전환이 중요하다. 나는 처음에 '앞으로 가야한다.' 라는 생각에 꽂혀있었다.
###### 그 생각에 사로잡히니 다른 방법이 떠오르지 않았고, 결국 문제를 풀지 못했다. (물론 10분 남짓 생각함 ㅋㅋㅋㅋ)
###### 그러다가 같이 스터디를 하는 분의 풀이를 듣고 깨달았다. '뒤에서 앞으로 가도 되는구나!!'
###### 생각이 닿는 것까지가 어렵지 문제는 풀고 나면 쉬웠다.