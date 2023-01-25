> 최초작성 : 2022.08.20

## ******Level3 - 가장 긴 팰린드롬**** (kotlin)**

 [코딩테스트 연습 - 가장 긴 팰린드롬](https://school.programmers.co.kr/learn/courses/30/lessons/12904)

| **문제 설명** |
| --- |
| 앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.<br>문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.<br><br>예를들면, 문자열 s가 "abcdcba"이면 7을 return하고 "abacde"이면 3을 return합니다.|

| **제한사항** |
| --- |
|   -   문자열 s의 길이 : 2,500 이하의 자연수   |
|   -   문자열 s는 알파벳 소문자로만 구성   |

| **​입출력 예**    |  |
| --- | --- |
| s | answer |
| "abcdcba" | 7 |
| "abacde | 3 |

| **입출력 예 설명** |
| --- |
| 입출력 예 #1 <br>4번째자리 'd'를 기준으로 문자열 s 전체가 팰린드롬이 되므로 7을 return합니다.
입출력 예 #2 <br>2번째자리 'b'를 기준으로 "aba"가 팰린드롬이 되므로 3을 return합니다.|

<br>

---

<br>

### _**나의 풀이1**_

1\. 입력 받은 문자열을 하나하나 비교할 수 있는 반복문을 작성한다.

2\. 비교하는 문자열을 절반으로 자르고 한쪽을 뒤집어서 문자열이 같은지 비교한다. (총 문자열의 길이가 짝수인지 홀수인지 나눠서 비교)

3\. 두개의 문자열이 같으면 팰린드롬으로 인식하고 팰린드롬의 길이를 리턴한다.

4\. 리턴된 길이가 answer보다 크면 answer에 리턴된 길이를 넣는다.


```kt
fun solution(s: String): Int {
    var answer = 0

    for (i in 0..s.length) {
        for (j in i..s.length) {
            val pLength = palindrom(s.substring(i, j))
            if (pLength > answer) {
                answer = pLength
            }
        }
    }

    return answer
}

private fun palindrom(s: String): Int {
    val size = s.length
    val midIndex: Int = s.length / 2
    if (s.length %2 == 0) {
        val s1 = s.substring(0, midIndex)
        val s2 = s.substring(s.length/2, size).reversed()
        if (s1 == s2) {
            return size
        }
    } else {
        val s1 = s.substring(0 , midIndex)
        val s2 = s.substring(midIndex+1, size).reversed()
        if (s1 == s2) {
            return size
        }
    }
    return 0
}
```

---

### _**나의 풀이2**_

1\. 문자를 하나하나 비교하기 위해 입력 받은 문자열의 첫 글자부터 끝에서 두번째 글자까지 반복하는 for문을 작성한다.

2\. 시작index부터 특정 길이까지 문자열을 자른다.

3\. 잘린 문자열 길이의 가운데 index를 기준으로 각각 대칭되는 문자가 일치하는지 비교한다.

4\. 대칭되는 문자가 일치하지 않으면 바로 비교문을 중단하고 다음 단계로 넘어간다.

5\. 모든 대칭되는 문자가 일치하면 잘린 문자열의 길이를 answer 값에 저장한다.

6\. 잘린 문자열의 마지막 인덱스가 총 문자열의 마지막 인덱스와 같을 때까지 3~5번을 반복한다.

7\. 잘린 문자열이 answer보다 크면 3~6번을 반복한다.

```kt
private lateinit var inputText: String
private var answer = 1

fun solution(s: String): Int {
    inputText = s

    // 첫 글자부터 끝에서 두번째 글자까지 반복
    for (i in 0..s.length-2) {
        palindrom(i, i+1)
    }

    return answer
}

private fun palindrom(startIndex: Int, endIndex: Int) {
    val size = endIndex - startIndex + 1
    val midIndex: Int = size / 2
    var correct = true

    if (size > answer) { //잘린 문자열이 answer보다 작으면 로직을 수행하지 않음
        for (index in 0 until midIndex) {
            if (inputText[index + startIndex] != inputText[endIndex - index]) {
                correct = false
                break // 문자가 하나라도 다르면 반복문 중단
            }
        }

        if (correct) {
            answer = size   // 팰린드롬이면 answer에 잘린 문자열의 길이를 저장
        }
    }

    // 잘린 문자열의 마지막 인덱스가 총 문자열의 마지막 인덱스와 같을 때까지 반복
    if (size < inputText.length-startIndex) {
        palindrom(startIndex, endIndex+1)
    }
}
```

<center>

| 문제에 정답에 맞춰 통과하는 것은 어렵지 않았는데, 효율성 검사를 통과하는 데에서 조금 애를 먹었다. 찾아보니 효율성 검사 통과를 위해서는 substring() 같은 함수를 작성하지 않고 코드 상으로 해결하는 것이 좋다는 코멘트를 발견했다. <br> 몇번의 수정 끝에 최대한 반복문을 사용하지 않고, substring을 사용하지 않는 코드를 완성했다. |
| :---: |

</center>