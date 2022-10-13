> 최초작성 : 2022.10.13

## ******Level2 - JadenCase 문자열 만들기****(kotlin)**

 [코딩테스트 연습 - JadenCase 문자열 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12951)

### 문제 설명
JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.

### 제한 조건
* s는 길이 1 이상 200 이하인 문자열입니다.
* s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
    * 숫자는 단어의 첫 문자로만 나옵니다.
    * 숫자로만 이루어진 단어는 없습니다.
    * 공백문자가 연속해서 나올 수 있습니다.

### **​입출력 예** 
| s                       | return                  |
|-------------------------|-------------------------|
| "3people unFollowed me" | "3people Unfollowed Me" |
| "for the last week"     | "For The Last Week"     |

---

### _**나의 풀이**_

1\. split을 이용하여 " " 간격으로 자른다.

2\. 각 배열의 string 중에서 앞자리는 upper로 만들고, 나머지는 lower로 만든다.

3\. 배열을 다시 연결하여 string으로 리턴한다.

```kt
class Solution {
    fun solution(s: String): String {
        val array = s.split(" ").toMutableList()

        array.forEachIndexed { index, s ->
            var chars = ""
            s.forEachIndexed { i, c ->
                chars += if (i == 0) {
                    c.uppercaseChar()
                } else {
                    c.lowercaseChar()
                }
            }
            array[index] = chars
        }

        return array.joinToString(" ")
    }
}
```

###### 원샷원킬!!

<br>

### _**Kotlin 1**_

```kt
class Solution {
     fun solution(s: String): String {
          return s.toLowerCase().split(" ").map {
                it.capitalize()
            }.joinToString(" ")
    }
}
```
* [capitalize](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/capitalize.html) : 현재는 Deprecated 되어있음.
* 대체 - [replaceFirstChar](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/replace-first-char.html)