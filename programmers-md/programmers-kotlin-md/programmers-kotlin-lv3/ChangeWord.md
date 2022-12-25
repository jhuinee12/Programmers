> 최초작성 : 2022.12.25

## ******Level3 - 단어 변환**** (kotlin)**

 [코딩테스트 연습 - 단어 변환](https://school.programmers.co.kr/learn/courses/30/lessons/43163)

### **문제 설명**
두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

    1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
    2. words에 있는 단어로만 변환할 수 있습니다.

예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.

두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

### **제한사항**
- 각 단어는 알파벳 소문자로만 이루어져 있습니다.
- 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
- words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
- begin과 target은 같지 않습니다.
- 변환할 수 없는 경우에는 0를 return 합니다.

### **​입출력 예**
| begin | target | words                                      | return |
|:------|:-------|:-------------------------------------------|:-------|
| "hit" | "cog"  | ["hot", "dot", "dog", "lot", "log", "cog"] | 4      |
| "hit" | "cog"  | ["hot", "dot", "dog", "lot", "log"]        | 0      |

### **입출력 예 설명**
#### 예제 #1
문제에 나온 예와 같습니다.

#### 예제 #2
target인 "cog"는 words 안에 없기 때문에 변환할 수 없습니다.

<br>

---

<br>

### _**나의 풀이**_

1\. 깊이 우선 탐색을 통해 모든 노드를 방문한다.

2\. 방문하지 않은 노드 중 현재 단어와 한 글자만 차이나는 단어를 방문한다.

3\. 방문한 방법 중 가장 짧은 시간에 완성되는 것을 리턴한다.

```kt
class Solution {
    lateinit var target: String
    lateinit var words: Array<String>

    var minCnt = Int.MAX_VALUE

    fun solution(begin: String, target: String, words: Array<String>): Int {
        this.target = target
        this.words = words

        val visited = BooleanArray(words.size) { false }

        if (!words.contains(target)) return 0

        dfs(visited, begin, 1)

        return minCnt
    }

    private fun dfs(visited: BooleanArray, word: String, count: Int) {
        words.forEachIndexed { i, w ->
            if (visited[i]) return@forEachIndexed

            var diff = 0

            word.forEachIndexed { j, c ->
                if (c != w[j]) diff++
            }

            if (diff == 1) {
                if (w == target && count < minCnt) minCnt = count
                visited[i] = true
                dfs(visited, w, count+1)
                visited[i] = false
            }
        }
    }
}
```