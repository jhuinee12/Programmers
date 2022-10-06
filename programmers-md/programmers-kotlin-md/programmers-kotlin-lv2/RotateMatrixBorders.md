> 최초작성 : 2022.10.06

## ******Level2 - 행렬 테두리 회전하기****(kotlin)**

 [코딩테스트 연습 - 행렬 테두리 회전하기](https://school.programmers.co.kr/learn/courses/30/lessons/77485?language=kotlin)

### 문제 설명
rows x columns 크기인 행렬이 있습니다. 행렬에는 1부터 rows x columns까지의 숫자가 한 줄씩 순서대로 적혀있습니다.
이 행렬에서 직사각형 모양의 범위를 여러 번 선택해, 테두리 부분에 있는 숫자들을 시계방향으로 회전시키려 합니다.
각 회전은 (x1, y1, x2, y2)인 정수 4개로 표현하며, 그 의미는 다음과 같습니다.

x1 행 y1 열부터 x2 행 y2 열까지의 영역에 해당하는 직사각형에서 테두리에 있는 숫자들을 한 칸씩 시계방향으로 회전합니다.
다음은 6 x 6 크기 행렬의 예시입니다.

![](../image/lv2_kotlin_rotatematrixborders_img1.png)

이 행렬에 (2, 2, 5, 4) 회전을 적용하면, 아래 그림과 같이 2행 2열부터 5행 4열까지 영역의 테두리가 시계방향으로 회전합니다.
이때, 중앙의 15와 21이 있는 영역은 회전하지 않는 것을 주의하세요.

![](../image/lv2_kotlin_rotatematrixborders_img2.png)

행렬의 세로 길이(행 개수) rows, 가로 길이(열 개수) columns, 그리고 회전들의 목록 queries가 주어질 때, 각 회전들을 배열에 적용한 뒤, 그 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

### 제한 조건
* rows는 2 이상 100 이하인 자연수입니다.
* columns는 2 이상 100 이하인 자연수입니다.
* 처음에 행렬에는 가로 방향으로 숫자가 1부터 하나씩 증가하면서 적혀있습니다.
    * 즉, 아무 회전도 하지 않았을 때, i 행 j 열에 있는 숫자는 ((i-1) x columns + j)입니다.
* queries의 행의 개수(회전의 개수)는 1 이상 10,000 이하입니다.
* queries의 각 행은 4개의 정수 [x1, y1, x2, y2]입니다.
    * x1 행 y1 열부터 x2 행 y2 열까지 영역의 테두리를 시계방향으로 회전한다는 뜻입니다.
    * 1 ≤ x1 < x2 ≤ rows, 1 ≤ y1 < y2 ≤ columns입니다.
    * 모든 회전은 순서대로 이루어집니다.
    * 예를 들어, 두 번째 회전에 대한 답은 첫 번째 회전을 실행한 다음, 그 상태에서 두 번째 회전을 실행했을 때 이동한 숫자 중 최솟값을 구하면 됩니다.

### ​입출력 예
| rows | columns | queries                                             | result         |
|------|---------|-----------------------------------------------------|----------------|
| 6    | 6       | \[\[2,2,5,4\],\[3,3,6,6\],\[5,1,6,3\]\]             | \[8, 10, 25\]  |
| 3    | 3       | \[\[1,1,2,2\],\[1,2,2,3\],\[2,1,3,2\],\[2,2,3,3\]\] | \[1, 1, 5, 3\] |
| 100  | 97      | \[\[1,1,100,97\]\]                                  | \[1\]          |

#### **입출력 예 #1**

회전을 수행하는 과정을 그림으로 표현하면 다음과 같습니다.

![](../image/lv2_kotlin_rotatematrixborders_img3.png)

#### **입출력 예 #2**

회전을 수행하는 과정을 그림으로 표현하면 다음과 같습니다.

![](../image/lv2_kotlin_rotatematrixborders_img4.png)

#### **입출력 예 #1**

이 예시에서는 행렬의 테두리에 위치한 모든 칸들이 움직입니다. 따라서, 행렬의 테두리에 있는 수 중 가장 작은 숫자인 1이 바로 답이 됩니다.

<br>

---

<br>

### _**나의 풀이**_

[2][2]에서 [5][4] 까지 회전하는 경우!!

Index가 [i][j]인 경우 -> [2][2]에서 시작

j++
- [2][2]의 값이 [2][3]으로 이동
- [2][3]의 값이 [2][4]으로 이동 // 목표([][4])까지 도달

i++
- [2][4]의 값이 [3][4]으로 이동
- [3][4]의 값이 [4][4]으로 이동
- [4][4]의 값이 [5][5]으로 이동 // 목표([5][])까지 도달

j--
- [5][4]의 값이 [5][3]으로 이동
- [5][3]의 값이 [5][2]으로 이동 // 초기([][2])까지 도달

i--
- [5][2]의 값이 [4][4]으로 이동
- [4][2]의 값이 [3][2]으로 이동
- [3][2]의 값이 [2][2]으로 이동 // 초기([2][])까지 도달


```kt
class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val numbers = arrayListOf<Int>()
        val table = arrayListOf<ArrayList<Int>>()

        // 행렬 생성
        for (i in 0 until rows) {
            val subTable = arrayListOf<Int>()
            for (j in 1 .. columns) {
                subTable.add(i*columns+j)
            }
            table.add(subTable)
        }

        queries.forEach {

            var min = 10000

            var i = it[0]-1
            var j = it[1]-1
            var temp = table[i][j]  // 시작값 저장

            // 목표 [][y]에 도달할 때까지 j++
            while (j < it[3]-1) {
                if (temp < min) min = temp

                j++
                val temp2 = table[i][j]
                table[i][j] = temp
                temp = temp2
            }

            // 목표 [x][]에 도달할 때까지 i++
            while (i < it[2]-1) {
                if (temp < min) min = temp

                i++
                val temp2 = table[i][j]
                table[i][j] = temp
                temp = temp2
            }

            // 초기 [][y]에 도달할 때까지 j--
            while (j > it[1]-1) {
                if (temp < min) min = temp

                j--
                val temp2 = table[i][j]
                table[i][j] = temp
                temp = temp2
            }

            // 초기 [x][]에 도달할 때까지 i--
            while (i > it[0]-1) {
                if (temp < min) min = temp

                i--
                val temp2 = table[i][j]
                table[i][j] = temp
                temp = temp2
            }

            numbers.add(min)
        }

        return numbers.toIntArray()
    }
}
```

###### 규칙을 찾으니 생각보다 금방 풀린 문제였다.