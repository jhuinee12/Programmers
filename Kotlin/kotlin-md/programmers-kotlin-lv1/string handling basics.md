> 최초작성 : 2021.04.29

## ******Level1 - **문자열 다루기 기본****** (kotlin)**

 [코딩테스트 연습 - 문자열 다루기 기본](https://programmers.co.kr/learn/courses/30/lessons/12918)

| **문제 설명** |
| --- |
| 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성되어있는지 확인해주는 함수, solution 완성하세요.   예를 들어 s가 “a234”이면 False를 리턴하고 “1234”이면 True를 리턴하면 됩니다. |

| **제한 조건** |
| --- |
|   -   s는 길이 1 이상, 길이 8 이하인 문자열입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| s | return |
| "a1234" | false |
| "1234" | true |

---

### _**나의 풀이**_

1\. try~catch문을 사용하여 int로 변환이 가능하고, 다시 string으로 바꿨을 때 s와 같으면 숫자로만 구성되어 있음

2\. int로 변환이 안되어 오류가 떨어져 catch문을 타게 되면 문자열 길이와 상관 없이 false

3\. try에서 문자열을 비교한 후 길이가 4나 6이면 true, 이외 false 값 리턴

```kt
class Solution {
    fun solution(s:String):Boolean {
        try {
            if (s.toInt().toString() == s)
            return (s.length == 4 || s.length == 6)
        }
        catch (e:NumberFormatException){
            return false
        }
        return false
    }
}
```

<center>

| 진짜 소름돋았던게...<br>내가 JAVA로 풀었을 때도 try~catch 문을 사용했었는데 코틀린도 똑같이 풀었다...<br>차이가 있다면 그때는 try~catch문이 처음이었고 이번엔 편하게 사용했다는 점? |
| :---: |

</center>

### _**Kotlin1 코드 정리**_

1\. isDigit()이라는 숫자 판별 내장 함수 사용

2\. s의 원소값이 숫자면 length+

3\. s의 길이와 숫자만 판별한 length 값을 비교해서 같고, 그 길이가 4나 6이면 true 리턴

```kt
class Solution {
	fun solution(s: String): Boolean {
		val length = s.filter{ it.isDigit() }.length
		return (length==4 || length==6) && length==s.length
	}
}
```
<center>

| kotlin을 잘 활용하려면 filter가 손에 익어야하는데 왜 이렇게 잘 안써질까...<br>아직 코틀린 감을 잡는 단계여서 그런가보다.<br>내가 숫자를 판별하는 걸로 머리를 싸맨 것이 무색할 정도로 간결한 코드이다. |
| --- |

</center>

### _**Kotlin2 코드 정리**_

1\. s의 길이가 4나 6이 아니면 false 리턴

2\. s를 charArray로 변경 후 그 원소 c를 isDigit() 함수를 활용해 숫자 판별

3\. 숫자가 아닌 원소가 있으면 false 리턴

```kt
class Solution { // 형광펜 두 조건 만족하면 false
	fun solution(s: String): Boolean {
		if(s.length!=4 && s.length!=6) {
			return false
		}
		for (c in s.toCharArray()) {
			if(!c.isDigit()) {
				return false
			}
		}
		return true
	}
}
```